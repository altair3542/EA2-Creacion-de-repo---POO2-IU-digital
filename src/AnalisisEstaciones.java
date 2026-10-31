import java.util.List;
import java.util.Map;
import modelo.Registro;
import Interfaces.IEstacionesUsuariosService;
import Interfaces.IFlujoTiempoService;

// Santiago: requisitos a (afluencia por estación) y b (horas pico).
public class AnalisisEstaciones {
        private final List<Registro> registros;
        private final IEstacionesUsuariosService estacionesService;
        private final IFlujoTiempoService flujoTiempo;

        public AnalisisEstaciones(List<Registro> registros,
                        IEstacionesUsuariosService estacionesService,
                        IFlujoTiempoService flujoTiempo) {
                this.registros = List.copyOf(registros);
                this.estacionesService = estacionesService;
                this.flujoTiempo = flujoTiempo; 
        }

        public Map<String, Long> obtenerAfluenciaPorEstacion() {
                return estacionesService.afluenciaPorEstacion(registros);
        }

        public Map<Integer, Long> obtenerFlujoPorHora() {
                return flujoTiempo.flujoPorHora(registros);
        }

        public List<Integer> obtenerHorasPico() {
                Map<Integer, Long> flujo = flujoTiempo.flujoPorHora(registros);
                return flujoTiempo.horasPico(flujo);
        }
}