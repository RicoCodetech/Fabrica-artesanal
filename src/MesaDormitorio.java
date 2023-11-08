
/**
 * Mesa de dormitorio con cajones
 * 
 * @author Oscar Rico Martinez 
 * @version 25/05/2020
 */
public class MesaDormitorio extends Mesa
{
    // instance variables - replace the example below with your own
    private int numeroCajones;
    
    /**
     * Constructor for objects of class MesaDormitorio
     */
    public MesaDormitorio(int idCliente, int alturaCm, int largoCm, int anchoCm, int numeroCajones, int cantidad)
    {
        // initialise instance variables
        super(idCliente,alturaCm, largoCm, anchoCm, cantidad);
        this.numeroCajones=numeroCajones;
        
    }
    
    /**
     * Define el numero de cajones
     */
    public void setCajones(byte numeroCajones)
    {
        this.numeroCajones=numeroCajones;
    }
    
    /**
     * devuelve el numero de cajones
     */
    public int getCajones()
    {
        return numeroCajones;
    }
    
    public String toString()
    {
         return "*Tipo Mueble: Mesa Dormitorio"+
                "\n\tCantidad: " +getCantidad()+
                "\n\tAltura: " +getAltura()+"Cm," + " Largo: " +getLargo()+"Cm," + " Ancho: " +getAncho()+"Cm," + " Cajones: " +getCajones() + "\n";
  
    }
   
}
