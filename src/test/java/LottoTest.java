import jdk.jfr.Description;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.ArrayList;

public class LottoTest {

    @Test
    @Description("로또 개수가 6개인지 확인")
    public void test_lotto_size_is_6(){
        ArrayList<LottoNumber> test_lotto = new ArrayList<>();

        for (int i = 2; i < 7; i++){
            test_lotto.add(new LottoNumber(i));
        }

        assertThatThrownBy(() -> new Lotto(test_lotto)).
                isInstanceOf(IllegalArgumentException.class);
    }
}
