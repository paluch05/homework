package pl.orzechsoft.paluch.tasks.Task22.Bridge;

public class Sweater extends Clothing {

    public Sweater(Colour colour) {
        super(colour);
    }

    @Override
    public String wear() {
        return "Sweater worn in " + colour.fill();
    }
}
