package product.console;

import product.IDeviceSwitcher;
import product.IPlayVideoGame;
import product.ProductAbstractClass;
//Open for Extension, Closed for Modification BY EXTENDING the ProductAbstractClass
public class ConsoleProduct extends ProductAbstractClass implements IPlayVideoGame, IDeviceSwitcher {
    private Integer diskCapacity;
    private boolean diskReader;

    public ConsoleProduct(){
        super();
    }

    public Integer getDiskCapacity() {
        return diskCapacity;
    }
    public void setDiskCapacity(Integer diskCapacity) {
        this.diskCapacity = diskCapacity;
    }
    public boolean isDiskReader() {
        return diskReader;
    }
    public void setDiskReader(boolean diskReader) {
        this.diskReader = diskReader;
    }
    public Boolean getDiskReader() {
        return diskReader;
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
