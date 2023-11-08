
/**
 * Clase que tiene las caracteristicas de una mesa de cafe con cristal
 * 
 * @author Oscar Rico Martinez 
 * @version 25/05/2020
 */
public class MesaCafeCristal extends MesaCafe
{
    // instance variables - replace the example below with your own
     
    
    /**
     * Constructor for objects of class MesaCafeCristal
     */
    public MesaCafeCristal(int idCliente, int alturaCm, int largoCm, int anchoCm, int cantidad)
    {
        // initialise instance variables
        super(idCliente, alturaCm, largoCm, anchoCm, cantidad);
        setOptionCristal("cristal");
        
    }
    
    public String toString()
    {
         return "*Tipo Mueble: " +getMesa()+ " " +getOptionCristal()+
                "\n\tCantidad: " +getCantidad()+
                "\n\tAltura: " +getAltura()+"Cm," + " Largo: " +getLargo()+"Cm," + " Ancho: " +getAncho()+"Cm.\n";
    }

}
