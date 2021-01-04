package pl.orzechsoft.paluch.tasks.Task23.Observer;

public class ObserverMain {

    public static void main(String[] args) {
        CarnegieHall carnegieHall = new CarnegieHall();

        for (int i = 0; i < 10; i++){
            System.out.println(carnegieHall.isTicketAvailable());
        }

        Client client1 = new Client("First");
        Client client2 = new Client("Second");

        carnegieHall.subscribeTickets(client1);
        carnegieHall.subscribeTickets(client2);

        carnegieHall.makeTicketsAvailable();
        for (int i = 0; i < 10; i++){
            System.out.println(carnegieHall.isTicketAvailable());
        }
    }
}