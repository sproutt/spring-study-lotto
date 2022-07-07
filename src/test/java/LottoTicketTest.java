import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    @DisplayName("당첨 번호를 넣었을 때, 로또 티켓에서 1등을 1장 반환하면 성공한다.")
    public void should_success_when_input_winning_lotto_number_return_one_first_prize_in_lotto_ticket() {
        // given
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for(int i = 1; i <= Lotto.LOTTO_SIZE; i ++) {
            lottoNumbers.add(new LottoNumber(i));
        }
        Lotto lotto = new Lotto(lottoNumbers);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(lotto);
        LottoTicket lottoTicket = new LottoTicket(lottos);
        WinningLotto winningLotto = new WinningLotto(lottoNumbers, new BonusNumber(new LottoNumber(7)));

        // when
        Map<Rank, Integer> statistics = lottoTicket.compareWithWinningLotto(new TreeMap<>(),winningLotto);

        // then
        assertThat(statistics.get(Rank.FIRST)).isEqualTo(1);
    }

    @Test
    @DisplayName("당첨 번호와 일치하는 개수가 5개이고, 일치하는 보너스 번호 개수가 1일때 2등의 개수가 1이면 성공이다.")
    public void should_success_when_winning_lotto_count_is_5_and_bonus_number_is_1_return_2nd_count() {
        // given
        List<LottoNumber> winningLottoNumbers = new ArrayList<>();
        for(int i = 1; i <= Lotto.LOTTO_SIZE; i ++) {
            winningLottoNumbers.add(new LottoNumber(i));
        }

        List<LottoNumber> testLottoNumber = new ArrayList<>();
        for (int i=2; i <= Lotto.LOTTO_SIZE + 1; i++) {
            testLottoNumber.add(new LottoNumber(i));
        }
        Lotto secondLotto = new Lotto(testLottoNumber);
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(secondLotto);

        LottoTicket lottoTicket = new LottoTicket(lottos);

        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, new BonusNumber(new LottoNumber(7)));

        // when
        Map<Rank, Integer> statistics = lottoTicket.compareWithWinningLotto(new TreeMap<>(), winningLotto);

        // then
        assertThat(statistics.get(Rank.SECOND)).isEqualTo(1);
    }
}