package pl.orzechsoft.paluch.tasks.Task23.State;

public class Pasta {

    private PastaState state;
    private int howManyMinOfBoiling = 0;

    public Pasta() {
        this.state = PastaState.RAW;
    }

    public PastaState getState() {
        return state;
    }

    public void boil(){
        howManyMinOfBoiling++;
        if (state == PastaState.COOKED){
            return;
        }
        if (state == PastaState.COOKING && howManyMinOfBoiling > 5){
            state = PastaState.COOKED;
        } else {
            state = PastaState.COOKING;
        }
    }

    public void saySmth(){
        switch (state) {
            case RAW:
                System.out.println("Dont eat me, I'm raw!");
                break;
            case COOKING:
                System.out.println("I'll be ready in few minutes!");
                break;
            case COOKED:
                System.out.println("Bon appetit!");
        }
    }
}
