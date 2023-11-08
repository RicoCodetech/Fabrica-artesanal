
/**
 * un cliente tiene acceso a su cuenta, realiza pedidos de los diferentes muebles,  acceso a los pedidos realizados, confirma
 * el presupuesto que previamente un comercial a asignado, recibe mensajes del comercial y se define como un cliente ciudadano.
 * 
 * @author Oscar Rico Martinez 
 * @version 19/05/2020
 */
public class Ciudadano extends Cliente
{
    // instance variables - replace the example below with your own
    
    private String tipoCuenta;
    
    /**
     * Constructor for objects of class Ciudadano
     */
    public Ciudadano(String nombre)
    {
        // initialise instance variables
        super(nombre);
        tipoCuenta="Ciudadano";
    }
    
    public Ciudadano(String nombre, int totalPedidos)
    {
        // initialise instance variables
        super(nombre);
        tipoCuenta="Ciudadano";
        setTotalPedidos(totalPedidos);
    }
    
    /**
     * Devuelve el tipo de cuenta
     * return tipoCuenta El tipo cuenta ciudadano/empresa
     */
    public String getTipoCuenta()
    {
        return tipoCuenta;
    }

    public String toString()
    {
        return "ID: " + getIdCliente() + " Historial pedidos: " + getTotalPedidos() + " Tipo cuenta: " + getTipoCuenta() + " Nombre: " + getNombre();
          
    }
}
