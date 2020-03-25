package week3.RemoteControl;

// a comand receiver
public class Megaboom implements Device {

    private int volume = 0;

    @Override
    public void on() {
        System.out.println("Megaboom is on");
    }

    @Override
    public void off() {
        System.out.println("Megaboom is off");
    }

    @Override
    public void volumeUp() {
        volume++;
        System.out.println("Megaboom volume is " + volume);
    }

    @Override
    public void volumeDown() {
        volume--;
        System.out.println("Megaboom volume is " + volume);
    }
}