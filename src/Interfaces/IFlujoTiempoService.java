package Interfaces;

import java.util.List;
import java.util.Map;
import modelo.Registro;

public interface IFlujoTiempoService {
    Map<Integer, Long> flujoPorHora(List<Registro> registros);
    List<Integer> horasPico(Map<Integer, Long> flujo);
}
