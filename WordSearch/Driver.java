public class Driver {
    public static void main(String[] args) {
	WordSearch puzzle = new WordSearch(7,7);

	puzzle.loadWords("words.txt");

	System.out.println(puzzle.printWordList());
    }
}
