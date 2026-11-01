package Interfaces;

import java.util.List;
import java.util.Map;
import modelo.Registro;

public interface IRutasService {

    Map<String, Long> usoPorRuta(List<Registro> registros);

    List<String> rutasCriticas(List<Registro> registros, long umbral);
}