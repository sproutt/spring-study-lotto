import java.util.List;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    private List<LottoNumber> lotto;

    public Lotto(List<LottoNumber> lotto){
        validateLottoSize(lotto);
        this.lotto = lotto;
    }

    private void validateLottoSize(List<LottoNumber> lotto){
        if (!(lotto.size() == LOTTO_SIZE)){
            throw new IllegalArgumentException();
        }
    }
}
