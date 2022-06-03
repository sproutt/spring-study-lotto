import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    @DisplayName("구입금액만큼 로또 티켓에 로또가 추가된다면 성공이다.")
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
}
