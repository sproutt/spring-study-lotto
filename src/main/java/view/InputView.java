package view;

import java.util.Scanner;

public class InputView {
    public static String inputString() {
        System.out.print("더하기를 할 문자열을 입력하세요 >>");
        return new Scanner(System.in).next();
    }
}
