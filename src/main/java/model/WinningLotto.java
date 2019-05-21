package model;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    private List<Lotto> winLotto;

    public WinningLotto(){
        winLotto = new ArrayList<>();
    }

    public void addWinLotto(Lotto lotto){
        winLotto.add(lotto);
    }
}
