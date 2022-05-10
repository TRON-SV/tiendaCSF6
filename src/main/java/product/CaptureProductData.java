package product;

import lombok.*;
import product.console.ConsoleProduct;
import product.console.MenuConsole;

import java.util.Scanner;
@NoArgsConstructor @AllArgsConstructor
public class CaptureProductData {
    @Getter @Setter
    private ConsoleProduct product;
    private Scanner sc = new Scanner("");

    @Builder
    public CaptureProductData(ConsoleProduct product){
        this.product = product;
    }

    public String captureProductId(String prefix){
        sc = new Scanner(System.in);
        sc.reset();
        while (!sc.hasNext("[0-9]*")) {
            System.out.println("That's not a valid Id!");
            sc.next();
        }
        product.setId(prefix+sc.nextLine());
        sc = new Scanner(System.in);
        return product.getId();
    }
    public void captureProductData() {
        product.setProductType(EProductType.CONSOLE);

        /*------------------ASKING NEXT DATA--------------------*/
        sc = new Scanner(System.in);
        sc.reset();
        System.out.println("Enter the Price: ");
        while (!sc.hasNextDouble()) {
            System.out.println("That's not a valid value (Double)!");
            sc.next();
        }
        product.setPrice(sc.nextDouble());
        /*------------------ASKING NEXT DATA--------------------*/
        sc = new Scanner(System.in);
        sc.reset();
        System.out.println("Enter the Name(String): ");
        while (!sc.hasNext("[A-Za-z]*")) {
            System.out.println("That's not a String!");
            sc.next();
        }
        product.setName(sc.nextLine());
        /*------------------ASKING NEXT DATA--------------------*/
        sc = new Scanner(System.in);
        sc.reset();
        System.out.println("Enter the TAX Price: ");
        while (!sc.hasNextDouble()) {
            System.out.println("That's not a valid value (Double)!");
            sc.next();
        }
        product.setTax(sc.nextDouble());
        /*------------------ASKING NEXT DATA--------------------*/
        sc = new Scanner(System.in);
        sc.reset();
        System.out.println("Enter the Brand(String): ");
        while (!sc.hasNext("[A-Za-z]*")) {
            System.out.println("That's not a String!");
            sc.next();
        }
        product.setBrand(sc.nextLine());
        sc = new Scanner(System.in);
    }
    public void captureConsoleProductData(){
        /*------------------ASKING NEXT DATA--------------------*/
        sc = new Scanner(System.in);
        sc.reset();
        System.out.println("Enter the Disk-Capacity(Integer): ");
        while (!sc.hasNextInt()) {
            System.out.println("That's not a valid value (Integer)!");
            sc.next();
        }
        product.setDiskCapacity(sc.nextInt());
        /*------------------ASKING NEXT DATA--------------------*/
        sc = new Scanner(System.in);
        sc.reset();
        System.out.println("Does the product has DiskReader? (true/false): ");
        while (!sc.hasNextBoolean()) {
            System.out.println("That's not a valid value (Integer)!");
            sc.next();
        }
        product.setDiskReader(sc.nextBoolean());
        sc = new Scanner(System.in);
    }
}
