package com.econo.lotto.utils;

public interface Splitter {

    public boolean supports(String string);

    public String[] split(String string);

}
