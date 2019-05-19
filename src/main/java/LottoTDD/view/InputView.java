package LottoTDD.view;

import java.util.Scanner;

public class InputView {
    Scanner scanner;
    public int InputPurchaseMoney(){
        scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }
    public int[] InputWinnerNum(){
        scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] winnerNum_String= scanner.next().split(",") ;
        return stringToInt(winnerNum_String);
    }

    private int[] stringToInt(String[] winnerNum_String) {
        int[] winnerNum_Int = new int[6];
        for (int i = 0; i < winnerNum_Int.length; i++) {
            winnerNum_Int[i] = Integer.parseInt(winnerNum_String[i]);
        }
        return winnerNum_Int;
    }
}
