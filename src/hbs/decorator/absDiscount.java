package hbs.decorator;

public abstract class absDiscount implements Discount {
    protected Discount dsc;
    
    public absDiscount(Discount dsc) {
	this.dsc = dsc;
    }
    
    public void discount() {
	dsc.discount();
    }
}
