import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoGame game = new LottoGame();
        OutputView.printLottoCount(game.inputMoney(new Money(InputView.inputMoney()).getMoney()));
        int lottoCount = InputView.manualLottoCount();
        List<Lotto> lottos = InputView.manualLotto(lottoCount);
        OutputView.printLottoTicket(game.generateLottoTicket(lottos));
        List<LottoNumber> lottoNumbers = StringParsingUtils.parseToLottoNumber(InputView.inputWinningLottoNumber());
        BonusNumber bonusNumber = InputView.inputBonusNumber();
        WinningLotto winningLotto = new WinningLotto(lottoNumbers, bonusNumber);
        OutputView.printStatistics(game.calculateRankStatistics(winningLotto));
        OutputView.printEarningRate(game.calculateEarningRatio());
    }
}