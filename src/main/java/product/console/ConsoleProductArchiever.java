package product.console;

import product.ProductAbstractClass;

import java.util.ArrayList;

public class ConsoleProductArchiever {
    //VARIABLES DEFINITION
    public ArrayList<ConsoleProduct> consoleProductList = new ArrayList<ConsoleProduct>();
    public ArrayList<ConsoleProduct> getConsoleProductList() {
        return consoleProductList;
    }
    public void setConsoleProductList(ArrayList<ConsoleProduct> productList) {
        this.consoleProductList = consoleProductList;
    }
    public void addConsoleProductToList(ConsoleProduct product) {
        this.consoleProductList.add(product);
    }
}
