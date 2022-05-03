package product.console;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
@Data
public class ConsoleProductPrinter implements IDisplayConsoleProductInfo {
    @Override
    public void displayProductInfo(ConsoleProductArchiver productArchiver) {
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for(int i=0; i<productArchiver.consoleProductList.size(); i++) {
            System.out.println("#: "+productArchiver.consoleProductList.get(i).getId()
                    +"      Type: "+productArchiver.consoleProductList.get(i).getProductType()
                    +"      Price: $"+productArchiver.consoleProductList.get(i).getPrice()
                    +"      Serie: "+productArchiver.consoleProductList.get(i).getSerie()
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
