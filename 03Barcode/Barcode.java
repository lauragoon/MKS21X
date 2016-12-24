import java.lang.IllegalArgumentException;
import java.lang.NumberFormatException;
import java.util.Arrays;

public class Barcode implements Comparable<Barcode>{
  private String _zip;
  private int _checkDigit;
  private static final String[] codes = {"||:::",  // 0
                                         ":::||",  // 1
                                         "::|:|",  // 2
                                         "::||:",  // 3
                                         ":|::|",  // 4
                                         ":|:|:",  // 5
                                         ":||::",  // 6
                                         "|:::|",  // 7
                                         "|::|:",  // 8
                                         "|:|::"}; // 9

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

  public int checkSum(){
    int sum = 0;
    for (int i = 0; i < _zip.length(); i++) {
      sum += Character.getNumericValue(_zip.charAt(i));
    }
    return sum;
  }

  public static String toCode(String zip){
    if (zip.length() != 5){
      throw new IllegalArgumentException("Invalid length");
    }
    try{
      Integer.parseInt(zip);
    } catch(NumberFormatException e){
      throw new IllegalArgumentException("Invalid character(s)");
    }
    String ret = "|";
    int sum = 0;
    for (int i = 0; i < zip.length(); i++) {
      sum += Character.getNumericValue(zip.charAt(i));
    }
    int check = sum%10;
    zip += Integer.toString(check);
    for (int i = 0; i < zip.length(); i++){
      ret += codes[Character.getNumericValue(zip.charAt(i))];
    }
    ret += "|";
    return ret;
  }

  public static String toZip(String bar){
    if (bar.length() != 32){
      throw new IllegalArgumentException("Invalid length");
    }
    if (!(bar.charAt(0) == '|' || bar.charAt(31) == '|')){
      throw new IllegalArgumentException("Invalid guard rails");
    }
    for (int i = 0; i < 32; i++) {
      if (!(bar.charAt(i) == ':' || bar.charAt(i) == '|')){
        throw new IllegalArgumentException("Invalid character(s)");
      }
    }
    String ret = "";
    for (int i = 0; i < 6; i++){
      String codeAt = bar.substring(i*5+1, i*5+6);
      int zipAt = Arrays.asList(codes).indexOf(codeAt);
      if (zipAt == -1){
        throw new IllegalArgumentException();
      }
      ret += zipAt;
    }
    int sum = 0;
    for (int i = 0; i < 5; i++){
      sum += Character.getNumericValue(ret.charAt(i));
    }
    if (sum%10 != Character.getNumericValue(ret.charAt(5))){
      throw new IllegalArgumentException();
    }
    return ret.substring(0,5);
  }

  public String toString(){
    String digit = Integer.toString(_checkDigit);
    String zip_ = _zip + digit;
    String code = toCode(_zip);
    return zip_ + " " + code;
  }

  public int compareTo(Barcode other){
    return (_zip + Integer.toString(_checkDigit)).compareTo(other._zip + Integer.toString(other._checkDigit));
  }


}
