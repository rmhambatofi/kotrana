package fr.manitra.kotrana;


import java.util.stream.Stream;

/**
 * Created by manitra on 23/10/2016.
 */
public class ScoreBoard {
    private int numEntries = 0;
    private GameEntry[] board;

    public ScoreBoard(int capacity) {
        board = new GameEntry[capacity];
    }

    public void add(GameEntry entry) {
        int newScore = entry.getScore();
        if (numEntries < board.length || newScore > board[numEntries - 1].getScore()) {
            if (numEntries < board.length) {
                numEntries++;
            }
            int j = numEntries - 1;
            while (j > 0 && board[j - 1].getScore() < newScore) {
                board[j] = board[j - 1];
                j--;
            }
            board[j] = entry;
        }
    }

    public GameEntry remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= numEntries) {
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        }
        GameEntry temp = board[i];
        for (int j = i; j < numEntries - 1; j++) {
            board[j] = board[j + 1];
        }
        board[numEntries - 1] = null;
        numEntries--;
        return temp;
    }

    public void printScore() {
        if (numEntries == 0) {
            System.out.println("No high score!");
        } else {
            Stream.of(board).forEach(System.out::println);
        }
    }
}
