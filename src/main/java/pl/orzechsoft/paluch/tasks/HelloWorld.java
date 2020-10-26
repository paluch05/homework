package pl.orzechsoft.paluch.tasks;

public class HelloWorld {
    public static void main(String[] args) {
        String name = getString();
        int modulo = getModulo(name);
        ifEvenCharacters(name, modulo);
    }

    private static String getString() {
        return "Ania";
    }

    private static int getModulo(String name) {
        return name.length() % 2;
    }

    private static void ifEvenCharacters(String name, int modulo) {
        if (modulo == 1) {
            System.out.println(name + " has not an even number of characters");
        } else {
            System.out.println(name + " has an even number of characters");
        }
    }
}
