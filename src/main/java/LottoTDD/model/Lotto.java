package LottoTDD.model;

import java.util.*;

public class Lotto {
    private final int numberOfTable = 45;
    private final int numberOfLottoNum = 6;
    private ArrayList<Integer> numberTable = new ArrayList<Integer>();
    private ArrayList<Integer> lotto = new ArrayList<Integer>();

    /*
    int OneToFortyfive[] = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
            31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
            41, 42, 43, 44, 45};
    */
    public List<Integer> lottoGenerator() {
        long seed = System.nanoTime();
        generateNumberTable();
        Collections.shuffle(numberTable, new Random(seed));
        for (int i = 0; i < numberOfLottoNum; i++) {
            lotto.add(numberTable.get(i));
        }
        return lotto;
    }
    private void generateNumberTable(){
        for (int i = 0; i < numberOfTable; i++) {
            numberTable.add(i+1);
        }
    }
}
