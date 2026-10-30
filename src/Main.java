import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Muestra mínima e inmutable para empezar; no representa una carga grande.
        List<Registro> registros = List.of(
                new Registro("U1", "R1", "Centro", "entrada",
                        LocalDateTime.of(2026, 10, 29, 7, 0)),
                new Registro("U1", "R1", "Norte", "salida",
                        LocalDateTime.of(2026, 10, 29, 7, 20)),
                new Registro("U2", "R2", "Centro", "entrada",
                        LocalDateTime.of(2026, 10, 29, 8, 0))
        );

        System.out.println("TecnoMovil Data - aporte de Santiago");
        System.out.println("Registros de ejemplo: " + registros.size());

        System.out.println("Entradas por estación:");
        AnalisisEstaciones.afluenciaPorEstacion(registros).entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entrada -> System.out.printf("  %s: %d%n",
                        entrada.getKey(), entrada.getValue()));

        Map<Integer, Long> flujo = AnalisisEstaciones.flujoPorHora(registros);
        System.out.println("Flujo por hora (entradas y salidas):");
        flujo.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entrada -> System.out.printf("  %02d:00: %d%n",
                        entrada.getKey(), entrada.getValue()));

        System.out.println("Horas pico:");
        AnalisisEstaciones.horasPico(flujo)
                .forEach(hora -> System.out.printf("  %02d:00 (%d registros)%n",
                        hora, flujo.get(hora)));

        // TODO: integrar los aportes de Alejandro (rutas) y Abimael (viajes).
    }
}
