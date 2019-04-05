package lotto;

import lotto.domain.LottoNumber;
import lotto.utils.Splitter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SplitterTest {
    @Test
    public void 문자나누기() {
        String string = "1,2,3,4,5,6";
        List<LottoNumber> splitedNumber = new ArrayList<>();
        splitedNumber.add(new LottoNumber(1));
        splitedNumber.add(new LottoNumber(2));
        splitedNumber.add(new LottoNumber(3));
        splitedNumber.add(new LottoNumber(4));
        splitedNumber.add(new LottoNumber(5));
        splitedNumber.add(new LottoNumber(6));
        assertThat(Splitter.splitNumber(string).get(0).getNumber(), is(splitedNumber.get(0).getNumber()));
        assertThat(Splitter.splitNumber(string).get(1).getNumber(), is(splitedNumber.get(1).getNumber()));
        assertThat(Splitter.splitNumber(string).get(2).getNumber(), is(splitedNumber.get(2).getNumber()));
        assertThat(Splitter.splitNumber(string).get(3).getNumber(), is(splitedNumber.get(3).getNumber()));
        assertThat(Splitter.splitNumber(string).get(4).getNumber(), is(splitedNumber.get(4).getNumber()));
        assertThat(Splitter.splitNumber(string).get(5).getNumber(), is(splitedNumber.get(5).getNumber()));
    }
}