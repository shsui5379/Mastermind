import java.util.Scanner;

/**
 * Game logic for Mastermind
 */
public class Mastermind {
  /** The Board used in this round */
  private final Board BOARD;
  /** The solution for this round */
  private final Combination SOLUTION;
  /** An Array of possible Pegs for this game */
  private final Peg[] PEGS = new Peg[] {
          new Peg("a"),
          new Peg("b"),
          new Peg("c"),
          new Peg("d"),
          new Peg("e"),
          new Peg("f")
  };
  /** Scanner for getting user input */
  private final Scanner SCANNER = new Scanner(System.in);

  /**
   * Initializes a round of Mastermind
   * @param rows  The number of turns in this round
   * @param columns  The length of the combinations in this round
   */
  public Mastermind(int rows, int columns) {
    BOARD = new Board(rows, columns);
    SOLUTION = getRandomCombination(columns);
  }

  /**
   * Main method for the game
   */
  public void play() {
    while (BOARD.emptyRowsRemain()) {
      System.out.print("Enter guess:  ");
      String inputString = SCANNER.nextLine();
      Combination inputCombo = new Combination(inputString);

      if (validateInput(inputCombo)) {
        Combination results = SOLUTION.compare(inputCombo);
        BOARD.add(inputCombo, results);
        System.out.println(BOARD);
        if (inputCombo.equals(SOLUTION)) {
          System.out.println("Congrats, you solved the code!");
          return;
        }
      } else {
        System.out.println("Invalid input.  Try again.");
      }
    }
    System.out.println("You ran out of guesses.  The solution was " + SOLUTION);
  }

  /**
   * Generates a random Combination of Pegs
   * @param num  The number of Pegs in the Combination
   * @return A random Combination
   */
  private Combination getRandomCombination(int num) {
    Peg[] temp = new Peg[num];
    for (int i = 0; i < temp.length; i++) {
      temp[i] = PEGS[(int) (Math.random() * PEGS.length)];
    }
    return new Combination(temp);
  }

  /**
   * @param input  The Combination from user input
   * @return  true only if the Combination is the same length as the solution and only contain Pegs found in PEGS
   */
  private boolean validateInput(Combination input) {
    for (Peg peg : input.toArray())
      if (!arrayContains(PEGS, peg))
        return false;

    return input.getLength() == SOLUTION.getLength();
  }

  /**
   * @param array  Array to search in
   * @param query  Query to search for
   * @return  true if query is found in array
   */
  private boolean arrayContains(Peg[] array, Peg query) {
    for (Peg peg : array)
      if (peg.equals(query))
        return true;

    return false;
  }

  /**
   * @return  The instructions for Mastermind
   */
  public static String getInstructions() {
    return "In this game, there are 6 pegs, lettered from a to f.\n" +
            "The computer will generate a random sequence of pegs.\n" +
            "Your task is to guess the exact sequence before you run out of turns.\n" +
            "For every turn, the computer will tell you the number of pegs in your guess that's in the correct position, as well as the number of pegs in your guess that does exist in the solution, but in a different position.";
  }
}
