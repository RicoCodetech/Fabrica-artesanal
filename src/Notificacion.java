
/**
 * Esta clase es la encargada de generar el mensaje que el comecial
 * enviara a un determinado cliente para notificar el estado del pedido
 * 
 * @author Oscar Rico Martinez
 * @version 20/05/2020
 */
public class Notificacion
{
    // instance variables - replace the example below with your own
    String de;
    int receptor;
    String asunto;
    String mensaje;
    
    /**
     * Constructor de la clase Notificacion
     * @param receptor El id del distinatario
     * @param asunto El motivo del mensaje
     * @param  mensaje El texto explicativo
     */
    public Notificacion(int receptor, String asunto, String mensaje)
    {
        // initialise instance variables
        de="Comercial";
        this.receptor=receptor;
        this.asunto=asunto;
        this.mensaje=mensaje;
    }
    
    /**
     * devuelve el id del receptor
     */
    public int getReceptor()
    {
        return receptor;
    }
    
    public String toString()
    {
        return "*-----------------------------Mensaje----------------------------*\n"+
               "Mensaje de: " +de+ 
               "\nPara cliente con id: " + receptor + 
               "\nAsunto: " + asunto + 
               "\nMensaje:\n" + mensaje +
               "\n*----------------------------------------------------------------*\n"; 
    }

}
