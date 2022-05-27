import jdk.jfr.Description;
import org.junit.Test;

public class MoneyTest {

    @Test
    @Description("입력값이 1000원 이상인지 확인")
    public void validate_money_over_1000(){
        Money money = new Money();
    }
}
