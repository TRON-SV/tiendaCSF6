package product.computer;

import lombok.NoArgsConstructor;
import product.EProductType;
import product.computer.interfaces.IFillSeveralComputerProduct;
import product.console.ConsoleProduct;

@NoArgsConstructor
public class ComputerProductFiller implements IFillSeveralComputerProduct {
    @Override
    public void fillProducts(Integer quantity, ComputerProductManager productManager) {
        for (int i = 0; i < quantity; i++) {
            ComputerProduct computerProduct = createNewProduct(productManager.getComputerProductList().size());
            computerProduct.setHardDisk(1000);
            computerProduct.setOperativeSystem("Windows 10");
            computerProduct.setProcessor("AMD Ryzen 3");
            computerProduct.setMemoryRam(8);
            computerProduct.setSize((float) i);
            productManager.addComputerProduct(computerProduct);
        }
    }
    public ComputerProduct createNewProduct(Integer listSize){
        return new ComputerProduct(
                "PC-"+listSize, EProductType.COMPUTER, "Product "+listSize, 500.00, "Product brand"+listSize, 120.5
        );
    }
}
