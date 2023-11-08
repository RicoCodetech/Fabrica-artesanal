
/**
 * visualizacion de los trabajos a realizar, actualizacion del estado del mueble
 * introduciendo la referencia del mismo y ademas define que el contrato sera fijo.
 * 
 * 
 * @author oscar rico martinez
 * @version 1.0
 */
import java.time.LocalDate;

public class ArtesanoPlantilla extends Artesano
{
    // instance variables - replace the example below with your own
    
    /**
     * Constructor de la clase ArtesanoPlantilla
     * @param nombre del artesano
     * @param sueldo del artesano
     */
    public ArtesanoPlantilla(String nombre, int sueldo)
    {
        // initialise instance variables
        super(nombre,sueldo);
        setTipoContrato("fijo");
        
    }
    
    
    public String toString()
    {
        return "ID: " + getId() +  " Puesto " + getPuesto() + " Contrato " + getTipoContrato() + " Sueldo: " + getSueldo() + " Nombre: " + getNombre();
    }
    
    
}
