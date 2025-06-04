public class ObserverGasolina {
    final static int CANTIDAD_GASOLINA_ALERTAR = 10;
    public static void update(Coche coche) {
        if (coche.cantidadGasolina < CANTIDAD_GASOLINA_ALERTAR) {
            View.alertarGasolina(coche.cantidadGasolina);
        }
    }
}
