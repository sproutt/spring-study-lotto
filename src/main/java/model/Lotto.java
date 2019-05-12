package model;

import java.util.List;

public class Lotto {

    private List<Integer> lottoNumbers;

    Lotto(List<Integer> lottoNumbers){
        this.lottoNumbers = lottoNumbers;
    }

    public int getCorrectNumberCount(List<Integer> answer){
        int count = 0;
        for (int i : answer){
            if(lottoNumbers.contains(i))
                count++;
        }
        return count;
    }

    public String showLotto(){
        return lottoNumbers.toString();
    }
}
