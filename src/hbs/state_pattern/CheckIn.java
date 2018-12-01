package hbs.state_pattern;

public class CheckIn implements Check_In_Out {

    @Override
    public void action(Context context) {
	System.out.println("you check in");
	context.setCheck(this);
	
    }
    public String toString() {
	return "Check in";
    }

}
