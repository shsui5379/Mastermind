/**
 * A peg carrying a symbol
 */
public class Peg {
  /** The symbol stored by this Peg */
  private final String SYMBOL;

  /**
   * Constructs a Peg and initializes its symbol
   * @param symbol  The symbol this Peg represents
   */
  public Peg(String symbol) {
    SYMBOL = symbol;
  }

  /**
   * Returns whether this Peg and another Peg shares the same symbol
   * @param other  The other Peg
   * @return true if both Pegs share the same symbol
   */
  public boolean equals(Peg other) {
    return SYMBOL.equals(other.SYMBOL);
  }

  /**
   * @return This Peg's symbol
   */
  public String toString() {
    return SYMBOL;
  }
}
