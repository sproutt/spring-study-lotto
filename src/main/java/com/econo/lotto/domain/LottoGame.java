package com.econo.lotto.domain;

import com.econo.lotto.utils.LottoGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;

    private List<Lotto> lottos;

    public LottoGame(){
        lottos = new ArrayList<>();
    }

    public void play(String expenditure){
        setLottos(getLottoCount(expenditure));
    }
    public void setLottos(int lottoCount){
        for(int i=0; i<lottoCount; i++){
            lottos.add(new Lotto(LottoGenerator.getLotto()));
        }
    }
    public List<Lotto> getLottos(){
        return lottos;
    }

    public void readWinNumbers(String winNumbers){
        List<String> winNumberList= Arrays.asList(winNumbers.split(", "));
    }

    public int getLottoCount(String expenditure) {
        return Integer.parseInt(expenditure)/LOTTO_PRICE;
    }






}
