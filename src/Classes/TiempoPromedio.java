package Classes;

import java.time.Duration;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import Interfaces.ITiempoPromedioService;
import modelo.Accion;
import modelo.Registro;

public abstract class TiempoPromedio implements ITiempoPromedioService {
    @Override
    public Map<Integer, List<Double>> calcularTiempoPromedioEntreEstaciones(List<Registro> registros) {
        Map<Integer, List<Registro>> agrupados = registros.stream()
                .collect(Collectors.groupingBy(r -> Integer.parseInt(r.idUsuario().replaceAll("\\D+", ""))));

        Map<Integer, List<Double>> resultado = new HashMap<>();

        for (Map.Entry<Integer, List<Registro>> entry : agrupados.entrySet()) {

            List<Double> promedioCalculado = calcularPromedio(entry.getValue());
            resultado.put(entry.getKey(), promedioCalculado);
        }

        return resultado;

    }

    private List<Double> calcularPromedio(List<Registro> registrosUsuario) {
        var ordenados = registrosUsuario.stream()
                .sorted(Comparator.comparing(Registro::timestamp)).toList();

        OptionalDouble tiempos = IntStream.range(1, ordenados.size())
                .filter(i -> ordenados.get(i - 1).accion() == Accion.ENTRADA &&
                        ordenados.get(i).accion() == Accion.SALIDA)
                .mapToLong(i -> Duration.between(
                        ordenados.get(i - 1).timestamp(),
                        ordenados.get(i).timestamp()).toMinutes())
                .average();

        return tiempos.isPresent() ? List.of(tiempos.getAsDouble()) : List.of();
    }
}