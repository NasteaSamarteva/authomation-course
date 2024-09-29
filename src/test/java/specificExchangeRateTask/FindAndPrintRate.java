package specificExchangeRateTask;


import dto.ValCurs;
import dto.Valute;

import java.util.HashMap;
import java.util.Map;

public class FindAndPrintRate {

    public static void printSpecificRate(ValCurs valCurs, String currency) {

        Map<String, Double> rate = new HashMap<>();
        for (Valute valute : valCurs.getValutes()) {
            rate.put(valute.getCharCode(), valute.getValue());
        }

        Double currentExchangeRate = rate.get(currency.toUpperCase());
        if (currentExchangeRate==null){
            System.out.println("No such currency");
        }else
            System.out.println(currentExchangeRate);
    }
}


