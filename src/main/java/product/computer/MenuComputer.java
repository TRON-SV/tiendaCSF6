package product.computer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import product.CaptureProductData;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuComputer {
    private static final Logger LOGGER = LogManager.getLogger(MenuComputer.class);
    public static void printMenu(String[] options) {
        LOGGER.info(MenuComputer.class);
        for (String option: options) {
            System.out.println(option);
        }
        System.out.println("Choose your option: ");
    }

    public static void crudComputer() {
        String[] options = {
                "/*------------------------MANAGE COMPUTERS---------------------------*/",
                "1- Display Products",
                "2- Add Product",
                "3- Delete a Product",
                "4- Modify Product Data",
                "5- Export to JSON File",
                "6- Import From Json File",
                "0- Exit",
                "/*---------------------------------------------------*/",
        };
        //DECLARING PRODUCT RELATED CLASSES FOR FURTHER USE
        ComputerProduct computerProduct = new ComputerProduct();
        ComputerProductFiller computerFiller = new ComputerProductFiller();
        ComputerProductManager computerManager = new ComputerProductManager();
        ComputerProductPrinter computerPrinter = new ComputerProductPrinter();
        computerFiller.fillProducts(5, computerManager);
        CaptureProductData captureProductData = new CaptureProductData(computerManager.getComputerProduct());
        ComputerJsonConverter computerJsonConverter;

        Scanner scanner = new Scanner(System.in);
        int option = 1;
        while (option != 0) {
            printMenu(options);
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        // ---- Display Products
                        computerPrinter.displayProductInfo(computerManager);
                        break;
                    case 2:
                        // ---- Add product
                        captureProductData.captureProductData();
                        captureProductData.captureComputerData();
                        captureProductData.getProduct().setId(computerManager.generateId());
                        computerManager.addComputerProduct(captureProductData.getComputerProduct());
                        computerProduct.turnOnDevice();
                        computerProduct.turnOffDevice();
                        captureProductData.setProduct(new ComputerProduct());
                        break;
                    case 3:
                        // ---- Delete product
                        LOGGER.info(computerPrinter);
                        computerPrinter.displayProductInfo(computerManager);
                        System.out.println("Choose a product from the list (0-9): ");
                        if(computerManager.deleteComputerProduct(captureProductData.captureProductId("PC-")))
                            LOGGER.info("--------------!PRODUCT DELETED!-----------------");
                        else LOGGER.error("--------------!COULDN'T FIND THE PRODUCT!--------------");
                        break;
                    case 4:
                        // ---- Modify product
                        computerPrinter.displayProductInfo(computerManager);
                        System.out.println("Choose a product from the list (0-9): ");
                        captureProductData.captureProductId("PC-");
                        captureProductData.captureProductData();
                        captureProductData.captureComputerData();
                        if(computerManager.modifyComputerProduct(captureProductData.getComputerProduct(),captureProductData.getProduct().getId()))
                            LOGGER.info("--------------!PRODUCT UPDATED!-----------------");
                        else LOGGER.error("--------------!COULDN'T UPDATE THE PRODUCT!--------------");
                        captureProductData.setProduct(new ComputerProduct());
                        break;
                    case 5://EXPORT TO JSON FILE
                        computerJsonConverter = new ComputerJsonConverter(computerManager.getComputerProductList());
                        computerJsonConverter.exportToJson();
                        break;
                    case 6://IMPORT FROM JSON FILE
                        computerJsonConverter = new ComputerJsonConverter();
                        computerManager.setComputerProductList(computerJsonConverter.importFromJson());
                        break;
                    case 0:
                        break;
                }
            }
            catch (InputMismatchException ex) {
                System.out.println("Please enter an integer value between 1 and " + options.length);
                scanner.next();
            }
            catch (Exception ex){
                System.out.println("An unexpected error happened. Please try again");
                scanner.next();
            }
        }
    }
    public static void main(String[] args) {
        MenuComputer.crudComputer();
    }
}
