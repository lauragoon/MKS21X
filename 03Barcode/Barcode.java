import java.lang.IllegalArgumentException;
import java.lang.NumberFormatException;
import java.util.Arrays;

public class Barcode implements Comparable<Barcode>{
  private String _zip;
  private int _checkDigit;
  private static final String[] codes = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};

  public Barcode(String zip){
    if (zip.length() != 5){
      throw new IllegalArgumentException("Invalid length");
    }
    try{
      Integer.parseInt(zip);
    } catch(NumberFormatException e){
      throw new IllegalArgumentException("Invalid character(s)");
    }
    _zip = zip;
    _checkDigit = checkSum()%10;
  }

  private int checkSum(){
    int sum = 0;
    for (int i = 0; i < _zip.length(); i++) {
      sum += Character.getNumericValue(_zip.charAt(i));
    }
    return sum;
  }

  public String toCode(String zip){
    if (zip.length() != 5){
      throw new IllegalArgumentException("Invalid length");
    }
    try{
      Integer.parseInt(zip);
    } catch(NumberFormatException e){
      throw new IllegalArgumentException("Invalid character(s)");
    }
    String ret = "|";
    for (int i = 0; i < zip.length(); i++){
      ret += codes[Character.getNumericValue(zip.charAt(i))];
    }
    ret += "|";
    return ret;
  }

  public String toZip(String bar){
    if (bar.length() != 32){
      throw new IllegalArgumentException("Invalid length");
    }
    if (bar.charAt(0) != '|' || bar.charAt(31) != '|'){
      throw new IllegalArgumentException("Invalid end bars");
    }
    for (int i = 0; i < bar.length(); i++) {
      if (bar.charAt(i) != ':' || bar.charAt(i) != '|'){
        throw new IllegalArgumentException("Invalid character(s)");
      }
    }
    String ret = "";
    for (int i = 0; i < 27; i++){
      ret += Integer.toString(Arrays.asList(codes).indexOf(bar.substring(i,i+5)));
    }
    
    return ret;
  }

  public String toString(){
    String digit = Integer.toString(_checkDigit);
    String zip_ = _zip + digit;
    String code = toCode(zip_);
    return zip_ + " " + code;
  }

  public int compareTo(Barcode other){
    return (_zip + Integer.toString(_checkDigit)).compareTo(other._zip + Integer.toString(other._checkDigit));
  }


}
