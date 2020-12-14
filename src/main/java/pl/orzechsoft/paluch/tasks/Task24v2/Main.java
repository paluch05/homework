package pl.orzechsoft.paluch.tasks.Task24v2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        NonThreadSafeBankAccount bankAccount = new NonThreadSafeBankAccount();
        final int MAX_OPERATIONS = 10;

        Thread withdrawer = new Thread(
                () -> {
                    for (int i = 0; i < MAX_OPERATIONS; i++) {
                        bankAccount.withdraw(new Random().nextDouble() * 1000, "Withdrawer withdrawing");
                        try {
//                                System.out.println("[WITHDRAWER] Waiting for next iteration...");
                            Thread.sleep(new Random().nextInt(1000));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }, "withdrawer");


        Thread depositer = new Thread(
                () -> {
                    for (int i = 0; i < MAX_OPERATIONS; i++) {
                        bankAccount.deposit(new Random().nextDouble() * 1000, "Depositer depositing");
                        try {
//                                System.out.println("[DEPOSITER] Waiting for next iteration...");
                            Thread.sleep(new Random().nextInt(1000));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                },
                "depositer");

        Thread checker = new Thread(
                () -> {
                    for (int i = 0; i < MAX_OPERATIONS; i++) {
                        int randomInt = new Random().nextInt((10-1) + 1 ) + 1;
                        List<Operation> lastOperations = bankAccount.getLastOperations(randomInt);
                        if(lastOperations.size() == 0){
                            System.out.println("0 bank operations made yet!");
                        } else {
                            System.out.println("Last " + randomInt + " operations are : " + lastOperations.stream()
                                    .map(Operation::toString).collect(Collectors.joining(", ")));
                        }

                        try {
//                                System.out.println("[CHECKER] Waiting for next iteration...");
                            Thread.sleep(new Random().nextInt(1000));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }, "checker");

        withdrawer.start();
        depositer.start();
        checker.start();

        System.out.println("Withdrawer Thread ID: "+withdrawer.getId());
        System.out.println("Depositer Thread ID: "+depositer.getId());
        System.out.println("Checker Thread ID: "+checker.getId());

        checker.join();
        withdrawer.join();
        depositer.join();

        double balance = bankAccount.getBalance();
        double deposited = bankAccount.getTotalDeposited();
        double withdrawn = bankAccount.getTotalWithdrawn();

        System.out.println("\n~~~~~");
        System.out.println("Summary:");
        System.out.println(String.format("|> Current balance: (%.2f$)", bankAccount.getBalance()));
        System.out.println(String.format("|> Total cash deposited: (%.2f$)", bankAccount.getTotalDeposited()));
        System.out.println(String.format("|> Total cash withdrawn: (%.2f$)", bankAccount.getTotalWithdrawn()));
        System.out.println(String.format(
                "|> (%.2f$) = %.2f$ - %.2f$",
                balance,
                deposited,
                withdrawn
        ));
        System.out.println("\n~~~~~");
    }
}