package nominalTask;

import dto.ValCurs;
import dto.Valute;

public class NominalValidation {
    private static final String exceptionMessage = "Nominal of all 'Valute' objects are not equals to 1";
    private static final String message = "Nominal of all 'Valute' objects are equals to 1";
    ;

    public static String nominalCheck(ValCurs valCurs) {


        for (Valute valute : valCurs.getValutes()
        ) {
            int nominal = valute.getNominal();

            if (nominal != 1){
                throw new NominalException(exceptionMessage);
            }
        }
        return message;
    }

}

