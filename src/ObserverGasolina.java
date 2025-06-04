/**
 * Observador de gasolina, observa si la gasolina del coche baja de ciertos limites, es más ortodoxo con el uso de Interfaces pero me da pereza hacerlas y tener que ponerme a organizarlas además es un poco más complejo
 * @version 1.0
 * @author Oscar Rodriguez
 */
public class ObserverGasolina {
    final static int CANTIDAD_GASOLINA_ALERTAR = 10;

    /**
     * Actualizar vista si cambia un dato
     * @param coche el coche que queremos comprobar si bajo en cantidad de gasolina
     */
    public static void update(Coche coche) {
        if (coche.cantidadGasolina < CANTIDAD_GASOLINA_ALERTAR) {
            View.alertarGasolina(coche.cantidadGasolina);
        }
    }
}
