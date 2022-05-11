package shoppingcar;

import product.AProduct;
import product.IDisplayInfo;

import java.util.ArrayList;

public interface ICartPrinter {
    public abstract void displayProductInfo(ArrayList<AProduct> productList);
}
