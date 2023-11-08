
/**
 * Clase abstracta que sirve para especificar el tipo de mesa.
 * 
 * @author Oscar Rico Martinez 
 * @version 25/05/2020
 */
public abstract class MesaCafe extends Mesa
{
    // instance variables - replace the example below with your own
    private String opcionCristal;

    /**
     * Constructor for objects of class MesaCafe
     */
    public MesaCafe(int idCliente, int alturaCm, int largoCm, int anchoCm, int cantidad)
    {
        // initialise instance variables
        super(idCliente,alturaCm, largoCm, anchoCm, cantidad);
        
        
    }
    
   /**
    * Define si la mesa es de cristal
    */
   public void setOptionCristal(String opcionCristal)
   {    
       this.opcionCristal=opcionCristal;
   }
   
   /**
    * Devuelve si la mesa contiene cristal
    */
   public String getOptionCristal()
   {
       return opcionCristal;
   }
   
   /**
    * Devuelve el tipo de mueble
    */
   public String getMesa(){
       return "mesa de cafe";
    }
   
   public String toString()
   {
       return "\n #Unidades: " +getCantidad()+ "\n #Mueble: " +getMesa();
   } 
   
}
