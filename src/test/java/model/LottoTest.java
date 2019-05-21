package model;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LottoTest {

    Lotto lotto;

    @Before
    public void setUp() {
        List<LottoNo> numbers = new ArrayList<>();
        for (int i=1; i<=6; i++){
            numbers.add(new LottoNo(i));
        }
        lotto = new Lotto(numbers));
    }

    @Test
    public void 로또번호_문자열() {
        assertThat(lotto.showLotto()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}