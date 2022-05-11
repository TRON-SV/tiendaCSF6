package product.console;

import product.EProductType;
import product.console.interfaces.IFillSeveralConsoleProduct;
import product.console.interfaces.IFillSingleConsoleProduct;

public class ConsoleProductFiller implements IFillSeveralConsoleProduct {
    @Override
    public void fillProducts(Integer quantity, ConsoleProductManager productManager) {
        for(int i=0; i<quantity; i++) {
            ConsoleProduct consoleProduct = createNewProduct(productManager.getConsoleProductList().size());
            consoleProduct.setDiskCapacity(512);
            consoleProduct.setDiskReader(true);
            productManager.addConsoleProduct(consoleProduct);
        }
    }
    public ConsoleProduct createNewProduct(Integer listSize){
        return new ConsoleProduct(
                "CON-"+listSize, EProductType.CONSOLE, "Product "+listSize, 500.00, "Product brand"+listSize, 120.5
        );
    }
}
