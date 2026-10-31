package Classes;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import Interfaces.IFlujoTiempoService;
import modelo.Registro;

public abstract class FlujoTiempo implements IFlujoTiempoService {
    
    @Override
    public Map<Integer, Long> flujoPorHora(List<Registro> registros) {
        return Map.copyOf(registros.stream()
                .collect(Collectors.groupingBy(
                        registro -> registro.timestamp().getHour(), Collectors.counting())));
    }

    @Override
    public List<Integer> horasPico(Map<Integer, Long> flujo) {
        long maximo = flujo.values().stream()
                .mapToLong(Long::longValue)
                .max()
                .orElse(0L);

        return flujo.entrySet().stream()
                .filter(entrada -> entrada.getValue() == maximo)
                .map(Map.Entry::getKey)
                .sorted()
                .toList();
    }
}
