package product.computer;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

public class MenuComputer {
    public static void printMenu(String[] options) {
        for (String option: options) {
            System.out.println(option);
        }
        System.out.println("Choose your option: ");
    }

    public static void crudComputer() {
        String[] options = {
                "/*---------------------------------------------------*/",
                "1- Display Products",
                "2- Add Product",
                "3- Delete a Product",
                "4- Modify Product Data",
                "0- Exit",
                "/*---------------------------------------------------*/",
        };
        ComputerProduct computerProduct = new ComputerProduct();
        ComputerProductFiller computerProductFiller = new ComputerProductFiller();
        ComputerProductArchiver computerProductArchiver = new ComputerProductArchiver();
        ComputerProductPrinter computerProductPrinter = new ComputerProductPrinter();

        computerProductFiller.fillProducts(20, computerProductArchiver);
        int productId;

        Scanner sc = new Scanner(System.in);

        int option = 1;
        while (option != 0) {
            printMenu(options);
            try {
                option = sc.nextInt();
                switch (option) {
                    case 1:
                        // ---- Display Products
                        computerProductPrinter.displayProductInfo(computerProductArchiver);
                        break;
                    case 2:
                        // ---- Add product
                        computerProduct = captureComputerProductData();
                        computerProductFiller.fillProduct(computerProduct, computerProductArchiver);
                        computerProductArchiver.addComputerProduct(computerProduct);
                        computerProduct.turnOnDevice();
                        computerProduct.turnOffDevice();
                        break;
                    case 3:
                        // ---- Delete product
                        computerProductPrinter.displayProductInfo(computerProductArchiver);
                        while (!sc.hasNextInt()) {
                            System.out.println("That's not a valid value (Integer)!");
                            sc.next();
                        }
                        productId = sc.nextInt();
                        computerProductArchiver.deleteComputerProduct(productId);
                        break;
                    case 4:
                        // ---- Modify product
                        computerProductPrinter.displayProductInfo(computerProductArchiver);
                        while (!sc.hasNextInt()) {
                            System.out.println("That's not a valid value (Integer)!");
                            sc.next();
                        }
                        productId = sc.nextInt();
                        computerProduct = captureComputerProductData();
                        computerProductArchiver.modifyComputerProduct(computerProduct, productId);
                        break;
                    case 0:
                        exit(0);
                        break;
                }
            }
            catch (InputMismatchException ex) {
                System.out.println("Please enter an integer value between 1 and " + options.length);
                sc.next();
            }
            catch (Exception ex){
                System.out.println("An unexpected error happened. Please try again");
                sc.next();
            }
        }
    }

    public static ComputerProduct captureComputerProductData() {
        ComputerProduct product = new ComputerProduct();
        product.setProductType("Computer");

        Scanner sc = new Scanner(System.in);
        /*------------------ASKING DATA--------------------*/
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
        product.setSerie(sc.nextLine());
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
        System.out.println("Enter Operative System (String): ");
        while (!sc.hasNext("[A-Za-z]*")) {
            System.out.println("That's not a String!");
            sc.next();
        }
        product.setOperativeSystem(sc.nextLine());
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
        System.out.println("Enter the Size in CM (Deciamal / Float): ");
        while (!sc.hasNextDouble()) {
            System.out.println("That's not a valid value (Float / Decimal)!");
            sc.next();
        }
        product.setSize(sc.nextFloat());
        sc = new Scanner(System.in);
        /*------------------ASKING NEXT DATA--------------------*/
        sc.reset();
        System.out.println("Enter the Memory-RAM(Integer): ");
        while (!sc.hasNextInt()) {
            System.out.println("That's not a valid value (Integer)!");
            sc.next();
        }
        product.setMemoryRam(sc.nextInt());
        sc = new Scanner(System.in);
        /*------------------ASKING NEXT DATA--------------------*/
        sc.reset();
        System.out.println("Enter Hard-Drive capacity(Integer): ");
        while (!sc.hasNextInt()) {
            System.out.println("That's not a valid value (Integer)!");
            sc.next();
        }
        product.setHardDisk(sc.nextInt());
        sc = new Scanner(System.in);
        /*------------------ASKING NEXT DATA--------------------*/
        sc.reset();
        System.out.println("Enter a description (String): ");
        while (!sc.hasNext("[A-Za-z]*")) {
            System.out.println("That's not a String!");
            sc.next();
        }
        product.setDescription(sc.nextLine());
        return product;
    }

    public static void main(String[] args) {
        MenuComputer.crudComputer();
    }
}
