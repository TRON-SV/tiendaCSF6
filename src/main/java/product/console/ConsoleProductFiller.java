package product.console;

import product.ProductAbstractClass;

public class ConsoleProductFiller {
    public ConsoleProductFiller(ConsoleProduct product, ConsoleProductArchiever productArchiever, String producType, double price, String serie, String brand, double tax) {
        product.setId(1);
        product.setProductType(producType);
        product.setPrice(price);
        product.setSerie(serie);
        product.setBrand(brand);
        product.setTax(tax);
        product.setDiskCapacity(512);
        product.setDiskReader(true);
        productArchiever.addConsoleProductToList(product);
    }
}
