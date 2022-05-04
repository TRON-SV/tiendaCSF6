package product.console;

import product.EProductType;

public class ConsoleProductFiller implements IFillSingleConsoleProduct, IFillSeveralConsoleProduct {
    @Override
    public void fillProduct(ConsoleProduct product, ConsoleProductArchiver productArchiver) {
        productArchiver.consoleProduct = product;
        product.setId("CON-"+productArchiver.consoleProductList.size());
    }
    @Override
    public void fillProducts(Integer quantity, ConsoleProductArchiver productArchiever) {
        for(int i=0; i<quantity; i++) {
            ConsoleProduct consoleProduct = new ConsoleProduct();
            consoleProduct.setId("CON-"+productArchiever.consoleProductList.size());
            consoleProduct.setProductType(EProductType.CONSOLE);
            consoleProduct.setName("Product " + i);
            consoleProduct.setPrice(500);
            consoleProduct.setBrand("Product brand" +i);
            consoleProduct.setTax(500);
            consoleProduct.setDiskCapacity(512);
            consoleProduct.setDiskReader(true);
            productArchiever.addConsoleProduct(consoleProduct);
        }
    }
}
