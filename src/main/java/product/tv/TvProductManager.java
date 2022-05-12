package product.tv;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import product.console.ConsoleProduct;
import product.tv.interfaces.ITvProductManager;
import product.tv.interfaces.ITvProductModifier;

import java.util.ArrayList;

@AllArgsConstructor @NoArgsConstructor
@Data
public class TvProductManager implements ITvProductManager, ITvProductModifier {
    //VARIABLES DEFINITION
    TvProduct tvProduct = new TvProduct();
    TvProductPrinter productPrinter = new TvProductPrinter();
    public ArrayList<TvProduct> tvProductList = new ArrayList<>();

    @Override
    public Boolean addTvProduct(TvProduct product) { return tvProductList.add(product); }
    @Override
    public Boolean deleteTvProduct(String productId) {
        for(int i = 0; i< tvProductList.size(); i++){
            if(Boolean.TRUE.equals(isProductFound(tvProductList.get(i),productId))){
                this.tvProductList.remove(i);
                return true;
            }
        }
        return false;
    }
    @Override
    public Boolean modifyTvProduct(TvProduct product, String productId) {
        for(TvProduct currentProduct : getTvProductList()){
            if(Boolean.TRUE.equals(isProductFound(currentProduct,productId))){
                setProductData(currentProduct, product);
                return true;
            }
        }
        return false;
    }
    public Boolean isProductFound(TvProduct product, String productId){
        return product.getId().equals(productId);
    }
    public void setProductData(TvProduct productSource, TvProduct productNew){
        productSource.setId(productNew.getId());
        productSource.setProductType(productNew.getProductType());
        productSource.setName(productNew.getName());
        productSource.setPrice(productNew.getPrice());
        productSource.setBrand(productNew.getBrand());
        productSource.setTax(productNew.getTax());
        productSource.setTvsize(productNew.getTvsize());
        productSource.setSmart(productNew.getSmart());
        productSource.setTvtype(productNew.getTvtype());
    }
    public String generateId(){
        if(!getTvProductList().isEmpty()){
            return "TV-"+ (Integer.parseInt(getTvProductList().get(getTvProductList().size()-1).getId().replaceFirst("TV-","")) + 1);
        }
        return "TV-0";
    }
}
