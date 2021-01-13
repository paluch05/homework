package pl.orzechsoft.paluch.tasks.Task28;

public class MyDatabaseException extends Exception {
    public MyDatabaseException(String message) {
        super(message);
    }

    public MyDatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
