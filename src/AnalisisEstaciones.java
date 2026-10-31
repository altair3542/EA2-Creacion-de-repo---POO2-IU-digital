import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Santiago: requisitos a (afluencia por estación) y b (horas pico).
public class AnalisisEstaciones {
    /** Cuenta validaciones de entrada, no usuarios únicos. No modifica los registros. */
    public static Map<String, Long> afluenciaPorEstacion(List<Registro> registros) {
        return Map.copyOf(registros.stream()
                .filter(registro -> "entrada".equals(registro.accion()))
                .collect(Collectors.groupingBy(Registro::estacion, Collectors.counting())));
    }

    /** Cuenta todas las acciones por hora (0 a 23) dentro del día analizado. */
    public static Map<Integer, Long> flujoPorHora(List<Registro> registros) {
        return Map.copyOf(registros.stream()
                .collect(Collectors.groupingBy(
                        registro -> registro.timestamp().getHour(), Collectors.counting())));
    }

    /** Devuelve todas las horas de máximo flujo, ordenadas; sin datos, una lista vacía. */
    public static List<Integer> horasPico(Map<Integer, Long> flujo) {
        long maximo = flujo.values().stream()
                .mapToLong(Long::longValue)
                .max()
                .orElse(0L);

        return flujo.entrySet().stream()
                .filter(entrada -> entrada.getValue() == maximo)
                .map(Map.Entry::getKey)
                .sorted()
                .toList();
    }
}
