package Classes;

import java.time.Duration;
import java.util.Comparator;
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
        public Map<String, List<Double>> calcularTiempoPromedioEntreEstaciones(List<Registro> registros) {
                return registros.stream()
                                .collect(Collectors.collectingAndThen(
                                                Collectors.groupingBy(Registro::idUsuario,
                                                                Collectors.collectingAndThen(
                                                                                Collectors.toList(),
                                                                                this::calcularPromedio)),
                                                Map::copyOf));
        }

        private List<Double> calcularPromedio(List<Registro> registrosUsuario) {
                var ordenados = registrosUsuario.stream()
                                .sorted(Comparator.comparing(Registro::timestamp))
                                .toList();

                // Calcular únicamente trayectos entre estaciones diferentes
                OptionalDouble tiempos = IntStream.range(1, ordenados.size())
                                .filter(i -> ordenados.get(i - 1).accion() == Accion.ENTRADA &&
                                                ordenados.get(i).accion() == Accion.SALIDA &&
                                                !ordenados.get(i - 1).estacion()
                                                                .equals(ordenados.get(i).estacion()))
                                .mapToLong(i -> Duration.between(
                                                ordenados.get(i - 1).timestamp(),
                                                ordenados.get(i).timestamp()).toMinutes())
                                .average();

                // Retornar el promedio calculado
                return tiempos.isPresent()
                                ? List.of(tiempos.getAsDouble())
                                : List.of();
        }
}
