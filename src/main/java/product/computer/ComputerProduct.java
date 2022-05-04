package product.computer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import product.IDeviceSwitcher;
import product.IProduct;
import product.ProductAbstractClass;

@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class ComputerProduct extends ProductAbstractClass implements IProduct, IDeviceSwitcher {
    private String operativeSystem;
    private String processor;
    private Float size;
    private Integer memoryRam;
    private Integer hardDisk;
    private String description;

    @Builder
    public ComputerProduct() {
        super();
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
