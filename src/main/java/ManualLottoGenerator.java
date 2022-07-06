import java.util.ArrayList;
import java.util.List;

public class ManualLottoGenerator {
    private static List<LottoNumber> lottoNumbers;

    static {
        lottoNumbers = new ArrayList<>();
    }

    public static Lotto generate(int i, int manualLottoCount) {
        lottoNumbers = InputView.manualLotto(i, manualLottoCount);
        return new Lotto(lottoNumbers);
    }
}