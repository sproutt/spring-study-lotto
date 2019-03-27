package com.econo.lotto.domain;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum WinType {

    LOSE(0,0),
    FIRST(6,2000000000),
    SECOND(5,1500000),
    THIRD(4,500000),
    FOURTH(3, 5000);

    private int matchCount;
    private int prize;

    WinType(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize=prize;
    }

    public static WinType checkWinType(int matchCount){
        return Arrays.stream(WinType.values())
                .filter(winType -> winType.match(matchCount))
                .findAny()
                .orElse(LOSE);
    }

    private boolean match(int matchCount) {
        return this.matchCount == matchCount;
    }
}
