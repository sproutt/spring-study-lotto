import jdk.jfr.Description;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    @Description("로또 번호가 범위를 넘어서면 예외를 발생시킨다.")
    public void should_throw_exception_when_number_is_out_of_range() {
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