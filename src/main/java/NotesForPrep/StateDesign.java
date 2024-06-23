package NotesForPrep;


interface State{
    void handlerequest();
}

class OutOfStockState implements State {
    @Override
    public void handlerequest() {
        System.out.println("Out of stock state !");
    }
}

class ReservedState implements State {
    @Override
    public void handlerequest() {
        System.out.println("Reserved state !");
    }
}

class vendingMachineContext{
    private State state;

    void setState(State state)
    {
        this.state=state;
    }

    void handlerequest()
    {
        state.handlerequest();
    }
}

public class StateDesign {

    public static void main(String[] args) {
        vendingMachineContext v1 = new vendingMachineContext();
        v1.setState(new OutOfStockState());
        v1.handlerequest();
    }
}
