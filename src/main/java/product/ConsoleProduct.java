package product;

public class ConsoleProduct extends ProductAbstractClass{
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
}
