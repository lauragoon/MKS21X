import java.lang.IllegalArgumentException;
import java.lang.NumberFormatException;

public class Barcode implements Comparable<Barcode>{
  // instance variables
  private String _zip;
  private int _checkDigit;

  // constructors
  // precondition: _zip.length() = 5 and zip contains only digits
  // postcondition: throws a runtime exception zip is not the correct
  //                or zip contains a non digit
  //                _zip and _checkDigit are initialized
  public Barcode(String zip){
    if (zip.length() != 5){
      throw new IllegalArgumentException();
    }
    try{
      Integer.parseInt(zip);
    } catch (NumberFormatException e){
      throw new IllegalArgumentException();
    }
    _zip = zip;
    _checkDigit = checkSum();
  }

  // postcondition: creates a copy of a bar code
  public Barcode clone(Barcode x){
    Barcode cp = new Barcode(_zip);
    return cp;
  }

  // postcondition: computes and returns the check sum for _zip
  private int checkSum(){
    int sum = 0;
    for (int i = 0; i < _zip.length(); i++) {
      sum += Character.getNumericValue(_zip.charAt(i));
    }
    return sum;
  }

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
    }
    return ret;
  }

  // postcondition: format zip + check digit + Barcode
  // ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"
  public String toString(){
    String code = "";
    String digit = Integer.toString(checkSum()%10);
    String zip_ = _zip + digit;
    //for (int i = 0; i < zip_.length(); i++){
      //code += zip_.substring(i,i+1);
      //code += convert(zip_.substring(i,i+1));
    //}
    code = toBar(zip_);
    return zip_ + "  " + "|" + code + "|";
  }

  // postcondition: compares the zip + checkdigit, in numerical order
  public int compareTo(Barcode other){
    return (_zip + Integer.toString(_checkDigit)).compareTo(other._zip + Integer.toString(other._checkDigit));
  }

}
