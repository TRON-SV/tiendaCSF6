package product.console;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import product.CaptureProductData;
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
                "5- Export to JSON File",
                "6- Import From Json File",
                "0- Exit",
                "/*------------------------------------------------------------------*/",
        };
        //DECLARING PRODUCT RELATED CLASSES FOR FURTHER USE
        ConsoleProductFiller consoleFiller = new ConsoleProductFiller();
        ConsoleProductManager consoleManager = new ConsoleProductManager();
        ConsoleProductPrinter consolePrinter = new ConsoleProductPrinter();
        //FILLING A FIXED SET OF PRODUCTS
        consoleFiller.fillProducts(5, consoleManager);
        CaptureProductData captureProductData = new CaptureProductData(consoleManager.getConsoleProduct());
        ConsoleJsonConverter consoleJsonConverter;

        Scanner scanner = new Scanner(System.in);
        int option = 1;
        while (option!=0){
            printMenu(options);
            try {
                option = scanner.nextInt();
                switch (option){
                    case 1://DISPLAY PRODUCTS
                        consolePrinter.displayProductInfo(consoleManager);
                        break;
                    case 2://ADD A PRODUCT
                        /*------------------CAPTURING THE DATA TO STORE--------------------*/
                        captureProductData.captureProductData();
                        captureProductData.captureConsoleData();
                        captureProductData.getProduct().setId(consoleManager.generateId());
                        consoleManager.addConsoleProduct(captureProductData.getCProduct());
                        //At this point, consoleManager.ConsoleProduct has its object<ConsoleProduct> filled
                        captureProductData.getCProduct().playVideoGame();
                        captureProductData.setProduct(new ConsoleProduct());
                        break;
                    case 3://DELETE A PRODUCT
                        LOGGER.info(consolePrinter);
                        consolePrinter.displayProductInfo(consoleManager);
                        System.out.println("Choose a product from the list (0-9): ");
                        if(consoleManager.deleteConsoleProduct(captureProductData.captureProductId("CON-")))
                            LOGGER.info("--------------!PRODUCT DELETED!-----------------");
                        else LOGGER.error("--------------!COULDN'T FIND THE PRODUCT!--------------");
                        break;
                    case 4://UPDATE A PRODUCT
                        consolePrinter.displayProductInfo(consoleManager);
                        System.out.println("Choose a product from the list (0-9): ");
                        captureProductData.captureProductId("CON-");
                        captureProductData.captureProductData();
                        captureProductData.captureConsoleData();
                        if(consoleManager.modifyProduct(captureProductData.getCProduct(),captureProductData.getProduct().getId()))
                            LOGGER.info("--------------!PRODUCT UPDATED!-----------------");
                        else LOGGER.error("--------------!COULDN'T UPDATE THE PRODUCT!--------------");
                        captureProductData.setProduct(new ConsoleProduct());
                        break;
                    case 5://EXPORT TO JSON FILE
                        consoleJsonConverter = new ConsoleJsonConverter(consoleManager.getConsoleProductList());
                        consoleJsonConverter.exportToJson();
                        break;
                    case 6://IMPORT FROM JSON FILE
                        consoleJsonConverter = new ConsoleJsonConverter();
                        consoleManager.setConsoleProductList(consoleJsonConverter.importFromJson());
                        break;
                    case 0:
                        break;
                }
            }
            catch (InputMismatchException ex){
                LOGGER.error(String.format("Please enter an integer value between 1 and %d", options.length));
                LOGGER.error("RunTime Exception: " + ex, ex);
                scanner.next();
            }
            catch (Exception ex){
                LOGGER.fatal("An unexpected error happened. Please try again");
                LOGGER.error("An unexpected error happened. Please try again" + ex, ex);
                scanner.next();
            }
        }
    }
    public static void main(String[] args) {
        crudConsole();
    }
}
