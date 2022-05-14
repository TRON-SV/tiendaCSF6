package product.computer.interfaces;

import product.IDisplayInfo;
import product.computer.ComputerProductManager;

//Liskov Substitution By Extending the base interface over further interfaces
public interface IDisplayComputerProductInfo extends IDisplayInfo {
    public abstract void displayProductInfo(ComputerProductManager productArcheiver);
}