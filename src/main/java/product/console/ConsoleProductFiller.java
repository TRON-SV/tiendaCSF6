package product.console;

import product.EProductType;
import product.console.interfaces.IFillSeveralConsoleProduct;
import product.console.interfaces.IFillSingleConsoleProduct;

public class ConsoleProductFiller implements IFillSingleConsoleProduct, IFillSeveralConsoleProduct {
    @Override
    public void fillProduct(ConsoleProduct product, ConsoleProductManager productManager) {
        product.setId("CON-"+productManager.getConsoleProductList().size());
        productManager.setConsoleProduct(product);
    }
    @Override
    public void fillProducts(Integer quantity, ConsoleProductManager productManager) {
        for(int i=0; i<quantity; i++) {
            ConsoleProduct consoleProduct = new ConsoleProduct(
                    "CON-"+productManager.getConsoleProductList().size(),
                    EProductType.CONSOLE, "Product "+i, 500.00, "Product brand"+1, 120.5
            );
            consoleProduct.setDiskCapacity(512);
            consoleProduct.setDiskReader(true);
            productManager.addConsoleProduct(consoleProduct);
        }
    }
    public void setBasicData(){
    }
    public void setSpecificData(){}
}
