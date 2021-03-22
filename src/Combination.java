import java.util.Arrays;

/**
 * A sequence of Pegs
 */
public class Combination {
  /** Array for the sequence of Pegs */
  private final Peg[] PEGS;

  /**
   * Constructs a Combination and initialize its combination from given Pegs
   * @param combo  The combination of Pegs to store
   */
  public Combination(Peg[] combo) {
    PEGS = combo;
  }

  /**
   * Constructs a Combination and initializes its combination from a given String
   * @param combo  A String representing the Combination to initialize.  Each single character becomes its own Peg
   */
  public Combination(String combo) {
    PEGS = new Peg[combo.length()];

    for (int i = 0; i < PEGS.length; i++)
      PEGS[i] = new Peg(combo.substring(i, i + 1));
  }

  /**
   * Compares this Combination with another Combination
   * @param combo  The other Combination to compare to
   * @return A new Combination.  The first position represents the number of Pegs that are in the same position in both Combinations.  The second position represents the number of Pegs in this Combination that could be found in a different position in the other Combination
   */
  public Combination compare(Combination combo) {
    int exactPositionCount = 0;
    int wrongPositionCount = 0;

    for (int i = 0; i < combo.PEGS.length; i++) {
      if (combo.PEGS[i].equals(PEGS[i])) exactPositionCount++;
      else {
        for (int j = 0; j < combo.PEGS.length; j++) {
          if (i != j) {
            if (combo.PEGS[i].equals(PEGS[j])) {
              wrongPositionCount++;
              break;
            }
          }
        }
      }
    }

    return new Combination(new Peg[] {new Peg(Integer.toString(exactPositionCount)),
                                      new Peg(Integer.toString(wrongPositionCount))});
  }

  /**
   * @return  The number of Pegs in this Combination
   */
  public int getLength() {
    return PEGS.length;
  }

  /**
   * @return This Combination as an Array of Pegs
   */
  public Peg[] toArray() {
    return PEGS;
  }

  /**
   * Compares if the sequence of Pegs are identical
   * @param other  The other Combination to compare with
   * @return  true if both Combinations are identical
   */
  public boolean equals(Combination other) {
    Combination comparison = compare(other);

    return comparison.PEGS[0].equals(new Peg(Integer.toString(other.getLength()))) &&
            comparison.PEGS[1].equals(new Peg(Integer.toString(0)));
  }

  /**
   * @return  String representation of this Combination
   */
  public String toString() {
    return Arrays.toString(PEGS);
  }
}
