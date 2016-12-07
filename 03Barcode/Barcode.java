import java.lang.RuntimeException;
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
	    throw new RuntimeException();
	}
	try{
	    Integer.parseInt(zip);
	} catch (NumberFormatException e){
	    throw new RuntimeException();
	}
	_zip = zip;
    }

    // postcondition: creates a copy of a bar code
    // public Barcode clone(Barcode x){}

    // postcondition: computes and returns the check sum for _zip
    private int checkSum(){
	int sum = 0;
	for (int i = 0; i < _zip.length(); i++) {
	    sum += Character.getNumericValue(_zip.charAt(i));
	}
	return sum;
    }

    // helper function!
    // postcondition: convert num string to bar string
    public String convert(String num){
	String ret = "";
	switch (num){
	case "1": ret = ":::||";
	case "2": ret = "::||:|";
	case "3": ret = "::||:";
	case "4": ret = ":|::|";
	case "5": ret = ":|:|:";
	case "6": ret = ":||::";
	case "7": ret = "|:::|";
	case "8": ret = "|::|:";
	case "9": ret = "|:|::";
	case "0": ret = "||:::";
	default: break;
	}
	return ret;
    }

    // postcondition: format zip + check digit + Barcode
    // ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"
    public String toString(){
	String code = "";
	String digit = Integer.toString(checkSum()%10);
	String zip_ = _zip + digit;
	for (int i = 0; i < zip_.length(); i++){
	    code += convert(zip_.substring(i,i+1));
	    //code += zip_.substring(i,i+1);
	}
	return zip_ + "  " + "|" + code + "|";
    }

    // postcondition: compares the zip + checkdigit, in numerical order
    public int compareTo(Barcode other){
	return 1+1;
    }

    // main
    public static void main (String[] args){
	Barcode ex = new Barcode("11229");
	System.out.println(ex.toString());
	//System.out.println("TEST");
	//System.out.println("digit: " + Integer.toString((1+1+2+2+9)%10));
	System.out.println("|:::||:::||::|:|::|:||:|:::|:|:|");
    }
}
