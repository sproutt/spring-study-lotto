import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    @Test
    @DisplayName("구입금액만큼 로또 티켓에 로또가 추가된다면 성공이다.")
    public void should_success_when_lotto_ticket_can_add_lottos_as_much_as_money() {
        // given
        int lottoCount = 14;
        LottoTicket lottoTicket = new LottoTicket();
        // when
        
        // then
        assertThat(lottoTicket.getLottoCount()).isEqualTo(lottoCount);
    }
}
