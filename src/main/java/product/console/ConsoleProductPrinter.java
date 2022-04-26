package product.console;

public class ConsoleProductPrinter implements IDisplayProductInfo{
    @Override
    public void displayProductInfo(ConsoleProductArchiever productArchiever) {
        for(int i=0; i<productArchiever.consoleProductList.size(); i++) {
            System.out.println(productArchiever.consoleProductList.get(i).getId());
            System.out.println(productArchiever.consoleProductList.get(i).getProductType());
            System.out.println(productArchiever.consoleProductList.get(i).getPrice());
            System.out.println(productArchiever.consoleProductList.get(i).getSerie());
            System.out.println(productArchiever.consoleProductList.get(i).getBrand());
            System.out.println(productArchiever.consoleProductList.get(i).getTax());
            System.out.println(productArchiever.consoleProductList.get(i).getDiskCapacity());
            System.out.println(productArchiever.consoleProductList.get(i).getDiskReader());
        }
    }
}
