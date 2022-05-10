package product.console;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import product.CaptureProductData;
import product.JsonConverter;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuConsole {
    private static final Logger LOGGER = LogManager.getLogger(MenuConsole.class);
    public static void printMenu(String[] options){
        LOGGER.info(MenuConsole.class);
        for (String option : options){
            System.out.println(option);
        }
        System.out.println("Choose your option: ");
    }
    public static void crudConsole() {
        String[] options = {
                "/*------------------------MANAGE CONSOLES---------------------------*/",
                "1- Display Products",
                "2- Add Product",
                "3- Delete a Product",
                "4- Modify Product Data",
                "5- Generate JSON File",
                "6- Load From Json File",
                "0- Exit",
                "/*---------------------------------------------------*/",
        };
        //DECLARING PRODUCT RELATED CLASSES FOR FURTHER USE
        ConsoleProductFiller consoleProductFiller = new ConsoleProductFiller();
        ConsoleProductManager consoleProductManager = new ConsoleProductManager();
        ConsoleProductPrinter consoleProductPrinter = new ConsoleProductPrinter();
        //FILLING A FIXED SET OF PRODUCTS
        consoleProductFiller.fillProducts(10, consoleProductManager);
        CaptureProductData captureProductData = new CaptureProductData(consoleProductManager.getConsoleProduct());
        JsonConverter jsonConverter;

        Scanner scanner = new Scanner(System.in);
        int option = 1;
        while (option!=0){
            printMenu(options);
            try {
                option = scanner.nextInt();
                switch (option){
                    case 1://DISPLAY PRODUCTS
                        consoleProductPrinter.displayProductInfo(consoleProductManager);
                        break;
                    case 2://ADD A PRODUCT
                        /*------------------CAPTURING THE DATA TO STORE--------------------*/
                        captureProductData.captureProductData();
                        captureProductData.captureConsoleProductData();
                        consoleProductFiller.fillProduct(captureProductData.getProduct(), consoleProductManager);
                        //At this point, consoleProductManager.ConsoleProduct has its object<ConsoleProduct> filled
                        consoleProductManager.addConsoleProduct(consoleProductManager.getConsoleProduct());
                        captureProductData.getProduct().turnOnDevice();
                        captureProductData.getProduct().playVideoGame();
                        captureProductData.getProduct().turnOffDevice();
                        break;
                    case 3://DELETE A PRODUCT
                        LOGGER.info(consoleProductPrinter);
                        consoleProductPrinter.displayProductInfo(consoleProductManager);
                        consoleProductPrinter.displayMessage("Choose a product from the list (0-9): ");
                        if(consoleProductManager.deleteConsoleProduct(captureProductData.captureProductId("CON-")))
                            consoleProductPrinter.displayMessage("--------------!PRODUCT DELETED!-----------------");
                        else consoleProductPrinter.displayMessage("--------------!COULDN'T FIND THE PRODUCT!--------------");
                        break;
                    case 4://UPDATE A PRODUCT
                        consoleProductPrinter.displayProductInfo(consoleProductManager);
                        consoleProductPrinter.displayMessage("Choose a product from the list (0-9): ");
                        captureProductData.captureProductId("CON-");
                        captureProductData.captureProductData();
                        captureProductData.captureConsoleProductData();
                        if(consoleProductManager.modifyProduct(captureProductData.getProduct(),captureProductData.getProduct().getId()))
                            consoleProductPrinter.displayMessage("--------------!PRODUCT UPDATED!-----------------");
                        else consoleProductPrinter.displayMessage("--------------!COULDN'T UPDATE THE PRODUCT!--------------");
                        break;
                    case 5://EXPORT TO JSON FILE
                        jsonConverter = new JsonConverter(consoleProductManager.getConsoleProductList());
                        jsonConverter.exportToJson();
                        break;
                    case 6://IMPORT FROM JSON FILE
                        jsonConverter = new JsonConverter();
                        consoleProductManager.setConsoleProductList(jsonConverter.importFromJson());
                        break;
                    case 0:
                        break;
                    default:
                        break;

                }
            }
            catch (InputMismatchException ex){
                LOGGER.error(String.format("Please enter an integer value between 1 and %d", options.length));
                scanner.next();
            }
            catch (Exception ex){
                LOGGER.fatal("An unexpected error happened. Please try again");
                scanner.next();
            }
        }
    }

    public static void main(String[] args) {
        crudConsole();
    }
}
