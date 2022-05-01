package product.tv;

import product.IDisplayInfo;

//Liskov Substitution By Extending the base interface over further interfaces
public interface IDisplayTvProductInfo extends IDisplayInfo {
    public abstract void displayProductInfo(TvProductArchiver productArchiever);
}