package User;

import product.cellphone.*;
import product.computer.*;
import product.console.*;
import product.tv.*;
import shoppingcar.ShoppingCart;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MenuCustomer {
    public static void printMenu(String[] options){
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }

    public static void showMenuCustomer(){
        String[] options = {
                "/*----------WELCOME CUSTOMER----------*/",
                "1- ADD PRODUCTS TO CAR(CELL/PC/CON/TV) :",
                "2- DISPLAY SHOPPING CAR",
                "0- Exit",
                "/*---------------------------------------------------*/",
        };
        //CREATING CUSTOMER USER AND SHOPPING CART DATA
        Customer customer = new Customer();
        customer.logInUser();
        //---------------------------VARIABLES USED FOR CELLPHONES------------------------------
        ArrayList<CellphoneProduct> cellphoneProductList = new ArrayList<CellphoneProduct>();
        CellphoneProduct cellphoneProduct = new CellphoneProduct();
        CellphoneProductFiller cellphoneProductFiller = new CellphoneProductFiller();
        CellphoneProductArchiver cellphoneProductArchiver = new CellphoneProductArchiver();
        CellphoneProductPrinter cellphoneProductPrinter = new CellphoneProductPrinter();
        //FILLING A FIXED SET OF PRODUCTS
        cellphoneProductFiller.fillProducts(10, cellphoneProductArchiver);
        //---------------------------VARIABLES USED FOR COMPUTERS------------------------------
        ArrayList<ComputerProduct> computerProductList = new ArrayList<>();
        ComputerProduct computerProduct = new ComputerProduct();
        ComputerProductFiller computerProductFiller = new ComputerProductFiller();
        ComputerProductArchiver computerProductArchiver = new ComputerProductArchiver();
        ComputerProductPrinter computerProductPrinter = new ComputerProductPrinter();
        //FILLING A FIXED SET OF PRODUCTS
        computerProductFiller.fillProducts(10, computerProductArchiver);
        //---------------------------VARIABLES USED FOR CONSOLES------------------------------
        ArrayList<ConsoleProduct> consoleProductList = new ArrayList<ConsoleProduct>();
        ConsoleProduct consoleProduct = new ConsoleProduct();
        ConsoleProductFiller consoleProductFiller = new ConsoleProductFiller();
        ConsoleProductArchiver consoleProductArchiver = new ConsoleProductArchiver();
        ConsoleProductPrinter consoleProductPrinter = new ConsoleProductPrinter();
        //FILLING A FIXED SET OF PRODUCTS
        consoleProductFiller.fillProducts(10, consoleProductArchiver);
        //---------------------------VARIABLES USED FOR TVs------------------------------
        ArrayList<TvProduct> tvProductList = new ArrayList<TvProduct>();
        TvProduct tvProduct = new TvProduct();
        TvProductFiller tvProductFiller = new TvProductFiller();
        TvProductArchiver tvProductArchiver = new TvProductArchiver();
        TvProductPrinter tvProductPrinter = new TvProductPrinter();
        //FILLING A FIXED SET OF PRODUCTS
        tvProductFiller.fillProducts(10, tvProductArchiver);
        //SHOPPING CART
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCustomer(customer);
        shoppingCart.setConsoleProductArchiver(consoleProductArchiver);
        //LOCAL VARIABLES
        String selectedOption;
        Integer productId;

        //customer.logInUser();
        Scanner scan = new Scanner(System.in);
        int option = 1;
        while (option!=0){
            printMenu(options);
            try{
                option = scan.nextInt();
                switch (option) {
                    case 1://DISPLAY PRODUCTS -> CELL/PC/CON/TV
                        /*------------------CHOOSE THE PRODUCT TYPE--------------------*/
                        Scanner sc = new Scanner(System.in);
                        System.out.println("Which type? CELL/PC/CON/TV): ");
                        while (!sc.hasNext(Pattern.compile("(CELL|PC|CONSOLE|TV)"))) {
                            System.out.println("That's not a valid product type!");
                            sc.next();
                        }
                        selectedOption = sc.nextLine();
                        /*-----------------DISPLAY THE PROPER PRODUCT TYPE--------------------*/
                        if(selectedOption.equals("cell")){
                            cellphoneProductPrinter.displayProductInfo(cellphoneProductArchiver);
                        }else if(selectedOption.equals("pc")){
                            computerProductPrinter.displayProductInfo(computerProductArchiver);
                        }else if(selectedOption.equals("console")){
                            consoleProductPrinter.displayProductInfo(consoleProductArchiver);
                        } else if(selectedOption.equals("tv")){
                            tvProductPrinter.displayProductInfo(tvProductArchiver);
                        }
                        sc = new Scanner(System.in);
                        /*------------------CHOOSE A PRODUCT FROM THE LIST--------------------*/
                        sc.reset();
                        System.out.println("Choose a product from the list (#): ");
                        while (!sc.hasNextInt()) {
                            System.out.println("That's not a valid value (Integer)!");
                            sc.next();
                        }
                        productId = sc.nextInt();
                        //UPDATING LISTs AND CREATING SHOPPING CART DATA
                        if(selectedOption.equals("cell")){
                            cellphoneProductArchiver.deleteCellphoneProduct(productId);
                            shoppingCart.addConsole(consoleProductList,productId);
                        }else if(selectedOption.equals("pc")){
                            computerProductArchiver.deleteComputerProduct(productId);
                        }else if(selectedOption.equals("console")){
                            consoleProductArchiver.deleteConsoleProduct(productId);
                        } else if(selectedOption.equals("tv")){
                            tvProductArchiver.deleteTvProduct(productId);
                        }
                        break;
                    case 2://CONSOLE PRODUCTS
                        MenuConsole menuConsole = new MenuConsole();
                        menuConsole.crudConsole();
                        break;
                    case 0:
                        break;
                }
            }catch (InputMismatchException ex){
                System.out.println("Please enter an integer value between 1 and " + options.length);
                scan.next();
            }
            catch (Exception ex){
                System.out.println("An unexpected error happened. Please try again");
                scan.next();
            }
        }

    }

    public static void main(String[] args) {
        MenuCustomer menu = new MenuCustomer();
        menu.showMenuCustomer();
    }
}
