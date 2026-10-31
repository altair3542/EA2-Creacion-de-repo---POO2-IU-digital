package Classes;


import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import Interfaces.IEstacionesUsuariosService;
import modelo.Accion;
import modelo.Registro;

public abstract class EstacionesUsuario implements IEstacionesUsuariosService {

    @Override
    public Map<String, List<String>> ObtenerEstacionesPorUsuarios(List<Registro> registros) {
        return registros.stream().sorted(Comparator.comparing(Registro::timestamp))
                .collect(Collectors.groupingBy(Registro::idUsuario,
                        Collectors.mapping(Registro::estacion, Collectors.toList())));
    }

    @Override
    public Map<String, Long> afluenciaPorEstacion(List<Registro> registros) {
        return Map.copyOf(registros.stream()
                // Nota: Si 'accion' es enum, usa Accion.ENTRADA.
                .filter(registro -> Accion.ENTRADA.equals(registro.accion())) 
                .collect(Collectors.groupingBy(Registro::estacion, Collectors.counting())));
    }
}
