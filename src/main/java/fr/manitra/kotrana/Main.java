package fr.manitra.kotrana;

/**
 * Created by manitra on 24/10/2016.
 */
public class Main {
    public static void main(String[] args) {
        ScoreBoard scoreBoard = new ScoreBoard(10);
        scoreBoard.add(new GameEntry("Jack", 510));
        scoreBoard.add(new GameEntry("Rose", 590));
        scoreBoard.add(new GameEntry("Mike", 1105));
        scoreBoard.add(new GameEntry("Rob", 750));
        scoreBoard.add(new GameEntry("Jill", 740));

        scoreBoard.printScore();

        System.out.println(Math.sqrt(100));
    }
}
