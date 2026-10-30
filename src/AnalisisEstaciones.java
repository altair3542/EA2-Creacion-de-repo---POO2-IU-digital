import java.util.List;
import java.util.Map;

// Santiago: requisitos a (afluencia por estación) y b (horas pico).
public class AnalisisEstaciones {
    public static Map<String, Long> afluenciaPorEstacion(List<Registro> registros) {
        // TODO a: contar las entradas por estación con Streams.
        throw new UnsupportedOperationException("Pendiente: afluencia por estación");
    }

    public static Map<Integer, Long> flujoPorHora(List<Registro> registros) {
        // TODO b: agrupar por hora (0 a 23) y contar el flujo.
        // Usar este resultado para identificar las horas pico al integrar en Main.
        throw new UnsupportedOperationException("Pendiente: flujo por hora");
    }
}
