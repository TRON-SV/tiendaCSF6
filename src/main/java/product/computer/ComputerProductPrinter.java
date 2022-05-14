package product.computer;

import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import product.computer.interfaces.IDisplayComputerProductInfo;
import product.console.ConsoleProductPrinter;

@NoArgsConstructor
public class ComputerProductPrinter implements IDisplayComputerProductInfo {
    private static final Logger LOGGER = LogManager.getLogger(ComputerProductPrinter.class);
    @Override
    public void displayProductInfo(ComputerProductManager productManager) {
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for(int i=0; i<productManager.computerProductList.size(); i++) {
            ComputerProduct computerProduct = productManager.computerProductList.get(i);
            System.out.println("#: " + computerProduct.getId()
                    +"      Type: " + computerProduct.getProductType()
                    +"      Name: " + computerProduct.getName()
                    +"      Price: $" + computerProduct.getPrice()
                    +"      Brand: " + computerProduct.getBrand()
                    +"      Tax: $" + computerProduct.getTax()
                    +"      CPU: " + computerProduct.getProcessor()
                    +"      Storage Size: " + computerProduct.getHardDisk() + "GB"
                    +"      RAM: " + computerProduct.getMemoryRam() + "GB"
                    +"      Operative System: " + computerProduct.getOperativeSystem()
                    +"      Size: " + computerProduct.getSize() + " cm"

            );
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }

    @Override
    public void displayMessage(String msg) {
        LOGGER.info(msg);
    }
}
