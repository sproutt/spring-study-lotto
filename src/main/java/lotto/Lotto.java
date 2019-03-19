package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final static int[] PRIZE_MONEY = new int[]{0, 0, 0, 5000, 50000, 1500000, 2000000000};
    private List<Long> countedTickets;
    private List<Integer>[] tickets;

    public void setTickets(int numberOfTicket) {
        tickets = (ArrayList<Integer>[]) new ArrayList[numberOfTicket];
        for (int times = 0; times < numberOfTicket; times++) {
            tickets[times] = new ArrayList<>();
        }
    }

    public List<Long> count(List<Integer> winnerNumber) {
        List<Long> countedTickets = new ArrayList<>();
        for (List ticket : tickets) {
            countedTickets.add(countSelectedTicket(ticket,winnerNumber));
        }
        return countedTickets;
    }

    public boolean isExist(int number, List<Integer> winnerNumber) {
        return winnerNumber.contains(number);
    }

    public long countSelectedTicket(List<Integer> ticket, List<Integer> winnerNumber) {
        return ticket.stream().filter(n -> isExist(n, winnerNumber)).count();
    }

    public Object seekIncome(List<Long> countedTicket) {
        int total = 0;
        for (int index = 0; index < countedTicket.size(); index++) {
            total += PRIZE_MONEY[Math.toIntExact(countedTicket.get(index))];
        }
        return total;
    }

    public Object seekEarningsRate(int income) {
        int outcome = tickets.length * 1000
        return income / outcome * 100;
    }

    public Object purchase(int totalPrice) {
        return totalPrice / 1000;
    }
}
