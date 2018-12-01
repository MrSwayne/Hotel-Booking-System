package hbs.state_pattern;

public class CheckOut implements Check_In_Out {
    
    @Override
    public void action(Context context) {
	System.out.println("You have check out");
	context.setCheck(this);
    }
    
    public String toString()
    {
	return "Check out";
    }

}
