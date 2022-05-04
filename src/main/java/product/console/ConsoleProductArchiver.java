package product.console;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import product.IProduct;

import java.util.ArrayList;
@AllArgsConstructor @NoArgsConstructor
@Data
public class ConsoleProductArchiver implements IConsoleProductArchiver, IConsoleProductModifier, IProduct {
    //VARIABLES DEFINITION
    ConsoleProduct consoleProduct = new ConsoleProduct();
    ConsoleProductPrinter productPrinter = new ConsoleProductPrinter();
    public ArrayList<ConsoleProduct> consoleProductList = new ArrayList<ConsoleProduct>();

    @Override
    public void addConsoleProduct(ConsoleProduct product) {
        this.consoleProductList.add(product);
        productPrinter.displayMessage("--------------!PRODUCT "+ product.getId() +" ADDED!-----------------");
    }
    @Override
    public void deleteConsoleProduct(String productSudoId) {
        boolean isTheProductFounded = false;
        for(int i=0; i<consoleProductList.size(); i++){
            if(consoleProductList.get(i).getId().equals(productSudoId)){
                isTheProductFounded = true;
                this.consoleProductList.remove(i);
                break;
            }
        }
        if(isTheProductFounded==true){
            productPrinter.displayMessage("--------------!PRODUCT "+ productSudoId +" DELETED!-----------------");
        }else{
            productPrinter.displayMessage("--------------!PRODUCT "+ productSudoId +" NOT FOUNDED!-----------------");
        }
    }
    @Override
    public void modifyConsoleProduct(ConsoleProduct product, String productId) {
        for(int i=0; i<consoleProductList.size(); i++){
            if(consoleProductList.get(i).getId().equals(productId)){
                //PERFORMING A UPDATE OF THE PRODUCT DATA
                consoleProductList.get(i).setProductType(product.getProductType());
                consoleProductList.get(i).setName(product.getName());
                consoleProductList.get(i).setPrice(product.getPrice());
                consoleProductList.get(i).setBrand(product.getBrand());
                consoleProductList.get(i).setTax(product.getTax());
                consoleProductList.get(i).setDiskCapacity(product.getDiskCapacity());
                consoleProductList.get(i).setDiskReader(product.getDiskReader());
                productPrinter.displayMessage("--------------!PRODUCT UPDATED!-----------------");
            }
        }
    }
}
