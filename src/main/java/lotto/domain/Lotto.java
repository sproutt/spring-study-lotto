package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final static int[] PRIZE_MONEY = new int[]{0, 0, 0, 5000, 50000, 1500000, 2000000000};
    private static List<Integer>[] tickets;

    public void makeTickets(int numberOfTicket) {
        tickets = (List<Integer>[]) new List[numberOfTicket];
        for (int times = 0; times < numberOfTicket; times++) {
            tickets[times] = new ArrayList<Integer>();
        }
    }

    public void setTickets(int index, List<Integer> Numbers) {
        tickets[index] = Numbers;
    }

    public List<Integer> count(List<Integer> winnerNumber) {
        List<Integer> countedTickets = new ArrayList<>();
        for (List ticket : tickets) {
            countedTickets.add(countSelectedTicket(ticket, winnerNumber));
        }
        return countedTickets;
    }

    public boolean isExist(int number, List<Integer> winnerNumber) {
        return winnerNumber.contains(number);
    }

    public int countSelectedTicket(List<Integer> ticket, List<Integer> winnerNumber) {
        return (int) ticket.stream().filter(n -> isExist(n, winnerNumber)).count();
    }

    public int seekIncome(List<Integer> countedTicket) {
        int total = 0;
        for (int index = 0; index < countedTicket.size(); index++) {
            total += PRIZE_MONEY[countedTicket.get(index)];
        }
        return total;
    }

    public double seekEarningsRate(int income) {
        int outcome = tickets.length * 1000;
        return (double) income / outcome * 100;
    }
}
