package product.computer.interfaces;

import product.IDisplayInfo;
import product.computer.ComputerProductArchiver;

//Liskov Substitution By Extending the base interface over further interfaces
public interface IDisplayComputerProductInfo extends IDisplayInfo {
    public abstract void displayProductInfo(ComputerProductArchiver productArcheiver);
}