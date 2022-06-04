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
        for (Rank value : Rank.values()){
            statistics.put(value, 0);
        }
        statistics.put(Rank.FOURTH, 1);
        // when

        // then
        assertThat(earningRatio).isEqualTo(expectedEarningRatio);
    }
}
