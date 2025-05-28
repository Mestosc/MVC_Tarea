import java.util.ArrayList;
import java.lang.module.ModuleDescriptor; // Lo voy a dejar porque como Damian lo puso a lo mejor es necesario para luego
/**
 * Clase encargada de manejar los datos
 */
public class Model {
    static ArrayList<Coche> parking = new ArrayList<>();

    /**
     * Crea un coche y lo mete en el parking
     * @param modelo del coche
     * @param matricula identificador unico
     * @return el coche creado
     */
    public static Coche crearCoche(String modelo, String matricula){
        Coche aux = new Coche(modelo, matricula);
        parking.add(aux);
        return aux;
    }

    /**
     * Busca coche segun matricula
     * @param matricula a buscar
     * @return chche o null si no existe
     */
    public static Coche getCoche(String matricula){
        Coche aux = null;
        // recorre el array buscando por matricula
        for (Coche e: parking) {
            if (e.matricula.equals(matricula)) {
                aux = e;
            }
        }
        return aux;
    }

    /**
     * Cambia la velocidad de un coche
     * @param matricula la matricula
     * @param v nueva velocidad
     * @return velocidad modificada
     */
    public static int cambiarVelocidad(String matricula, Integer v) {
        // busca el coche
        getCoche(matricula).velocidad = v;
        // retorna la nueva velocidad
        return getCoche(matricula).velocidad;
    }

    /**
     * Ddevuelve la velocidad segun la matricula
     * @param matricula la matricula del vehiculo
     * @return La velocidad
     */
    public static int getVelocidad(String matricula) {
        return getCoche(matricula).velocidad;
    }
    // PIERO
    public static int incrementarVel(String matricula){
       int velocidad =  getCoche(matricula).velocidad+1;
       cambiarVelocidad(matricula, velocidad);
       return  velocidad;
    }

    public static int decrementarVel(String matricula){
        int velocidad =  getCoche(matricula).velocidad-1;
        cambiarVelocidad(matricula, velocidad);
        return  velocidad;
    }

    /**
     * Avanza el vehiculo y refleja el avance
     * @param metrosAvanzar los metros que se desea avanzar
     * @param matricula la matricula del vehiculo que desea hacer avanzar
     * @return Los metros que avanzo esta vez
     */
    public static int avanzar(int metrosAvanzar, String matricula) {
        Coche coche = getCoche(matricula);
        coche.metrosAvanzo += metrosAvanzar;
        int vel = 1;
        if (coche.velocidad>1) vel = coche.velocidad;
        coche.cantidadGasolina += vel / -metrosAvanzar;
        if (coche.cantidadGasolina<0) coche.cantidadGasolina = 0;
        return metrosAvanzar;
    }

    /**
     * Sirve para repostar el vehiculo
     * @param listrosGasolina los litros de gasolina a añadir
     * @param matricula la matricula del vehiculo
     * @return la cantidad de total de gasolina con el incremento
     */
    public static int ponerGasolina(int listrosGasolina, String matricula) {
        Coche c = getCoche(matricula);
        c.cantidadGasolina += listrosGasolina;
        return c.cantidadGasolina;
    }
}
