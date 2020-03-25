package week3.RemoteControl;

// concrete command
public class VolumeDownCommand implements Command {
    
    private Device device;

    VolumeDownCommand (Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.volumeDown();
    }
}