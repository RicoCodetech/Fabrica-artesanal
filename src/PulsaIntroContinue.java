
/**
 * Permite hacer interrupciones en el programa.
 * 
 * @author Internet 
 * @version 19/05/2020
 */
import java.util.*;
public class PulsaIntroContinue
{
    public PulsaIntroContinue()
    {
        
    }
    // instance variables - replace the example below with your own
    public void intro()
    {
        String seguir;
        Scanner entrada = new Scanner(System.in);
        System.out.println("\nPulsa intro para continuar...");
        try {
            seguir = entrada.nextLine();
        }
        catch(Exception e)
        {}
    }
}
