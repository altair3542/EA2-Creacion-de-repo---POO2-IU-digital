import java.time.LocalDateTime;
import java.util.List;

// Prepara datos de ejemplo reutilizables para los análisis del equipo.
public final class DatosSimulados {
    private DatosSimulados() {}

    public static List<Registro> crear() {
        // Muestra mínima e inmutable; no representa una carga grande.
        return List.of(
                new Registro("U1", "R1", "Centro", "entrada",
                        LocalDateTime.of(2026, 10, 29, 7, 0)),
                new Registro("U1", "R1", "Norte", "salida",
                        LocalDateTime.of(2026, 10, 29, 7, 20)),
                new Registro("U2", "R2", "Centro", "entrada",
                        LocalDateTime.of(2026, 10, 29, 8, 0))
        );
    }
}
