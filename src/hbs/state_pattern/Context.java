package hbs.state_pattern;

public class Context {
    private Check_In_Out check;
    
    public Context() {
	check = null;
    }
    
    public void setCheck(Check_In_Out check)
    {
	this.check = check;
    }
    
    public Check_In_Out getCheck() {
	return check;
    }
}
