package product;

import lombok.*;
import product.computer.ComputerProduct;
import product.console.ConsoleProduct;
import product.tv.TvProduct;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

@NoArgsConstructor @AllArgsConstructor
@Data
public class CaptureProductData {
    @Getter @Setter
    private AProduct product;
    private ConsoleProduct cProduct;
    private ComputerProduct computerProduct;
    private TvProduct tvProduct;

    private Scanner sc = new Scanner("");

    @Builder
    public CaptureProductData(ConsoleProduct product){
        this.product = product;
    }
    public CaptureProductData(AProduct product){ this.product = product; }
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
    //Function use on thr ShoppingCart Class
    public EProductType captureProductType(){
        /*------------------CHOOSE THE PRODUCT TYPE--------------------*/
        Scanner sc = new Scanner(System.in); sc.reset();
        System.out.println("Which type? PC/CONSOLE/TV): ");
        while (!sc.hasNext(Pattern.compile("(PC|pc|CONSOLE|console|TV|tv)"))) {
            System.out.println("That's not a valid product type!");
            sc.next();
        }
        product.setProductType(EProductType.valueOf(sc.nextLine().toUpperCase()));
        return product.getProductType();
    }
    public void captureProductData() {
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
    public void captureConsoleData(){
        product.setProductType(EProductType.CONSOLE);
        cProduct = (ConsoleProduct) product;
        /*------------------ASKING NEXT DATA--------------------*/
        sc = new Scanner(System.in);
        sc.reset();
        System.out.println("Enter the Disk-Capacity(Integer): ");
        while (!sc.hasNextInt()) {
            System.out.println("That's not a valid value (Integer)!");
            sc.next();
        }
        cProduct.setDiskCapacity(sc.nextInt());
        /*------------------ASKING NEXT DATA--------------------*/
        sc = new Scanner(System.in);
        sc.reset();
        System.out.println("Does the product has DiskReader? (true/false): ");
        while (!sc.hasNextBoolean()) {
            System.out.println("That's not a valid value (Integer)!");
            sc.next();
        }
        cProduct.setDiskReader(sc.nextBoolean());
        sc = new Scanner(System.in);
    }
    public void captureTvData(){
        product.setProductType(EProductType.TV);
        tvProduct = (TvProduct) product;
        /*------------------ASKING NEXT DATA--------------------*/
    }
    public void captureComputerData(){
        product.setProductType(EProductType.COMPUTER);
        computerProduct = (ComputerProduct) product;
        /*------------------ASKING NEXT DATA--------------------*/
    }
}
