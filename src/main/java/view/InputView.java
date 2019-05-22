package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static String inputString(Scanner scanner) {
        System.out.print("더하기를 할 문자열을 입력하세요 >>");
        return scanner.next();
    }

    public static int inputTotalPrice(Scanner scanner) {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputNumber(Scanner scanner) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static String inputBonusNumber(Scanner scanner) {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine();
    }

    public static List<String> inputTotalLottoNumber(Scanner scanner) {
        List<String> totalLottoNumber = new ArrayList<>();
        int count = inputDirectLotto(scanner);

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < count; i++)
            totalLottoNumber.add(scanner.nextLine());

        return totalLottoNumber;
    }

    public static int inputDirectLotto(Scanner scanner) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }
}