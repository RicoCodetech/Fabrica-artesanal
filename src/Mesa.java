
/**
 * Clase abstracta que define las caracteristica generales de una mesa.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Mesa extends Mueble
{
    // instance variables - replace the example below with your own
    private int alturaCm;
    private int largoCm;
    private int anchoCm;
    
    /**
     * Constructor for objects of class Mesa
     */
    public Mesa(int idCliente, int alturaCm, int largoCm, int anchoCm, int cantidad)
    {
        // initialise instance variables
        super(idCliente);
        this.alturaCm=alturaCm;
        this.largoCm=largoCm;
        this.anchoCm=anchoCm;
        setCantidad(cantidad);
        
    }
    
    /**
     * Devuelve la altura en centimetros
     */
    public int getAltura()
    {
        return alturaCm;
    }
    
    /**
     * Devuelve el largo en centimetros
     */
    public int getLargo()
    {
        return largoCm;
    }
    
    /**
     * Devuelve el ancho en centimetros
     */
    public int getAncho()
    {
        return anchoCm;
    }
    
    /**
     * Devuelve el tipo de mueble
     */
    public String getMesa()
    {
        return "mesa";
    }
    
    public String toString()
    {
        return "\n #Unidades: " +getCantidad()+ "\n #Mueble: " +getMesa();
    }
    
    //public abstract String infoMesa();
    

    
}
