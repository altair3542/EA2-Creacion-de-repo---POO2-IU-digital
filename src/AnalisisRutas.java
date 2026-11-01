import java.util.List;
import java.util.Map;

import Interfaces.IRutasService;
import modelo.Registro;

public class AnalisisRutas {

    private final List<Registro> registros;
    private final IRutasService rutasService;

    public AnalisisRutas(List<Registro> registros, IRutasService rutasService) {
        this.registros = List.copyOf(registros);
        this.rutasService = rutasService;
    }

    public Map<String, Long> obtenerUsoPorRuta() {
        return rutasService.usoPorRuta(registros);
    }

    public List<String> obtenerRutasCriticas(long umbral) {
        return rutasService.rutasCriticas(registros, umbral);
    }
}