import java.util.ArrayList;

public class Lotto {
    ArrayList<LottoNumber> lotto;

    public Lotto(ArrayList<LottoNumber> lotto){
        validate_lotto_size_is_6(lotto);
        this.lotto = lotto;
    }

    private void validate_lotto_size_is_6(ArrayList<LottoNumber> lotto){
        if (!(lotto.size() == 6)){
            throw new IllegalArgumentException();
        }
    }
}
