public class Sorts{

  public static String name(){
    return "06.Goon.Laura";
  }

  /**Selection sort of an int array.
  *Upon completion, the elements of the array will be in increasing order.
  *@param data the elements to be sorted.
  */
  public static void selectionSort(int[] data){
    int temp;
    for (int counter = 0; counter < data.length; counter++){
      int champ = counter;
      for (int i = champ+1; i < data.length; i++){
        if (data[i] < data[champ]){
          champ = i;
        }
      }
      temp = data[counter];
      data[counter] = data[champ];
      data[champ] = temp;
  }

}
