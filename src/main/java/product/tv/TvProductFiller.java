package product.tv;

import lombok.NoArgsConstructor;
import product.EProductType;

@NoArgsConstructor
public class TvProductFiller implements IFillSingleTvProduct, IFillSeveralTvProduct {
    @Override
    public void fillProduct(TvProduct product, TvProductArchiver productArchiver) {
        productArchiver.tvProduct = product;
        product.setId("TV-"+productArchiver.tvProductList.size());
    }
    @Override
    public void fillProducts(Integer quantity, TvProductArchiver productArchiever) {
        for(int i=0; i<quantity; i++) {
            TvProduct tvProduct = new TvProduct();
            tvProduct.setId("TV-"+productArchiever.tvProductList.size());
            tvProduct.setProductType(EProductType.TV);
            tvProduct.setName("Product " + i);
            tvProduct.setPrice(500);
            tvProduct.setBrand("Product brand" +i);
            tvProduct.setTax(500);
            tvProduct.setTvsize("19´´"+i);
            tvProduct.setSmart(true);
            tvProduct.setTvtype("LED"+i);
            productArchiever.addTvProduct(tvProduct);
        }
    }


}
