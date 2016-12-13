import java.util.Arrays;

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
	int[] ret = new int[data.length];
	for (int counter = 0; counter < data.length; counter++){
	    int champ = counter;
	    for (int i = champ+1; i < data.length-counter; i++){
		if (data[i] < data[champ]){
		    champ = i;
		}
	    }
	    //want to switch data[0] with data[champ].....
	    temp = data[counter];
	    data[counter] = data[champ];
	    data[champ] = temp;
	}
	data = ret;
    }

    public static void main(String[] args){
	int[] test = {3,2,5,7,6,4,7,10,3,4};
        selectionSort(test);
	System.out.println(Arrays.toString(test));
	
    }
}
