package hbs.decorator;

public class Silver implements Discount {
    private double money;
    @Override
    public void discount() {
	System.out.println("Silver");
	
    }

    @Override
    public double getDiscount() {
	// TODO Auto-generated method stub
	return money;
    }

    @Override
    public void setDiscount(double money) {
	this.money = money;
    }

}
