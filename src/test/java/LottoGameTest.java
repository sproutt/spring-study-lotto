import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @Test
    public void should_success_when_real_lotto_earning_ratio_matches_expected_lotto_yield() throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        LottoGame lottoGame = new LottoGame();
        lottoGame.calculateLottoCount(1000);
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for(int i=1; i<7; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(lottoNumbers));

        Method method = lottoGame.getClass().getDeclaredMethod("makeLottoTicket", List.class);
        method.setAccessible(true);

        method.invoke(lottoGame, lottos);

        WinningLotto winningLotto = new WinningLotto(lottoNumbers, new BonusNumber(new LottoNumber(7)));
        lottoGame.calculateRankStatistics(winningLotto);

        //when
        String earningRatio = lottoGame.calculateEarningRatio();

        // then
        assertThat(earningRatio).isEqualTo("200000000.0");
    }

    @Test
    @DisplayName("입력한 금액만큼 로또 장수를 반환하면 성공이다.")
    public void should_success_when_input_money_return_lotto_as_much_as_input_money() {
        // given
        int expectedLottoCount = 14;
        int money = 14000;
        LottoGame lottoGame = new LottoGame();

        // when
        int lottoCount = lottoGame.calculateLottoCount(money);

        // then
        assertThat(lottoCount).isEqualTo(expectedLottoCount);
    }

    @Test
    @DisplayName("구입 장수만큼 로또 티켓에 로또가 추가된다면 성공이다.")
    public void should_success_when_lotto_ticket_can_add_lottos_as_much_as_money() {
        // given
        int manualLottoCount = 1;

        LottoGame lottoGame = new LottoGame();
        int lottoCount = lottoGame.calculateLottoCount(3000);

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }

        List<Lotto> manualLotto = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            manualLotto.add(new Lotto(lottoNumbers));
        }

        // when
        LottoTicket lottoTicket = lottoGame.generateLottoTicket(manualLottoCount);

        // then
        assertThat(lottoTicket.getLottoTicket().size()).isEqualTo(lottoCount);
    }
}