import java.util.Scanner;
import java.util.Random;

public class hw2 {
    public static void main(String[] args) {

        // random and scanner classes
        Random random = new Random();
        Scanner sc  = new Scanner(System.in);

        String board[][] = new String[6][6];
        String board2[][] = new String[6][6];

        // initialize empty 2-dim array to store user inputs
        String[][] prev_values = new String[100][100];

        // create initial board before the game begins
        System.out.println("The initial board");
        for(int i=0; i<=5; i++) {
            System.out.print(i + " | ");
        }
        System.out.println("");
        for (int j = 1; j <= 5; j++) {
            System.out.print(j + " | ");
            for (int k = 1; k <= 5; k++) {
                board[j][k] = "-";
                System.out.print(board[j][k] + " | ");
            }
            System.out.println("");
        }

        System.out.println("");
        System.out.println("All set. Get ready to rumble!");
        System.out.println("");

        // random variables between 1 and 5
        int rand_j = random.nextInt(5);
        int rand_k = random.nextInt(5);

        // initialize boolean variable which will be used to get out of the while loop if the game is over
        boolean outerBreak = true;

        while(outerBreak) {

            // get the inputs from the user
            System.out.print("Enter a row number: ");
            int user_j = 0;
            boolean check_j = true;

            while (check_j) {
                try {
                    user_j = Integer.parseInt(sc.next());
                } catch (NumberFormatException ex) {
                    System.out.print("Not a number. Please enter a valid number: ");
                    user_j = Integer.parseInt(sc.next());
                }
                while (user_j < 1 || user_j > 5) {
                    System.out.print("Invalid number. Please enter a row number between 1-5: ");
                    user_j = Integer.parseInt(sc.next());
                }
                check_j = false;
            }

            System.out.print("Enter a column number: ");
            int user_k = 0;
            boolean check_k = true;

            while (check_k) {
                try {
                    user_k = Integer.parseInt(sc.next());
                } catch (NumberFormatException ex) {
                    System.out.print("Not a number. Please enter a valid number: ");
                    user_k = Integer.parseInt(sc.next());
                }
                while (user_k < 1 || user_k > 5) {
                    System.out.print("Invalid number. Please enter a column number between 1-5: ");
                    user_k = Integer.parseInt(sc.next());
                }
                check_k = false;
            }

            // print the board again according to user inputs and random variables
            for(int i=0; i<=5; i++) {
                System.out.print(i + " | ");
            }
            System.out.println("");
            for (int j = 1; j <= 5; j++) {
                System.out.print(j + " | ");
                for (int k = 1; k <= 5; k++) {
                    prev_values[j][k] = board[j][k];

                    if (prev_values[j][k] != board[user_j][user_k]) {
                        board[j][k] = "-";
                    }
                    // there are different signs based on two different conditions
                    // that`s why we use if-else statement
                    if(user_j == rand_j && user_k == rand_k) {
                        board[user_j][user_k] = "×";
                    } else {
                        board[user_j][user_k] = "*";
                    }
                    System.out.print(board[j][k] + " | ");
                }
                System.out.println("");
            }
            // in the case if the user inputs meet with the random variables then the program will be terminated
            // and the corresponding message will be printed on the screen
            if(user_j == rand_j && user_k == rand_k) {
                System.out.println("You have won!");
                // we assign false to outerBreak variable in order not to start while loop again
                outerBreak = false;
            }
        }
    }
}