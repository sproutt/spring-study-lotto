package model;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;


public class LottoTest {

    Lotto lotto;

    @Before
    public void setUp() {
        lotto = new Lotto(Arrays.asList(new String[]{"1", "2", "3", "4", "5", "6"}));
    }

    @Test
    public void 로또_정답수() {
        List<String> answers = Arrays.asList(new String[]{"1", "2", "3"});
        assertThat(lotto.getCorrectNumberCount(answers)).isEqualTo(3);
    }

    @Test
    public void 로또번호_문자열() {
        assertThat(lotto.showLotto()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}