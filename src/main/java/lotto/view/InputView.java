package lotto.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static int inputNumberOfManual() {
        System.out.println("수동으로 구먀할 로또의 수 입력해 주세요.");
        return scanner.nextInt();
    }

    public static String[] inputManualLottos(int NumberOfManual) {
        scanner.skip("\n");
        String[] ManualLottos = new String[NumberOfManual];
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int index = 0; index < NumberOfManual; index++) {
            ManualLottos[index] = scanner.nextLine();
        }
        return ManualLottos;
    }

    public static String inputResult() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
}
