package week3.RemoteControl;

// invoker
public class bUp implements Button {

    private Command command;

    @Override
    public void setCommand(Command cmd) {
        this.command = cmd;
    }

    @Override
    public void pressButton() {
        this.command.execute();
    }
}