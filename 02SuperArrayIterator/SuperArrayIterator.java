import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.UnsupportedOperationException;

public class SuperArrayIterator implements Iterator<String>{
  private SuperArray which;
  private int now;

  public SuperArrayIterator(SuperArray ar){
    which = ar;
    now = 0;
  }

  public boolean hasNext(){
    return which.size()-1 > now;
  }

  public String next(){
    if (hasNext()){
      now++;
      return which.get(now-1);
    } else {
      throw new NoSuchElementException();
    }
  }

  public void remove(){
    throw new UnsupportedOperationException();
  }

}
