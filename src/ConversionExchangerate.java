import java.util.Map;

public record ConversionExchangerate(String result, String base_code, Map<String,Double> conversion_rates) {
}
