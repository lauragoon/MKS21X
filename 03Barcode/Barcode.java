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
    public Barcode clone(Barcode x){
    }

    // postcondition: computes and returns the check sum for _zip
    private int checkSum(){
	int sum = 0;
	for (int i = 0; i < _zip.length(); i++) {
	    sum += Character.getNumericValue(_zip.charAt(i));
	}
	return sum;
    }

    // postcondition: format zip + check digit + Barcode
    // ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"
    public String toString(){}

    // postcondition: compares the zip + checkdigit, in numerical order
    public int compareTo(Barcode other){}
}
