
/**
 * Clase padre y abstracta
 * 
 * El proposito de la clase mueble es definir de manera generalizada el 
 * comportamiento base que ha de tener un mueble como pedido de compra
 * de un cliente.
 * 
 * Para asignar una referencia a cada pedido se ha creado una variable
 * que es de tipo static, hay que tener en cuent que la referencia se asocia al pedido
 * y no al mueble, un pedido puede contener una cantidad x de muebles del mismo
 * tipo, pero contara con una unica referencia.
 * 
 * @author Oscar Rico Martinez 
 * @version 10/05/2020
 */

public abstract class Mueble 
{

    private static int refSiguiente=0;  // RefSiguiente es la referencia del mueble y se incrementa en cada pedido
    private int precio;                 // El precio de cada pedido lo asigna el comercial
    private int cantidad;               // Cantidad de muebles del mismo tipo
    private int idCliente;              // el id del cliente que compra el mueble
    private int referencia;
    
    Estado estado;

    /**
     * Constructor for objects of class Mueble
     * El constructor asigna una referencia al pedido y se asocia con el id del cliente.
     */
    public Mueble(int idCliente)
    {
        refSiguiente++;
        referencia=refSiguiente;
        this.idCliente=idCliente;
        estado=new Estado();
    }
    
    
    /**
     * 
     * Metodo que recibe como parametro el precio para asignarlo al mueble
     * @param precio El precio del mueble
     */
    public void setPrecio(int precio)
    {
        this.precio=precio;
    }
    
    /**
     * Metodo que devuelve el precio del mueble
     * @return precio El precio del mueble
     */
    public int getPrecio()
    {
        return precio;
    }
    
    /**
     * Metodo que recibe como argumento la cantidad de muebles de un mismo tipo
     */
    public void setCantidad(int cantidad)
    {
        this.cantidad=cantidad;
    }
    
    /**
     * Metodo que devuelve la cantidad de muebles del mismo tipo
     */
    public int getCantidad()
    {
        return cantidad;
    }

    /**
     * Metodo que devuelve la referencia del mueble pedido
     */
    public int getRef()
    {
        return refSiguiente;
    }
    
    public int referencia()
    {
        return referencia;
    }
    
    /**
     * Metodo que asocia al cliente con el pedido
     */
    public void setIdCliente(int idCliente)
    {
        this.idCliente=idCliente;
    }
    
    /**
     * Metodo que devulve el id cliente
     */
    public int getIdCliente()
    {
        return idCliente;
    }
    
    public String toString()
    {
        return "Cantidad: " +getCantidad();
    }
   
}
