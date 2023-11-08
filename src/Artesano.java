 /**
 * Clase abstracta Artesano, visualizacion de los trabajos a realizar, actualizacion del estado del mueble
 * introduciendo la referencia del mismo.
 * 
 * @author Oscar Rico Martinez 
 * @version 19/05/2020
 */

import java.util.ArrayList;
import java.util.*;

public abstract class Artesano extends Empleado
{
    // instance variables
    
    private String tipoContrato;    //Contrato temporal/fijo
    private int numPedidos;         //Cantidad de trabajos que tiene asignados.
    private int historialPedidos;
    
    /**
     * Constructor de la clase Artesano
     * @param nombre del artesano
     * @param sueldo del artesano
     */
    public Artesano(String nombre, int sueldo)
    {
        // initialise instance variables
        super(nombre,sueldo);
        setPuesto("Artesano");
        numPedidos=0;
        historialPedidos=0;
        tipoContrato=null;
    }
    
    public String historial()
    {
        return "ID " + getId() + " Trabajos activos: " + getNumPedidos() + " Trabajos totales: " + getHistorialPedidos() + " Nombre: " + getNombre();
    }
    
    /**
     * define el tipo de contrato 
     * @param tipoContrato establece el tipo de contrato
     */
    public void setTipoContrato(String tipoContrato)
    {
        this.tipoContrato=tipoContrato;
    }
    
    /**
     * Devuelve el tipo de contrato
     * 
     * @return String tipo de contrato
     */
    public String getTipoContrato()
    {
        return tipoContrato;
    }
    
    /**
     * Suma un pedido al historial y a pedidos activos
     */
    public void setNumPedidos()
    {
        numPedidos++;
        historialPedidos++;
    }  
   
    /**
     * Devuelve el numero de pedidos activos
     * 
     * @return numPedidos pedidos activos
     */
    public int getNumPedidos()
    {
        return numPedidos;
    }
    
    /**
     * Devuelve el numero de pedidos totales
     * 
     * @return historialPedidos pedidos totales
     * 
     */
    public int getHistorialPedidos()
    {
        return historialPedidos;
    }
    
    /**
     * Descuenta un pedido activo
     * 
     */
    private void descontarPedido()
    {
        numPedidos--;
    }
    
    /**
     * lista los trabajos asignados al artesano
     */
    public void verTrabajo(ArrayList<Mueble> mueble)
    {
        for(Mueble pedido: mueble) {
            if(pedido.estado.getIdArtesano() == getId()) {
                 System.out.println("Trabajo con referencia nº: ["+ pedido.referencia() + "] Estado actual: " + pedido.estado + "\n"+ pedido);
            }
        }
    }
    
    
    /**
     * Actualiza el estado del pedido en el estado Fabricando
     * @param referencia define la referencia del pedido a actualizar
     */
    public void actualizaEstadoFabricando(int referencia, ArrayList<Mueble >arrayPedido)
    {
        boolean flag=false;
        for(Mueble mueble: arrayPedido) {
            if(referencia == mueble.referencia()) {
                mueble.estado.setFabricando();
                flag=true;
                break;
            }
        }
        
        if(!flag) {
            System.out.println("Referencia no encontrada, contacte con el Jefe.");
        }
    }
    
    private Mueble buscaMueble(int referencia,ArrayList<Mueble >arrayPedido)
    {
        for(Mueble mueble: arrayPedido) {
            if(referencia == mueble.referencia()) {
                return mueble;
            }
        }
       return null;
    }
    
    /**
     * Actualiza el estado del pedido en el estado Incompleto
     * @param referencia define la referencia del pedido a actualizar
     */
    public void actualizaEstadoIncompleto(int referencia,ArrayList<Mueble> arrayPedido)
    {
        Mueble mueble=buscaMueble(referencia, arrayPedido);
        
        if(mueble == null) {
            System.out.println("Referencia no encontrada, contacte con el Jefe.");
        }
        else {
            mueble.estado.setIncompleto();
        }

    }
    
    /**
     * Actualiza el estado del pedido en el estado Completado
     * @param referencia define la referencia del pedido a actualizar
     */
    public void actualizaEstadoFinalizado(int referencia,ArrayList<Mueble> arrayPedido)
    {
        Mueble mueble=buscaMueble(referencia, arrayPedido);
        
        if(mueble == null) {
            System.out.println("Referencia no encontrada, contacte con el Jefe.");
        }
        else {
            mueble.estado.setFinalizado();
            mueble.estado.setIdArtesano(0);
            descontarPedido();
        }
    }
    
    

    public String toString()
    {
        return "ID: " + getId() +  " Puesto " + getPuesto() + " Sueldo: " + getSueldo() + " Nombre: " + getNombre();
    }
    

}
