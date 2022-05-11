package product.console;

import lombok.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import product.*;
import product.console.interfaces.IPlayVideoGame;

//Open for Extension, Closed for Modification BY EXTENDING the AProduct
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class ConsoleProduct extends AProduct implements IPlayVideoGame, IDeviceSwitcher {
    private static final Logger LOGGER = LogManager.getLogger(ConsoleProduct.class);
    private Integer diskCapacity;
    private Boolean diskReader;

    @Builder
    public ConsoleProduct(String id, EProductType productType, String name, Double price, String brand, Double tax){
        super(id,productType,name,price,brand,tax);
    }
    public ConsoleProduct() {
        super();
    }
    @Override
    public void playVideoGame() { LOGGER.info("Playing a video game..."); }
    @Override
    public void turnOnDevice() {
        LOGGER.info("Turning ON Device...");
    }
    @Override
    public void turnOffDevice() {
        LOGGER.info("Turning OFF Device...");
    }
}
