package pl.orzechsoft.paluch.tasks.Task22.Bridge;

public class ClothesToWear {
    public static void main(String[] args) {
        Sweater sweater = new Sweater(new Black());
        System.out.println(sweater.wear());
    }
}
