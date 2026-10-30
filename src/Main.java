import java.time.LocalDateTime;
import java.util.List;

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

        System.out.println("TecnoMovil Data - esqueleto inicial");
        System.out.println("Registros de ejemplo: " + registros.size());
        System.out.println("Las seis operaciones están pendientes de implementar.");

        // TODO: llamar las operaciones de los tres integrantes cuando estén listas.
    }
}
