import java.util.List;
import java.util.Map;
import modelo.Registro;

public class Main {
        public static void main(String[] args) {
                List<Registro> registros = DatosSimulados.crear();

                AnalisisViajes analisis = new AnalisisViajes(registros, new Classes.EstacionesUsuario() {
                }, new Classes.TiempoPromedio() {
                });

                System.out.println("TecnoMovil Data");
                System.out.println("=============================================================");

                System.out.println("=== Aporte Abimael ===");
                System.out.println("=== PATRONES DE VIAJES POR USUARIO ===");
                analisis.obtenerPatronesViajes().forEach((idUsuario, estaciones) -> {
                        System.out.println("Usuario [" + idUsuario + "]  Recorrido: " + String.join(" -> ", estaciones));
                });
                System.out.println("=============================================================");
                System.out.println("=== TIEMPO PROMEDIO POR VIAJES DE LOS USUARIOS ===");
                analisis.obtenerTiempoPromedio().forEach((idUsuario, tiempo) -> {
                        System.out.println("Usuario " + idUsuario + "  Tiempo promedio: " + tiempo + " minutos");
                });

                AnalisisEstaciones analisisEstaciones = new AnalisisEstaciones(
                                registros,
                                new Classes.EstacionesUsuario() {
                                }, // Implementa IEstacionesUsuariosService
                                new Classes.FlujoTiempo() {
                                } // Implementa IFlujoTiempoService (Clase abstracta)
                );
                System.out.println("=============================================================");
                System.out.println("=== Aporte Santiago ===");
                System.out.println("=== AFLUENCIA POR ESTACIÓN ===");
                analisisEstaciones.obtenerAfluenciaPorEstacion().forEach((estacion, total) -> {
                        System.out.println("Estación " + estacion + " " + total + " Registros");
                });

                System.out.println("=============================================================");
                System.out.println("=== FLUJO POR HORA ===");
                analisisEstaciones.obtenerFlujoPorHora().forEach((hora, total) -> {
                        System.out.println("Hora " + hora + ":00  " + total + " Registros");
                });

                System.out.println("=============================================================");
                System.out.println("=== HORAS PICO ===");
                List<Integer> horasPico = analisisEstaciones.obtenerHorasPico();
                System.out.println("hora pico : " + horasPico.stream()
                                .map(hora -> String.format("%02d:00", hora))
                                .reduce((hora1, hora2) -> hora1 + ", " + hora2)
                                .orElse("No hay horas pico"));

                System.out.println("=============================================================");
                System.out.println("=== Aporte Alejandro ===");
                System.out.println("=== USO POR RUTA ===");

                AnalisisRutas analisisRutas = new AnalisisRutas(
                                registros,
                                new Classes.RutasUsuarios() {
                                }
                );

                analisisRutas.obtenerUsoPorRuta().entrySet().stream()
                                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()
                                                .thenComparing(Map.Entry.comparingByKey()))
                                .forEach(entrada -> System.out.println(
                                                "Ruta [" + entrada.getKey() + "] -> "
                                                                + entrada.getValue() + " entradas"));

                // Requerimiento f: Detección de sobrecarga.
                System.out.println("=============================================================");
                System.out.println("=== RUTAS CRÍTICAS ===");

                long umbral = 10;
                System.out.println("Umbral simulado: más de " + umbral + " entradas por ruta en el día.");

                List<String> rutasCriticas = analisisRutas.obtenerRutasCriticas(umbral);

                if (rutasCriticas.isEmpty()) {
                        System.out.println("No se encontraron rutas críticas.");
                } else {
                        rutasCriticas.forEach(ruta -> {
                                System.out.println("Ruta sobrecargada: " + ruta);
                        });
                }
        }
}
