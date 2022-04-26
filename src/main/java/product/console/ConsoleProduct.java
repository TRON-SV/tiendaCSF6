package product.console;

import product.ProductAbstractClass;

public class ConsoleProduct extends ProductAbstractClass implements IPlayVideoGame {
    private Integer diskCapacity;
    private boolean diskReader;

    public ConsoleProduct(Integer diskCapacity, boolean diskReader) {
        super();
        this.diskCapacity = diskCapacity;
        this.diskReader = diskReader;
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
}
