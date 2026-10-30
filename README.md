# TecnoMovil Data

Punto de partida para la actividad EA2 de programación funcional en Java.
Grupo de tres integrantes. Este repositorio contiene únicamente el esqueleto:
las seis operaciones del caso de estudio están pendientes.

## Ejecutar

Requiere un JDK 17 o superior. No usa frameworks, Maven ni dependencias externas.
Desde la carpeta del proyecto:

```sh
mkdir -p out
javac -encoding UTF-8 -d out src/*.java
java -cp out Main
```

En Windows PowerShell, crear `out` con `New-Item -ItemType Directory -Force out`;
los comandos de compilación y ejecución son los mismos.

Salida inicial:

```text
TecnoMovil Data - esqueleto inicial
Registros de ejemplo: 3
Las seis operaciones están pendientes de implementar.
```

`Main.java` solo carga tres registros y muestra ese mensaje. Los métodos pendientes
lanzan `UnsupportedOperationException` hasta que cada integrante los implemente.

## Reparto propuesto

Reemplazar los nombres pendientes por los del equipo antes de empezar.

| Responsable | Archivo principal | Aporte pendiente |
| --- | --- | --- |
| Integrante 1 (nombre pendiente) | `src/AnalisisEstaciones.java` | a) Afluencia por estación; b) Flujo por hora e identificación de horas pico |
| Integrante 2 (nombre pendiente) | `src/AnalisisRutas.java` | c) Rutas más utilizadas; f) Detección de rutas críticas |
| Integrante 3 (nombre pendiente) | `src/AnalisisViajes.java` | d) Estaciones por usuario; e) Tiempo promedio entre estaciones |

Cada integrante agrega las llamadas y la presentación de sus resultados en
`Main.java` al integrar su aporte. Coordinar esos cambios para evitar conflictos.

## Cómo aportar

1. El propietario invita a los otros dos usuarios desde **Settings > Collaborators**.
2. Cada compañero clona el repositorio:

   ```sh
   git clone https://github.com/altair3542/tecnomovil-data.git
   cd tecnomovil-data
   git switch -c aporte/estaciones
   ```

   Usar `aporte/rutas` o `aporte/viajes` para los otros aportes.

3. Implementar su clase, compilar y revisar sus resultados con ejemplos conocidos.
4. Registrar y subir únicamente sus cambios. Ejemplo para estaciones:

   ```sh
   git add src/AnalisisEstaciones.java
   git commit -m "Implementar análisis de estaciones"
   git push -u origin aporte/estaciones
   ```

5. Abrir un Pull Request hacia `main`; otro integrante lo revisa y después se integra.
   Agregar también los archivos de documentación o integración que se hayan editado.

## Acuerdos antes de implementar

- Usar funciones puras, lambdas, Streams y funciones de orden superior.
- No modificar la lista recibida ni los registros; `Registro` es un `record` inmutable.
- Evitar efectos secundarios en el análisis. Mostrar resultados únicamente en `Main`.
- Acordar si el flujo y el uso de rutas cuentan todas las acciones o solo entradas,
  y si la afluencia cuenta validaciones o usuarios únicos. Documentar la decisión.
- Definir el tratamiento de empates en horas pico y rutas más utilizadas.
- Para los patrones por usuario, conservar el orden de aparición de las estaciones.
- Acordar cómo emparejar estaciones para calcular tiempos y tratar registros desordenados.
- Definir cómo se simula la ocupación para detectar sobrecarga; no confundirla sin
  justificación con el total diario de registros de una ruta.
- Ampliar los datos simulados después. Los tres ejemplos actuales solo permiten arrancar.
  Si se decide usar `parallelStream()`, comprobar que se conserva el resultado esperado.

## Pendientes conjuntos para la entrega final

- [ ] Completar nombres de integrantes, grupo, asignatura y docente.
- [ ] Implementar e integrar las seis operaciones en `main`.
- [ ] Generar un conjunto grande de datos simulados y validar resultados.
- [ ] Documentar las funciones puras, inmutabilidad, orden superior, lambdas y Streams usados.
- [ ] Capturar evidencias reales de ejecución de la solución terminada.
- [ ] Elaborar el informe PDF en APA 7: portada, introducción, objetivos, desarrollo,
      código fuente, evidencias, conclusiones y enlaces de los tres repositorios.
- [ ] Crear el ZIP del proyecto final.
- [ ] Cada integrante aloja la solución en la rama principal de su propio repositorio
      y sube allí el mismo informe grupal.
- [ ] Verificar que el docente pueda acceder a los repositorios.
- [ ] Nombrar el PDF según la guía: `EA2_Creación_de_repositorio_GrupoX_ApellidoNombre.pdf`
      (incluir los apellidos y nombres que correspondan al grupo).
- [ ] Cada integrante entrega el informe mediante **Cargar Tarea** en la plataforma.

El informe, las evidencias, el ZIP final y los repositorios individuales se prepararán
cuando el equipo complete la solución.
