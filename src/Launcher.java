import java.util.Scanner;

/**
 * Game launcher
 */
public class Launcher {
  private final Scanner SCANNER = new Scanner(System.in);

  public void open() {
    int input = 0;
    while (input != 3) {
      System.out.println("Mastermind:\n\n" +
              "1: Play game\n" +
              "2: Get instructions\n" +
              "3: Quit");

      input = SCANNER.nextInt();
      SCANNER.nextLine();

      if (input == 1) {
        int row = 0;
        int col = 0;

        while (row < 1) {
          System.out.print("How many attempts would you like?  ");
          row = SCANNER.nextInt();
          SCANNER.nextLine();
        }
        while (col < 1) {
          System.out.print("How long should the combinations be?  ");
          col = SCANNER.nextInt();
          SCANNER.nextLine();
        }

        (new Mastermind(row, col)).play();
      } else if (input == 2) {
        System.out.println(Mastermind.getInstructions());
      } else if (input != 3) {
        System.out.println("Invalid option - try again.");
      }
    }
  }
}
