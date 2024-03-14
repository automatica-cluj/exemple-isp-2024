package utcluj.isp.curs3.simpleapps.eventticketsystem;

import com.google.zxing.NotFoundException;

import java.io.IOException;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        //Create ticket

          TicketsManager tm = new TicketsManager();
          PurchasedTicket pt = tm.createTicket("ISP", "mihai@mihai.com", "123", "Event1", LocalDateTime.now(), "REG", 100, "22-12-10");
          tm.generateElectronicTicket(pt);

        try {
            boolean result = tm.checkinTicket("C:\\Tickets\\ticket_ISP.png", "1234567890");
            System.out.println("Ticket validated: " + result);
        } catch (IOException | NotFoundException e) {
            e.printStackTrace();
        }

    }
}
