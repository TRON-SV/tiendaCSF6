package product.tv;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import product.AProduct;
import product.EProductType;

@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class TvProduct extends AProduct {
    private String tvsize;
    private Boolean smart;
    private String tvtype;
    public TvProduct(){ super();}
    @Builder
    public TvProduct(String id, EProductType productType, String name, Double price, String brand, Double tax){
        super(id,productType,name,price,brand,tax);
    }
}
