package User;

import product.cellphone.MenuCellphone;

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
                "1- CELLPHONE PRODUCTS",
                "2- CONSOLE PRODUCTS",
                "3- TELEVISION PRODUCTS",
                "4- COMPUTER PRODUCTS",
                "0- Exit",
                "/*---------------------------------------------------*/",
        };
        Admin admin = new Admin();
        Scanner scan = new Scanner(System.in);
        int option = 1;

        admin.logInUser();
        while (option!=0){
            printMenu(options);
            try{
                option = scan.nextInt();
                switch (option) {
                    case 1://CELLPHONE PRODUCTS
                        MenuCellphone menuCellphone = new MenuCellphone();
                        menuCellphone.crudCellphone();
                        break;
                    case 2://CONSOLE PRODUCTS
                        System.out.println("2");
                        break;
                    case 3://TELEVISION PRODUCTS
                        System.out.println("3");

                    case 4://COMPUTER PRODUCTS
                        System.out.println("4");
                        break;

                    case 0:
                        exit(0);
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
