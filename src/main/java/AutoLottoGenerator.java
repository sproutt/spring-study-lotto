import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoGenerator {

    private static List<LottoNumber> lotto;

    static {
        lotto = new ArrayList<>();
        for(int i = LottoNumber.MIN_NUMBER; i <= LottoNumber.MAX_NUMBER; i++) {
            lotto.add(LottoNumber.of(i));
        }
    }

    public static Lotto generate() {
        Collections.shuffle(lotto);
        return new Lotto(lotto.subList(0,6));
    }
}