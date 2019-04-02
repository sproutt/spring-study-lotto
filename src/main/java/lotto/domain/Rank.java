package lotto.domain;

public enum Rank {
    ZERO("0개", 0), ONE("1개", 0), TWO("2개", 0), THREE("3개", 5000), FOUR("4개", 50000), FIVE("5개", 1500000), SIX("6개", 2000000000);

    private final String text;
    private final int reward;

    Rank(String text, int reward) {
        this.text = text;
        this.reward = reward;
    }

    public String getText() {
        return this.text;
    }

    public int getReward() {
        return this.reward;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getText());
        stringBuilder.append(" 일치 ");
        stringBuilder.append("(");
        stringBuilder.append(this.getReward());
        stringBuilder.append(")- ");
        return stringBuilder.toString();
    }

    public boolean hasReward(){
        if(this.getReward() > 0){
            return true;
        }
        return false;
    }
}
