package product.tv;

import product.ProductAbstractClass;

public class TvProduct extends ProductAbstractClass {
    private String tvsize;
    private Boolean smart;

    public String getTvsize() {
        return tvsize;
    }

    public void setTvsize(String tvsize) {
        this.tvsize = tvsize;
    }

    public Boolean getSmart() {
        return smart;
    }

    public void setSmart(Boolean smart) {
        this.smart = smart;
    }

    public String getTvtype() {
        return tvtype;
    }

    public void setTvtype(String tvtype) {
        this.tvtype = tvtype;
    }

    private String tvtype;


}
