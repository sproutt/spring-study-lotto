import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StringParsingUtilsTest {
    @Test
    @DisplayName("당첨 로또 리스트 크기와 로또 사이즈가 같다면 성공이다.")
    public void should_success_when_winning_lotto_list_size_matches_lotto_size(){
        // given
        String winningLotto = "2, 4, 6, 8, 10, 12";

        // when


        // then
        assertThat(winningLotto.getSize()).isEqualTo(Lotto.LOTTO_SIZE);
    }
}
