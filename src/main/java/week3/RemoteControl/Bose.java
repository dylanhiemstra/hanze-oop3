package week3.RemoteControl;

// a comand receiver
public class Bose implements Device {

    private int volume = 0;

    @Override
    public void on() {
        System.out.println("Bose is on");
    }

    @Override
    public void off() {
        System.out.println("Bose is off");
    }

    @Override
    public void volumeUp() {
        volume++;
        System.out.println("Bose volume is " + volume);
    }

    @Override
    public void volumeDown() {
        volume--;
        System.out.println("Bose volume is " + volume);
    }
}