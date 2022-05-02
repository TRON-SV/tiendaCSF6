package product.console;

import lombok.*;
import product.IDeviceSwitcher;
import product.IPlayVideoGame;
import product.ProductAbstractClass;
//Open for Extension, Closed for Modification BY EXTENDING the ProductAbstractClass
@AllArgsConstructor
public @Data @EqualsAndHashCode(callSuper = false) class ConsoleProduct extends ProductAbstractClass implements IPlayVideoGame, IDeviceSwitcher {
    private Integer diskCapacity;
    private Boolean diskReader;
    @Builder
    public ConsoleProduct(){
        super();
    }
    @Override
    public void playVideoGame() {
        System.out.println("Playing a video game...");
    }
    @Override
    public void turnOnDevice() {
        System.out.println("Turning ON Device...");
    }
    @Override
    public void turnOffDevice() {
        System.out.println("Turning OFF Device...");
    }
}
