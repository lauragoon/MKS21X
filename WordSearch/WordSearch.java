import java.util.*;
import java.io.*;

public class WordSearch {
  private char[][] data;
  private  ArrayList<String> wordsToAdd;
  private ArrayList<String> wordsAdded;
  private Random randgen;

  /**Initialize the grid to the size specified
  *fill all of the positions with '_'
  *@param row is the starting height of the WordSearch
  *@param col is the starting width of the WordSearch
  */
  public WordSearch(int rows, int cols) {
    data = new char[rows][cols];
    wordsToAdd = new ArrayList<String>();
    wordsAdded = new ArrayList<String>();
    randgen = new Random();
  }
  public WordSearch(int rows, int cols, String filename, int seed, boolean showKey) {

  }

  /**Set all values in the WordSearch to underscores '_'*/
  public void clear() {
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[i].length; j++) {
        data[i][j] = '_';
      }
    }
  }

  /**The proper formatting for a WordGrid is created in the toString.
  *@return a String with each character separated by spaces, and rows
  *separated by newlines.
  */
  public String toString() {
    String ret = "";
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[i].length; j++) {
        ret += data[i][j];
        ret += " ";
      }
      ret = ret.substring(0, ret.length()-1);
      ret += "\n";
    }
    return ret;
  }

  public void loadWords(String fileName) {
    try {
      Scanner in = new Scanner(new File(fileName));
      while(in.hasNext()) {
        String word = in.next();
        wordsToAdd.add(word);
      }
    } catch(FileNotFoundException e) {
      System.out.println("Invalid filename or path");
      System.exit(1);
    }
  }

  public ArrayList printWordList() {
    return wordsToAdd;
    //return wordsAdded;
  }


  public boolean addWord(String word, int row, int col, int rowChange, int colChange) {
    int len = word.length();
    word = word.toUpperCase();

    // if (row + (r*len) > data.length || row + (r*len) < 0 || col + (c*len) > data[0].length || col + (c*len) < 0) {
    //   return false;
    // }

    try {
      for (int i = 0; i < len; i++) {
        if ((word.charAt(i) != data[row][col]) && (data[row][col] != '_')) {
          return false;
        }
        row += rowChange;
        col += colChange;
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Array Indx Out of Bounds");
      return false;
    }
    for (int i = 0; i < len; i++) {
      data[row][col] = word.charAt(i);
      row += rowChange;
      col += colChange;
    }
    return true;
  }

  public void fillWithWords() {
    int count = 0;
    int initRow = randgen.nextInt(data.length);
    int initCol = randgen.nextInt(data[initRow].length);
    int r = randgen.nextInt(3)-1; //does this really do -1. 0. 1
    int c;
    if (r == 0) {
      c = 1;
    } else {
      c = randgen.nextInt(3)-1;
    }

    for (int i = 0; i < wordsToAdd.size(); i++) {
      while (count < 300) {
        if (addWord(wordsToAdd.get(i),initRow,initCol,r,c)) {
          addWord(wordsToAdd.get(i),initRow,initCol,r,c);
          wordsAdded.add(wordsToAdd.get(i));
          wordsToAdd.remove(i);
        } else {
          count++;
          initRow = randgen.nextInt(data.length);
          initCol = randgen.nextInt(data[initRow].length);
          r = randgen.nextInt(3)-1;
          if (r == 0) {
            c = 1;
          } else {
            c = randgen.nextInt(3)-1;
          }
          if (count >= 150) {
            System.out.println("Error: words dont fit");
            System.exit(1);
          }
        }
      }
    }
    for (int j = 0; j < data.length; j++) {
      for (int k = 0; k < data[j].length; k++) {
        if (data[j][k] == '_') {
          data[j][k] = (char)(randgen.nextInt(26) + 'a');
        }
      }
    }
  }
}
