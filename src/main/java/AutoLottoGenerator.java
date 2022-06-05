import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoGenerator {

    public static Lotto generate() {
        List<LottoNumber> lotto = new ArrayList<>();
        for(int i = LottoNumber.MIN_NUMBER; i <= LottoNumber.MAX_NUMBER; i++) {
            lotto.add(LottoNumber.of(i));
        }
        Collections.shuffle(lotto);
        return new Lotto(lotto.subList(0,6));
    }
}