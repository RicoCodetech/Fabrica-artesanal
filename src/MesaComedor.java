
/**
 * Mesa de comedor
 * 
 * @author Oscar Rico Martinez 
 * @version 25/05/2020
 */
public class MesaComedor extends Mesa
{
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class MesaComedor
     */
    public MesaComedor(int idCliente, int alturaCm, int largoCm, int anchoCm, int cantidad)
    {
        // initialise instance variables
        super(idCliente, alturaCm, largoCm, anchoCm, cantidad);
        
        
    }
    
     public String toString()
    {
         return "*Tipo Mueble: Mesa Comedor"+
                "\n\tCantidad: " +getCantidad()+
                "\n\tAltura: " +getAltura()+"Cm," + " Largo: " +getLargo()+"Cm," + " Ancho: " +getAncho()+"Cm."+ "\n";

    }
    
    
}
