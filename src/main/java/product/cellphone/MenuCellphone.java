package product.cellphone;

import product.EProductType;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuCellphone {
    public MenuCellphone() {
    }

    public static void printMenu(String[] options){
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }

    public static void crudCellphone() {
        String[] options = {
                "/*------------------------MANAGE CELLPHONES---------------------------*/",
                "1- Display Products",
                "2- Add Product",
                "3- Delete a Product",
                "4- Modify Product Data",
                "0- Exit",
                "/*---------------------------------------------------*/",
        };
        CellphoneProduct cellphoneProduct = new CellphoneProduct();
        CellphoneProductFiller cellphoneProductFiller = new CellphoneProductFiller();
        CellphoneProductArchiver cellphoneProductArchiver = new CellphoneProductArchiver();
        CellphoneProductPrinter cellphoneProductPrinter = new CellphoneProductPrinter();

        cellphoneProductFiller.fillProducts(20, cellphoneProductArchiver);
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
                        cellphoneProductPrinter.displayProductInfo(cellphoneProductArchiver);
                        break;
                    case 2://ADD A PRODUCT
                        cellphoneProduct = captureCellphoneProductData();
                        /*------------------ADDING THE PRODUCT TO THE LIST--------------------*/
                        cellphoneProductFiller.fillProduct(cellphoneProduct, cellphoneProductArchiver);
                        cellphoneProductArchiver.addCellphoneProduct(cellphoneProduct);
                        //IMPLEMENTING METHODS RELATED TO CLASS ConsoleProduct (SINGLE RESPONSIBILITY AND INTERFACE SEGREGATION)
                        cellphoneProduct.turnOnDevice();
                        cellphoneProduct.turnOffDevice();
                        break;
                    case 3://DELETE A PRODUCT
                        cellphoneProductPrinter.displayProductInfo(cellphoneProductArchiver);
                        sc = new Scanner(System.in);
                        /*------------------CHOOSE A PRODUCT FROM THE LIST--------------------*/
                        sc.reset();
                        System.out.println("Choose a product from the list (#): ");
                        while (!sc.hasNext("[0-9]*")) {
                            System.out.println("That's not a valid Id!");
                            sc.next();
                        }
                        productId = "CELL-"+sc.nextLine();
                        sc = new Scanner(System.in);
                        cellphoneProductArchiver.deleteCellphoneProduct(productId);
                        break;
                    case 4://UPDATE A PRODUCT
                        cellphoneProductPrinter.displayProductInfo(cellphoneProductArchiver);
                        sc = new Scanner(System.in);
                        /*------------------CHOOSE A PRODUCT FROM THE LIST--------------------*/
                        sc.reset();
                        System.out.println("Choose a product from the list (#): ");
                        while (!sc.hasNext("[0-9]*")) {
                            System.out.println("That's not a valid Id!");
                            sc.next();
                        }
                        productId = "CELL-"+sc.nextLine();
                        sc = new Scanner(System.in);
                        cellphoneProduct = captureCellphoneProductData();
                        cellphoneProductArchiver.modifyCellphoneProduct(cellphoneProduct,productId);
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

    public static CellphoneProduct captureCellphoneProductData() {
        //DECLARING ALL PRODUCT RELATED VARIABLES
        CellphoneProduct product = new CellphoneProduct();
        product.setProductType(EProductType.CELLPHONE);

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
        System.out.println("Enter the Name(String): ");
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
        product.setScreenSize(sc.nextLine());
        sc = new Scanner(System.in);
        /*------------------ASKING NEXT DATA--------------------*/
        sc.reset();
        System.out.println("Enter the Processor (String): ");
        while (!sc.hasNext("[A-Za-z]*")) {
            System.out.println("That's not a String!");
            sc.next();
        }
        product.setProcessor(sc.nextLine());
        sc = new Scanner(System.in);
        /*------------------ASKING NEXT DATA--------------------*/
        sc.reset();
        System.out.println("Enter Operating System (String): ");
        while (!sc.hasNext("[A-Za-z]*")) {
            System.out.println("That's not a String!");
            sc.next();
        }
        product.setOperatingSystem(sc.nextLine());
        sc = new Scanner(System.in);
        /*------------------ASKING NEXT DATA--------------------*/
        sc.reset();
        System.out.println("Enter the Memory-RAM(Integer): ");
        while (!sc.hasNextInt()) {
            System.out.println("That's not a valid value (Integer)!");
            sc.next();
        }
        product.setMemoryRAM(sc.nextInt());
        sc = new Scanner(System.in);
        /*------------------ASKING NEXT DATA--------------------*/
        sc.reset();
        System.out.println("Enter Hard-Drive capacity(Integer): ");
        while (!sc.hasNextInt()) {
            System.out.println("That's not a valid value (Integer)!");
            sc.next();
        }
        product.setHardDrive(sc.nextInt());
        sc = new Scanner(System.in);
        /*------------------ASKING NEXT DATA--------------------*/
        sc.reset();
        System.out.println("Enter Camera Quality (Integer): ");
        while (!sc.hasNextInt()) {
            System.out.println("That's not a valid value (Integer)!");
            sc.next();
        }
        product.setCamera(sc.nextInt());
        sc = new Scanner(System.in);

        return product;
    }

    public static void main(String[] args) {
        MenuCellphone menu = new MenuCellphone();
        menu.crudCellphone();
    }
}
