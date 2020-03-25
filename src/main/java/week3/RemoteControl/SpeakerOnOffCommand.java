package week3.RemoteControl;

// concrete command
public class SpeakerOnOffCommand implements Command {
    
    enum State {ON, OFF};

    private Device device;
    private State currentState = State.OFF;

    public SpeakerOnOffCommand (Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        if(currentState == State.OFF) {
            currentState = State.ON;
            device.on();
        } else {
            currentState = State.OFF;
            device.off();
        }
    }
}