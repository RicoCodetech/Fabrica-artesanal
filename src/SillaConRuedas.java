
/**
 * Write a description of class SillaSiRuedas here.
 * 
 * @author Oscar Rico Martinez 
 * @version 25/05/2020
 */
public class SillaConRuedas extends SillaOficina
{
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class SillaSiRuedas
     */
    public SillaConRuedas(int idCliente,int cantidad, boolean reposaBrazos)
    {
        // initialise instance variables
        super(idCliente, cantidad, reposaBrazos);
    }
    
    /**
     * devuelve silla con ruedas 
     */
    public String ruedas()
    {
        return "con ruedas";
    }
    
    
    public String toString()
    {
        return "*Tipo " +getTipoSilla() + " " + ruedas() + " \nCantidad: " + getCantidad() + " reposabrazos: " +reposaBrazos() + "\n"; 
    }
}
