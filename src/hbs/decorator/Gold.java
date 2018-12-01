package hbs.decorator;

public class Gold implements Discount {
    private double money;
    @Override
    public void discount() {
	System.out.println("Gold");
	
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
