import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    private List<LottoNumber> lotto;

    public Lotto(List<LottoNumber> lotto){
        validateLottoSize(lotto);
        validateLottoIsUnique(lotto);
        this.lotto = lotto;
    }

    private void validateLottoSize(List<LottoNumber> lotto){
        if (!(lotto.size() == LOTTO_SIZE)){
            throw new IllegalArgumentException();
        }
    }
    
    private void validateLottoIsUnique(List<LottoNumber> lotto){
        Set<LottoNumber> lottoNumberSet = new HashSet<>(lotto);

        if (lottoNumberSet.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("중복되는 값이 있습니다.");
        }
    }

    public int getLottoSize() {
        return lotto.size();
    }

    public List<LottoNumber> getLotto() {
        return lotto;
    }
}
