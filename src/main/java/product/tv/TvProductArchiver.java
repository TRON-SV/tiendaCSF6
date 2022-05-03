package product.tv;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor @NoArgsConstructor
@Data
public class TvProductArchiver implements ITvProductArchiver, ITvProductModifier {
    //VARIABLES DEFINITION
    TvProduct tvProduct = new TvProduct();
    TvProductPrinter productPrinter = new TvProductPrinter();
    public ArrayList<TvProduct> tvProductList = new ArrayList<TvProduct>();

    @Override
    public void addTvProduct(TvProduct product) {
        this.tvProductList.add(product);
        productPrinter.displayMessage("--------------!PRODUCT "+ product.getId() +" ADDED!-----------------");
    }
    @Override
    public void deleteTvProduct(Integer productSudoId) {
        boolean isTheProductFounded = false;
        for(int i = 0; i< tvProductList.size(); i++){
            if(tvProductList.get(i).getId() == productSudoId){
                isTheProductFounded = true;
                this.tvProductList.remove(i);
            }
        }
        if(isTheProductFounded==true){
            productPrinter.displayMessage("--------------!PRODUCT DELETED!-----------------");
        }else{
            productPrinter.displayMessage("--------------!PRODUCT NOT FOUNDED!-----------------");
        }
    }
    @Override
    public void modifyTvProduct(TvProduct product, int productId) {
        for(int i = 0; i< tvProductList.size(); i++){
            if(tvProductList.get(i).getId() == productId){
                //PERFORMING A UPDATE OF THE PRODUCT DATA
                tvProductList.get(i).setProductType(product.getProductType());
                tvProductList.get(i).setPrice(product.getPrice());
                tvProductList.get(i).setSerie(product.getSerie());
                tvProductList.get(i).setTax(product.getTax());
                tvProductList.get(i).setBrand(product.getBrand());
                tvProductList.get(i).setTvtype(product.getTvtype());
                tvProductList.get(i).setSmart(product.getSmart());
                tvProductList.get(i).setTvsize(product.getTvsize());
                productPrinter.displayMessage("--------------!PRODUCT UPDATED!-----------------");
            }
        }
    }
}
