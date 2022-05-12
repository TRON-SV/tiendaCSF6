package product.tv.interfaces;

import product.IDisplayInfo;
import product.tv.TvProductManager;

//Liskov Substitution By Extending the base interface over further interfaces
public interface IDisplayTvProductInfo extends IDisplayInfo {
    public abstract void displayProductInfo(TvProductManager productArchiever);
}