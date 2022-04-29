package product.console;

import product.IDisplayInfo;
//Liskov Substitution By Extending the base interface over further interfaces
public interface IDisplayConsoleProductInfo extends IDisplayInfo {
    public abstract void displayProductInfo(ConsoleProductArchiver productArchiever);
}