import exception.LottoIsNotUniqueException;
import exception.LottoSizeMismatchException;
import org.junit.jupiter.api.Test;
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
                .isInstanceOf(LottoSizeMismatchException.class);
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
                .isInstanceOf(LottoIsNotUniqueException.class);
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
    @DisplayName("당첨 번호와 자동 로또 번호의 일치하는 개수를 반환하는지 확인한다.")
    public void should_check_whether_winning_lotto_match_lotto() {
        List<LottoNumber> testLotto = new ArrayList<>();
        List<LottoNumber> testWinningLotto = new ArrayList<>();

        for (int i = 1; i < 7; i++) {
            testLotto.add(new LottoNumber(i));
            testWinningLotto.add(new LottoNumber(i));
        }

        Lotto lotto = new Lotto(testLotto);
        WinningLotto winningLotto = new WinningLotto(testWinningLotto, new BonusNumber(new LottoNumber(7)));

        int matchCount = lotto.match(winningLotto);

        assertThat(matchCount).isEqualTo(6);
    }
}