package Classes;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Interfaces.IRutasService;
import modelo.Accion;
import modelo.Registro;

public abstract class RutasUsuarios implements IRutasService {

    @Override
    public Map<String, Long> usoPorRuta(List<Registro> registros) {
        return Map.copyOf(registros.stream()
                .filter(r -> Accion.ENTRADA.equals(r.accion()))
                .collect(Collectors.groupingBy(
                        Registro::ruta,
                        Collectors.counting()
                )));
    }

    @Override
    public List<String> rutasCriticas(List<Registro> registros, long umbral) {
        return usoPorRuta(registros).entrySet().stream()
                .filter(entry -> entry.getValue() > umbral)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}