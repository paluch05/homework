package pl.orzechsoft.paluch.tasks.Task24;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        BankAccount bankAccount = new NonThreadSafeBankAccount();

        Thread withdrawer = new Thread(
                () -> {
                    synchronized (bankAccount) {
                        for (int i = 0; i < 100; i++) {
                            bankAccount.withdraw(new Random().nextDouble() * 1000, "Withdrawer withdrawing");
                            try {
                                Thread.sleep(new Random().nextInt(1000));
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, "withdrawer");

        Thread depositer = new Thread(
                () -> {
                    synchronized (bankAccount) {
                        for (int i = 0; i < 100; i++) {
                            bankAccount.deposit(new Random().nextDouble() * 1000, "Depositer depositing");
                            try {
                                Thread.sleep(new Random().nextInt(1000));
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                "depositer");
        Thread checker = new Thread(
                () -> {
                    synchronized (bankAccount) {
                        for (int i = 0; i < 100; i++) {
                            int randomInt = new Random().nextInt(10);
                            List<Operation> lastOperations = bankAccount.getLastOperations(randomInt);
                            System.out.println("Last " + randomInt + " operations are : " + lastOperations.stream()
                                    .map(Operation::toString).collect(Collectors.joining(", ")));
                            try {
                                Thread.sleep(new Random().nextInt(1000));
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, "checker");

        withdrawer.start();
        depositer.start();
        checker.start();
    }
}