package product.console;

public class ConsoleProductFiller implements IFillSingleConsoleProduct, IFillSeveralConsoleProduct {
    @Override
    public void fillProduct(ConsoleProduct product, ConsoleProductArchiver productArchiver) {
        productArchiver.consoleProduct = product;
        product.setId(productArchiver.consoleProductList.size());
    }
    @Override
    public void fillProducts(Integer quantity, ConsoleProductArchiver productArchiever) {
        for(int i=0; i<quantity; i++) {
            ConsoleProduct consoleProduct = new ConsoleProduct();
            consoleProduct.setId(productArchiever.consoleProductList.size());
            consoleProduct.setProductType("Console" + i);
            consoleProduct.setPrice(500);
            consoleProduct.setSerie("Product " + i);
            consoleProduct.setBrand("Product brand" +i);
            consoleProduct.setTax(500);
            consoleProduct.setDiskCapacity(512);
            consoleProduct.setDiskReader(true);
            productArchiever.addConsoleProduct(consoleProduct);
        }
    }
}