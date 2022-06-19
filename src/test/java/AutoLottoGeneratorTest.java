import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottoGeneratorTest {

    @Test
    @DisplayName("수동 로또 제너레이터가 로또를 생성한다.")
    public void should_success_when_manual_lotto_generator_generate_lotto() {
        // given
        AutoLottoGenerator autoLottoGenerator = new AutoLottoGenerator();

        // when
        Lotto lotto = autoLottoGenerator.generate();

        // then
        assertThat(lotto).isNotNull();
    }
}
