
/**
 *Permite limpiar la pantalla.
 * 
 * @author Internet
 * 
 */
public class LimpiarConsola
{
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class LimpiarConsola
     */
    public LimpiarConsola()
    {
        // initialise instance variables
       
    }

    /**
     * 
     */
    public void limpiarConsola()
    {
        // put your code here
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            
        }
    }
}
