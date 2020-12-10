package pl.orzechsoft.paluch.tasks.Task24;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class NonThreadSafeBankAccount implements BankAccount {

    List<Operation> operations = Collections.synchronizedList(new LinkedList<>());

    @Override
    public double getBalance() {
        return operations.stream().mapToDouble(Operation::getAmount).sum();
    }

    @Override
    public List<Operation> getLastOperations(int n) {
        return new ArrayList<>(
                operations.subList(Math.max(operations.size() - n, 0), operations.size()));
    }

    @Override
    public void deposit(double amount, String name) {
            if (amount <= 0) {
                throw new IllegalArgumentException("Amount cannot be equal to or lower than 0");
            }
            operations.add(new Operation(amount, System.currentTimeMillis(), name));
    }
    @Override
    public void withdraw ( double amount, String name){
            if (amount <= 0) {
                throw new IllegalArgumentException("Amount cannot be equal to or lower than 0");
            }
            operations.add(new Operation(-1 * amount, System.currentTimeMillis(), name));
    }
}
