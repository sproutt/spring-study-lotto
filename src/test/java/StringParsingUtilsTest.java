import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringParsingUtilsTest {

    @Test
    @DisplayName("공백이 제대로 제거되면 성공이다.")
    public void should_success_when_blank_is_removed_clearly() {
        // given
        String testInput = " 1 2 3 ";

        // when
        StringParsingUtils stringParsingUtils = new StringParsingUtils();
        testWinningLottoList = stringParsingUtils.stringParsing(winningLotto);

        // then
        assertThat(!blankRemovedTestInput.contains(StringParsingUtils.BLANK)).isTrue();
    }
}
