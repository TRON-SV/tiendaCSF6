package product.tv;

import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import product.console.ConsoleProductPrinter;
import product.tv.interfaces.IDisplayTvProductInfo;

@NoArgsConstructor
public class TvProductPrinter implements IDisplayTvProductInfo {
    private static final Logger LOGGER = LogManager.getLogger(TvProductPrinter.class);
    @Override
    public void displayProductInfo(TvProductManager productArchiver) {
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for(int i = 0; i<productArchiver.tvProductList.size(); i++) {
            System.out.println("#: "+productArchiver.tvProductList.get(i).getId()
                    +"      Type: "+productArchiver.tvProductList.get(i).getProductType()
                    +"      Name: "+productArchiver.tvProductList.get(i).getName()
                    +"      Price: $"+productArchiver.tvProductList.get(i).getPrice()
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
        LOGGER.info(msg);
    }
}
