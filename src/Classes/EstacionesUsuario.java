package Classes;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import Interfaces.IEstacionesUsuariosService;
import modelo.Accion;
import modelo.Registro;

public abstract class EstacionesUsuario implements IEstacionesUsuariosService {

    @Override
    public Map<String, List<String>> ObtenerEstacionesPorUsuarios(List<Registro> registros) {

        Map<String, List<String>> resultado = registros.stream()
                .collect(Collectors.groupingBy(
                        Registro::idUsuario,
                        Collectors.mapping(
                                Registro::estacion,
                                Collectors.toList())));

        // Hacer inmutables las listas de estaciones
        resultado.replaceAll((id, estaciones) -> List.copyOf(estaciones));

        // Devolver un mapa inmutable
        return Map.copyOf(resultado);
    }

    @Override
    public Map<String, Long> afluenciaPorEstacion(List<Registro> registros) {
        return Map.copyOf(registros.stream()
                // Nota: Si 'accion' es enum, usa Accion.ENTRADA.
                .filter(registro -> Accion.ENTRADA.equals(registro.accion()))
                .collect(Collectors.groupingBy(Registro::estacion, Collectors.counting())));
    }
}
