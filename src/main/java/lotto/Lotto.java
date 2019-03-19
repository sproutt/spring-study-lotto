package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private int[] PrizeMoney = new int[]{0,0,0,5000,50000,1500000,2000000000};
    private List<Integer>[] tickets;
    public boolean isExist(int number, List<Integer> winnerNumber) {
        return winnerNumber.contains(number);
    }

    public long count(List<Integer> ticket, List<Integer> winnerNumber) {
        return ticket.stream().filter(n-> isExist(n,winnerNumber)).count();
    }

    public Object seekIncome(List<Integer> countedTicket) {
        int total = 0;
        for(int i = 0 ; i < 7 ; i++){
            total = countedTicket.get(i)*PrizeMoney[i];
        }
        return total;
    }

    public Object seekEarningsRate(int income, int outcome) {
        return income / outcome * 100;
    }

    public Object purchase(int totalPrice) {
        return totalPrice / 1000;
    }
}
