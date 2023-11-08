

import java.util.ArrayList;
import java.util.Iterator;

/**
 * La clase sistema contiene todos los ArrayList de la fabrica donde almacena
 * a los empleados, clientes, pedidos y los mensajes que el comercial envia.
 * 
 * @author Oscar Rico Martinez
 * @version 19/05/2020
 */


public class Sistema
{
    // instance variables - replace the example below with your own    
    private ArrayList <Mueble> arrayPedido= new ArrayList();
    private ArrayList <Empleado> arrayEmpleado= new ArrayList<>();
    private ArrayList <Cliente> arrayCliente= new ArrayList();
    private ArrayList <Notificacion> arrayNotificacion= new ArrayList<>();
    
    /**
     * Constructor for objects of class Timer
     */
    public Sistema()
    {
        // initialise instance variables
        
        
    }
    
    /**
     * obtiene por parametro el id del cliente que desea ver los pedidos y
     * devuelve un arrayList con unicamente los pedidos del cliente que lo solcita
     * @return ArrayList<Mueble> devuelve todos los pedidos realizados por un cliente.
     */
    public ArrayList<Mueble> listarPedido(int id)
    {
        ArrayList<Mueble> mueble= new ArrayList();
       for(Mueble pedido: arrayPedido) {
             if(pedido.getIdCliente() == id) {
                mueble.add(pedido);
            }
        }
        return mueble;
    }
    
    /**
     * Devuelve un arrayList con todos los Artesanos de la fabrica
     * @return ArrayLis<Empleado>
     */
    public ArrayList<Empleado> arrayArtesano()
    {
        ArrayList<Empleado> trabajador=new ArrayList();
        for(Empleado empleado: arrayEmpleado) {
            if("Artesano".equalsIgnoreCase(empleado.getPuesto())) {
                trabajador.add(empleado);
            }
        }
        return trabajador;
    }
    
    
    /**
     * Borra mensajes del arrayList notificacion
     */
    public void borraMensaje(Notificacion mensaje)
    {
        arrayNotificacion.remove(mensaje);
    }
    
    /**
     * Se pasa por parametro el id del cliente que accede a visualizar mensajes
     * y recibe un arrayList con todos los mensajes del cliente
     */
    public ArrayList<Notificacion> notifica(int idCliente)
    {
        ArrayList<Notificacion> notifica= new ArrayList();
        
        for(Notificacion mensaje: arrayNotificacion) {
            
            if(mensaje.getReceptor() == idCliente) {
                notifica.add(mensaje);
            }
        }
        
        return notifica;
    }
    
    /**
     * Se pasa el id de un cliente y comprueba que existe
     * @return si el cliente existe
     */
    public boolean existeCliente(int id)
    {   
        boolean flag=false;
        for(Cliente cliente: arrayCliente) {
            if(cliente.getIdCliente() == id) {
                flag=true;
            }
        }
        return flag;
    }
    
    /**
     * recibe el nombre y el id del cliente y lo borra del ArrayLisrt
     * @return si la operacion ha tenido exito.
     */
    public boolean removeArrayCliente(String nombre,int id)
    {
        boolean flag=false;
        for(Cliente cliente: arrayCliente) {
            if(nombre.equalsIgnoreCase(cliente.getNombre()) && (cliente.getIdCliente() == id)) {
                arrayCliente.remove(cliente);
                flag=true;
            }
        }
        return flag;
    }
    
    /**
     * Añade un pedido al arrayList
     */
    public void addArrayPedido(Mueble pedido)
    {
        arrayPedido.add(pedido);
    }
    
    /**
     * Devuelve el arrayList de pedidos
     * @return ArrayList<Mueble>
     */
    public ArrayList<Mueble> arrayPedido()
    {
        return arrayPedido;
    }
    
    /**
     * Añade un cliente al arrayList
     * 
     */
    public void addArrayCliente(Cliente cliente)
    {
        arrayCliente.add(cliente);
    }
    
    
    /**
     * Devuelve el ArrayList<Cliente>
     * @return arrayCliente
     */
    public ArrayList<Cliente> cliente()
    {
        return arrayCliente;
    }
    
    /**
     * Elimina una cuenta mal introducida
     */
    public void limparRegistros()
    {   
        Iterator<Cliente> it= arrayCliente.iterator();
        while(it.hasNext()) {
            if(it.next().getNombre() == null) {
                it.remove();
            }
        }
        
    }
    
    /**
     * Devuelve el arrayList de mensajes
     * @return arrayNotificacion
     */
    public ArrayList notificacion()
    {
        return arrayNotificacion;
    }
    
    /**
     * Devuelve el arrayList de empleados
     * @return arrayEmpleado
     */
    public ArrayList<Empleado> empleado()
    {
        return arrayEmpleado;
    }
    
    /**
     * Elimina una asignacion a un artesano cuando el artesano que realizaba el pedido
     * es dado de baja en la empresa
     */
    public void borrarAsignacionArtesano(int id)
    {
            for(Mueble mueble: arrayPedido) {
            if(mueble.estado.getIdArtesano() == id) {
                mueble.estado.setAsignado(false);
                mueble.estado.setIdReg(0);
                mueble.estado.setIdArtesano(0);
            }
        }
    }
    
    /**
     * Añade a un empleado al ArrayList
     */
    public void addEmpleado(Empleado empleado)
    {
        arrayEmpleado.add(empleado);
    }
    

}
