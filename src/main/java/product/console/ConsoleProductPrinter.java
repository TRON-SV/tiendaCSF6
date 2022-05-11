package product.console;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import product.console.interfaces.IDisplayConsoleProductInfo;

@NoArgsConstructor
@Data
public class ConsoleProductPrinter implements IDisplayConsoleProductInfo {
    private static final Logger LOGGER = LogManager.getLogger(ConsoleProductPrinter.class);
    @Override
    public void displayProductInfo(ConsoleProductManager productManager) {
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for(int i = 0; i<productManager.getConsoleProductList().size(); i++) {
            System.out.println("#: "+productManager.getConsoleProductList().get(i).getId()
                    +"      Type: "+productManager.getConsoleProductList().get(i).getProductType()
                    +"      Name: "+productManager.getConsoleProductList().get(i).getName()
                    +"      Price: $"+productManager.getConsoleProductList().get(i).getPrice()
                    +"      Brand: "+productManager.getConsoleProductList().get(i).getBrand()
                    +"      Tax: $"+productManager.getConsoleProductList().get(i).getTax()
                    +"      Disk Capacity: "+productManager.getConsoleProductList().get(i).getDiskCapacity()+"GB"
                    +"      Disk Reader: "+productManager.getConsoleProductList().get(i).getDiskReader()

            );
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
    @Override
    public void displayMessage(String msg) {
        LOGGER.info(msg);
    }
}
