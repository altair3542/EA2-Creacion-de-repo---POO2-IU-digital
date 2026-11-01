import java.time.LocalDateTime;
import java.util.List;
import modelo.Registro;
import modelo.Accion;

// Prepara datos de ejemplo reutilizables para los análisis del equipo.
public final class DatosSimulados {
        private DatosSimulados() {
        }

        public static List<Registro> crear() {
                // Muestra mínima e inmutable; no representa una carga grande.
                return List.of(
                                new Registro("U001", "Ruta A", "Estacion Central", Accion.ENTRADA,
                                                LocalDateTime.parse("2026-06-01T08:00:00")),
                                new Registro("U001", "Ruta A", "Estacion Norte", Accion.SALIDA,
                                                LocalDateTime.parse("2026-06-01T08:35:00")),
                                new Registro("U002", "Ruta B", "Estacion Sur", Accion.ENTRADA,
                                                LocalDateTime.parse("2026-06-01T08:10:00")),
                                new Registro("U002", "Ruta B", "Estacion Central", Accion.SALIDA,
                                                LocalDateTime.parse("2026-06-01T08:50:00")),
                                new Registro("U003", "Ruta C", "Estacion Oeste", Accion.ENTRADA,
                                                LocalDateTime.parse("2026-06-01T09:00:00")),
                                new Registro("U003", "Ruta C", "Estacion Este", Accion.SALIDA,
                                                LocalDateTime.parse("2026-06-01T09:20:00")),
                                new Registro("U001", "Ruta A", "Estacion Norte", Accion.ENTRADA,
                                                LocalDateTime.parse("2026-06-01T17:00:00")),
                                new Registro("U001", "Ruta A", "Estacion Central", Accion.SALIDA,
                                                LocalDateTime.parse("2026-06-01T17:40:00")),
                                new Registro("U004", "Ruta D", "Estacion Universidad", Accion.ENTRADA,
                                                LocalDateTime.parse("2026-06-01T10:15:00")),
                                new Registro("U004", "Ruta D", "Estacion Centro", Accion.SALIDA,
                                                LocalDateTime.parse("2026-06-01T10:45:00")),
                                new Registro("U002", "Ruta B", "Estacion Central", Accion.ENTRADA,
                                                LocalDateTime.parse("2026-06-01T13:00:00")),
                                new Registro("U002", "Ruta B", "Estacion Sur", Accion.SALIDA,
                                                LocalDateTime.parse("2026-06-01T13:30:00")),
                                new Registro("U005", "Ruta E", "Estacion Terminal", Accion.ENTRADA,
                                                LocalDateTime.parse("2026-06-01T07:30:00")),
                                new Registro("U005", "Ruta E", "Estacion Aeropuerto", Accion.SALIDA,
                                                LocalDateTime.parse("2026-06-01T08:15:00")),
                                new Registro("U003", "Ruta C", "Estacion Este", Accion.ENTRADA,
                                                LocalDateTime.parse("2026-06-01T18:00:00")),
                                new Registro("U003", "Ruta C", "Estacion Oeste", Accion.SALIDA,
                                                LocalDateTime.parse("2026-06-01T18:25:00")),
                                new Registro("U004", "Ruta D", "Estacion Centro", Accion.ENTRADA,
                                                LocalDateTime.parse("2026-06-01T16:00:00")),
                                new Registro("U004", "Ruta D", "Estacion Universidad", Accion.SALIDA,
                                                LocalDateTime.parse("2026-06-01T16:30:00")),
                                new Registro("U005", "Ruta E", "Estacion Aeropuerto", Accion.ENTRADA,
                                                LocalDateTime.parse("2026-06-01T19:00:00")),
                                new Registro("U005", "Ruta E", "Estacion Terminal", Accion.SALIDA,
                                                LocalDateTime.parse("2026-06-01T19:50:00"))

                );
        }
}
