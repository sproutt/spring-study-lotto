public class Application {
    public static void main(String[] args) {
        LottoGame game = new LottoGame();
        OutputView.printLottoCount(game.inputMoney(InputView.inputMoney()));
        OutputView.printLottoTicket(game.generateLottoTicket());
        WinningLotto winningLotto = new WinningLotto(StringParsingUtils.parseToLottoNumber(InputView.inputWinningLottoNumber()));
        OutputView.printStatistics(game.calculateRankStatistics(winningLotto));
        OutputView.printEarningRate(game.calculateEarningRatio());
    }
}