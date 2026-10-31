import java.util.List;
//import java.util.Map;

import modelo.Registro;

public class Main {
        public static void main(String[] args) {
                List<Registro> registros = DatosSimulados.crear();

                AnalisisViajes analisis = new AnalisisViajes(registros, new Classes.EstacionesUsuario() {
                }, new Classes.TiempoPromedio() {
                });

                System.out.println("=== PATRONES DE VIAJES POR USUARIO ===");
                analisis.obtenerPatronesViajes().forEach((usuario, estaciones) -> {
                        System.out.println("Usuario [" + usuario + "] ➔ Recorrido: " + String.join(" -> ", estaciones));
                });
                System.out.println("=============================================================");
                System.out.println("=== TIEMPO PROMEDIO POR VIAJES DE LOS USUARIOS ===");
                analisis.obtenerTiempoPromedio().forEach((usuarioId, tiempo) -> {
                        System.out.println("Usuario U0" + usuarioId + " ➔ Tiempo promedio: " + tiempo + " minutos");
                });

                AnalisisEstaciones analisisEstaciones = new AnalisisEstaciones(
                                registros,
                                new Classes.EstacionesUsuario() {
                                }, // Implementa IEstacionesUsuariosService
                                new Classes.FlujoTiempo() {
                                } // Implementa IFlujoTiempoService (Clase abstracta)
                );
                System.out.println("=============================================================");
                System.out.println("=== AFLUENCIA POR ESTACIÓN ===");
                analisisEstaciones.obtenerAfluenciaPorEstacion().forEach((estacion, total) -> {
                        System.out.println("Estación [" + estacion + "] ➔ " + total + " entradas");
                });

                System.out.println("=============================================================");
                System.out.println("=== FLUJO POR HORA ===");
                analisisEstaciones.obtenerFlujoPorHora().forEach((hora, total) -> {
                        System.out.println("Hora " + hora + ":00 ➔ " + total + " movimientos");
                });

                System.out.println("=============================================================");
                System.out.println("=== HORAS PICO ===");
                List<Integer> horasPico = analisisEstaciones.obtenerHorasPico();
                System.out.println("Las horas pico del sistema son: " + horasPico.stream()
                                .map(hora -> String.format("%02d:00", hora))
                                .reduce((hora1, hora2) -> hora1 + ", " + hora2)
                                .orElse("No hay horas pico"));
                /*
                 * System.out.println("TecnoMovil Data - aporte de Santiago");
                 * System.out.println("Registros de ejemplo: " + registros.size());
                 * 
                 * System.out.println("Entradas por estación:");
                 * AnalisisEstaciones.afluenciaPorEstacion(registros).entrySet().stream()
                 * .sorted(Map.Entry.comparingByKey())
                 * .forEach(entrada -> System.out.printf("  %s: %d%n",
                 * entrada.getKey(), entrada.getValue()));
                 * 
                 * Map<Integer, Long> flujo = AnalisisEstaciones.flujoPorHora(registros);
                 * System.out.println("Flujo por hora (entradas y salidas):");
                 * flujo.entrySet().stream()
                 * .sorted(Map.Entry.comparingByKey())
                 * .forEach(entrada -> System.out.printf("  %02d:00: %d%n",
                 * entrada.getKey(), entrada.getValue()));
                 * 
                 * System.out.println("Horas pico:");
                 * AnalisisEstaciones.horasPico(flujo)
                 * .forEach(hora -> System.out.printf("  %02d:00 (%d registros)%n",
                 * hora, flujo.get(hora)));
                 */

                // TODO: integrar los aportes de Alejandro (rutas) y Abimael (viajes).
        }
}
