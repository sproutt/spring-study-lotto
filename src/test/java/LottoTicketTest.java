import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    @Test
    public void should_success_when_lotto_ticket_has_lottos_as_much_as_money() {
        // given
        int lottoCount = 14;
        LottoTicket lottoTicket = new LottoTicket();
        // when
        
        // then
        assertThat(lottoTicket.getLottoCount()).isEqualTo(lottoCount);
    }
}
