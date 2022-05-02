package shoppingcar;

import User.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import product.cellphone.CellphoneProduct;
import product.computer.ComputerProduct;
import product.console.*;
import product.tv.TvProduct;

import java.util.ArrayList;
@AllArgsConstructor @NoArgsConstructor
public @Data class ShoppingCart {

    private Customer customer;
    private ArrayList<CellphoneProduct> cellphoneProductList;
    private ArrayList<ComputerProduct> computerProductList;
    private ArrayList<ConsoleProduct> consoleProductList;
    ConsoleProductPrinter productPrinter = new ConsoleProductPrinter();
    private ArrayList<TvProduct> tvProductList;
    //---------------------------VARIABLES USED FOR CONSOLES------------------------------
    ConsoleProductFiller consoleProductFiller;
    ConsoleProductArchiver consoleProductArchiver;
    ConsoleProductPrinter consoleProductPrinter;

    public void addConsole(ArrayList<ConsoleProduct> consoleProductList, Integer productId) {
        boolean isTheProductFounded = false;
        for(int i=0; i<consoleProductList.size(); i++){
            if(consoleProductList.get(i).getId() == productId){
                isTheProductFounded = true;
                this.getConsoleProductList().add(consoleProductList.get(i));
                displayProductInfo(consoleProductArchiver);
            }
        }
        if(isTheProductFounded==true){
            productPrinter.displayMessage("--------------!PRODUCT DELETED!-----------------");
        }else{
            productPrinter.displayMessage("--------------!PRODUCT NOT FOUNDED!-----------------");
        }
    }
    public void displayProductInfo(ConsoleProductArchiver productArchiver) {
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for(int i=0; i<productArchiver.consoleProductList.size(); i++) {
            System.out.println("#: "+productArchiver.consoleProductList.get(i).getId()
                    +"      Type: "+productArchiver.consoleProductList.get(i).getProductType()
                    +"      Price: $"+productArchiver.consoleProductList.get(i).getPrice()
                    +"      Serie: "+productArchiver.consoleProductList.get(i).getSerie()
                    +"      Brand: "+productArchiver.consoleProductList.get(i).getBrand()
                    +"      Tax: $"+productArchiver.consoleProductList.get(i).getTax()
                    +"      Disk Capacity: "+productArchiver.consoleProductList.get(i).getDiskCapacity()+"GB"
                    +"      Disk Reader: "+productArchiver.consoleProductList.get(i).getDiskReader()

            );
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
}