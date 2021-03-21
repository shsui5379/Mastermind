/**
 * A Board that holds Pegs
 */
public class Board {
  /** A 2D Array of Pegs as a board */
  private final Peg[][] BOARD;
  /** The last row of this board to have been written to */
  private int lastRow = -1;

  /**
   * Constructs and initializes an empty board
   * @param row Number of rows for user selected Pegs
   * @param col Number of columns for user selected Pegs
   */
  public Board(int row, int col) {
    BOARD = new Peg[row][col + 2];
  }

  /**
   * Populates a row of this Board
   * @param combo  The user inputted Combination
   * @param result  The Combination representing the results of comparing user input to answer
   */
  public void add(Combination combo, Combination result) {
    if (lastRow < BOARD.length) {
      lastRow++;
      Peg[] row = BOARD[lastRow];
      Peg[] userCombo = combo.toArray();
      Peg[] resultCombo = result.toArray();

      for (int i = 0; i < row.length - 2; i++)
        row[i] = userCombo[i];

      row[row.length - 2] = resultCombo[0];
      row[row.length - 1] = resultCombo[1];
    }
  }

  /**
   * @return true if there's empty rows left on this Board
   */
  public boolean emptyRowsRemain() {
    return !(BOARD.length == lastRow);
  }

  /**
   * @return the number of Pegs of user input that this Board can fit
   */
  public int getColumns() {
    return BOARD[0].length - 2;
  }

  /**
   * @return  a String representation of this Board
   */
  public String toString() {
    String output = "";

    for (Peg[] row : BOARD) {
      if (row[0] != null) {
        for (int i = 0; i < row.length - 2; i++)
          output += row[i].toString() + "|";

        output += "||" + row[row.length - 2].toString() + "|" + row[row.length - 1].toString() + "\n";
      }
    }

    return output;
  }
}
