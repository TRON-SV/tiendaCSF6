package User;

import product.computer.*;
import product.console.*;
import product.tv.*;
import shoppingcar.CartPrinter;
import shoppingcar.ShoppingCart;

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
                "/*------------------------------WELCOME CUSTOMER------------------------------*/",
                "1- ADD PRODUCTS TO CAR(CELL/PC/CON/TV) :",
                "2- DISPLAY SHOPPING CAR",
                "0- Exit",
                "/*----------------------------------------------------------------------------*/",
        };
        //CREATING CUSTOMER USER AND SHOPPING CART DATA
        Customer customer = new Customer("CGroup3CSF",2,"Customer 1","12345","any@hotmail.com");
        //customer.logInUser();
        //---------------------------VARIABLES USED FOR COMPUTERS------------------------------
        ComputerProduct computerProduct = new ComputerProduct();
        ComputerProductFiller computerProductFiller = new ComputerProductFiller();
        ComputerProductArchiver computerProductArchiver = new ComputerProductArchiver();
        ComputerProductPrinter computerProductPrinter = new ComputerProductPrinter();
        //FILLING A FIXED SET OF PRODUCTS
        computerProductFiller.fillProducts(10, computerProductArchiver);
        //---------------------------VARIABLES USED FOR CONSOLES------------------------------
        ConsoleProduct consoleProduct = new ConsoleProduct();
        ConsoleProductFiller consoleProductFiller = new ConsoleProductFiller();
        ConsoleProductManager consoleProductManager = new ConsoleProductManager();
        ConsoleProductPrinter consoleProductPrinter = new ConsoleProductPrinter();
        //FILLING A FIXED SET OF PRODUCTS
        consoleProductFiller.fillProducts(10, consoleProductManager);
        //---------------------------VARIABLES USED FOR TVs------------------------------
        TvProduct tvProduct = new TvProduct();
        TvProductFiller tvProductFiller = new TvProductFiller();
        TvProductManager tvProductArchiver = new TvProductManager();
        TvProductPrinter tvProductPrinter = new TvProductPrinter();
        //FILLING A FIXED SET OF PRODUCTS
        tvProductFiller.fillProducts(10, tvProductArchiver);
        //SHOPPING CART
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setCustomer(customer);
        CartPrinter cartPrinter = new CartPrinter(shoppingCart);
        //LOCAL VARIABLES
        String selectedOption;
        String productId;

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
                        System.out.println("Which type? PC/CONSOLE/TV): ");
                        while (!sc.hasNext(Pattern.compile("(PC|pc|CONSOLE|console|TV|tv)"))) {
                            System.out.println("That's not a valid product type!");
                            sc.next();
                        }
                        selectedOption = sc.nextLine();
                        /*-----------------DISPLAY THE PROPER PRODUCT TYPE--------------------*/
                        if(selectedOption.equals("PC") || selectedOption.equals("pc")){
                            computerProductPrinter.displayProductInfo(computerProductArchiver);
                        }else if(selectedOption.equals("CONSOLE") || selectedOption.equals("console")){
                            consoleProductPrinter.displayProductInfo(consoleProductManager);
                        } else if(selectedOption.equals("TV") || selectedOption.equals("tv")){
                            tvProductPrinter.displayProductInfo(tvProductArchiver);
                        }
                        sc = new Scanner(System.in);
                        /*------------------CHOOSE A PRODUCT FROM THE LIST--------------------*/
                        sc.reset();
                        System.out.println("Choose a product from the list (0-9): ");
                        while (!sc.hasNext("[0-9]*")) {
                            System.out.println("That's not a valid Id!");
                            sc.next();
                        }
                        //UPDATING LISTs AND CREATING SHOPPING CART DATA
                        if(selectedOption.equals("PC") || selectedOption.equals("pc")){
                            productId = "PC-"+sc.nextLine();
                            shoppingCart.addComputer(computerProductArchiver.getComputerProductList(),productId);
                            computerProductArchiver.deleteComputerProduct(productId);
                        }else if(selectedOption.equals("CONSOLE") || selectedOption.equals("console")){
                            productId = "CON-"+sc.nextLine();
                            shoppingCart.addConsole(consoleProductManager.getConsoleProductList(),productId);
                            consoleProductManager.deleteConsoleProduct(productId);
                        } else if(selectedOption.equals("TV") || selectedOption.equals("tv")){
                            productId = "TV-"+sc.nextLine();
                            shoppingCart.addTv(tvProductArchiver.getTvProductList(),productId);
                            tvProductArchiver.deleteTvProduct(productId);
                        }
                        break;
                    case 2://DISPLAY SHOPPING CAR
                        shoppingCart.setComputerCounter(0); shoppingCart.setConsoleCounter(0); shoppingCart.setTvCounter(0);
                        cartPrinter.displayProductInfo(shoppingCart.getIProductList());
                        break;
                    case 0:
                        break;
                }
            }catch (InputMismatchException ex){
                System.out.println("Please enter an integer value between 1 and " + options.length);
                ex.printStackTrace();
                scan.next();
            }
            catch (Exception ex){
                System.out.println("An unexpected error happened. Please try again");
                ex.printStackTrace();
                scan.next();
            }
        }
    }

    public static void main(String[] args) {
        showMenuCustomer();
    }
}
