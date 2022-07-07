import exception.*;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoGame game = new LottoGame();
        while (true) {
            try {
                OutputView.printLottoCount(game.calculateLottoCount(new Money(InputView.inputMoney()).getMoney()));
                int manualLottoCount = InputView.manualLottoCount();

                OutputView.printLottoTicket(game.generateLottoTicket(manualLottoCount));
                List<LottoNumber> lottoNumbers = StringParsingUtils.parseToLottoNumber(InputView.inputWinningLottoNumber());
                BonusNumber bonusNumber = InputView.inputBonusNumber();
                WinningLotto winningLotto = new WinningLotto(lottoNumbers, bonusNumber);

                OutputView.printStatistics(game.calculateRankStatistics(winningLotto));
                OutputView.printEarningRate(game.calculateEarningRatio());
                break;
            } catch (MoneyUnderMinMoneyException moneyUnderMinMoneyException) {
                System.out.println(moneyUnderMinMoneyException.getMessage());
            } catch (LottoSizeMismatchException lottoSizeMismatchException) {
                System.out.println(lottoSizeMismatchException.getMessage());
            } catch (LottoIsNotUniqueException lottoIsNotUniqueException) {
                System.out.println(lottoIsNotUniqueException.getMessage());
            } catch (LottoNumberOutOfRangeException lottoNumberOutOfRangeException) {
                System.out.println(lottoNumberOutOfRangeException.getMessage());
            } catch (BonusNumberDuplicatedException bonusNumberDuplicatedException) {
                System.out.println(bonusNumberDuplicatedException.getMessage());
            }
        }
    }
}