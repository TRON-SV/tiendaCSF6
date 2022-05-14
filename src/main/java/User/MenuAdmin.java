package User;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import product.computer.MenuComputer;
import product.console.MenuConsole;
import product.tv.MenuTv;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

public class MenuAdmin {
    private static final Logger LOGGER = LogManager.getLogger(MenuConsole.class);
    public static void printMenu(String[] options){
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }

    public static void showMenuAdmin(){
        String[] options = {
                "/*----------WELCOME ADMINISTRATOR----------*/",
                "1- CONSOLE PRODUCTS",
                "2- TELEVISION PRODUCTS",
                "3- COMPUTER PRODUCTS",
                "0- Exit",
                "/*---------------------------------------------------*/",
        };
        Admin admin = new Admin("CGroup3CSF",2,"Customer 1","12345","any@hotmail.com");
        Scanner scan = new Scanner(System.in);
        int option = 1;

        //admin.logInUser();
        while (option!=0){
            printMenu(options);
            try{
                option = scan.nextInt();
                switch (option) {
                    case 1://CONSOLE PRODUCTS
                        MenuConsole menuConsole = new MenuConsole();
                        menuConsole.crudConsole();
                        break;
                    case 2://TELEVISION PRODUCTS
                        MenuTv menuTv = new MenuTv();
                        menuTv.crudTv();
                        break;
                    case 3://COMPUTER PRODUCTS
                        MenuComputer menuComputer = new MenuComputer();
                        menuComputer.crudComputer();
                        break;
                    case 0:
                        break;
                }
            }catch (InputMismatchException ex){
                LOGGER.error(String.format("Please enter an integer value between 1 and %d", options.length));
                LOGGER.error("RunTime Exception: " + ex, ex);
                scan.next();
            }
            catch (Exception ex){
                LOGGER.fatal("An unexpected error happened. Please try again");
                LOGGER.error("An unexpected error happened. Please try again" + ex, ex);
                scan.next();
            }
        }

    }

    public static void main(String[] args) {
        MenuAdmin menu = new MenuAdmin();
        menu.showMenuAdmin();
    }
}
