package model;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LottoTest {

    @Test
    public void 로또번호_문자열_list생성자() {
        List<LottoNo> numbers = new ArrayList<>();
        for (int i=1; i<=6; i++){
            numbers.add(new LottoNo(i));
        }
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.showLotto()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    public void 로또번호_문자열_String생성자(){
        Lotto lotto = new Lotto(new String[]{"1, 2, 3, 4, 5, 6"});
        assertThat(lotto.showLotto()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}