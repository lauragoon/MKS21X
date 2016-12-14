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

    public static void insertionSort(int[] data){
	// int[] temp = new int[data.length];
        boolean sorted = false;
	int counter = 1;
	int insert;
	int temp;
	while !(sorted){
		for (int i = counter-1; i >= 0; i--){
		    if (data[i] < data[counter]){
			insert = i;
			break;
		    } else if (insert != null){
			insert = null;
		    }
		}
		if (insert != null){
		    // gotta move out everything....
		    for (int i = data.length-1; i >= insert; i--) {
			// actually move now
		    }
		}
		
        }
    }

}
