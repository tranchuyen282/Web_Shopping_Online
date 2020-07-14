package currency;

import java.text.NumberFormat;
import java.util.Locale;

public class ShowMoney {
    private static Locale locale = new Locale("vi","VN");
    private static NumberFormat fomart = NumberFormat.getCurrencyInstance(locale);
    public static String fomartMoney(int money){
        return fomart.format(money);
    }
}
