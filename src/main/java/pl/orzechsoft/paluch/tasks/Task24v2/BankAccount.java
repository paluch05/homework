package pl.orzechsoft.paluch.tasks.Task24v2;
import java.util.List;

public interface BankAccount {

    double getBalance();

    List<Operation> getLastOperations(int n);

    void deposit(double amount, String name);

    void withdraw(double amount, String name);
}