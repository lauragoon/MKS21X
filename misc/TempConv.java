public class TempConv extends JFrame implements ActionListener{
    private Container pane;
    private 

    public void actionPerformed(ActionEvent e){
    }

    public TempCov(){
	this.setTitle("Fahrenheit/Celcius Converter");
	this.setSize(500,500);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

  public static double CtoF(double t){
    return (t * 9 / 5) + 32;
  }

  public static double FtoC(double t){
    return (t - 32) * 5 / 9;
  }
  
    public static void main(String[] args){
	TempConv w = new TempConv();
	w.setVisible(true);
    }
}
