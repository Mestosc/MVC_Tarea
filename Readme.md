# Arquitectura MVC

Aplicación que trabaja con objetos coches, modifica la velocidad y la muestra

## Cambios que decidi hacer

Los cambios que decidi hacer y que luego me di cuenta son:

1. Retorno de la funcion avanzar en el model hago que retorne los metros que avanzo, al llamar a la funcion y no los metros totales que avanzo más los actuales
2. Se me olvido en avanzar poner lo de quitar gasolina en el pseudocodigo y en el diagrama de secuencia solo represente procesos pero no lo especifique asi que bueno, lo hare que en funcion de la velocidad y asi haga la resta pero si da menos que 0 lo pongo a 0
basicamente la formula que he sacado es algo asi, he cambiado la forma en la que hace el calculo para asegurar que funcione y hacerlo más sencillo, este es el actual calculo de gasolina
```java
coche.cantidadGasolina -= (metrosAvanzar+coche.velocidad)/2;
```
3. Tambien aunque seria más ortodoxo el uso de Interfaces como Observable y Observer que describiste en la rama Observer de tu repositorio de solucion de MVC, dado a que facilita la implementacion de multiples Observer, pues como tal yo no he hecho eso porque es más complejo y no es necesario para esto, aunque a lo mejor lo hago

---
## DIagrama con Observer de gasolina
```mermaid
sequenceDiagram
    participant View
    box gray Controlador
    participant Controller
    participant observoGasolina
    end
    participant Model

    Controller->>Model: avanzar()
    activate Model
    Model->>observoGasolina: update()
    deactivate Model
    activate observoGasolina
    observoGasolina->>View: alertarGasolina()
    deactivate observoGasolina
    activate View
    View->>View: sout()
    deactivate View
```
## Diagrama de clases:

```mermaid
classDiagram
    class Coche {
        String: matricula
        String: modelo
        Integer: velocidad
    }
      class Controller{
          +main()
      }
      class View {+muestraVelocidad(String, Integer)}
      class Model {
          ArrayList~Coche~: parking
          +crearCoche(String, String, String)
          +getCoche(String)
          +cambiarVelocidad(String, Integer)
          +getVelocidad(String)
      }
    Controller "1" *-- "1" Model : association
    Controller "1" *-- "1" View : association
    Model "1" *-- "1..n" Coche : association
      
```

---

## Diagrama de Secuencia

Ejemplo básico del procedimiento, sin utilizar los nombres de los métodos


```mermaid
sequenceDiagram
    participant Model
    participant Controller
    participant View
    Controller->>Model: Puedes crear un coche?
    activate Model
    Model-->>Controller: Creado!
    deactivate Model
    Controller->>+View: Muestra la velocidad, porfa
    activate View
    View->>-View: Mostrando velocidad
    View-->>Controller: Listo!
    deactivate View
```

El mismo diagrama con los nombres de los métodos

```mermaid
sequenceDiagram
    participant Model
    participant Controller
    participant View
    Controller->>Model: crearCoche("Mercedes", "BXK 1234")
    activate Model
    Model-->>Controller: Coche
    deactivate Model
    Controller->>+View: muestraVelocidad("BXK 1234", velocidad)
    activate View
    View->>-View: System.out.println()
    View-->>Controller: boolean
    deactivate View
```
Diagrama de secuencia propio, hecho en Mermaid
```mermaid
sequenceDiagram
    participant View
    participant Controller
    participant Model

%% --- Crear Coche ---
    View->>+Controller: crearCoche(matricula, modelo)
    Controller->>+Model: crearCoche(matricula, modelo)
    Model-->>-Controller: Coche creado
    Controller-->>-View: Coche creado

%% --- Cambiar Velocidad ---
    View->>+Controller: cambiarVelocidad(matricula, nuevaVelocidad)
    Controller->>+Model: cambiarVelocidad(matricula, nuevaVelocidad)
    Model-->>-Controller: nuevaVelocidad
    Controller-->>-View: velocidad aplicada

%% --- Incrementar Velocidad ---
    View->>+Controller: incrementarVelocidad(matricula)
    Controller->>+Model: incrementarVelocidad(matricula)
    Model-->>-Controller: velocidad incrementada
    Controller-->>-View: velocidad incrementada

%% --- Obtener Coche ---
    View->>+Controller: obtenerCoche(matricula)
    Controller->>+Model: obtenerCoche(matricula)
    Model-->>-Controller: datos del Coche
    Controller-->>-View: Coche solicitado

```