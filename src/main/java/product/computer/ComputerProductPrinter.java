package product.computer;

import lombok.NoArgsConstructor;
import product.computer.interfaces.IDisplayComputerProductInfo;

@NoArgsConstructor
public class ComputerProductPrinter implements IDisplayComputerProductInfo {
    public void displayProductInfo(ComputerProductArchiver productArcheiver) {
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for(int i=0; i<productArcheiver.computerProductList.size(); i++) {
            ComputerProduct computerProduct = productArcheiver.computerProductList.get(i);
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
                    +"      Description: " + computerProduct.getDescription()

            );
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }

    @Override
    public void displayMessage(String msg) {
        System.out.println(msg);
    }
}
