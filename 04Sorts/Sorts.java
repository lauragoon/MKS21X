import java.util.Arrays;

public class Sorts{

  public static String name(){
    return "06.Goon.Laura";
  }

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

    public static void insertionSort(int[] data){
      int counter;
      for (int i = 1; i < data.length; i++){
        counter = data[i];
        int j;
        for (j = i-1; (j >= 0)&&(counter < data[j]); j--){
          data[j+1] = data[j];
        }
        data[j+1] = counter;
      }
    }

    public static void bubbleSort(int[] data){
	boolean notSorted = true;
	boolean swapped = false;
	int temp;
	while (notSorted){
	    for (int i = 0; i < data.length-1; i++){
		if (data[i] > data[i+1]){
		    temp = data[i];
		    data[i] = data[i+1];
		    data[i+1] = temp;
		    swapped = true;
		}
	    }
	    if (swapped == false){
		notSorted = false;
	    } else {
		swapped = false;
	    }
	}
    }


    public static void main(String[] args){
	int[] test = {3,5,3,2,10,2,333,4,56,4,365};
	bubbleSort(test);
	System.out.println(Arrays.toString(test));
    }

}
