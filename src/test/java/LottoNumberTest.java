import jdk.jfr.Description;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    @Description("로또 번호가 1부터 45사이인가")
    public void test_lotto_number_range_from_1_to_45(){
        int testNumber = 52;

        assertThatThrownBy(()->new LottoNumber(testNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @Description("생성된 로또 번호가 범위안에 있으면 성공이다.")
    public void should_success_when_number_in_range() {
        int testNumber = 45;

        assertThat(new LottoNumber(testNumber).getNumber()).isEqualTo(testNumber);
    }
}