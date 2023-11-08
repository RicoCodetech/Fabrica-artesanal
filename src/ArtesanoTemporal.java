
/**
 * visualizacion de los trabajos a realizar, actualizacion del estado del mueble
 * introduciendo la referencia del mismo y ademas define que el contrato sera temporal.
 * 
 * @author Oscar Rico Martinez
 * @version 19/05/2020
 */
import java.util.ArrayList;

public class ArtesanoTemporal extends Artesano
{
    // instance variables - replace the example below with your own
    ///ArrayList <Integer> refPedido= new ArrayList();
    
    /**
     * Constructor de la clase ArtesanoTemporal
     * @param nombre Del Artesano
     * @param sueldo Del Artesano
     */
    public ArtesanoTemporal(String nombre, int sueldo)
    {
        // initialise instance variables
        super(nombre,sueldo);
        setTipoContrato("temporal");
    }
    
    @Override
    public String toString()
    {
        return "ID: " + getId() +  " Puesto " + getPuesto() + " Contrato " + getTipoContrato() + " Sueldo: " + getSueldo() + " Nombre: " + getNombre();
    }

}
