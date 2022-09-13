# CVDS_Laboratorio3

## PARTE I - Registry
Para compilar el proyecto se utiliza 

~~~
mvn package
~~~
### Diferencia entre mvn package y mvn test
mvn package Se utiliza mas para construir el proyecto. En cambio
mvn test Para correr la pruebas unitarias

*  DEAD isn't alive and age > 100
*  UNDERAGE age < 18, age > 0 and alive
*  INVALID_AGE age < 0 and alive
*  VALID age < 100, age > 17 and alive
*  DUPLICATED if id duplicate


## PARTE II - Aerodescuentos
Se está desarrollando para una aerolínea su módulo de liquidación de tiquetes aéreos. Para el mismo, se tiene una función que aplica descuentos a la tarifa base del vuelo dependiendo del tiempo de antelación de la reserva y la edad del pasajero. Los descuentos SON ACUMULABLES.  Normativa 005, sobre los descuentos: 
* 15% de descuento sacando el billete con antelación superior a 20 días.
* 5% a los pasajeros con edad inferior a 18 años y 8% a los pasajeros con edad superior a 65 años.  
La siguiente es la especificación de la función que se usará en el módulo del cálculo de los descuentos: 

~~~
/**  calcular la tarifa de cada billete según el trayecto, la antelación
   en la que  se obtiene el billete y la edad del pasajero, de acuerdo   
   con la normativa 005.  
   @param tarifaBase valor base del vuelo  
   @param diasAntelacion dias de antelación del vuelo  
   @param edad - edad del pasajero  
   @throws ExcepcionParametrosInvalidos [XXXXXXXXXXXXXXXXXXXXXXXXXXX]  **/ 
   public long calculoTarifa(long tarifaBase, int diasAntelacion, int edad)
~~~

1. De acuerdo con lo indicado, y teniendo en cuenta que NO hay precondiciones, en qué casos se debería arrojar una excepción de tipo ExcepcionParametrosInvalidos?. Agregue esto a la especificación. 
Va a mandar excepcion cuando:

   * Cuando la tarifa base sea menor a 0
   * Cuando los dias de antelacion sean menor a 0
   * Cuando la edad sea menor a 0 o mayor a 65

2. En la siguiente tabla enumere un conjunto de clases de equivalencia que -según usted- creen una buena división del conjunto de datos de entrada de la función anterior:
   
| Número | Clase de equivalencia | Resultado correcto / incorrecto |
|--------|----------------------|--------------------------------| 
| 30     | tarifaBase >= 0      | Correcto                       |
| -80    | edad < 0             | Incorrecto                     |
| -10    | DiasAntelacion < 0   | Incorrecto                     |
| 40     | 0 <= edad <= 65      | Correcto                       | 

3. Para cada clase de equivalencia, defina un caso de prueba específico, definiendo: parámetros de entrada y resultados esperados.  

* calculoTarifa(tarifaBase=25, diasAntelacion=10, edad=10).
   Resultado: válido y aplica descuento de 5% por edad

* calculoTarifa(tarifaBase=5, diasAntelacion=10, edad=12).
  Resultado: Invalido y manda excepcion.

4. A partir de las clases de equivalencia identificadas en el punto 2, identifique las condiciones límite o de frontera de las mismas. 
Condiciones limite:
* Edad: 0-65
* TarifaBase: 0
* DiasAntelacion: 0

5. Para cada una de las condiciones de frontera anteriores, defina casos de prueba específicos. 

* calculoTarifa(tarifaBase=0, diasAntelacion=10, edad=10).
  Resultado: válido

* calculoTarifa(tarifaBase=5, diasAntelacion=20, edad=12).
  Resultado: valido