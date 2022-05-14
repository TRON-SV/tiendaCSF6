package product.computer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import product.computer.interfaces.IComputerProductManager;
import product.computer.interfaces.IComputerProductModifier;
import java.util.ArrayList;

@AllArgsConstructor @NoArgsConstructor
@Data
public class ComputerProductManager implements IComputerProductManager, IComputerProductModifier {
    private static final Logger LOGGER = LogManager.getLogger(ComputerProductManager.class);

    //VARIABLES DEFINITION
    ComputerProduct computerProduct = new ComputerProduct();
    ComputerProductPrinter productPrinter = new ComputerProductPrinter();
    ArrayList<ComputerProduct> computerProductList = new ArrayList<>();

    @Override
    public Boolean addComputerProduct(ComputerProduct product) { return computerProductList.add(product); }
    @Override
    public Boolean deleteComputerProduct(String productId) {
        for (int i = 0; i < computerProductList.size(); i++) {
            if (Boolean.TRUE.equals(isProductFound(computerProductList.get(i),productId))) {
                computerProductList.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean modifyComputerProduct(ComputerProduct product, String productId) {
        for(ComputerProduct currentProduct : getComputerProductList()){
            if(Boolean.TRUE.equals(isProductFound(currentProduct,productId))){
                setProductData(currentProduct, product);
                return true;
            }
        }
        return false;
    }
    public Boolean isProductFound(ComputerProduct product, String productId){
        return product.getId().equals(productId);
    }
    public void setProductData(ComputerProduct productSource, ComputerProduct productNew){
        productSource.setId(productNew.getId());
        productSource.setProductType(productNew.getProductType());
        productSource.setName(productNew.getName());
        productSource.setPrice(productNew.getPrice());
        productSource.setBrand(productNew.getBrand());
        productSource.setTax(productNew.getTax());
        productSource.setSize(productNew.getSize());
        productSource.setProcessor(productNew.getProcessor());
        productSource.setOperativeSystem(productNew.getOperativeSystem());
        productSource.setMemoryRam(productNew.getMemoryRam());
        productSource.setHardDisk(productNew.getHardDisk());
    }
    public String generateId(){
        if(!getComputerProductList().isEmpty()){
            return "PC-"+ (Integer.parseInt(getComputerProductList().get(getComputerProductList().size()-1).getId().replaceFirst("PC-","")) + 1);
        }
        return "PC-0";
    }
}
