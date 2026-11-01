package modelo;
import java.time.LocalDateTime;
// Modelo inmutable compartido; accion usa Accion.ENTRADA o Accion.SALIDA.
public record Registro(
        String idUsuario,
        String ruta,
        String estacion,
        Accion accion,
        LocalDateTime timestamp
) {}
