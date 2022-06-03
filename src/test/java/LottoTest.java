import jdk.jfr.Description;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    @DisplayName("로또 개수가 6개가 아니라면 예외를 발생한다.")
    public void should_throw_exception_when_lotto_size_is_not_6() {
        List<LottoNumber> testLotto = new ArrayList<>();

        for (int i = 2; i < 7; i++){
            testLotto.add(new LottoNumber(i));
        }

        assertThatThrownBy(() -> new Lotto(testLotto))
                .isInstanceOf(Lotto.ValidateLottoSizeException.class);
    }

    @Test
    @DisplayName("로또 개수가 6개라면 성공한다.")
    public void should_success_when_lotto_size_is_6() {
        List<LottoNumber> testLotto = new ArrayList<>();

        for (int i = 1; i < 7; i++){
            testLotto.add(new LottoNumber(i));
        }

        Lotto lotto = new Lotto(testLotto);

        assertThat(lotto.getLottoSize()).isEqualTo(Lotto.LOTTO_SIZE);
    }

    @Test
    @DisplayName("로또가 서로 다른 로또 번호로 이루어지지 않으면 예외를 발생한다.")
    public void should_throw_exception_when_lotto_is_not_unique() {
        List<LottoNumber> testLotto = new ArrayList<>();

        for (int i = 1; i < 6; i++){
            testLotto.add(new LottoNumber(i));
        }

        testLotto.add(new LottoNumber(5));

        assertThatThrownBy(() -> new Lotto(testLotto))
                .isInstanceOf(Lotto.ValidateLottoIsUniqueException.class);
    }

    @Test
    @DisplayName("로또가 서로 다른 로또 번호로 이루어지면 성공한다.")
    public void should_success_when_lotto_is_unique() {
        List<LottoNumber> testLotto = new ArrayList<>();

        for (int i = 1; i < 7; i++) {
            testLotto.add(new LottoNumber(i));
        }

        Lotto lotto = new Lotto(testLotto);

        assertThat(lotto.getLottoSize()).isEqualTo(Lotto.LOTTO_SIZE);
    }

    @Test
    @DisplayName("로또와 당첨 로또 번호가 일치하지 않으면 예외를 발생시킨다.")
    public void should_throw_exception_when_lotto_is_not_same_with_winning_lotto(){
        List<LottoNumber> testLotto = new ArrayList<>();
        List<LottoNumber> testWinningLotto = new ArrayList<>();

        setLottoList(testLotto);
        setLottoList(testWinningLotto);

        Lotto lotto = new Lotto(testLotto);
        WinningLotto winningLotto = new WinningLotto(testWinningLotto);

        assertThat(lotto.getLotto()).isEqualTo(winningLotto.getWinningLotto());
    }

    public void setLottoList(List<LottoNumber> list){
        for (int i = 1; i < 7; i++){
            list.add(new LottoNumber(i));
        }
    }
}