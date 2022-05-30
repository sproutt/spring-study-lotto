import java.util.ArrayList;

public class WinningLotto {
    ArrayList<LottoNumber> winningLotto;

    public WinningLotto(ArrayList<LottoNumber> winningLotto){
        validate_winning_lotto_size_is_6(winningLotto);
        this.winningLotto = winningLotto;
    }

    private void validate_winning_lotto_size_is_6(ArrayList<LottoNumber> winningLotto){
        if (!(winningLotto.size() == 6)){
            throw new IllegalArgumentException();
        }
    }
}