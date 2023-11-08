
/**
 * un cliente tiene acceso a su cuenta, realiza pedidos de los diferentes muebles,  acceso a los pedidos realizados, confirma
 * el presupuesto que previamente un comercial a asignado y recibe mensajes del comercial.
 * 
 * @author Oscar Rico Martinez 
 * @version 19/05/2020
 */
import java.util.*;

public abstract class Cliente extends Persona
{
    // instance variables - replace the example below with your own
    private static int idClienteSiguiente=1;
    private int idCliente;
    private int totalPedidos;
    private Scanner entrada=new Scanner(System.in);
    private ObtenerDato datos;

    /**
     * Constructor de la clase Cliente
     */
    public Cliente(String nombre)
    {   
        // initialise instance variables
        super(nombre);
        datos= new ObtenerDato(); 
        idCliente=idClienteSiguiente;
        idClienteSiguiente++;  
    }
    
    
    /**
     * Devuelve id del cliente
     * @return idCliente El identificador del cliente
     */
    public int getIdCliente()
    {
        return idCliente;
    }
    
    public void setTotalPedidos(int total)
    {
        totalPedidos=total;
    }
    
    /**
     * Suma un pedido al historial de pedidos de un cliente
     */
    public void setTotalPedidos()
    {
        totalPedidos++;
    }
    
    /**
     * Devuelve el historial total de pedidos
     * 
     * @return totalPedidos El total de pedidos realizados por el cliente
     */
    public int getTotalPedidos()
    {
        return totalPedidos;
    }
    
    public void confirmaPresupuesto(ArrayList<Mueble> confirma)
    {   
        boolean flag=false;
        if(confirma.size() == 0) {
            System.out.println("No hay operaciones pendientes.");
        }
        
        for(Mueble pedido: confirma) {
            if((pedido.getIdCliente() == getIdCliente()) && (pedido.getPrecio() > 0) && (!pedido.estado.getAprobado())) {
                System.out.println(pedido);
                flag=true;
                if(confirmaPedido(pedido.getPrecio())) {
                    pedido.estado.setAprobado(true);
                }
                else {
                    confirma.remove(pedido);
                }
            }
        }
       
    }
    
    
    private boolean confirmaPedido(int precio)
    {
        System.out.println("PRECIO: " + precio +"€");
        System.out.println("1) Confirmar pedido.");
        System.out.println("2) Eliminar pedido");
        
        byte opcion=datos.option();
        
        if(opcion == 1) {
            return true;
        }
        return false;
    }
    
    
    
    /**
     * Lista todos los pedidos del cliente
     */
    public void listarPedidos(ArrayList<Mueble> mueble)
    {   
        boolean flag=false;
        
        for(Mueble pedido: mueble) {
            System.out.println(pedido);
            flag=true;
        }
        
        if(!flag) {
            System.out.println("Usted no a realizado ningun pedido.");
        }
    }
    
    
    public void mensajeBuzon(ArrayList<Notificacion> notifica)
    {
        if(notifica!=null) {
            for(Notificacion mensaje: notifica) {
                System.out.println(mensaje);
            }
        }
        else {
            System.out.println("No tiene mensajes nuevos.");
        }
    }
    

    
    public String toString()
    {
        return "Nombre: " + getNombre();
    }
    
    public abstract String getTipoCuenta();
}
