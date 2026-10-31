package modelo;
import java.time.LocalDateTime;
// Modelo inmutable. accion debe ser "entrada" o "salida".
public record Registro(
        String idUsuario,
        String ruta,
        String estacion,
        Accion accion,
        LocalDateTime timestamp
) {}