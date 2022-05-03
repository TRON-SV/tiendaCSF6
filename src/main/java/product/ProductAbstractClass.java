package product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
public @Data abstract class ProductAbstractClass {
    private Integer id;
    private String productType;
    private double price;
    private String serie;
    private String brand;
    private double tax;
}