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

    public String showLotto() {
        List<String> lotto = new ArrayList<>();
        for (LottoNo lottoNo : lottoNumbers){
            lotto.add(lottoNo.getStringNumber());
        }
        return lotto.toString();
    }

    public int getCorrectCount(List<String> winningNumbers){
        return (int)lottoNumbers.stream().filter((x)->winningNumbers.contains(x.getStringNumber())).count();
    }

    public boolean isContain(String stringNumber){
        return lottoNumbers.contains(new LottoNo(Integer.parseInt(stringNumber)));
    }
}
