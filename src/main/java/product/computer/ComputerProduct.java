package product.computer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import product.AProduct;
import product.EProductType;
import product.IDeviceSwitcher;

@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class ComputerProduct extends AProduct implements IDeviceSwitcher {
    private String operativeSystem;
    private String processor;
    private Float size;
    private Integer memoryRam;
    private Integer hardDisk;

    public ComputerProduct() {
        super();
    }
    @Builder
    public ComputerProduct(String id, EProductType productType, String name, Double price, String brand, Double tax){
        super(id,productType,name,price,brand,tax);
    }

    @Override
    public void turnOnDevice() {
        System.out.println("Turning ON computer...");
    }
    @Override
    public void turnOffDevice() {
        System.out.println("Turning OFF computer...");
    }
}
