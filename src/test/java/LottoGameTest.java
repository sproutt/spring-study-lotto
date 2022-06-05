import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @Test
    @DisplayName("실제 로또 수익률과 예상한 로또 수익률이 같다면 성공이다.")
    public void should_success_when_real_lotto_earning_ratio_matches_expected_lotto_yield() {
        // given
        LottoGame lottoGame = new LottoGame();
        Map<Rank, Integer> statistics = new HashMap<>();
        statistics.put(Rank.FOURTH, 1);
        String expectedEarningRatio = "35.7";
        int money = 14000;

        // when
        String earningRatio = lottoGame.calculateEarningRatio();

        // then
        assertThat(earningRatio).isEqualTo(expectedEarningRatio);
    }

    @Test
    @DisplayName("입력한 금액만큼 로또 장수를 반환하면 성공이다.")
    public void should_success_when_input_money_return_lotto_as_much_as_input_money() {
        // given
        int expectedLottoCount = 14;
        int money = 14000;
        LottoGame lottoGame = new LottoGame();

        // when
        int lottoCount = lottoGame.inputMoney(money);

        // then
        assertThat(lottoCount).isEqualTo(expectedLottoCount);
    }
}