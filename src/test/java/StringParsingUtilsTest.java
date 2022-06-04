import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringParsingUtilsTest {

    @Test
    @DisplayName("공백이 제대로 제거되면 성공이다.")
    public void should_success_when_blank_is_removed_clearly() {
        // given
        String testInput = " 1 2 3 ";

        // when
        String blankRemovedTestInput = StringParsingUtils.removeBlank(testInput);

        // then
        assertThat(!blankRemovedTestInput.contains(StringParsingUtils.BLANK)).isTrue();
    }

    @Test
    @DisplayName("콤마(,) 제대로 제거되면 성공이다.")
    public void should_success_when_comma_is_removed_clearly() {
        // given
        String testInput = "1,2,3";

        // when
        String[] commaRemovedTestInput = StringParsingUtils.splitWithComma(testInput);

        // then
        assertThat(!Arrays.asList(commaRemovedTestInput).contains(StringParsingUtils.COMMA)).isTrue();
    }

    @Test
    @DisplayName("문자열이 숫자 리스트로 변환되면 성공이다.")
    public void should_success_when_string_is_transferred_to_integer_list() {
        // given
        String testInput = "1, 2, 3";

        // when
        List<Integer> input = StringParsingUtils.parseToNumber(testInput);

        // then
        assertThat(input.get(0)).isInstanceOf(Integer.class);
    }
}