package stuff;

public class ThreadingStuff {

    public static void main(String[] args) {
        new ThreadingStuff().start();
    }

    public void start() {
        new Game();
    }

}

class Game {
    public Player turn;

    private Player player1;
    private Player player2;

    private Thread player1Thread;
    private Thread player2Thread;

    private int moves = 0;

    public Game() {
        player1 = new Player(this, "Player 1");
        player2 = new Player(this, "Player 2");

        turn = player1;

        player1Thread = new Thread(player1);
        player2Thread = new Thread(player2);

        player1Thread.start();
        player2Thread.start();
    }

    public void updateBoard() {
        System.out.println("Updating board!");

        if(turn == player1) {
            turn = player2;
        } else {
            turn = player1;
        }

        moves++;

        if(moves >= 6) {
            System.out.println("Ending game");
            player1Thread.interrupt();
            player2Thread.interrupt();
            System.out.println("Game ended");
        } else {
            notifyAll();
        }

    }
}

class Player implements Runnable {
    private final Game game;
    private final String name;

    public Player(Game game, String name) {
        this.game = game;
        this.name = name;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            synchronized (game) {
                if(game.turn == this) {
                    doTurn();
                } else {
                    try {
                        game.wait();
                    } catch (InterruptedException e) {
                        // e.printStackTrace();
                    }
                }
            }
        }
    }

    private void doTurn() {
        System.out.printf("%s thinking of a turn...\n", name);

        try {
            Thread.sleep(1000); // Let AI decide or wait for user input
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("%s took a turn! \n", name);
        game.updateBoard();
    }
}

