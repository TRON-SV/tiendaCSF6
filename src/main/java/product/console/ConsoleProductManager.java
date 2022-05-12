package product.console;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import product.console.interfaces.IConsoleProductManager;
import product.console.interfaces.IConsoleProductModifier;

import java.util.ArrayList;
@AllArgsConstructor @NoArgsConstructor
@Data
public class ConsoleProductManager implements IConsoleProductManager, IConsoleProductModifier {
    private static final Logger LOGGER = LogManager.getLogger(ConsoleProductManager.class);

    //VARIABLES DEFINITION
    ConsoleProduct consoleProduct = new ConsoleProduct();
    ConsoleProductPrinter productPrinter = new ConsoleProductPrinter();
    private ArrayList<ConsoleProduct> consoleProductList = new ArrayList<>();

    @Override
    public Boolean addConsoleProduct(ConsoleProduct product) {
        return consoleProductList.add(product);
    }
    @Override
    public Boolean deleteConsoleProduct(String productId) {
        for(int i = 0; i< consoleProductList.size(); i++){
            if(Boolean.TRUE.equals(isProductFound(consoleProductList.get(i),productId))){
                this.consoleProductList.remove(i);
                return true;
            }
        }
        return false;
    }
    @Override
    public Boolean modifyProduct(ConsoleProduct product, String productId) {
        for (ConsoleProduct currentProduct : consoleProductList) {
            if (Boolean.TRUE.equals(isProductFound(currentProduct,productId))) {
                setProductData(currentProduct, product);
                return true;
            }
        }
        return false;
    }
    public Boolean isProductFound(ConsoleProduct product,String productId){
        return product.getId().equals(productId);
    }
    public void setProductData(ConsoleProduct productSource, ConsoleProduct productNew){
        productSource.setId(productNew.getId());
        productSource.setProductType(productNew.getProductType());
        productSource.setName(productNew.getName());
        productSource.setPrice(productNew.getPrice());
        productSource.setBrand(productNew.getBrand());
        productSource.setTax(productNew.getTax());
        productSource.setDiskCapacity(productNew.getDiskCapacity());
        productSource.setDiskReader(productNew.getDiskReader());
    }
    public String generateId(){
        if(!getConsoleProductList().isEmpty()){
            return "CON-"+ (Integer.parseInt(getConsoleProductList().get(getConsoleProductList().size()-1).getId().replaceFirst("CON-","")) + 1);
        }
        return "CON-0";
    }
}
