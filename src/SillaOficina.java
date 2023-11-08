
/**
 * Write a description of class SillaOficina here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class SillaOficina extends Silla
{
    // instance variables - replace the example below with your own
    
    /**
     * Constructor for objects of class SillaOficina
     */
    public SillaOficina(int idCliente, int cantidad, boolean reposaBrazos)
    {
        // initialise instance variables
        super(idCliente,cantidad,reposaBrazos);
        setTipoSilla("Silla Oficina");
    }
    
    public abstract String ruedas();

}
