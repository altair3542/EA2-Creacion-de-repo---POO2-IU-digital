package Interfaces;

import modelo.Registro;
import java.util.List;
import java.util.Map;

public interface IEstacionesUsuariosService {
    Map<String, List<String>> ObtenerEstacionesPorUsuarios(List<Registro> registros);
    Map<String, Long> afluenciaPorEstacion(List<Registro> registros);
}
