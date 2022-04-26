import product.ProductAbstractClass;
import product.console.ConsoleProduct;
import product.console.ConsoleProductArchiever;
import product.console.ConsoleProductFiller;
import product.console.ConsoleProductPrinter;

import java.util.Scanner;

import static java.lang.System.exit;

public class TiendaCSF6 {
    public static void printMenu(String[] options){
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }
    public static void main(String[] args) {
        String[] options = {
                "------------------",
                "1- Display Products",
                "2- Insert Console Product",
                "3- Insert TV Product",
                "0- Exit",
        };
        ProductAbstractClass productAbstract = null;
        ConsoleProduct consoleProduct = new ConsoleProduct(2,true);
        ConsoleProductArchiever consoleProductArchiever = new ConsoleProductArchiever();

        Scanner scanner = new Scanner(System.in);
        int option = 1;
        while (option!=0){
            printMenu(options);
            try {
                option = scanner.nextInt();
                switch (option){
                    case 1: getProducts(); break;
                    case 2: console(consoleProduct, consoleProductArchiever); break;
                    case 3: tv(); break;
                    case 0: exit(0);
                }
            }
            catch (Exception ex){
                System.out.println("Please enter an integer value between 1 and " + options.length);
                scanner.next();
            }
        }
    }
    public static void getProducts(){

    }
    public static void tv(){
    }
    public static void console(ConsoleProduct product, ConsoleProductArchiever consoleProductArchiever) {
        //INSERTAMOS A LA LISTA UN PRODUCTO DE TIPO CONSOLA
        ConsoleProductFiller consoleProductFiller = new ConsoleProductFiller(product,consoleProductArchiever,"console",500, "Series X", "Xbox", 0.12);
        ConsoleProductPrinter consoleProductPrinter = new ConsoleProductPrinter();
        consoleProductPrinter.displayProductInfo(consoleProductArchiever);
        product.playVideoGame();
    }
}
