package product.tv;

public class TvProductPrinter implements IDisplayTvProductInfo {
    @Override
    public void displayProductInfo(TvProductArchiver productArchiver) {
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for(int i = 0; i<productArchiver.tvProductList.size(); i++) {
            System.out.println("#: "+productArchiver.tvProductList.get(i).getId()
                    +"      Type: "+productArchiver.tvProductList.get(i).getProductType()
                    +"      Price: $"+productArchiver.tvProductList.get(i).getPrice()
                    +"      Serie: "+productArchiver.tvProductList.get(i).getSerie()
                    +"      Brand: "+productArchiver.tvProductList.get(i).getBrand()
                    +"      Tax: $"+productArchiver.tvProductList.get(i).getTax()
                    +"      Television size: "+productArchiver.tvProductList.get(i).getTvsize()
                    +"      Television type: "+productArchiver.tvProductList.get(i).getTvtype()
                    +"      Smart tv: "+productArchiver.tvProductList.get(i).getSmart()

            );
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
    @Override
    public void displayMessage(String msg) {
        System.out.println(msg);
    }
}