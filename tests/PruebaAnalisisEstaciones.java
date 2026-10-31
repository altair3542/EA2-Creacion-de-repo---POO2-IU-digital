import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// Verificación sin frameworks: falla con AssertionError ante un resultado incorrecto.
public class PruebaAnalisisEstaciones {
    public static void main(String[] args) {
        List<Registro> registros = new ArrayList<>(List.of(
                registro("U1", "Centro", "entrada", 7),
                registro("U1", "Norte", "salida", 7),
                registro("U2", "Norte", "entrada", 8),
                registro("U1", "Centro", "entrada", 8),
                registro("U3", "Centro", "entrada", 9)
        ));
        List<Registro> original = List.copyOf(registros);

        Map<String, Long> afluencia = AnalisisEstaciones.afluenciaPorEstacion(registros);
        comprobar(afluencia.equals(Map.of("Centro", 3L, "Norte", 1L)),
                "Debe contar entradas repetidas del mismo usuario y excluir salidas");

        Map<Integer, Long> flujo = AnalisisEstaciones.flujoPorHora(registros);
        comprobar(flujo.equals(Map.of(7, 2L, 8, 2L, 9, 1L)),
                "El flujo debe incluir entradas y salidas");
        comprobar(AnalisisEstaciones.horasPico(flujo).equals(List.of(7, 8)),
                "Debe devolver todas las horas empatadas en orden");
        comprobar(AnalisisEstaciones.horasPico(Map.of(23, 5L, 0, 1L)).equals(List.of(23)),
                "Debe identificar una única hora pico, incluida la hora 23");

        comprobar(AnalisisEstaciones.afluenciaPorEstacion(List.of()).isEmpty(),
                "Sin registros no hay afluencia");
        comprobar(AnalisisEstaciones.flujoPorHora(List.of()).isEmpty(),
                "Sin registros no hay flujo");
        comprobar(AnalisisEstaciones.horasPico(Map.of()).isEmpty(),
                "Sin flujo no hay horas pico");
        comprobar(AnalisisEstaciones.afluenciaPorEstacion(
                List.of(registro("U1", "Sur", "salida", 0))).isEmpty(),
                "Una salida no debe generar afluencia");

        comprobar(registros.equals(original), "El análisis no debe modificar la entrada");
        comprobar(AnalisisEstaciones.afluenciaPorEstacion(registros).equals(afluencia),
                "La misma entrada debe producir el mismo resultado");
        exigirInmutable(() -> afluencia.put("Sur", 1L));
        exigirInmutable(() -> flujo.put(10, 1L));
        exigirInmutable(() -> AnalisisEstaciones.horasPico(flujo).add(10));

        System.out.println("OK: conteos, horas pico, empates, datos vacíos e inmutabilidad.");
    }

    private static Registro registro(String usuario, String estacion, String accion, int hora) {
        return new Registro(usuario, "R1", estacion, accion,
                LocalDateTime.of(2026, 10, 29, hora, 0));
    }

    private static void comprobar(boolean condicion, String mensaje) {
        if (!condicion) {
            throw new AssertionError(mensaje);
        }
    }

    private static void exigirInmutable(Runnable cambio) {
        try {
            cambio.run();
        } catch (UnsupportedOperationException esperado) {
            return;
        }
        throw new AssertionError("El resultado debe ser inmutable");
    }
}
