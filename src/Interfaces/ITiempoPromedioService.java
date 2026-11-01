package Interfaces;
import java.util.List;
import java.util.Map;
import modelo.Registro;

public interface ITiempoPromedioService {
    Map<String, List<Double>> calcularTiempoPromedioEntreEstaciones(List<Registro> registros);
}
