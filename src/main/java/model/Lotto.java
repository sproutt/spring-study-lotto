package model;

import java.util.List;

public class Lotto {

    private List<String> lottoNumbers;

    public Lotto(List<String> lottoNumbers){
        this.lottoNumbers = lottoNumbers;
    }

    public int getCorrectNumberCount(List<String> winningNumber){
        return (int)winningNumber.stream().filter((x)->lottoNumbers.contains(x)).count();
    }

    public String showLotto(){
        return lottoNumbers.toString();
    }
}
