# Conversor de Moneda en Java

## Descripción
Este proyecto es un conversor de moneda desarrollado en Java que utiliza la API de ExchangeRate para obtener las tasas de cambio actualizadas en tiempo real. El programa permite al usuario seleccionar monedas de origen y destino, ingresar una cantidad y obtener el valor convertido.

## Tecnologías
- Java 21
- API ExchangeRate (https://www.exchangerate-api.com/)
- Gson (para manejar JSON)
- HttpClient (para realizar solicitudes HTTP)

## Características
- Obtiene las tasas de cambio actuales desde la API.
- Permite al usuario elegir entre varias monedas populares.
- Conversión dinámica entre monedas usando las tasas obtenidas.
- Interfaz de consola con menú interactivo para una experiencia amigable.

## Cómo usar
1. Clona este repositorio.
2. Asegúrate de tener Java instalado (versión 11 o superior).
3. Descarga el archivo `gson.jar` y añádelo a tu proyecto.
4. Compila y ejecuta la clase `Principal`.
5. Sigue las instrucciones en pantalla para realizar conversiones.

## Archivos principales
- `Principal.java`: Clase principal que ejecuta el programa y maneja la interacción con el usuario.
- `ConversionExchangerate.java`: Record que representa la estructura JSON de la API.
- `CalculadoraConversion.java`: Clase que contiene el método para calcular la conversión.

## Notas
- Necesitas una conexión a Internet para que el programa obtenga las tasas de cambio.
- La clave de API está incluida en el código para facilitar las pruebas, pero se recomienda manejarla de forma segura en proyectos reales.

## Autor
Daniela Molina 

## Licencia
MIT License

---

¡Gracias por usar el conversor de moneda!
