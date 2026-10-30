# EA2 Creacion de repo - POO2-IU-digital

Punto de partida para la actividad EA2 de programación funcional en Java.
Grupo de tres integrantes. La rama `aporte/estaciones` implementa las operaciones
de Santiago: afluencia por estación y horas pico. Las operaciones de rutas y viajes
siguen pendientes para los otros integrantes.

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

Salida del ejemplo:

```text
TecnoMovil Data - aporte de Santiago
Registros de ejemplo: 3
Entradas por estación:
  Centro: 2
Flujo por hora (entradas y salidas):
  07:00: 2
  08:00: 1
Horas pico:
  07:00 (2 registros)
```

`Main.java` carga tres registros y muestra el análisis de estaciones. Los métodos de
rutas y viajes lanzan `UnsupportedOperationException` hasta que sus responsables
los implementen; todavía no se invocan desde `Main`.

## Aporte de Santiago

- `afluenciaPorEstacion`: cuenta cada validación de entrada por estación, incluidos
  ingresos repetidos de un mismo usuario. No cuenta usuarios únicos ni salidas.
- `flujoPorHora`: cuenta todas las acciones (entradas y salidas) por hora. Se espera
  una lista de un solo día; el método no separa fechas ni incluye horas sin registros.
- `horasPico`: recibe el mapa de flujo y devuelve todas las horas de máximo flujo
  en orden ascendente. Sin datos, devuelve una lista vacía.

Son funciones puras: dependen de sus argumentos, no imprimen y no modifican los
datos recibidos. `Registro` es inmutable, `Map.copyOf` protege los mapas devueltos y
`Stream.toList()` devuelve una lista que no admite modificaciones.

Las lambdas describen el filtro de entradas, la extracción de la hora y la selección
de máximos. `filter`, `map` y `groupingBy` son operaciones de orden superior porque
reciben funciones. Los pipelines con `stream`, `collect`, `counting`, `max` y `sorted`
expresan el análisis de forma declarativa. La impresión con `forEach` queda en `Main`,
separada del cálculo. El agrupamiento usa un acumulador interno del collector, sin
mutar la lista original ni compartir estado externo.

Estos criterios de conteo están adoptados para este aporte y deben revisarse con el
equipo antes de la entrega final.

### Verificar el aporte

Después de compilar `src`, ejecutar:

```sh
javac -encoding UTF-8 -cp out -d out tests/*.java
java -cp out PruebaAnalisisEstaciones
```

La verificación usa resultados conocidos para entradas y salidas, ingresos repetidos,
horas empatadas, una sola hora pico, datos vacíos y conservación de la lista original.
También comprueba que los resultados no se puedan modificar. No requiere frameworks.

## Reparto propuesto

| Responsable | Archivo principal | Aporte |
| --- | --- | --- |
| Santiago | `src/AnalisisEstaciones.java` | a) Afluencia por estación; b) Flujo por hora e identificación de horas pico |
| Alejandro | `src/AnalisisRutas.java` | c) Rutas más utilizadas; f) Detección de rutas críticas |
| Abimael | `src/AnalisisViajes.java` | d) Estaciones por usuario; e) Tiempo promedio entre estaciones |

Cada integrante agrega las llamadas y la presentación de sus resultados en
`Main.java` al integrar su aporte. Coordinar esos cambios para evitar conflictos.

## Cómo aportar

1. El propietario invita a los otros dos usuarios desde **Settings > Collaborators**.
2. Cada compañero clona el repositorio:

   ```sh
   git clone https://github.com/altair3542/EA2-Creacion-de-repo---POO2-IU-digital.git
   cd EA2-Creacion-de-repo---POO2-IU-digital
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
