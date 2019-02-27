package com.econo.lotto.utils;

import java.util.regex.Pattern;

public class DefaultSplitter implements Splitter {

    @Override
    public boolean supports(String string) {

        return !pattern.matcher(string).find();
    }

    @Override
    public String[] split(String string) {

        return string.split(",|:");
    }
}
