package product.computer;

import product.IDeviceSwitcher;
import product.ProductAbstractClass;

public class ComputerProduct extends ProductAbstractClass implements IDeviceSwitcher {
    private String operativeSystem;
    private String processor;
    private Float size;
    private Integer memoryRam;
    private Integer hardDisk;
    private String description;

    public ComputerProduct() {
        super();
    }

    public void setOperativeSystem(String os) {
        this.operativeSystem = os;
    }
    public String getOperativeSystem() {
        return this.operativeSystem;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }
    public String getProcessor() {
        return processor;
    }

    public void setSize(Float size) {
        this.size = size;
    }
    public Float getSize() {
        return size;
    }

    public void setMemoryRam(int memoryRam) {
        this.memoryRam = memoryRam;
    }
    public int getMemoryRam() {
        return memoryRam;
    }

    public void setHardDisk(int hardDisk) {
        this.hardDisk = hardDisk;
    }
    public int getHardDisk() {
        return hardDisk;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
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
