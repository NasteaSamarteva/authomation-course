package convertioTask;

import dto.ValCurs;
import dto.Valute;

import java.util.ArrayList;
import java.util.List;

public  class ConvertAllRates {

    public static List<Double> convertedRates(ValCurs valCurs, String base) {
        Double baseCurrency=0.0;
        List<Double> convertedRates = new ArrayList<>();
        for (Valute valute : valCurs.getValutes()) {
            if (valute.getCharCode().equalsIgnoreCase(base)) {
                baseCurrency = valute.getValue();
                break;
            }
        }
        for (Valute valute: valCurs.getValutes()) {
            convertedRates.add(valute.getValue()/baseCurrency);
        }
        return convertedRates;

    }
}
