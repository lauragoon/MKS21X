import java.util.*;
import java.lang.UnsupportedOperationException;

public class SuperArrayIterator implements Iterator<String>{
    private int current;
    private int end;
    
    public SuperArrayIterator(int start, int stop){
	current = start;
	end = stop;
    }
    
    public boolean hasNext(){
	return current < end;
    }

    public int next(){
	if (hasNext()){
	    current++;
	    return current-1;
	} else {
	    throw new NoSuchElementException();
	}
    }

    public void remove(){
	throw new UnsupportedOperationError();
    }
}
