import java.util.Iterator;

public class SuperArray implements Iterable<String>{
  private String[] data;
  private int size;


  public SuperArray(){
    data = new String[10];
    size = 0;
  }

  public SuperArray(int initialCapacity){
    if (initialCapacity < 0){
      throw new IllegalArgumentException();
    }
    data = new String[initialCapacity];
  }

  public int size(){
    return size;
  }

  public void clear(){
    size = 0;
  }

  public boolean isEmpty(){
    return size == 0;
  }

  public String[] toArray(){ //how to test this
    String[] copy = new String[size];
    for (int i = 0; i < size; i++){
      copy[i] = data[i];
    }
    return copy;
  }

  public int indexOf(String i){
    for (int j = 0; j < size; j++){
      if (data[j] == i){
        return j;
      }
    }
    return -1;
  }

  public int lastIndexOf(String i){
    for (int j = size; j >= 0; j --){
      if (data[j] == i){
        return j;
      }
    }
    return -1;
  }


  public String get(int index){
    if (index < 0 || index >= size()){
      throw new IndexOutOfBoundsException();
    }
    return data[index];
  }


  public String set(int index, String element){
    if (index < 0 || index >= size()){
      throw new IndexOutOfBoundsException();
    }
    String replaced = data[index];
    data[index] = element;
    return replaced;
  }


  public String remove(int index){
    if (index < 0 || index >= size()){
      throw new IndexOutOfBoundsException();
    }
    String removing = data[index];
    for(int i = index; i < size - 1; i++){
      data[i] = data[i+1];
    }
    size--;
    return removing;
  }


  public boolean add(String element){
    add(size,element);
    return true;
  }

  public void add(int index, String element){
    if (index < 0 || index > size()){
      throw new IndexOutOfBoundsException();
    }
    if (size == data.length){
      grow();
    }
    String[] ret;
    ret = new String[data.length+1];
    for (int i =0; i < index; i++ ){
      ret[i] = data[i];
    }
    ret[index] = element;
    for (int i = index+1; i < data.length; i++ ){
      ret[i] = data[i-1];
    }
    size++;
    data = ret;
  }

  // public void add(int element){
  //   add(size, element);
  // }


  public void grow(){
    int bigger;
    if (size == 0) {
      bigger = 4;
    } else {
      bigger = size*2;
    }
    String[] biggerAry = new String[bigger];
    for (int i = 0; i < size; i++){
      biggerAry[i] = data[i];
    }
    data = biggerAry;
  }

  public void trimToSize(){
    String[] ret = new String[size];
    for (int i = 0; i < size; i++){
      ret[i] = data[i];
    }
    data = ret;
  }


  public String toString(){
    String ret = "[ ";
    for (int i = 0; i < size; i++ ){
      ret += data[i] + ", ";
    }
    ret += "]";
    return ret;
  }


  public String toStringDebug(){
    String ret = "[ ";
    for (int i = 0; i < size; i++ ){
      ret += data[i] + ", ";
    }
    for (int i = 0; i < data.length-size; i++ ) {
      ret += "_, ";
    }
    ret += "]";
    return ret;
  }

  //

  public Iterator<String> iterator() {
    return new SuperArrayIterator(this);
  }

  public static void main(String[] args) {
    SuperArray data = new SuperArray();
    int i = 0;
    while(i < 26){
      data.add(""+(char)('A'+i%26));
      i++;
    }

    System.out.println(data);
    System.out.println("Standard loop:");

    for(int n = 0; n < data.size(); n++){
      System.out.print(data.get(n)+" ");
    }
    System.out.println();
    System.out.println("for-each loop:");
    for(String s : data){
      System.out.print(s+" ");
    }
  }
}
