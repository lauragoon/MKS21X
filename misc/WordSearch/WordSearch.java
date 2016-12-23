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
    wordsToAdd = new ArrayList<String>();
    wordsAdded = new ArrayList<String>();
    fileName = filename;
    seed = (int)(Math.random()*10000);
    randgen = new Random(seed);
    key = false;
    data = new char[rows][cols];
    clear();

    try{
      Scanner in = new Scanner(new File(filename));
      while(in.hasNext()){
        String word = in.next();
        wordsToAdd.add(word);
      }
      fillWithWords();
      fillRandomWords();
    } catch(FileNotFoundException e){
      System.out.println("invalid filename or path");
      System.exit(1);
    }
    // printWordList();
  }

  public WordSearch(int rows, int cols, String filename, int userSeed, boolean showKey) {
    wordsToAdd = new ArrayList<String>();
    wordsAdded = new ArrayList<String>();
    fileName = filename;
    seed = userSeed;
    randgen = new Random(seed);
    key = showKey;
    data = new char[rows][cols];
    clear();

    try{
      Scanner in = new Scanner(new File(filename));
      while(in.hasNext()){
        String w = in.next();
        wordsToAdd.add(w);
      }
      fillWithWords();
      if (!showKey){
        fillRandomWords();
      }
    } catch(FileNotFoundException e){
      System.out.println("invalid file or path");
      System.exit(1);
    }
    // printWordList();
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
        if (j == data[i].length - 1){
          ret += data[i][j] + "\n";
        } else{
          ret += data[i][j] + " ";
        }
      }
    }
    return ret;
  }


  public ArrayList printWordList() {
    return wordsAdded;
  }
  public int printSeed() {
    return seed;
  }


  public boolean addWord(String word, int row, int col, int rowChange, int colChange) {
    boolean ret = true;
    int rowCP = row;
    int colCP = col;
    char hi;
    try{
      for (int i = 0; i < word.length(); i++){
        if((data[row+i][col] != '_') && (data[row+i][col] != word.charAt(i))){
          ret = false;
        }
      }
      for (int k = 0; k < word.length(); k++){
        hi = data[rowCP][colCP];
        rowCP += rowChange;
        colCP += colChange;
      }
    }catch(ArrayIndexOutOfBoundsException e){
      ret = false;
    }
    if((rowChange == 0 && colChange == 0) ||
    (rowChange == 0 && (colChange == 1 || colChange == -1) && word.length()+col > data[row].length)||
    ((rowChange == 1 || rowChange == -1) && colChange == 0 && word.length()+row > data.length)||
    ((rowChange == 1 || rowChange == -1) && (colChange == 1 || rowChange == -1) && (word.length()+row > data.length || word.length()+col > data[row].length))){
      ret = false;
    }
    if (ret){
      for (int j = 0; j < word.length(); j++){
        data[row][col] = word.charAt(j);
        row += rowChange;
        col += colChange;
      }
    }
    return ret;
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
    boolean yes;
    while (wordsToAdd.size() > 0){
      yes = false;
      while (count < 9000 && !yes){
        if (addWord(wordsToAdd.get(0), randgen.nextInt(data.length), randgen.nextInt(data[0].length), (int)(randgen.nextInt(3) - 1), (int)(randgen.nextInt(3) - 1))){
          // addWord(wordsToAdd.get(i), randgen.nextInt(data.length), randgen.nextInt(data[0].length), (int)(randgen.nextInt(3) - 1), (int)(randgen.nextInt(3) - 1));
          wordsAdded.add(wordsToAdd.get(0));
          wordsToAdd.remove(wordsToAdd.get(0));
          yes = true;
        } else {
          count++;
        }
        if (count >= 9000){
          System.out.println("words dont fit error");
        }
      }
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
        // puzz.loadWords();
        // puzz.fillWithWords();
        System.out.println(puzz.toString());
        System.out.println(puzz.printWordList());
        System.out.println("Seed Num: " + puzz.printSeed());
      } else {
        WordSearch puzz = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Filename);
        // puzz.loadWords();
        // puzz.fillWithWords();
        System.out.println(puzz.toString());
        System.out.println(puzz.printWordList());
        System.out.println("Seed Num: " + puzz.printSeed());
      }
    }

  }
}
