package product.tv;

import lombok.NoArgsConstructor;
import product.EProductType;
import product.console.ConsoleProduct;
import product.tv.interfaces.IFillSeveralTvProduct;
import product.tv.interfaces.IFillSingleTvProduct;

@NoArgsConstructor
public class TvProductFiller implements IFillSeveralTvProduct {
    @Override
    public void fillProducts(Integer quantity, TvProductManager productManager) {
        for(int i=0; i<quantity; i++) {
            TvProduct tvProduct = createNewProduct(productManager.getTvProductList().size());
            tvProduct.setTvsize("19´´"+i);
            tvProduct.setSmart(true);
            tvProduct.setTvtype("LED"+i);
            productManager.addTvProduct(tvProduct);
        }
    }
    public TvProduct createNewProduct(Integer listSize){
        return new TvProduct(
                "TV-"+listSize, EProductType.TV, "Product "+listSize, 500.00, "Product brand"+listSize, 120.5
        );
    }
}
