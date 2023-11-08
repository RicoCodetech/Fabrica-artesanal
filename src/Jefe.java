 
/**
 * Gestiona la contratacion de nuevos empleados, asigna pedidos a los artesanos, comprueba el estado de los pedidos
 * gestiona el historial de empleados visualizando el historial de trabajos que cada artesano a realizado y el
 * numero de pedidos que tiene asignado cada artesano, gestiona la cartera de clientes y tiene el control absoluto
 * de la plantilla de empleados.
 * 
 * @author Oscar Rico Martinez 
 * @version 19/05/2020
 */
import java.util.*;
import java.util.ArrayList;
public class Jefe extends Empleado 
{
    // instance variables - replace the example below with your own
    //ArrayList <Integer> pedidos=new ArrayList();
    ObtenerDato datos=new ObtenerDato();
    //Plantilla plantilla;
    /**
     * Constructor de la clase jefe
     * @param nombre Del jefe
     * @param sueldo Del jefe
     */
    public Jefe(String nombre, int sueldo)
    {
        // initialise instance variables
        super(nombre, sueldo);
        setPuesto("Jefe");
    }
    
    
    /**
     * Instancia a un Artesano con contrato fijo
     * @param nombre Del artesano
     * @param sueldo Del artesano
     * @return artesanoPlantilla
     */
    public void contratarArtesanoFijo(String nombre, int sueldo, ArrayList<Empleado> arrayEmpleado)
    {
        arrayEmpleado.add(new ArtesanoPlantilla(nombre, sueldo));
    }
    
    /**
     * Instancia a un Artesano con contrato temporal
     * @param nombre Del artesano
     * @param sueldo Del artesano
     * @return artesanoTemporal
     */
    public void contratarArtesanoTemporal(String nombre, int sueldo, ArrayList<Empleado> arrayEmpleado)
    {
        arrayEmpleado.add(new ArtesanoTemporal(nombre, sueldo));
    }   
    
    /**
     * Instancia a un Comercial
     * @param nombre Del comercial
     * @param sueldo Del comercial
     * @return comercial
     */
    public void contratarComercial(String nombre, int sueldo, ArrayList<Empleado> arrayEmpleado)
    {
        arrayEmpleado.add(new Comercial(nombre, sueldo));
    } 
    
    /**
     * Instancia a un Jefe
     * @param nombre Del jefe
     * @param sueldo Del jefe
     * @return jefe
     */
    public void contratarJefe(String nombre, int sueldo, ArrayList<Empleado> arrayEmpleado)
    {
        arrayEmpleado.add(new Jefe(nombre, sueldo));
    } 
    
    /**
     * Recibe el id de un empleado y lo elimina del ArrayList
     * @param id define el id del empleado 
     */
    public void despedirEmpleado(int id, ArrayList<Empleado> arrayEmpleado)
    {
        
        Iterator <Empleado> it= arrayEmpleado.iterator();
        while(it.hasNext()) {
            if(it.next().getId() == id) {
                it.remove();
                System.out.println("La operacion a tenido exito.");
            } 
        }
        
    }
    
    /**
     * imprime la lista de empleados
     */
    public void listarPlantilla(ArrayList<Empleado> arrayEmpleado)
    {   
        for(Empleado empleado: arrayEmpleado) {
            System.out.println(empleado);
        }
    }
    
    private void listarArtesanos(ArrayList<Empleado> arrayEmpleado)
    {
        for(Empleado empleado: arrayEmpleado) {
            if(empleado.getPuesto().equalsIgnoreCase("Artesano")) {
                Artesano artesano=(Artesano)empleado;
                System.out.println("ID: " + artesano.getId() + ". Trabajos: " + artesano.getNumPedidos() + ". Nombre: " + artesano.getNombre());
            }
        }
    }
    
    /**
     * Asigna un pedido a un artesano
     */
    public void GestionPedidos(ArrayList<Empleado> arrayEmpleado, ArrayList<Mueble> arrayPedido)
    {
        boolean confirma=false; //confirma que hay pedidos por confirmar
        
        for(Mueble mueble: arrayPedido) {   
            
            if(mueble.estado.getAprobado() && !mueble.estado.getAsignado()) {
                confirma=true;
                
                System.out.println("Pedido sin asignar con referencia: " + mueble.referencia() + "\n" + mueble);
                System.out.println("Lista de Artesanos:");
                
                listarArtesanos(arrayEmpleado); //llama al metodo privado para listar artesanos.

                System.out.println("\nAsignar pedido a empleado con id: ");
                int id=datos.pideId();
               
                boolean flag=false;
                for(Empleado empleado: arrayEmpleado) {
                    if(id == empleado.getId()) {
                        flag=true;
                        Artesano artesano=(Artesano)empleado;
                        artesano.setNumPedidos();
                        mueble.estado.setIdArtesano(id); //se asocia el id del empleado al estado del mueble
                        mueble.estado.setIdReg(id);      //la asociacion quedara registrada incluso despues de que el artesano termine el trabajo
                        mueble.estado.setAsignado(true);
                    }
                }
                
                if(!flag) {
                    System.out.println("No hay Artesano con ese ID.");
                }
            }
                
        }
        
        if(!confirma) {
            System.out.println("No hay nuevos pedidos confirmados.");
            
        }
        
    }
    
    /**
     * Lista los pedidos y el estado de cada uno
     */
    public void estadoPedidos(ArrayList<Mueble> arrayPedido)
    {
        boolean flag=false;
        for(Mueble mueble: arrayPedido) {
            if(mueble.estado.getAsignado()) {
                System.out.println("Progreso: "+ mueble.estado+". Asignado a artesano con ID: " + mueble.estado.getIdReg() +"\n"+ mueble);
                flag=true;
            }
        }
        if(!flag) {
            System.out.println("No hay pedidos.");
        }
    }
   
    /**
     * Imprime la lista de clientes
     */
    public void listarClientes(ArrayList<Cliente> arrayCliente)
    {
        if(arrayCliente.size() == 0) {
            System.out.println("No hay clientes");
        }
        else {
            for(Cliente cliente: arrayCliente) {
                System.out.println(cliente);
            }
        }
    }
    
    /**
     * Imprime la lista de artesanos con trabajos totales y trabajos activos
     */
    public void historialArtesanos(ArrayList<Empleado> arrayEmpleados)
    {   
        boolean flag=false;
        for(Empleado empleado: arrayEmpleados) {
            if("Artesano".equals(empleado.getPuesto())) {
                Artesano artesano=(Artesano)empleado;
                System.out.println(artesano.historial());
                flag=true;
            }
        } 
        if(!flag) {
            System.out.println("No hay Artesanos contratados.");
        }
    }
    
    public String toString()
    {
        return "ID: " + getId() + " Puesto " + getPuesto() + " Sueldo: " + getSueldo() + " Nombre: " + getNombre();
    }
   
}
