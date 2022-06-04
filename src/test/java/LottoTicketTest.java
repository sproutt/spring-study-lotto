import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    @DisplayName("구입 장수만큼 로또 티켓에 로또가 추가된다면 성공이다.")
    public void should_success_when_lotto_ticket_can_add_lottos_as_much_as_money() {
        // given
        int lottoCount = 3;
        List<Lotto> lottos = new ArrayList<>();
        LottoTicket lottoTicket = new LottoTicket(lottos);
        AutoLottoGenerator autoLottoGenerator = new AutoLottoGenerator();

        // when
        for(int i = 0; i < lottoCount; i++) {
            lottoTicket.add(autoLottoGenerator.generate());
        }

        // then
        assertThat(lottoTicket.getLottoCount()).isEqualTo(lottoCount);
    }

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
        WinningLotto winningLotto = new WinningLotto(lottoNumbers);

        // when
        Map<Rank, Integer> statistics = lottoTicket.calculateRankStatistics(winningLotto);

        // then
        assertThat(statistics.get(Rank.FIRST)).isEqualTo(1);
    }
}
