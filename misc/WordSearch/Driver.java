public class Driver {
  public static void main(String[] args) {
    WordSearch puzzle = new WordSearch(20,20);

    puzzle.loadWords("words.txt");

    System.out.println(puzzle.printWordList());
    puzzle.clear();
    System.out.println(puzzle.toString());
    puzzle.fillWithWords();
    System.out.println(puzzle.toString());
  }
}
