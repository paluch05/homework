package pl.orzechsoft.paluch.tasks.Task23.State;

public class MainPasta {
    public static void main(String[] args) {
        Pasta pasta = new Pasta();
        for (int i = 0; i < 7; i++) {
            pasta.saySmth();
            pasta.boil();
        }


    }
}
