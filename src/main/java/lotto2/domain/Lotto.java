package lotto2.domain;

import java.util.List;

public class Lotto {
    private List<LottoNo> list;

    public Lotto(List<LottoNo> list) {
        this.list = list;
    }

    public List<LottoNo> getList() {
        return list;
    }

    public void setList(List<LottoNo> list) {
        this.list = list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        list.stream().forEach(n -> stringBuilder.append(n.getNumber() + ", "));
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append("]");
        return stringBuilder.toString();

    }

    public boolean isContain(LottoNo number) {
        return list.stream().filter(n -> n.equals(number)).count() != 0;
    }
}