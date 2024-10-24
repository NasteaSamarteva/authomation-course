package AverageExchangeRateTask;

import dto.ValCurs;
import dto.Valute;

import java.util.ArrayList;
import java.util.List;

public class AverageExchangeRate {

    public static Double averageExR(ValCurs valCurs) {
        List<Double> exRate = new ArrayList<>();
        for (Valute valute : valCurs.getValutes()) {
            exRate.add(valute.getValue());
        }
        int size = exRate.size();
        Double sumOfRates = exRate.stream().reduce(0.0, Double::sum);
        return sumOfRates/size;

    }

}
