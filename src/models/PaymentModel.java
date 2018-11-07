package hbs.models;

public class PaymentModel
{
	private int totalPrice, pID, bID;
	private boolean isPaid;
	
	public int getPID()
	{
		return pID;
	}
	
	public int getBID()
	{
		return bID;
	}
	
	public void setTotalPrice(int totalPrice)
	{
		this.totalPrice = totalPrice;
	}
	
	public int getTotalPrice()
	{
		return totalPrice;
	}
	
	public void setIsPaid(boolean isPaid)
	{
		this.isPaid = isPaid;
	}
	
	public boolean getIsPaid()
	{
		return isPaid;
	}
}