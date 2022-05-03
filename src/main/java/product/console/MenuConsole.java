package product.console;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MenuConsole {
    public static void printMenu(String[] options){
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }
    public static void crudConsole() {
        String[] options = {
                "/*------------------------MANAGE CONSOLES---------------------------*/",
                "1- Display Products",
                "2- Add Product",
                "3- Delete a Product",
                "4- Modify Product Data",
                "5- Generate JSON from Object",
                "6- Send a Email to jerson.psn@hotmail.com",
                "0- Exit",
                "/*---------------------------------------------------*/",
        };
        //DECLARING PRODUCT RELATED CLASSES FOR FURTHER USE
        ConsoleProduct consoleProduct = new ConsoleProduct();
        ConsoleProductFiller consoleProductFiller = new ConsoleProductFiller();
        ConsoleProductArchiver consoleProductArchiver = new ConsoleProductArchiver();
        ConsoleProductPrinter consoleProductPrinter = new ConsoleProductPrinter();
        //FILLING A FIXED SET OF PRODUCTS
        consoleProductFiller.fillProducts(10, consoleProductArchiver);
        Integer productId;

        Scanner scanner = new Scanner(System.in);
        Scanner sc;
        int option = 1;
        while (option!=0){
            printMenu(options);
            try {
                option = scanner.nextInt();
                switch (option){
                    case 1://DISPLAY PRODUCTS
                        consoleProductPrinter.displayProductInfo(consoleProductArchiver);
                        break;
                    case 2://ADD A PRODUCT
                        consoleProduct = captureConsoleProductData();
                        /*------------------ADDING THE PRODUCT TO THE LIST--------------------*/
                        consoleProductFiller.fillProduct(consoleProduct, consoleProductArchiver);
                        consoleProductArchiver.addConsoleProduct(consoleProduct);
                        //IMPLEMENTING METHODS RELATED TO CLASS ConsoleProduct (SINGLE RESPONSIBILITY AND INTERFACE SEGREGATION)
                        consoleProduct.turnOnDevice();
                        consoleProduct.playVideoGame();
                        consoleProduct.turnOffDevice();
                        break;
                    case 3://DELETE A PRODUCT
                        consoleProductPrinter.displayProductInfo(consoleProductArchiver);
                        sc = new Scanner(System.in);
                        /*------------------CHOOSE A PRODUCT FROM THE LIST--------------------*/
                        sc.reset();
                        System.out.println("Choose a product from the list (#): ");
                        while (!sc.hasNextInt()) {
                            System.out.println("That's not a valid value (Integer)!");
                            sc.next();
                        }
                        productId = sc.nextInt();
                        consoleProductArchiver.deleteConsoleProduct(productId);
                        break;
                    case 4://UPDATE A PRODUCT
                        consoleProductPrinter.displayProductInfo(consoleProductArchiver);
                        sc = new Scanner(System.in);
                        /*------------------CHOOSE A PRODUCT FROM THE LIST--------------------*/
                        sc.reset();
                        System.out.println("Choose a product from the list (#): ");
                        while (!sc.hasNextInt()) {
                            System.out.println("That's not a valid value (Integer)!");
                            sc.next();
                        }
                        productId = sc.nextInt();
                        consoleProduct = captureConsoleProductData();
                        consoleProductArchiver.modifyConsoleProduct(consoleProduct,productId);
                        break;
                    case 5://GENERATE JSON FILE FROM OBJECT
                        try {
                            ObjectMapper objectMapper = new ObjectMapper();
                            //Set pretty printing of json
                            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
                            //Define map which will be converted to JSON
                            //ArrayList<ConsoleProduct> consoleProductList = consoleProductArchiver.getConsoleProductList();
                            //Convert List of ConsoleProduct objects to JSON
                            String arrayToJson = objectMapper.writeValueAsString(consoleProductArchiver.getConsoleProductList());
                            consoleProductPrinter.displayMessage(arrayToJson);
                            objectMapper.writeValue(new File("src/main/resources/productList.json"), consoleProductArchiver.getConsoleProductList());
                            consoleProductPrinter.displayMessage("PRODUCTS EXPORTED TO -> src/main/resources/productList.json");
                            //EMPTY THE ConsoleProductList
                            consoleProductArchiver.setConsoleProductList(null);
                            //2. Convert JSON to List of ConsoleProduct objects
                            //Define Custom Type reference for List<ConsoleProduct> type
                            TypeReference<ArrayList<ConsoleProduct>> mapType = new TypeReference<ArrayList<ConsoleProduct>>() {};
                            consoleProductArchiver.setConsoleProductList(objectMapper.readValue(arrayToJson, mapType));
                            consoleProductPrinter.displayMessage("Converted JSON to List of ConsoleProduct objects :");
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 6://SENDING EMAIL TO jerson.psn@hotmail.com
                        /*Session session = Session.getInstance(prop, new Authenticator() {

                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(username, password);
                            }
                        });

                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress("from@gmail.com"));
                        message.setRecipients(
                                Message.RecipientType.TO, InternetAddress.parse("jerson.psn@hotmail.com"));
                        message.setSubject("Mail Subject");

                        String msg = "This is my first email using JavaMailer";

                        MimeBodyPart mimeBodyPart = new MimeBodyPart();
                        mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

                        Multipart multipart = new MimeMultipart();
                        multipart.addBodyPart(mimeBodyPart);

                        message.setContent(multipart);

                        Transport.send(message);*/
                        break;
                    case 0:
                        break;
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

    public static ConsoleProduct captureConsoleProductData() {
        //DECLARING ALL PRODUCT RELATED VARIABLES
        String productType;double price;String serie;String brand;double tax;Integer diskCapacity;boolean diskReader;
        ConsoleProduct product = new ConsoleProduct();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the productType(Console/TV/PC): ");
        while (!sc.hasNext("[A-Za-z]*")) {
            System.out.println("That's not a String!");
            sc.next();
        }
        product.setProductType(sc.nextLine());
        sc = new Scanner(System.in);
        /*------------------ASKING NEXT DATA--------------------*/
        sc.reset();
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
        System.out.println("Enter the Disk-Capacity(Integer): ");
        while (!sc.hasNextInt()) {
            System.out.println("That's not a valid value (Integer)!");
            sc.next();
        }
        product.setDiskCapacity(sc.nextInt());
        sc = new Scanner(System.in);
        /*------------------ASKING NEXT DATA--------------------*/
        sc.reset();
        System.out.println("Does the product has DiskReader? (true/false): ");
        while (!sc.hasNextBoolean()) {
            System.out.println("That's not a valid value (Integer)!");
            sc.next();
        }
        product.setDiskReader(sc.nextBoolean());
        sc = new Scanner(System.in);
        return product;
    }
    public static void main(String[] args) {
        MenuConsole menu = new MenuConsole();
        menu.crudConsole();
    }
}
