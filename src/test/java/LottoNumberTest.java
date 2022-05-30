import jdk.jfr.Description;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    @Description("로또 번호가 1부터 45사이인가")
    public void test_lotto_number_range_from_1_to_45(){
        int test_number = 52;

        assertThatThrownBy(()->new LottoNumber(test_number)).
                isInstanceOf(IllegalArgumentException.class);
    }
}