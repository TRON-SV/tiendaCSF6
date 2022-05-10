package product.computer;

import lombok.NoArgsConstructor;
import product.EProductType;
import product.computer.interfaces.IFillSeveralComputerProduct;
import product.computer.interfaces.IFillSingleComputerProduct;

@NoArgsConstructor
public class ComputerProductFiller implements IFillSingleComputerProduct, IFillSeveralComputerProduct {
    @Override
    public void fillProduct(ComputerProduct product, ComputerProductArchiver productArchiver) {
        productArchiver.computerProduct = product;
        product.setId("PC-"+String.valueOf(productArchiver.computerProductList.size()));
    }

    @Override
    public void fillProducts(Integer quantity, ComputerProductArchiver productArchiver) {
        for (int i = 0; i < quantity; i++) {
            ComputerProduct computerProduct = new ComputerProduct();
            computerProduct.setId("PC-"+String.valueOf(productArchiver.computerProductList.size()));
            computerProduct.setProductType(EProductType.COMPUTER);
            computerProduct.setName("Product " + i);
            computerProduct.setPrice(1000.99);
            computerProduct.setBrand("Product brand" + i);
            computerProduct.setTax(215.20);
            computerProduct.setHardDisk(1000);
            computerProduct.setOperativeSystem("Windows 10");
            computerProduct.setProcessor("AMD Ryzen 3");
            computerProduct.setMemoryRam(8);
            computerProduct.setSize(Float.valueOf(i));
            computerProduct.setDescription("Computer description " + i);
            productArchiver.addComputerProduct(computerProduct);
        }
    }
}
