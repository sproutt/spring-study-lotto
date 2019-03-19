package lotto.view;

import lotto.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final static int LOTTO_LENGTH = 6;
    private static Scanner scanner = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println("구입 금액을 입력해주세요.");
        return scanner.nextInt();
    }

    public static List<Integer> inputWinnerNumber() {
        scanner.nextLine();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Utils.splitNumber(scanner.nextLine());
    }
}
