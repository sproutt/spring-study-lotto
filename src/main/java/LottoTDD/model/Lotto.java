package LottoTDD.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Lotto {
    private final int numberOfTable = 45;
    private final int numberOfLottoNum = 6;
    private ArrayList<Integer> numberTable = new ArrayList<Integer>();
    public List<Integer> lotto = new ArrayList<Integer>();

    public List<Integer> lottoGenerator() {
        long seed = System.nanoTime();
        generateNumberTable();
        Collections.shuffle(numberTable, new Random(seed));
        for (int i = 0; i < numberOfLottoNum; i++) {
            lotto.add(numberTable.get(i));
        }
        Collections.sort(lotto);
        return lotto;
    }

    private void generateNumberTable() {
        for (int i = 0; i < numberOfTable; i++) {
            numberTable.add(i + 1);
        }
    }
}
