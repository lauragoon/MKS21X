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

<<<<<<< HEAD
  // postcondition: convert bar string to num string
  public String toZip(Sting zip){
      String ret = "";
      for (int i = 0; i < zip.length(); i++) {
	  switch (zip[i]){
	      case
	  }
      }
  }

  // helper function!
  // postcondition: convert num string to bar string
  public String toCode(String num){
    String ret = "";
    for (int i = 0; i < num.length(); i++) {

    switch (num[i]){
    case "1":
        ret+ = ":::||";
        break;
    case "2":
        ret+ = "::|:|";
        break;
    case "3":
        ret+ = "::||:";
        break;
    case "4":
        ret+= ":|::|";
        break;
    case "5":
        ret+= ":|:|:";
        break;
    case "6":
        ret+= ":||::";
        break;
    case "7":
        ret+= "|:::|";
        break;
    case "8":
        ret+= "|::|:";
        break;
    case "9":
        ret += "|:|::";
        break;
    case "0":
        ret += "||:::";
        break;
    default:
        break;
=======
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
>>>>>>> 352c340cdf22f2175c7d5dd2c2ad4f4195578107
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
<<<<<<< HEAD
    //for (int i = 0; i < zip_.length(); i++){
      //code += zip_.substring(i,i+1);
      //code += convert(zip_.substring(i,i+1));
    //}
    code = toBar(zip_);
    return zip_ + "  " + "|" + code + "|";
=======
    String code = toCode(_zip);
    return zip_ + " " + code;
>>>>>>> 352c340cdf22f2175c7d5dd2c2ad4f4195578107
  }

  public int compareTo(Barcode other){
    return (_zip + Integer.toString(_checkDigit)).compareTo(other._zip + Integer.toString(other._checkDigit));
  }

  public static void main(String args[]){
    //
    //toZip TESTS
    //
    System.out.println("\ntoZip TESTS");
    System.out.println(Barcode.toZip(Barcode.toCode("99999"))); //99999

    //exceptions for toZip()
    try{
      Barcode.toZip("|:|");
    }catch(IllegalArgumentException e){
      e.printStackTrace();//not correct length
    }

    try{
      Barcode.toZip("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
    }catch(IllegalArgumentException e){
      e.printStackTrace();//invalid guard rails
    }

    try{
      Barcode.toZip("|eeeeeeeeeeeeeeeeeeeeeeeeeeeeee|");
    }catch(IllegalArgumentException e){
      e.printStackTrace();//invalid barcode characters
    }

    try{
      Barcode.toZip("|||:::|::|::|::|:|:||||:|||::|:|");
    }catch(IllegalArgumentException e){
      e.printStackTrace();//encoded int invalid
    }

    try{
      Barcode.toZip("|||:::|::|::|::|:|:|::::|||::|||");
    }catch(IllegalArgumentException e){
      e.printStackTrace();//invalid checkDigit
    }
  }

}
