
/**
 * Clase que define una silla de cocina
 * 
 * @author Oscar Rico Martinez 
 * @version 25/05/2020
 */
public class SillaCocina extends Silla
{
    // instance variables - replace the example below with your own
    //private String tipoSilla;

    /**
     * Constructor for objects of class SillaCocina
     */
    public SillaCocina(int idCliente, int cantidad, boolean reposaBrazos)
    {
        // initialise instance variables
        super(idCliente,cantidad,reposaBrazos);
        setTipoSilla("Silla cocina");
        setCantidad(cantidad);
    }
    
    public String toString()
    {
        return "*Tipo " +getTipoSilla() +" \nCantidad: " + getCantidad() + " reposabrazos: " +reposaBrazos() + "\n"; 
    }
}
