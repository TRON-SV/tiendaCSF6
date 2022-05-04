package product.console;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ConsoleProductPrinter implements IDisplayConsoleProductInfo {
    @Override
    public void displayProductInfo(ConsoleProductArchiver productArchiver) {
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for(int i=0; i<productArchiver.consoleProductList.size(); i++) {
            System.out.println("#: "+productArchiver.consoleProductList.get(i).getId()
                    +"      Type: "+productArchiver.consoleProductList.get(i).getProductType()
                    +"      Name: "+productArchiver.consoleProductList.get(i).getName()
                    +"      Price: $"+productArchiver.consoleProductList.get(i).getPrice()
                    +"      Brand: "+productArchiver.consoleProductList.get(i).getBrand()
                    +"      Tax: $"+productArchiver.consoleProductList.get(i).getTax()
                    +"      Disk Capacity: "+productArchiver.consoleProductList.get(i).getDiskCapacity()+"GB"
                    +"      Disk Reader: "+productArchiver.consoleProductList.get(i).getDiskReader()

            );
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
    @Override
    public void displayMessage(String msg) {
        System.out.println(msg);
    }
}
