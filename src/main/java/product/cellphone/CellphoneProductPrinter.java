package product.cellphone;

public class CellphoneProductPrinter implements IDisplayCellphoneProductInfo{
    @Override
    public void displayMessage(String msg) {
        System.out.println(msg);
    }

    @Override
    public void displayProductInfo(CellphoneProductArchiver productArchiver) {
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for(int i=0; i<productArchiver.cellphoneProductList.size(); i++) {
            System.out.println("#: "+productArchiver.cellphoneProductList.get(i).getId()
                    +"      Type: "+productArchiver.cellphoneProductList.get(i).getProductType()
                    +"      Price: $"+productArchiver.cellphoneProductList.get(i).getPrice()
                    +"      Serie: "+productArchiver.cellphoneProductList.get(i).getSerie()
                    +"      Brand: "+productArchiver.cellphoneProductList.get(i).getBrand()
                    +"      Tax: $"+productArchiver.cellphoneProductList.get(i).getTax()
                    +"      Screen size: "+productArchiver.cellphoneProductList.get(i).getScreenSize()
                    +"      Processor: "+productArchiver.cellphoneProductList.get(i).getProcessor()
                    +"      Operating System: "+productArchiver.cellphoneProductList.get(i).getOperatingSystem()
                    +"      Memory RAM: "+productArchiver.cellphoneProductList.get(i).getMemoryRAM()+"GB"
                    +"      Hard Drive: "+productArchiver.cellphoneProductList.get(i).getHardDrive()+"GB"
                    +"      Camera: "+productArchiver.cellphoneProductList.get(i).getCamera()+"PXL"
            );
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
}
