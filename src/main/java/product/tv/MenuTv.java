package product.tv;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import product.CaptureProductData;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuTv {
    private static final Logger LOGGER = LogManager.getLogger(MenuTv.class);
    public static void printMenu(String[] options){
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }

    public static void crudTv() {
        String[] options = {
                "/*------------------------MANAGE TVs---------------------------*/",
                "1- Display Products",
                "2- Add Product",
                "3- Delete a Product",
                "4- Modify Product Data",
                "5- Export to JSON File",
                "6- Import From Json File",
                "0- Exit",
                "/*---------------------------------------------------*/",
        };
        TvProduct tvProduct = new TvProduct();
        TvProductFiller tvFiller = new TvProductFiller();
        TvProductManager tvManager = new TvProductManager();
        TvProductPrinter tvPrinter = new TvProductPrinter();
        tvFiller.fillProducts(5, tvManager);
        String productId;
        CaptureProductData captureProductData = new CaptureProductData(tvManager.getTvProduct());
        TvJsonConverter tvJsonConverter;

        Scanner scanner = new Scanner(System.in);
        int option = 1;
        while (option!=0){
            printMenu(options);
            try{
                option = scanner.nextInt();
                switch (option){
                    case 1://DISPLAY PRODUCTS
                        tvPrinter.displayProductInfo(tvManager);
                        break;
                    case 2://ADD A PRODUCT
                        /*------------------CAPTURING THE DATA TO STORE--------------------*/
                        captureProductData.captureProductData();
                        captureProductData.captureTvData();
                        captureProductData.getProduct().setId(tvManager.generateId());
                        tvManager.addTvProduct(captureProductData.getTvProduct());
                        //At this point, consoleProductManager.ConsoleProduct has its object<ConsoleProduct> filled
                        captureProductData.setProduct(new TvProduct());
                        break;
                    case 3://DELETE A PRODUCT
                        LOGGER.info(tvPrinter);
                        tvPrinter.displayProductInfo(tvManager);
                        System.out.println("Choose a product from the list (0-9): ");
                        if(tvManager.deleteTvProduct(captureProductData.captureProductId("TV-")))
                            LOGGER.info("--------------!PRODUCT DELETED!-----------------");
                        else LOGGER.error("--------------!COULDN'T FIND THE PRODUCT!--------------");
                        break;
                    case 4://UPDATE A PRODUCT
                        tvPrinter.displayProductInfo(tvManager);
                        System.out.println("Choose a product from the list (0-9): ");
                        captureProductData.captureProductId("TV-");
                        captureProductData.captureProductData();
                        captureProductData.captureTvData();
                        if(tvManager.modifyTvProduct(captureProductData.getTvProduct(),captureProductData.getProduct().getId()))
                            LOGGER.info("--------------!PRODUCT UPDATED!-----------------");
                        else LOGGER.error("--------------!COULDN'T UPDATE THE PRODUCT!--------------");
                        captureProductData.setProduct(new TvProduct());
                        break;
                    case 5://EXPORT TO JSON FILE
                        tvJsonConverter = new TvJsonConverter(tvManager.getTvProductList());
                        tvJsonConverter.exportToJson();
                        break;
                    case 6://IMPORT FROM JSON FILE
                        tvJsonConverter = new TvJsonConverter();
                        tvManager.setTvProductList(tvJsonConverter.importFromJson());
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
        crudTv();
    }
}
