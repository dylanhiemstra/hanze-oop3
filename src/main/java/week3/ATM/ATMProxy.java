package week3.ATM;

public class ATMProxy {
    private ATM realATM;

    public ATMState getATMState() {
        return realATM.getState();
    }

    public int getCashInMachine() {
        return realATM.getCashInMachine();
    }
}
