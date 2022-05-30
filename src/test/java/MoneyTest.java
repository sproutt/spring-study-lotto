import jdk.jfr.Description;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @Test
    @Description("지불한 금액이 1000원이하이면 예외를 발생시킨다.")
    public void should_throw_exception_when_money_is_under_1000() {
        int testMoney = 500;

        assertThatThrownBy(()->new Money(testMoney))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @Description("지불한 금액이 1000원 이상이면 성공이다.")
    public void should_success_when_money_is_over_1000() {
        int testMoney = 2000;

        Money testMoneyObject = new Money(testMoney);
        assertThat(testMoneyObject).isNotNull();
    }
}
