
/**
 * Write a description of class SillaPlegable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SillaPlegable extends Silla
{
    // instance variables - replace the example below with your own


    /**
     * Constructor for objects of class SillaPlegable
     */
    public SillaPlegable(int idCliente, int cantidad, boolean reposaBrazos)
    {
        // initialise instance variables
        super(idCliente,cantidad,reposaBrazos);
        setTipoSilla("Silla plegable");
    }
    
    public String toString()
    {
        return "*Tipo" +getTipoSilla() +" \nCantidad: " + getCantidad() + " reposabrazos: " + reposaBrazos() + "\n"; 
    }
}
