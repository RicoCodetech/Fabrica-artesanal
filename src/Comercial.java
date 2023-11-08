
/**
 * Realiza presupuestos de muebles, consulta los pedidos que un artesano a completado
 * y envia mensajes a los clientes para notificar el estado del pedido.
 * 
 * 
 * @author Oscar Rico Martinez 
 * @version 19/05/2020
 */
import java.util.*;
public class Comercial extends Empleado
{
    // instance variables - replace the example below with your ow
    private ObtenerDato datos;
    private final int sinPrecio;
    private LimpiarConsola limpiar;
    private PulsaIntroContinue pulsaIntro;
    /**
     * Constructor de la clase Comercial
     * @param nombre Del Comercial
     * @param sueldo Del Comercial
     */
    public Comercial(String nombre, int sueldo)
    {
        // initialise instance variables  
        super(nombre,sueldo);
        limpiar= new LimpiarConsola();
        pulsaIntro= new PulsaIntroContinue();
        datos= new ObtenerDato();
        //pulsaIntro= new PulsaIntroContinue();
        sinPrecio=0;
        setPuesto("Comercial");
    }
    
    /**
     * Define el presupuesto de todos los pedidos que no tienen precio
     */
    public void presupuesto(ArrayList<Mueble> arrayPedido)
    {   
        int contador=0;
        for(Mueble mueble: arrayPedido) {
            if(mueble.getPrecio() == sinPrecio) {
                contador++;
                System.out.println("Presupuesto pendiente[" + contador + "]\n" + mueble);
                mueble.setPrecio(datos.precio());
                System.out.println("Presupuesto enviado al cliente.");
                pulsaIntro.intro();
            }
        }
        if(contador == 0) {
            System.out.println("No quedan pedidos...");
        }
    }
    
    
    /**
     * lista los pedidos que han sido actualizados con el estado Completado
     */
    public void verPedidoCompletado(ArrayList<Mueble> arrayPedido)
    {
        boolean flag=false;
        for(Mueble mueble: arrayPedido) {
            if(mueble.estado.getFinalizado()) {
                System.out.println("Pedido completado con referencia nº: "+ mueble.referencia() + " del cliente con ID: [" + mueble.getIdCliente() + "]\n");
                flag=true;
            }
        }

        if(!flag) {
            System.out.println("No hay nuevos pedidos completados.");
        }
    }
    
    /**
     * Envia un mensaje a un cliente
     * @param id Define el id del cliente
     * @param asunto Del mensaje
     * @param mensaje Para el cliente
     */
    public Notificacion envioMensaje(int id, String asunto, String mensaje)
    {
        Notificacion notifica= new Notificacion(id,asunto,mensaje);
        return notifica;
    }
       
    
    @Override
    public String toString()
    {
        return "ID: " + getId() + " Puesto " + getPuesto() + " Sueldo: " + getSueldo() + " Nombre: " + getNombre();
    }
  
}
