package view;

import java.util.Scanner;

public class InputView {
    public static String inputString(Scanner scanner) {
        System.out.print("더하기를 할 문자열을 입력하세요 >>");
        return scanner.next();
    }

    public static int inputTotalPrice(Scanner scanner){
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputNumber(Scanner scanner){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }
}
