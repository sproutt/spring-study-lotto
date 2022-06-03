import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

public class ManualLottoGeneratorTest {

    @Test
    @DisplayName("수동 로또 제너레이터가 로또를 생성한다.")
    public void should_success_when_manual_lotto_generator_generate_lotto() {
        // given
        ManualLottoGenerator manualLottoGenerator = new ManualLottoGenerator();

        // when
        Lotto lotto = manualLottoGenerator.generate();

        // then
        assertThat(lotto).isNotNull();
    }
}
