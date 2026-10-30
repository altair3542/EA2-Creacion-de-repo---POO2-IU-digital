import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Módulo de Análisis de Rutas para TecnoMovil Data.
 * Integrante 2: Alejandro Jaramillo
 * Requerimientos asignados: c (Rutas más utilizadas) y f (Detección de sobrecarga).
 */
public class AnalisisRutas {

    /**
     * Requerimiento c: Calcula el volumen total de uso de cada ruta.
     * Cuenta cuántas validaciones de entrada registró cada ruta.
     */
    public static Map<String, Long> usoPorRuta(List<Registro> registros) {
        return registros.stream()
                .filter(r -> "entrada".equalsIgnoreCase(r.accion()))
                .collect(Collectors.groupingBy(
                        Registro::ruta,
                        Collectors.counting()
                ));
    }

    /**
     * Requerimiento f: Filtra e identifica las rutas críticas que superan el umbral de ocupación.
     */
    public static List<String> rutasCriticas(List<Registro> registros, long umbral) {
        return usoPorRuta(registros).entrySet().stream()
                .filter(entry -> entry.getValue() > umbral)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
