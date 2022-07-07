import exception.BonusNumberDuplicatedException;
import exception.LottoIsNotUniqueException;
import exception.LottoSizeMismatchException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {
    private List<LottoNumber> testWinningLotto;
    private BonusNumber testBonusNumber;

    @BeforeEach
    public void setUp() {
        testWinningLotto = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            testWinningLotto.add(new LottoNumber(i));
        }
        testBonusNumber = new BonusNumber(new LottoNumber(7));
    }

    @Test
    @DisplayName("당첨 로또 번호가 6개가 아니라면 예외를 발생시킨다")
    public void should_throw_exception_when_winning_lotto_size_is_not_6() {

        assertThatThrownBy(() -> new WinningLotto(testWinningLotto, testBonusNumber))
                .isInstanceOf(LottoSizeMismatchException.class);
    }

    @Test
    @DisplayName("로또 개수가 6개라면 성공한다.")
    public void should_success_when_winning_lotto_size_is_6() {

        WinningLotto winningLotto = new WinningLotto(testWinningLotto, testBonusNumber);

        assertThat(winningLotto.getWinningLottoSize()).isEqualTo(Lotto.LOTTO_SIZE);
    }

    @Test
    @DisplayName("로또가 서로 다른 로또 번호로 이루어지지 않으면 예외를 발생한다.")
    public void should_throw_exception_when_winning_lotto_is_not_unique() {
        List<LottoNumber> testWrongLotto = new ArrayList<>();

        for (int i = 1; i < 6; i++){
            testWrongLotto.add(new LottoNumber(i));
        }

        testWrongLotto.add(new LottoNumber(5));

        assertThatThrownBy(() -> new WinningLotto(testWrongLotto, testBonusNumber))
                .isInstanceOf(LottoIsNotUniqueException.class);
    }

    @Test
    @DisplayName("로또가 서로 다른 로또 번호로 이루어지면 성공한다.")
    public void should_success_when_winning_lotto_is_unique() {
        WinningLotto lotto = new WinningLotto(testWinningLotto, testBonusNumber);

        assertThat(lotto.getWinningLottoSize()).isEqualTo(Lotto.LOTTO_SIZE);
    }

    @Test
    @DisplayName("보너스 번호가 당첨번호에 포함되어 있을 때 예외를 던지면 성공이다. ")
    public void should_success_if_winning_lotto_contains_bonus_number_then_throw_exception() {
        // given
        BonusNumber testWrongBonusNumber = new BonusNumber(new LottoNumber(6));
        // when
        // then
        assertThatThrownBy(() -> new WinningLotto(testWinningLotto, testWrongBonusNumber))
                .isInstanceOf(BonusNumberDuplicatedException.class);
    }
}