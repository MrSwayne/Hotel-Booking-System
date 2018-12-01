package hbs.decorator;

public class DiscountDecorator extends absDiscount {
    public DiscountDecorator(Discount dsc) {
	super(dsc);
    }
    private double money;
    @Override
    public void discount() {
	dsc.discount();
	setRoomDiscount(dsc);
    }

    private void setRoomDiscount(Discount dsc) {
	System.out.println("Extra discount for booking more rooms");
    }

    @Override
    public double getDiscount() {
	// TODO Auto-generated method stub
	return money;
    }

   

    @Override//Set discoutn with added rooms
    public void setDiscount(double money) {
	this.money = money;
	
    }
    
}
