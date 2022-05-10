package product.console.interfaces;

import product.IDisplayInfo;
import product.console.ConsoleProductManager;

//Liskov Substitution By Extending the base interface over further interfaces
public interface IDisplayConsoleProductInfo extends IDisplayInfo {
    public abstract void displayProductInfo(ConsoleProductManager productArchiever);
}