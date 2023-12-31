
/**
 * Clase que da informacion util sobre la practica
 * 
 * @author Oscar Rico Martinez 
 * @version 26/05/2020
 */
public class Ayuda
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Ayuda
     */
    public Ayuda()
    {
        // initialise instance variables

    }
    
    /**
     * Ayuda para la seccion del Comercial
     */
    public void ayudaEmpleadoComercial()
    {
        System.out.println(".:AYUDA SOLICITADA:.");
        
        System.out.println("\n-¿Como envio un mensaje a un cliente? ");
        System.out.println(" Necesita el ID del cliente, por ejemplo, ID:1 de Angela, para enviar\n"
                         + " un mensaje, primero consulte pedidos completados, y obtendrá   la información "
                         + "\n del pedido completado con el ID del cliente que ha realizado el pedido.");
    }
    
    /**
     * Ayuda para la seccion contratos del jefe
     */
    public void ayudaEmpleadoJefeContratos()
    {
        System.out.println(".:AYUDA SOLICITADA:.");
        
        System.out.println("\n-¿Que sucede si despido a un artesano y dicho artesano ya tenia un pedido asignado?");
        System.out.println(" En ese caso el pedido de dicho artesano cambia al estado \"no asignado\" y debera\n ser asignado de nuevo en el correspondiente apartado.");
        System.out.println("\n-¿Como despido a un empleado?");
        System.out.println(" Solo necesita introducir el ID del empleado.");
    }
    
    /**
     * Ayuda para la seccion del jefe
     */
    public void ayudaEmpleadoJefe()
    {
        System.out.println(".:AYUDA SOLICITADA:.");
        
        System.out.println("\n-¿Como asigno un pedido a un artesano?");
        System.out.println(" Sección , asignar pedido, obtiene una lista de artesanos con sus respectivos ID y\n"
                         + " con el número   de trabajos activos de cada artesano, para cada pedido se le" 
                         + "\n solicitara que introduzca el ID del artesano.");
        System.out.println("\n-¿Por qué no visualizo ningún pedido en la sección  \"Asignar pedido\"?");
        System.out.println(" 1-.Puede ocurrir que el cliente no haya confirmado el presupuesto");
        System.out.println(" 2-.Puede que el pedido ya este asignado a un artesano, con lo cual, no"
                            +"\n es visible en dicho apartado");
        System.out.println("\n-¿Como accedo a la información  de la fábrica ?");
        System.out.println(" Apartado, Funcionamiento de la fábrica .");
        System.out.println(" 1) Visualiza el estado de todos los pedidos");
        System.out.println(" 2) Una lista con los artesanos el historial total de pedidos asignados y el\n    número de pedidos activos");
        System.out.println(" 3) Lista de los clientes con información ");
        System.out.println(" 4) Historial total de los muebles más  solicitados.");
    }
    
    /**
     * Ayuda para la seccion general del empleado
     */
    public void ayudaEmpleado()
    {
        System.out.println(".:AYUDA SOLICITADA:.");
        
        System.out.println("\n-¿Como accedo a la sección jefe ?");  
        System.out.println(" El acceso es automático , únicamente  es necesario que el jefe"+
                           " \n este en plantilla");
        System.out.println("\n-¿Como accedo a la sección  del Comercial");
        System.out.println(" El acceso es automático , únicamente es necesario que el Comercial"+
                           " \n este en plantilla");
        System.out.println("\n-¿Como accedo a la sección  del Artesano?");
        System.out.println(" Hay que introducir el ID del artesano, en la sección  jefe puede" +
                           " \n visualizar el ID de cada artesano.");
                           
    }
    
    /**
     * Ayuda para la cuenta del cliente
     */
    public void ayudaClienteCuenta()
    {
        System.out.println(".:AYUDA SOLICITADA:.");
        System.out.println("\n-¿Cuándo  recibo un presupuesto?");
        System.out.println(" El comercial asigna el presupuesto al pedido, Prueba a entrar en la seccion del comercial, apartado Realizar presupuesto.");
        System.out.println("\n-¿para qué  es la sección  mensajes?");
        System.out.println(" El comercial le enviara un mensaje cuando un pedido ha sido fabricado");
        System.out.println("\n-¿Como funciona el proceso de pedido?");
        System.out.println(" Se asocia el id del cliente al pedido, el comercial realiza el presupuesto, si el cliente acepta el presupuesto" +
                             "\n entonces el jefe asigna dicho pedido a un artesano, cuando el pedido ha finalizado, el comercial envía " +
                             "\n un mensaje al cliente.");
    }
    
    /**
     * Ayuda general para el cliente
     */
    public void ayudaCliente()
    {
        System.out.println(".:AYUDA SOLICITADA:.");
       
        System.out.println("\n-¿Como accedo a mi cuenta?");
        System.out.println(" Puede acceder poniendo el nombre de usuario, Prueba con: Angela o Oscar.");
        
        System.out.println("\n-¿Como eliminar mi cuenta?");
        System.out.println(" Introduzca su nombre y confirme con su ID");
        
        System.out.println("\n-¿Qué  diferencia existe entre cuenta estándar  y cuenta empresa?");
        System.out.println(" Tienen las mismas funcionalidades, únicamente  se definen como tal para estadísticas  de venta.");
    }
    
    /**
     * Ayuda general del programa
     */
    public void ayudaGeneral()
    {
        System.out.println("\n.: A Y U D A :.");
        System.out.println("\nIMPORTANTE: Tiene un asistente de ayuda con información que puede variar dependiendo de la\nsección  en la que solicite la ayuda. Se solicita pulsando la tecla numerica cero.");
        System.out.println("\nNota: la cuenta de Angela tiene dos pedidos realizados; el primer pedido tiene el presupuesto\nrealizado, falta confirmar presupuesto y que que el jefe lo asigne a un artesano, sin embargo, el\notro pedido esta esperando que el comercial realice el presupuesto.");
        System.out.println("\nAccesos a cuenta:");
        System.out.println("\tClientes:");
        System.out.println("\tAcceden a la cuenta con el nombre.\n");
        System.out.println("\tEmpleados:\n\tJefe:\n\tÚnicamente  es necesario que el jefe " + 
        "este en plantilla\n\n\tComercial:\n\tÚnicamente es necesario que el comercial este en plantilla" + 
        " \n\n\tArtesanos\n\tEl acceso se hace con ID");
    }
    
    /**
     * Ayuda para entender la situacion de la fabrica inicializada
     */
    private void ayudaDatos()
    {
        //System.out.println("\n.: A Y U D A :.");
        System.out.println("\n Datos de clientes:");
        System.out.println("\n Nombre usuario: Angela. Pedido: dos mesas de dormitorio.");
        System.out.println(" Falta aceptar un presupuesto y que el comercial realice el presupuesto del segundo mueble.");
        System.out.println("\n Nombre usuario: Oscar. Pedido: sin realizar.");
        System.out.println("\n Datos Artesanos:");
        System.out.println(" ID: 3. Pedido: esperando un trabajo,");
        System.out.println(" ID: 4. Pedido: esperando un trabajo.");
        System.out.println(" ID: 5. Pedido: esperando un trabajo.");
    }
    
    /**
     * Mensaje de ayuda
     */
    public void ayudaBasica()
    {
        System.out.println("\n.: A Y U D A :.");
        System.out.println("\n En este apartado no hay mucha informacion, \n mejor solicite la ayuda dentro de una de las areas.");
        ayudaDatos();
    }

}
