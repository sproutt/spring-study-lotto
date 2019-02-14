package model;

public class Splitter {

    private char splitChar;

    public Splitter(char splitChar) {
        this.splitChar = splitChar;
    }

    public String getSplitString() {
        return String.valueOf(splitChar);
    }

}
