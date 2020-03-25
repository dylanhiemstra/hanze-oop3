package week3.template;

public class Main {
    public static void main(String[] args) {
        Game csgo = new CSGO();
        csgo.play();
    }
}


abstract class Game {
    abstract void init();
    abstract void start();
    abstract void stop();

    public final void play() {
        init();
        start();
        stop();
    }
}

class CSGO extends Game {
    @Override
    void init() {
        System.out.println("Launching CSGO");
    }

    @Override
    void start() {
        System.out.println("Game in CSGO started");
    }

    @Override
    void stop() {
        System.out.println("Game in CSGO stopped");
    }
}