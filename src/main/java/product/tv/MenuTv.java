package product.tv;

import product.EProductType;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuTv {
    public MenuTv() {
    }

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
                "0- Exit",
                "/*---------------------------------------------------*/",
        };
        TvProduct tvProduct = new TvProduct();
        TvProductFiller tvProductFiller = new TvProductFiller();
        TvProductManager tvProductArchiver = new TvProductManager();
        TvProductPrinter tvProductPrinter = new TvProductPrinter();

        tvProductFiller.fillProducts(20, tvProductArchiver);
        String productId;

        Scanner scanner = new Scanner(System.in);
        Scanner sc;

        int option = 1;
        while (option!=0){
            printMenu(options);
            try{
                option = scanner.nextInt();
                switch (option){
                    case 1://DISPLAY PRODUCTS
                        tvProductPrinter.displayProductInfo(tvProductArchiver);
                        break;
                    case 2://ADD A PRODUCT
                        tvProduct = captureTvProductData();
                        /*------------------ADDING THE PRODUCT TO THE LIST--------------------*/
                        tvProductFiller.fillProduct(tvProduct, tvProductArchiver);
                        tvProductArchiver.addTvProduct(tvProduct);
                        break;
                    case 3://DELETE A PRODUCT
                        tvProductPrinter.displayProductInfo(tvProductArchiver);
                        sc = new Scanner(System.in);
                        /*------------------CHOOSE A PRODUCT FROM THE LIST--------------------*/
                        sc.reset();
                        System.out.println("Choose a product from the list (#): ");
                        while (!sc.hasNext("[0-9]*")) {
                            System.out.println("That's not a valid Id!");
                            sc.next();
                        }
                        productId = "TV-"+sc.nextLine();
                        sc = new Scanner(System.in);
                        tvProductArchiver.deleteTvProduct(productId);
                        break;
                    case 4://UPDATE A PRODUCT
                        tvProductPrinter.displayProductInfo(tvProductArchiver);
                        sc = new Scanner(System.in);
                        /*------------------CHOOSE A PRODUCT FROM THE LIST--------------------*/
                        sc.reset();
                        System.out.println("Choose a product from the list (#): ");
                        while (!sc.hasNext("[0-9]*")) {
                            System.out.println("That's not a valid Id!");
                            sc.next();
                        }
                        productId = "TV-"+sc.nextLine();
                        sc = new Scanner(System.in);
                        tvProduct = captureTvProductData();
                        tvProductArchiver.modifyTvProduct(tvProduct,productId);
                        break;

                    case 0: break;
                }

            }
            catch (InputMismatchException ex){
                System.out.println("Please enter an integer value between 1 and " + options.length);
                scanner.next();
            }
            catch (Exception ex){
                System.out.println("An unexpected error happened. Please try again");
                scanner.next();
            }
        }

    }

    public static TvProduct captureTvProductData() {
        //DECLARING ALL PRODUCT RELATED VARIABLES
        TvProduct product = new TvProduct();
        product.setProductType(EProductType.TV);

        Scanner sc = new Scanner(System.in);
        /*------------------ASKING NEXT DATA--------------------*/
        System.out.println("Enter the Price: ");
        while (!sc.hasNextDouble()) {
            System.out.println("That's not a valid value (Double)!");
            sc.next();
        }
        product.setPrice(sc.nextDouble());
        sc = new Scanner(System.in);
        /*------------------ASKING NEXT DATA--------------------*/
        sc.reset();
        System.out.println("Enter the Serie(String): ");
        while (!sc.hasNext("[A-Za-z]*")) {
            System.out.println("That's not a String!");
            sc.next();
        }
        product.setName(sc.nextLine());
        sc = new Scanner(System.in);
        /*------------------ASKING NEXT DATA--------------------*/
        sc.reset();
        System.out.println("Enter the TAX Price: ");
        while (!sc.hasNextDouble()) {
            System.out.println("That's not a valid value (Double)!");
            sc.next();
        }
        product.setTax(sc.nextDouble());
        sc = new Scanner(System.in);
        /*------------------ASKING NEXT DATA--------------------*/
        sc.reset();
        System.out.println("Enter the Brand(String): ");
        while (!sc.hasNext("[A-Za-z]*")) {
            System.out.println("That's not a String!");
            sc.next();
        }
        product.setBrand(sc.nextLine());
        sc = new Scanner(System.in);
        /*------------------ASKING NEXT DATA--------------------*/
        sc.reset();
        System.out.println("Enter Screen Size (String): ");
        while (!sc.hasNext("[A-Za-z]*")) {
            System.out.println("That's not a String!");
            sc.next();
        }
        product.setTvsize(sc.nextLine());
        sc = new Scanner(System.in);
        /*------------------ASKING NEXT DATA--------------------*/
        sc.reset();
        System.out.println("Enter the type (String): ");
        while (!sc.hasNext("[A-Za-z]*")) {
            System.out.println("That's not a String!");
            sc.next();
        }
        product.setTvtype(sc.nextLine());
        sc = new Scanner(System.in);
        /*------------------ASKING NEXT DATA--------------------*/
        sc.reset();
        System.out.println("Enter Smart (Boolean): ");
        while (!sc.hasNextBoolean()) {
            System.out.println("That's not a Boolean!");
            sc.next();
        }
        product.setSmart(sc.nextBoolean());
        sc = new Scanner(System.in);

        return product;
    }

    public static void main(String[] args) {
        MenuTv menu = new MenuTv();
        menu.crudTv();
    }
}
