package pl.orzechsoft.paluch.tasks.Task23.Observer;

import java.util.LinkedList;
import java.util.List;

public class CarnegieHall {

    List<Client> subscribedClients = new LinkedList<>();
    private boolean isTicketAvailable = false;

    public void subscribeTickets(Client client){
        subscribedClients.add(client);
    }
    public boolean isTicketAvailable() {
        return isTicketAvailable;
    }
    public void makeTicketsAvailable() {
        isTicketAvailable = true;
        for (Client subscribedClient : subscribedClients) {
            subscribedClient.notifyOfTicketsAvailability();
        }
    }
}