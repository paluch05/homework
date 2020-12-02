package pl.orzechsoft.paluch.tasks.Task22.Bridge;

public abstract class Clothing {

    protected Colour colour;

    public Clothing(Colour colour) {
        this.colour = colour;
    }

    abstract public String wear();
}
