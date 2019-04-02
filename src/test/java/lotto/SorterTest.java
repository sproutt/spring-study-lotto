package lotto;

import lotto.domain.LottoNo;
import lotto.utils.Sorter;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SorterTest {
    int[] array;
    LottoNo[] lottoNos;
    List<LottoNo> list;

    @Before
    public void setUp() {
        list = new ArrayList<LottoNo>();
        array = new int[]{4, 5, 6, 1, 2, 3};
        lottoNos = new LottoNo[6];
        for (int index = 0; index < 6; index++) {
            lottoNos[index] = new LottoNo(array[index]);
        }
        list = Arrays.asList(lottoNos);
    }

    @Test
    public void 정렬() {
        int[] array2 = new int[]{1, 2, 3, 4, 5, 6};
        LottoNo[] lottoNos2 = new LottoNo[6];
        for (int index = 0; index < 6; index++) {
            lottoNos2[index] = new LottoNo(array2[index]);
        }
        List<LottoNo> list2 = new ArrayList<>();
        list2 = Arrays.asList(lottoNos2);
        assertThat(Sorter.sort(list).get(0).getNumber(), is(list2.get(0).getNumber()));
        assertThat(Sorter.sort(list).get(1).getNumber(), is(list2.get(1).getNumber()));
        assertThat(Sorter.sort(list).get(2).getNumber(), is(list2.get(2).getNumber()));
        assertThat(Sorter.sort(list).get(3).getNumber(), is(list2.get(3).getNumber()));
        assertThat(Sorter.sort(list).get(4).getNumber(), is(list2.get(4).getNumber()));
        assertThat(Sorter.sort(list).get(5).getNumber(), is(list2.get(5).getNumber()));
    }
}
