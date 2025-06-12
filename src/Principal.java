import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("***Te damos la bienvenida al mejor conversor de moneda del mercado***");

        try {
            String direccion = "https://v6.exchangerate-api.com/v6/44d7c9ab25c1b415c6acf193/latest/USD";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            Gson gson = new Gson();

            ConversionExchangerate respuestaExchangerate = gson.fromJson(json, ConversionExchangerate.class);
            Map<String, Double> tasas = respuestaExchangerate.conversion_rates();

            Scanner scanner = new Scanner(System.in);

//            System.out.println("Resultado: " + respuestaExchangerate.result());
//            System.out.println("Moneda base: " + respuestaExchangerate.base_code());
//            System.out.println("base de USD a EUR: " + respuestaExchangerate.conversion_rates().get("EUR"));
//            System.out.println("base de USD a COP: " + respuestaExchangerate.conversion_rates().get("COP"));

            String [] monedasFiltradas = {"ARS", "BOB", "BRL", "CLP", "COP", "EUR"};

            System.out.println("-------------------------------------------------------");

            boolean continuar = true;

            while (continuar){
                System.out.println("\nElija la moneda de origen");
                for (int i = 0; i < monedasFiltradas.length; i++) {
                    System.out.printf("%d. %s\n", i +1, monedasFiltradas[i]);
                }

                int opcionOrigen = scanner.nextInt();
                if (opcionOrigen <1 || opcionOrigen > monedasFiltradas.length) {
                    System.out.println("Opcion no valida, intente de nuevo.");
                    continue;
                }

                System.out.println("Elija la moneda de destino: ");
                for (int i = 0; i < monedasFiltradas.length; i++) {
                    System.out.printf("%d. %s\n", i+1, monedasFiltradas[i]);
                }

                int opcionDestino = scanner.nextInt();
                if (opcionDestino < 1 || opcionDestino > monedasFiltradas.length){
                    System.out.println("Opcion no valida, intente de nuevo.");
                    continue;
                }

                System.out.println("Ingrese la cantidad a convertir");
                double cantidad = scanner.nextDouble();

                String monedaOrigen = monedasFiltradas[opcionOrigen - 1];
                String monedaDestino = monedasFiltradas[opcionDestino - 1];

                Double tasaOrigen = tasas.get(monedaOrigen);
                Double tasaDestino = tasas.get(monedaDestino);

                if (tasaOrigen == null || tasaDestino == null) {
                    System.out.println("No se encontro la tasa para alguna de las monedas seleccionadas.");
                    continue;
                }

                double resultado = CalculadoraConversion.convertirMoneda(cantidad,tasaOrigen,tasaDestino);

                System.out.printf("%.2f %s equivale a %.2f %s\n", cantidad, monedaOrigen,resultado, monedaDestino);

                System.out.println("¿Quieres realizar otra conversion? (Para SI, escribe 1. Para NO, escribe 2.)");
                int respuesta = scanner.nextInt();
                if (respuesta == 2) {
                    continuar = false;
                }
            }

            System.out.println("Gracias, vuelve pronto.");
            scanner.close();
        } catch (Exception e){
            System.out.println("Error al obtener datos de la API: " + e.getMessage());
        }

    }
}
