import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TempConv extends JFrame implements ActionListener{
  private Container pane;
  private JButton toCel;
  private JButton toFah;
  private JLabel lab;
  private JTextField in;
  private JTextField out;

  public TempConv(){
    this.setTitle("Fahrenheit/Celcius Converter");
    this.setSize(500,500);
    this.setLocation(100,100);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    pane = this.getContentPane();
    pane.setLayout(new FlowLayout());

    lab = new JLabel("input temperature");
    add(lab);
    in = new JTextField(5);
    toCel = new JButton("convert to Celcius");
    toCel.addActionListener(this);
    toCel.setActionCommand("celcius");
    toFah = new JButton("convert to Fahrenheit");
    toFah.addActionListener(this);
    toFah.setActionCommand("fahrenheit");
    out = new JTextField(5);
    pane.add(in);
    pane.add(toCel);
    pane.add(toFah);
    pane.add(out);
  }

  public void actionPerformed(ActionEvent e){
    String cmd = e.getActionCommand();
    double temp = Double.parseDouble(in.getText());
    if (cmd.equals("celcius")){
      double ret = FtoC(temp);
      out.setText(Double.toString(ret));
    } else if (cmd.equals("fahrenheit")){
      double ret = CtoF(temp);
      out.setText(Double.toString(ret));
    }
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
