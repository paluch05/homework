package pl.orzechsoft.paluch.tasks.Task23.Observer;

public class Client {

    private final String name;

    public Client(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void notifyOfTicketsAvailability(){
        System.out.println("Finally I can go to the concert! My name is " + name);
    }
}