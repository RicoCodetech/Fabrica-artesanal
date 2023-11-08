
/**
 * Esta clase tiene las caracteristicas de una mesa de cafe sin cristal
 * 
 * @author Oscar Rico Martinez 
 * @version 25/05/2020
 */
public class MesaCafeMadera extends MesaCafe
{
         
    /**
     * Constructor for objects of class MesaCafeMadera
     */
    public MesaCafeMadera(int idCliente, int alturaCm, int largoCm, int anchoCm, int cantidad)
    {
        // initialise instance variables
        super(idCliente, alturaCm, largoCm, anchoCm, cantidad);
        setOptionCristal("madera");
        
    }
    
    public String toString()
    {
        return "*Tipo Mueble: " +getMesa()+ " " +getOptionCristal()+
                "\n\tCantidad: " +getCantidad()+
                "\n\tAltura: " +getAltura()+"Cm," + " Largo: " +getLargo()+"Cm," + " Ancho: " +getAncho()+"Cm.\n";
    }
    
}
