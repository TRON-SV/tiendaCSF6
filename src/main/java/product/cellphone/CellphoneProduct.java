package product.cellphone;

import product.IDeviceSwitcher;
import product.ProductAbstractClass;

public class CellphoneProduct extends ProductAbstractClass implements IDeviceSwitcher {

    private String screenSize;
    private String processor;
    private String operatingSystem;
    private Integer memoryRAM;
    private Integer hardDrive;
    private Integer camera;

    public CellphoneProduct() {
        super();
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public int getMemoryRAM() {
        return memoryRAM;
    }

    public void setMemoryRAM(int memoryRAM) {
        this.memoryRAM = memoryRAM;
    }

    public int getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(int hardDrive) {
        this.hardDrive = hardDrive;
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
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
