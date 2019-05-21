package model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private List<LottoNo> lottoNumbers;

    public Lotto(List<LottoNo> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(String[] lottoNumbers){
        this.lottoNumbers = new ArrayList<>();
        for (int i=0; i<lottoNumbers.length; i++){
            this.lottoNumbers.add(new LottoNo(Integer.parseInt(lottoNumbers[i])));
        }
    }

    public int getCorrectNumberCount(List<String> winningNumber) {
        return (int) winningNumber.stream().filter((x) -> lottoNumbers.contains(x)).count();
    }

    public String showLotto() {
        return lottoNumbers.toString();
    }
}
