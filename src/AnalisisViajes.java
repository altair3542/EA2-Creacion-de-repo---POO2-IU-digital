
import java.util.List;
import java.util.Map;

import modelo.Registro;
import Interfaces.IEstacionesUsuariosService;
import Interfaces.ITiempoPromedioService;

// Integrante 3: requisitos d y e.
public class AnalisisViajes {
    private final List<Registro> registros;
    private final IEstacionesUsuariosService estaciones;
    private final ITiempoPromedioService tiempos;

    public AnalisisViajes(List<Registro> registros, IEstacionesUsuariosService estaciones,
            ITiempoPromedioService tiempos) {
        this.registros = List.copyOf(registros);
        this.estaciones = estaciones;
        this.tiempos = tiempos;
    }

    public Map<String, List<String>> obtenerPatronesViajes() {
        return estaciones.ObtenerEstacionesPorUsuarios(registros);
    }

    public Map<String, List<Double>> obtenerTiempoPromedio() {
        return tiempos.calcularTiempoPromedioEntreEstaciones(registros);
    }
}
