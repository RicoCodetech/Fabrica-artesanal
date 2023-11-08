
/**
 * Clase que define una silla de oficina sin ruedas.
 * 
 * @author Oscar Rico Martinez 
 * @version 25/05/2020
 */
public class SillaSinRuedas extends SillaOficina
{
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class SillaSinRuedas
     */
    public SillaSinRuedas(int idCliente, int cantidad, boolean reposaBrazos)
    {
        // initialise instance variables
        super(idCliente, cantidad, reposaBrazos);
    }
    
    /**
     * Devuelve silla sin ruedas
     */
    public String ruedas()
    {
        return "sin ruedas"; 
    }
    
    public String toString()
    {
        return "*Tipo" +getTipoSilla() + " " + ruedas() + " \nCantidad: " + getCantidad() + " reposabrazos: " +reposaBrazos() + "\n"; 
    }
}