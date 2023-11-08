
/**
 * Proporciana mensajes que se repiten en toda la ejecucion del programa.
 * 
 * @author Oscar Rico
 * @version 19/05/2020
 */
public class MensajesSystema
{

    /**
     * Mensaje que confirma el registro exitoso del cliente en el sistema.
     */
    public String registroCompleto()
    {
        return "** El registro se ha completado con exito, gracias. **";
    }
    
    public void prueba()
    {
        System.out.println("");
    }
    
    /**
     * Mensaje que da la bienvenida al programa
     */
    public void bienvenida()
    {
         System.out.println("           [**LA FABRICA DE MUEBLES**]\n");
         
    }    
    
    /**
     * Mensaje de cierre del programa.
     */
    public String adios()
    {
        return "[**Gracias, hasta pronto**]";
    }
    
    public void pedidoRealizado()
    {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("| Nuestro comercial le notificara del precio y podra confirmar el pedido|");
        System.out.println("| desde la seccion \"Confirmar presupuesto\".                           |");
        System.out.println("| Gracias.                                                              |");
        System.out.println("-------------------------------------------------------------------------");
    }
}
