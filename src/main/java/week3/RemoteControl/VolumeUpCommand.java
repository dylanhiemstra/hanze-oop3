package week3.RemoteControl;

// concrete command
public class VolumeUpCommand implements Command {
    
    private Device device;

    public VolumeUpCommand (Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.volumeDown();
    }
}