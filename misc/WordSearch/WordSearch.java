import java.util.*;
import java.io.*;

public class WordSearch {
  private char[][] data;
  private ArrayList<String> wordsToAdd;
  private ArrayList<String> wordsAdded;
  private Random randgen;
  private String fileName;
  private int seed;
  private boolean key;


  /**Initialize the grid to the size specified
  *fill all of the positions with '_'
  *@param row is the starting height of the WordSearch
  *@param col is the starting width of the WordSearch
  */
  public WordSearch(int rows, int cols, String filename) {
    data = new char[rows][cols];
    clear();
    wordsToAdd = new ArrayList<String>();
    wordsAdded = new ArrayList<String>();
    fileName = filename;
    seed = (int)(Math.random()*10000);
    randgen = new Random(seed);
    key = false;
  }

  public WordSearch(int rows, int cols, String filename, int userSeed, boolean showKey) {
    data = new char[rows][cols];
    clear();
    wordsToAdd = new ArrayList<String>();
    wordsAdded = new ArrayList<String>();
    fileName = filename;
    seed = userSeed;
    key = showKey;
  }

  /**Set all values in the WordSearch to underscores '_'*/
  private void clear() {
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

  public void loadWords() {
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
    // return wordsToAdd;
    return wordsAdded;
  }
  public int printSeed() {
    return seed;
  }


  public boolean addWord(String word, int row, int col, int rowChange, int colChange) {
    int len = word.length();
    word = word.toUpperCase();

    // if (row + (r*len) > data.length || row + (r*len) < 0 || col + (c*len) > data[0].length || col + (c*len) < 0) {
    //   return false;
    // }

    try {
      for (int i = 0; i < data.length; i++) {
        if ((word.charAt(0) == data[row+(i*rowChange)][col+(i*colChange)]) && (data[row+(i*rowChange)][col+(i*colChange)] != '_')) {
          return false;
        }
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Array Indx Out of Bounds");
      return false;
    }
    // for (int i = 0; i < len; i++) {
    //   data[rrow][ccol] = word.charAt(0);
    //   word = word.substring(i);
    //   rrow += rowChange;
    //   ccol += colChange;
    // }
    while ( word.length() > 0) {
      data[row][col] = word.charAt(0);
      if (word.length() == 1) {
        break;
      }
      word = word.substring(1);
      row += rowChange;
      col += colChange;
    }
    return true;
  }

  public void fillRandomWords() {
    for (int j = 0; j < data.length; j++) {
      for (int k = 0; k < data[j].length; k++) {
        if (data[j][k] == '_') {
          data[j][k] = (char)(randgen.nextInt(26) + 'a');
        }
      }
    }
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
      while (count < 9000) {
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
          if (count >= 9000) {
            System.out.println("Error: words dont fit");
            System.exit(1);
          }
        }
      }
    }

    if (!key) {
      fillRandomWords();
    }
  }

  public static void main(String[] args) {
    // System.out.println("Random Seed Num: " + seed);
    if (args.length < 2 || args.length > 5) {
      System.out.println("Please input: java WordSearch <rowSize> <colSize> [<filename> <seed> <showKey>]");
      System.out.println("<rowSize> <colSize> and <seed> as ints");
      System.out.println("<filename> with file extension");
      System.out.println("<showKey> as a boolean");
    }

    if (args.length >= 2) {
      String Filename = "words.txt";
      if (args.length >= 3) {
        Filename = args[2];
        int Seed = (int)(Math.random()*100000);
        boolean Key = false;
        if (args.length >= 4) {
          Seed = Integer.parseInt(args[3]);
          if (args.length == 5) {
            Key = Boolean.parseBoolean(args[4]);
          }
        }
        WordSearch puzz = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Filename, Seed, Key);
        puzz.loadWords();
        puzz.fillWithWords();
        System.out.println(puzz.toString());
        System.out.println(puzz.printWordList());
        System.out.println("Seed Num: " + puzz.printSeed());
      } else {
        WordSearch puzz = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Filename);
        puzz.loadWords();
        puzz.fillWithWords();
        System.out.println(puzz.toString());
        System.out.println(puzz.printWordList());
        System.out.println("Seed Num: " + puzz.printSeed());
      }
    }

  }
}
