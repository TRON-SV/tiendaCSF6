package product.computer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import product.computer.interfaces.IComputerProductArchiver;
import product.computer.interfaces.IComputerProductModifier;

import java.util.ArrayList;

@AllArgsConstructor @NoArgsConstructor
@Data
public class ComputerProductArchiver implements IComputerProductArchiver, IComputerProductModifier {
    ComputerProduct computerProduct = new ComputerProduct();
    ComputerProductPrinter productPrinter = new ComputerProductPrinter();
    public ArrayList<ComputerProduct> computerProductList = new ArrayList<>();

    @Override
    public void addComputerProduct(ComputerProduct product) {
        computerProductList.add(product);
        productPrinter.displayMessage("--------------!PRODUCT "+ product.getId() +" ADDED!-----------------");
    }
    @Override
    public void deleteComputerProduct(String productId) {
        boolean founded = false;
        for (int i = 0; i < computerProductList.size(); i++) {
            if (computerProductList.get(i).getId().equals(productId)) {
                founded = true;
                computerProductList.remove(i);
                break;
            }
        }
        if (founded) {
            productPrinter.displayMessage("--------------!PRODUCT DELETED!-----------------");
        }else {
            productPrinter.displayMessage("--------------!PRODUCT NOT FOUNDED!-----------------");
        }
    }

    @Override
    public void modifyComputerProduct(ComputerProduct product, String productId) {
        for(int i=0; i<computerProductList.size(); i++){
            if(computerProductList.get(i).getId().equals(productId)){
                //PERFORMING A UPDATE OF THE PRODUCT DATA
                computerProductList.get(i).setProductType(product.getProductType());
                computerProductList.get(i).setName(product.getName());
                computerProductList.get(i).setPrice(product.getPrice());
                computerProductList.get(i).setBrand(product.getBrand());
                computerProductList.get(i).setTax(product.getTax());
                computerProductList.get(i).setProcessor(product.getProcessor());
                computerProductList.get(i).setOperativeSystem(product.getOperativeSystem());
                computerProductList.get(i).setHardDisk(product.getHardDisk());
                computerProductList.get(i).setMemoryRam(product.getMemoryRam());
                computerProductList.get(i).setDescription(product.getDescription());
                computerProductList.get(i).setSize(product.getSize());
                productPrinter.displayMessage("--------------!PRODUCT UPDATED!-----------------");
            }
        }
    }
}
