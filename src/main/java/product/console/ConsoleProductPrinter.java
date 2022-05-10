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
    public void displayProductInfo(ConsoleProductManager productArchiver) {
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for(int i = 0; i<productArchiver.getConsoleProductList().size(); i++) {
            System.out.println("#: "+productArchiver.getConsoleProductList().get(i).getId()
                    +"      Type: "+productArchiver.getConsoleProductList().get(i).getProductType()
                    +"      Name: "+productArchiver.getConsoleProductList().get(i).getName()
                    +"      Price: $"+productArchiver.getConsoleProductList().get(i).getPrice()
                    +"      Brand: "+productArchiver.getConsoleProductList().get(i).getBrand()
                    +"      Tax: $"+productArchiver.getConsoleProductList().get(i).getTax()
                    +"      Disk Capacity: "+productArchiver.getConsoleProductList().get(i).getDiskCapacity()+"GB"
                    +"      Disk Reader: "+productArchiver.getConsoleProductList().get(i).getDiskReader()

            );
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
    @Override
    public void displayMessage(String msg) {
        LOGGER.info(msg);
    }
}
