import jdk.jfr.Description;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @Test
    @Description("입력값이 1000원 이상인지 확인")
    public void exception_money_over_1000(){
        int test_money = 500;

        assertThatThrownBy(()->new Money(test_money))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
