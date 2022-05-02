package product.console;

import java.util.ArrayList;

public class ConsoleProductArchiver implements IConsoleProductArchiver, IConsoleProductModifier{
    //VARIABLES DEFINITION
    ConsoleProduct consoleProduct = new ConsoleProduct();
    ConsoleProductPrinter productPrinter = new ConsoleProductPrinter();
    public ArrayList<ConsoleProduct> consoleProductList = new ArrayList<ConsoleProduct>();
    public ArrayList<ConsoleProduct> getConsoleProductList() {
        return consoleProductList;
    }
    public void setConsoleProductList(ArrayList<ConsoleProduct> productList) {
        this.consoleProductList = consoleProductList;
    }
    @Override
    public void addConsoleProduct(ConsoleProduct product) {
        this.consoleProductList.add(product);
        productPrinter.displayMessage("--------------!PRODUCT "+ product.getId() +" ADDED!-----------------");
    }
    @Override
    public void deleteConsoleProduct(Integer productSudoId) {
        boolean isTheProductFounded = false;
        for(int i=0; i<consoleProductList.size(); i++){
            if(consoleProductList.get(i).getId() == productSudoId){
                isTheProductFounded = true;
                this.consoleProductList.remove(i);
            }
        }
        if(isTheProductFounded==true){
            productPrinter.displayMessage("--------------!PRODUCT DELETED!-----------------");
        }else{
            productPrinter.displayMessage("--------------!PRODUCT NOT FOUNDED!-----------------");
        }
    }
    @Override
    public void modifyConsoleProduct(ConsoleProduct product, int productId) {
        for(int i=0; i<consoleProductList.size(); i++){
            if(consoleProductList.get(i).getId() == productId){
                //PERFORMING A UPDATE OF THE PRODUCT DATA
                consoleProductList.get(i).setProductType(product.getProductType());
                consoleProductList.get(i).setPrice(product.getPrice());
                consoleProductList.get(i).setSerie(product.getSerie());
                consoleProductList.get(i).setTax(product.getTax());
                consoleProductList.get(i).setBrand(product.getBrand());
                consoleProductList.get(i).setDiskCapacity(product.getDiskCapacity());
                consoleProductList.get(i).setDiskReader(product.getDiskReader());
                productPrinter.displayMessage("--------------!PRODUCT UPDATED!-----------------");
            }
        }
    }
}
