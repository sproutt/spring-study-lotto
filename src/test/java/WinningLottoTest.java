import jdk.jfr.Description;
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {
    @Test
    @Description("당첨 로또 번호가 6개인지 확인")
    public void test_winning_lotto_size_is_6(){
        ArrayList<LottoNumber> test_winning_lotto = new ArrayList<>();

        for (int i = 2; i < 7; i++){
            test_winning_lotto.add(new LottoNumber(i));
        }

        assertThatThrownBy(() -> new WinningLotto(test_winning_lotto)).
                isInstanceOf(IllegalArgumentException.class);
    }
}