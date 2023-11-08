
/**
 * un cliente tiene acceso a su cuenta, realiza pedidos de los diferentes muebles,  acceso a los pedidos realizados, confirma
 * el presupuesto que previamente un comercial a asignado, recibe mensajes del comercial y se define como un cliente empresa.
 * 
 * @author Oscar Rico Martinez 
 * @version 19/05/2020
 */
public class Empresa extends Cliente
{
    // instance variables - replace the example below with your own
    
    private String tipoCuenta;
    
    /**
     * Constructor for objects of class Empresa
     */
    public Empresa(String nombre)
    {
        // initialise instance variables
        super(nombre);
        tipoCuenta="Empresa";
    }
    
    /**
     * Devuelve el tipo de cueta
     */
    public String getTipoCuenta()
    
    {
        return tipoCuenta;
    }
    
    public String toString()
    {
        return "ID: " + getIdCliente() + " Tipo cuenta: " + getTipoCuenta() + " Nombre: " + getNombre();
    }

}
