public class Coche {
    String matricula;
    String modelo;
    Integer velocidad;
    Integer cantidadGasolina; // Se implemento para saber la cantidad de gasolina y hacer posible la implementacion de ponerGasolina
    Integer metrosAvanzo; // Se añadio esto para saber los metros que avanzo y para hacer posible implementar el metodo avanzar con mis conocimientos actuales
    /**
     * Constructor de objetos coche
     * @param modelo el modelo de coche a establecer
     * @param matricula la matricula del coche
     */
    public Coche(String modelo, String matricula) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.velocidad = 0;
    }
}
