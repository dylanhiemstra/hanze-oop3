package week3.ATM;


public interface ATMState {

    void insertCard(ATM atm);

    void ejectCard(ATM atm);

    void insertPin(ATM atm);

    void requestAmount(ATM atm);

}

// implement the 5 concrete states
class IdleState implements ATMState {
    @Override
    public void insertCard(ATM atm) {
        System.out.println("Card inserted!");
        atm.setState(new CardInserted());
    }

    @Override
    public void ejectCard(ATM atm) {
        System.out.println("Cannot eject card");
    }

    @Override
    public void insertPin(ATM atm) {
        System.out.println("Cannot insert pin");
    }

    @Override
    public void requestAmount(ATM atm) {
        System.out.println("Cannot request amount");
    }
}

class CardInserted implements ATMState {
    @Override
    public void insertCard(ATM atm) {
        System.out.println("Card already inserted");
    }

    @Override
    public void ejectCard(ATM atm) {
        System.out.println("Card ejected");
        atm.setState(new IdleState());
    }

    @Override
    public void insertPin(ATM atm) {
        System.out.println("PINCODE inserted");
        atm.setState(new PinInserted());
    }

    @Override
    public void requestAmount(ATM atm) {
        System.out.println("Cannot request amount yet!");
    }
}

class PinInserted implements ATMState {
    @Override
    public void insertCard(ATM atm) {
        System.out.println("Card already inserted");
    }

    @Override
    public void ejectCard(ATM atm) {
        System.out.println("Card ejected");
        atm.setState(new IdleState());
    }

    @Override
    public void insertPin(ATM atm) {
        System.out.println("Pin already inserted");
    }

    @Override
    public void requestAmount(ATM atm) {
        System.out.println("you have zero dollars");
    }
}