package com.econo.lotto;

import com.econo.lotto.exception.NagativeNumberException;
import com.econo.lotto.exception.NumberFormatException;

import java.util.Arrays;


public class Calculator {

    public int calculate(String input){
        //문자열에서 토큰을 얻어옴, char 토큰 리턴
        //토큰으로 문자열을 분리 , 숫자의 list 리턴  &&
        //compute메서드 : int 리턴   && 숫자 이외값 들어있는 경우 예외, 음수일경우 예외

        return 0;
    }

    public String getToken(String stringWithToken) {
        return "a";
    }

    public boolean findToken() {
        return false;
    }

    public String[] tokenize(String stringWithToken){
        if(findToken()){
            return stringWithToken.split(getToken(stringWithToken));
        }
        return stringWithToken.split(",|:");
    }

    public int[] toNumbers(String[] numberStrings){

       return Arrays.stream(numberStrings).mapToInt(number->{
           try{

               return Integer.parseInt(number);
           }catch (NumberFormatException e){

               throw new NumberFormatException(number);
           }
       }).toArray();
    }

    public int compute(int[] numbers){
        if(findNagativeNumber(numbers)){

            throw new NagativeNumberException("-1");
        }

        return Arrays.stream(numbers).sum();
    }

    private boolean findNagativeNumber(int[] numbers) {
        return false;
    }
}
