package model;

import java.util.List;

public class Lotto {

    private List<Integer> lottoNumbers;

    Lotto(List<Integer> lottoNumbers){
        this.lottoNumbers = lottoNumbers;
    }

    public int getCorrectNumberCount(List<Integer> winningNumber){
        return (int)winningNumber.stream().filter((x)->lottoNumbers.contains(x)).count();
    }

    public String showLotto(){
        return lottoNumbers.toString();
    }
}
