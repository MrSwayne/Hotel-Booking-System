package hbs.decorator;

public class Platinum implements Discount {
    private double money;
    @Override
    public void discount() {
	System.out.println("Platinum");
	
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
