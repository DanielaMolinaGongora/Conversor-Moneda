public class CalculadoraConversion {

    public static double convertirMoneda(double cantidad, double tasaOrigen, double tasaDestino){
        return cantidad * (tasaDestino / tasaOrigen);
    }
}
