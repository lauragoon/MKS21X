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

  /**Set all values in the WordSearch to underscores '_'*/
  private void clear() {
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[i].length; j++) {
        data[i][j] = '_';
      }
    }
    //do i need to return?
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


    // public boolean addWord(String word) {
    //return true;
    // }

    public void fillWithWords() {
	String word = wordsToAdd.remove(randgen.nextInt(wordsToAdd.size()));
	int r = randgen.nextInt(2)-1; //does this really do -1. 0. 1
	int c;
	if (r == 0) {
	    c = 1;
	} else {
	    c = randgen.nextInt(2)-1;
	}
	for (int i = 0; i < word.length(); i++) {
	    //need to find random row and col?? or is given?
	}
    }

  /**Attempts to add a given word to the specified position of the WordGrid.
    *The word is added from Left to right, must fit on the WordGrid, and must
    *have a corresponding letter to match any letters that it overlaps.
    *
    *@param word is any text to be added to word grid.
    *@param row is the vertical location of where you want the word to start.
    *@param col is the horizontal location of where you want the word to start.
    *@return true when the word is added succxessfully. When the word doesn't fit,
    *or there are overlapping letters that do not match, then false is returned.
    */
  public boolean addWordHorizontal(String word, int row, int col) {
    try {
	for (int i = 0; i < word.length(); i++) {
	    data[row][col+i] = word.charAt(i);
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Index is out of bounds");
      return false;
    }
    return true;
  }

  /**Attempts to add a given word to the specified position of the WordGrid.
    *The word is added from top to bottom, must fit on the WordGrid, and must
    *have a corresponding letter to match any letters that it overlaps.
    *
    *@param word is any text to be added to the word grid.
    *@param row is the vertical location of where you want the word to start.
    *@param col is the horizontal location of where you want the word to start.
    *@return true when the word is added succcessfully. WHen the word doesn't fit,
    *or there are overlapping letters that do not match, then false is returned.
    */
  public boolean addWordVertical(String word, int row, int col) {
      try {
	  for (int i = 0; i < word.length(); i++) {
	      data[row+i][col] = word.charAt(i);
	  }
      } catch (ArrayIndexOutOfBoundsException e) {
	  System.out.println("Index is out of bounds");
	  return false;
      }
      return true;
  }
}
