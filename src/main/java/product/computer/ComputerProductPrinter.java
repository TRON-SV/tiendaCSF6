package product.computer;

import product.computer.interfaces.IDisplayComputerProductInfo;

public class ComputerProductPrinter implements IDisplayComputerProductInfo {
    public void displayProductInfo(ComputerProductArchiver productArcheiver) {
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for(int i=0; i<productArcheiver.computerProductList.size(); i++) {
            ComputerProduct computerProduct = productArcheiver.computerProductList.get(i);
            System.out.println("#: " + computerProduct.getId()
                    +"      Type: " + computerProduct.getProductType()
                    +"      Price: $" + computerProduct.getPrice()
                    +"      Serie: " + computerProduct.getSerie()
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
