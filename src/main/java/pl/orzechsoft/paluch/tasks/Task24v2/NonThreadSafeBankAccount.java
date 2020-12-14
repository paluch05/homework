package pl.orzechsoft.paluch.tasks.Task24v2;

import lombok.Getter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class NonThreadSafeBankAccount implements BankAccount{

    @Getter
    private double totalWithdrawn = 0;
    @Getter
    private double totalDeposited = 0;

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
        System.out.println(String.format("[DEPOSIT] (%.2f$)", amount ));
        addOperation(new Operation(amount, System.currentTimeMillis(), name));
    }
    @Override
    public void withdraw ( double amount, String name){
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount cannot be equal to or lower than 0");
        }
        System.out.println(String.format("[WITHDRAW] (%.2f$)", amount ));
        addOperation(new Operation(-1 * amount, System.currentTimeMillis(), name));
    }

    synchronized private void addOperation(Operation o){
        if(getBalance() + o.getAmount() < 0) {
            System.out.println(" ! "+o.toString());
            System.out.println("  >> Cannot do operation! Balance would be negative");
            System.out.println(String.format("  >> Balance (%.2f$) ", getBalance()));
            System.out.println(String.format("  >> Would be (%.2f$)", getBalance() + o.getAmount() ));
            return;
        }

        if(o.getName().equals("Depositer depositing")) {
            totalDeposited += o.getAmount();
        } else if(o.getName().equals("Withdrawer withdrawing")) {
            totalWithdrawn += o.getAmount();
        }
        operations.add(o);
    }
}