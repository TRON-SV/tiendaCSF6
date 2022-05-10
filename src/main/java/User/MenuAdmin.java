package User;

import product.computer.MenuComputer;
import product.console.MenuConsole;
import product.tv.MenuTv;

import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.exit;

public class MenuAdmin {
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
        MenuAdmin menu = new MenuAdmin();
        menu.showMenuAdmin();
    }
}
