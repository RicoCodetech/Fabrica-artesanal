
/**
 * Esta clase es la clase principal del sistema integrado de Gestion
 * de la fabrica artesanal de muebles. existen dos grandes apartados
 * 
 * por un lado el area del cliente donde se puede acceder a la cuenta
 * para realizar pedidos de muebles, recibir presupuestos y notificaciones
 * del departamento comercial de la fabrica.
 * por otro lado y dentro del area de empleados tenemos el menu del jefe 
 * desde donde se controlan todos los detalles de la fabrica, el 
 * comercial que realiza los presupuestos y notifica a los clientes sobre
 * el estado del mueble, por ultimo los artesanos que acuden al sistema 
 * para actualizar los datos de progreso de los muebles.
 * 
 * para inicializar el programa se ejecuta el main y se puede inicializar
 * la fabrica con clientes y pedidos ya en marcha y tambien se puede
 * inicializar la fabrica sin datos.
 * 
 * Los clientes acceden a la cuenta con el nombre.
 * el jefe y comercial no necesitan identificacion para entrar en sus secciones,
 * pero es necesario que esten en plantilla para poder operar.
 * los artesano acceden a la cuenta con el id.
 *
 *
 * @author Oscar Rico Martinez 
 * @version 1.0 (17/05/2020)
 */
//
import java.util.*;
public class Fabrica
{
    // instance variables - replace the example below with your own
    private Setup setup;
    private Ayuda ayuda;
    private Pedido pedido;                      //contiene los metodos para instanciar muebles
    private ObtenerDato datos;                  //Clase que pide los datos necesarios del programa            
    private MensajesSystema mensaje;            //mensajes del programa
    private LimpiarConsola limpiar;             //Contiene el metodo para limpiar pantalla
    private PulsaIntroContinue pulsaIntro;      //Contiene el metodo que pausa la ejecucion del programa
    private Sistema sistema;                                        

    /**
     * Constructor for objects of class CopyOfFabrica
     */
    public Fabrica()
    {
        // initialise instance variables
        setup= new Setup();
        ayuda= new Ayuda();
        datos= new ObtenerDato();
        pedido= new Pedido();
        mensaje= new MensajesSystema();
        limpiar= new LimpiarConsola();
        pulsaIntro= new PulsaIntroContinue(); 
        sistema= new Sistema();
    }
    
    
    public static void main(String [] args)
    {
        Fabrica fabrica;
        fabrica= new Fabrica();      
        
        byte option=0;               //Variable para todos los menus
       
        do{
            
            fabrica.limpiar.limpiarConsola();       //Limpia la pantalla
            fabrica.mensaje.bienvenida();           //Mensaje de bienvenida
            
            System.out.println("--------------------------------------------------");
            System.out.println("Inicio>");
            System.out.println("--------------------------------------------------");
            System.out.println(" ");
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - -  - -");
            System.out.println("1) Fabrica funcionando(Recomendado)");
            System.out.println("2) Fabrica sin datos. ");
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - -  - -\n");
            
            option=fabrica.datos.option();          //obtiene la opcion seleccionada
            
        }while( (option !=1 ) && (option != 2) );
        
        if(option == 1) {
            //Carga datos desde documento de texto
            fabrica.setup.addClientes(fabrica.sistema.cliente());               //Añade clientes
            fabrica.setup.addEmpleados(fabrica.sistema.empleado());             //añade empleados
            fabrica.setup.addPedidos(fabrica.sistema.arrayPedido());            //añade pedidos
            fabrica.setup.addClientesComprueba(fabrica.datos.arrayComprueba()); //añade nombre de clientes para no poder registrar ptra cuenta con el mismo nombre
            fabrica.pedido.sumaLosPedidosIniciales();                           //Suma los pedidos al historico
            fabrica.setup.organizandoPedidos(fabrica.sistema.arrayPedido());    //Inserta el precio a un pedido

            fabrica.ayuda.ayudaGeneral();
            fabrica.pulsaIntro.intro();

        }
        else {
            fabrica.ayuda.ayudaGeneral();
            fabrica.pulsaIntro.intro();
        }
        
        while(option != 3) {
            fabrica.limpiar.limpiarConsola();
            fabrica.mensaje.bienvenida();
            
            System.out.println("--------------------------------------------------");
            System.out.println("Menú>");
            System.out.println("--------------------------------------------------");
            System.out.println("0) Ayuda");
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - -  - -");
            System.out.println("1) Área  Cliente");
            System.out.println("2) Área  empleado");
            System.out.println("3) Salir");
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - -  - -");
            
            option=fabrica.datos.option();//pide y guarda la opcion deseada
            
            if(option == 3) {//Pide confirmacion para salir del programa
                fabrica.limpiar.limpiarConsola();
                fabrica.mensaje.bienvenida(); 
                option=fabrica.confirmaSalir(option);   
            }
            
            switch(option) {
                case 0:
                    fabrica.ayuda.ayudaBasica();
                    fabrica.pulsaIntro.intro();
                    break;
                case 1://Menu> Cliente>
                
                    do{
                        
                        fabrica.limpiar.limpiarConsola();
                        fabrica.mensaje.bienvenida();
                        
                        System.out.println("--------------------------------------------------");
                        System.out.println("Menú > Cliente>");
                        System.out.println("--------------------------------------------------");
                        System.out.println("0) Ayuda");
                        System.out.println("- - - - - - - - - - - - - - - - - - - - - - -  - -");
                        System.out.println("1) Acceder a cuenta");
                        System.out.println("2) Registrar cuenta estándar ");
                        System.out.println("3) Registrar cuenta empresa");
                        System.out.println("4) Eliminar cuenta");
                        System.out.println("5) Volver");
                        System.out.println("- - - - - - - - - - - - - - - - - - - - - - -  - -");
                        
                        option=fabrica.datos.option();                  //option obtiene la opcion seleccionada
                        
                        switch(option) {
                            case 0:
                                fabrica.ayuda.ayudaCliente();
                                fabrica.pulsaIntro.intro();
                                break;
                                
                            case 1://Acceder a cuenta                                     
                                int idCliente;                          //Obtiene el ID del cliente 
                                boolean clienteEncontrado=false;        //Señala que se ha encontrado o no el cliente.
                                
                                String nombre=fabrica.datos.nombre();   //Obtiene el nombre del cliente que quiere acceder a la cuenta
                                Cliente persona=null;
                                
                                for(Cliente cliente: fabrica.sistema.cliente()) {//Comprueba si existe el cliente
                                    if(nombre.equalsIgnoreCase(cliente.getNombre())) {
                                        persona=cliente;
                                        clienteEncontrado=true;
                                        break;
                                    }
                                }
                                
                                if(clienteEncontrado) {
                                    
                                    do{
                                        fabrica.limpiar.limpiarConsola();
                                        fabrica.mensaje.bienvenida();

                                        idCliente=persona.getIdCliente(); //obtiene el ID del cliente
                                        
                                        System.out.println("--------------------------------------------------");
                                        System.out.println("Menú > Cliente> "+ persona.getNombre() + " ID-" + persona.getIdCliente()+">");
                                        System.out.println("--------------------------------------------------");
                                        System.out.println("0) Ayuda");
                                        System.out.println("- - - - - - - - - - - - - - - - - - - - - - -  - -");
                                        System.out.println("1) Realizar Pedido                                ");                            
                                        System.out.println("2) Ver mis pedidos                                ");
                                        System.out.println("3) Confirmar presupuesto                          ");
                                        System.out.println("4) Mensajes                                       ");
                                        System.out.println("5) Volver                                         ");     
                                        System.out.println("- - - - - - - - - - - - - - - - - - - - - - -  - -");
                                        
                                        option=fabrica.datos.option(); 

                                        boolean bandera=false;
                                        
                                        switch(option) {
                                            case 0:
                                                fabrica.ayuda.ayudaClienteCuenta();
                                                fabrica.pulsaIntro.intro();
                                                break;
                                            case 1://Realizar pedido
                                                                                   
                                                do{   
                                                    
                                                    fabrica.limpiar.limpiarConsola();
                                                    fabrica.mensaje.bienvenida();
                                                    
                                                    System.out.println("--------------------------------------------------");
                                                    System.out.println("Menú> Cliente> " + persona.getNombre() + " ID-" + persona.getIdCliente() + "> Realizar Pedido>");
                                                    System.out.println("--------------------------------------------------");
                                                    System.out.println("0) Ayuda");
                                                    System.out.println("- - - - - - - - - - - - - - - - - - - - - - -  - -");
                                                    System.out.println("1) Mesas");
                                                    System.out.println("2) Sillas");
                                                    System.out.println("3) Volver");
                                                    System.out.println("- - - - - - - - - - - - - - - - - - - - - - -  - -");
                                                    
                                                    option=fabrica.datos.option();
                                                        
                                                    switch(option) {
                                                        case 0:
                                                        System.out.println("Esta seccion no contiene ayuda.");
                                                        fabrica.pulsaIntro.intro();
                                                        break;
                                                        
                                                        case 1:
                                                    
                                                            do{
                                                                
                                                                fabrica.limpiar.limpiarConsola();
                                                                fabrica.mensaje.bienvenida();  
                                                                
                                                                System.out.println("--------------------------------------------------");
                                                                System.out.println("Menú> Cliente> "+ persona.getNombre() + " ID-" + persona.getIdCliente()+"> Realizar Pedido> Mesas>");
                                                                System.out.println("--------------------------------------------------");
                                                                System.out.println("    Ayuda");
                                                                System.out.println("- - - - - - - - - - - - - - - - - - - - - - -  - -");
                                                                System.out.println("1) Mesa Dormitorio");
                                                                System.out.println("2) Mesa Comedor");
                                                                System.out.println("3) Mesa Café Madera");
                                                                System.out.println("4) Mesa Café  Cristal");
                                                                System.out.println("5) Volver");
                                                                System.out.println("- - - - - - - - - - - - - - - - - - - - - - -  - -");
                                                                
                                                                option=fabrica.datos.option();
                                                                Mueble mueble=null;
                                                                
                                                                switch(option) {
                                                                    
                                                                    case 1:
                                                                        mueble=fabrica.pedido.addMesaDormitorio(idCliente, fabrica.datos.altura(), fabrica.datos.largo(), fabrica.datos.ancho(), fabrica.datos.cajones(), fabrica.datos.cantidad());
                                                                        fabrica.sistema.addArrayPedido(mueble);
                                                                        persona.setTotalPedidos();
                                                                        fabrica.mensaje.pedidoRealizado();
                                                                        fabrica.pulsaIntro.intro();
                                                                        break;
                                                                            
                                                                    case 2:
                                                                        mueble=fabrica.pedido.addMesaComedor(idCliente, fabrica.datos.altura(),fabrica.datos.largo(),fabrica.datos.ancho(),fabrica.datos.cantidad());
                                                                        fabrica.sistema.addArrayPedido(mueble);
                                                                        persona.setTotalPedidos();
                                                                        fabrica.mensaje.pedidoRealizado();
                                                                        fabrica.pulsaIntro.intro();
                                                                        break;
                                                                            
                                                                    case 3:
                                                                        mueble=fabrica.pedido.addMesaCafeMadera(idCliente, fabrica.datos.altura(),fabrica.datos.largo(),fabrica.datos.ancho(),fabrica.datos.cantidad());
                                                                        fabrica.sistema.addArrayPedido(mueble);
                                                                        persona.setTotalPedidos();
                                                                        fabrica.mensaje.pedidoRealizado();
                                                                        fabrica.pulsaIntro.intro();
                                                                        break;
                                                                            
                                                                    case 4:
                                                                        mueble=fabrica.pedido.addMesaCafeCristal(idCliente,fabrica.datos.altura(),fabrica.datos.largo(),fabrica.datos.ancho(),fabrica.datos.cantidad());
                                                                        fabrica.sistema.addArrayPedido(mueble);
                                                                        persona.setTotalPedidos();
                                                                        fabrica.mensaje.pedidoRealizado();
                                                                        fabrica.pulsaIntro.intro();
                                                                        break;  
                                                                        
                                                                }
                                                                     
                                                             }while(option != 5); 
                                                             option=0;
                                                             break;
                                                          
                                                                
                                                        case 2:
                                                            
                                                            do{
                                                                fabrica.limpiar.limpiarConsola();
                                                                fabrica.mensaje.bienvenida(); 
                                                                
                                                                System.out.println("--------------------------------------------------");
                                                                System.out.println("Menú> Cliente> "+ persona.getNombre() + " ID-" + persona.getIdCliente()+"> Realizar Pedido> Sillas>");
                                                                System.out.println("--------------------------------------------------");
                                                                System.out.println("   Ayuda");
                                                                System.out.println("- - - - - - - - - - - - - - - - - - - - - - -  - -");
                                                                System.out.println("1) Silla de Cocina");
                                                                System.out.println("2) Silla de oficina con ruedas");
                                                                System.out.println("3) Silla de oficina sin ruedas");
                                                                System.out.println("4) Silla Plegable");
                                                                System.out.println("5) Volver");
                                                                System.out.println("- - - - - - - - - - - - - - - - - - - - - - -  - -");
                                                                option=fabrica.datos.option();
                                                                
                                                                switch(option) {
                                                                    
                                                                    case 1: 
 
                                                                        Mueble pedidoCocina=fabrica.pedido.addSillaCocina(idCliente,fabrica.datos.cantidad(),fabrica.datos.reposabrazos());
                                                                        fabrica.sistema.addArrayPedido(pedidoCocina);
                                                                        persona.setTotalPedidos();
                                                                        fabrica.mensaje.pedidoRealizado();
                                                                        fabrica.pulsaIntro.intro();
                                                                        break;
                                                                   
                                                                    case 2:
                                                                        
                                                                        Mueble pedidoOficina=fabrica.pedido.addSillaConRuedas(idCliente,fabrica.datos.cantidad(),fabrica.datos.reposabrazos());
                                                                        fabrica.sistema.addArrayPedido(pedidoOficina);
                                                                        persona.setTotalPedidos();
                                                                        fabrica.mensaje.pedidoRealizado();
                                                                        fabrica.pulsaIntro.intro();
                                                                        break;
                                                                        
                                                                    case 3:
                                                                    
                                                                        Mueble pedidoOficinaRueda=fabrica.pedido.addSillaConRuedas(idCliente,fabrica.datos.cantidad(),fabrica.datos.reposabrazos());
                                                                        fabrica.sistema.addArrayPedido(pedidoOficinaRueda);
                                                                        persona.setTotalPedidos();
                                                                        fabrica.mensaje.pedidoRealizado();
                                                                        fabrica.pulsaIntro.intro();  
                                                                        break;
                                                                        
                                                                    case 4:
                                                                    
                                                                        Mueble pedidoPlegable=fabrica.pedido.addSillaConRuedas(idCliente,fabrica.datos.cantidad(),fabrica.datos.reposabrazos());
                                                                        fabrica.sistema.addArrayPedido(pedidoPlegable);
                                                                        persona.setTotalPedidos();
                                                                        fabrica.mensaje.pedidoRealizado();
                                                                        fabrica.pulsaIntro.intro();                                                                    
                                                                        break;
                                                                        
                                                                }
                                                                
                                                            }while(option != 5);
                                                            break;
                                                            
                                                    }
                                                    
                                                }while(option != 3);
                                                option=0;
                                                break;
                                                
                                            case 2: //verpedidos

                                                persona.listarPedidos(fabrica.sistema.listarPedido(persona.getIdCliente()));
                                                fabrica.pulsaIntro.intro();                     
                                                break;
                                                
                                            case 3://Confirmar presupuesto
                                                
                                                persona.confirmaPresupuesto(fabrica.sistema.arrayPedido());
                                                bandera=false;
                                                fabrica.pulsaIntro.intro();
                                                break;
                                                
                                            case 4://Buzon de mensajes
                                                persona.mensajeBuzon(fabrica.sistema.notifica(persona.getIdCliente()));
                                            
                                                fabrica.pulsaIntro.intro();
                                                break;
                                                
                                        }
                                    }while(option!=5);      
                                    option=0; 
                                    
                                   }else {
                                       System.out.println("Cliente no encontrado");
                                       fabrica.pulsaIntro.intro();
                                   }                             
                                   break;
                                
                            case 2: //Registrar cuenta estandar
                                fabrica.sistema.addArrayCliente(new Ciudadano(fabrica.datos.nombreRegistro()));
                                fabrica.sistema.limparRegistros(); //si se a introducido un nombre null lo borra del array
                                fabrica.pulsaIntro.intro();
                                break;
                                
                            case 3: //Registrar cuenta empresa
                                
                                fabrica.sistema.addArrayCliente(new Empresa(fabrica.datos.nombreRegistro()));
                                fabrica.sistema.limparRegistros(); //si se a introducido un nombre null lo borra del array
                                fabrica.pulsaIntro.intro();
                                break;
                                
                            case 4: //Eliminar cuenta
                                
                                if(fabrica.sistema.cliente().size()==0) {
                                    System.out.println("no hay clientes.");
                                }else {   
                                    
                                    String nom=fabrica.datos.nombre();
                                    System.out.print(">Para confirmar introduzca su ID cliente: ");
                                    
                                    int id=fabrica.datos.pideId();  
                                    boolean encontrado=false;
                                    boolean borrar=fabrica.sistema.removeArrayCliente(nom,id);
                                    
                                    if(borrar) {
                                        System.out.println("La operación ha tenido éxito ");
                                    }
                                    else {
                                        System.out.println("ID y/o Nombre incorrectos.");
                                    }
                                }
                                fabrica.pulsaIntro.intro();
                                break;
                                
                        }
                        
                    }while(option != 5);
                    break;//Final de case 1 (Area Cliente)
                       
                case 2://AreaEmpleado
                    //Jefe jefe=null;
                    do{
                        fabrica.limpiar.limpiarConsola();
                        fabrica.mensaje.bienvenida();
                        System.out.println("--------------------------------------------------");
                        System.out.println("Área Empleado>");
                        System.out.println("--------------------------------------------------");
                        System.out.println("0) Ayuda");
                        System.out.println("- - - - - - - - - - - - - - - - - - - - - - -  - -");
                        System.out.println("1) Menú Jefe");
                        System.out.println("2) Menú Comercial");
                        System.out.println("3) Menú  Artesano");
                        System.out.println("4) Volver");
                        System.out.println("- - - - - - - - - - - - - - - - - - - - - - -  - -");
                        option=fabrica.datos.option();
                        
                        Jefe trabajador=null;
                        switch(option) {
                            case 0:
                                fabrica.ayuda.ayudaEmpleado();
                                fabrica.pulsaIntro.intro();
                                break;
                            case 1:
                                
                                boolean encontrado=false;
                                //Busca al jefe para acceder a la cuenta como Jefe
                                for(Empleado empleado: fabrica.sistema.empleado()) {
                                    if("Jefe".equalsIgnoreCase(empleado.getPuesto())) {
                                        trabajador=(Jefe)empleado;
                                        encontrado=true;
                                        break;
                                    }
                                } 
                                
                                //Si no hay jefe lo crea.
                                if(!encontrado) {
                                    System.out.println("No se ha encontrado al jefe... Pon tu nombre y sueldo, tu serás el jefe .");
                                    Empleado jefe1= new Jefe(fabrica.datos.nombre(), fabrica.datos.sueldo());
                                    fabrica.sistema.addEmpleado(jefe1);
                                    
                                    for(Empleado empleado: fabrica.sistema.empleado()) {
                                        if("Jefe".equalsIgnoreCase(empleado.getPuesto())) {
                                            trabajador=(Jefe)empleado;
                                            break;
                                        }
                                    } 
                                    
                                }
                            
                                do{
                                    fabrica.limpiar.limpiarConsola();
                                    fabrica.mensaje.bienvenida();
                                    
                                    System.out.println("--------------------------------------------------");
                                    System.out.println("Área Empleado> Jefe> " + trabajador.getNombre() + " ID-" + trabajador.getId() + ">"); 
                                    System.out.println("--------------------------------------------------");
                                    System.out.println("0) Ayuda");
                                    System.out.println("- - - - - - - - - - - - - - - - - - - - - - -  - -");
                                    System.out.println("1) Contratos: Altas/Bajas");
                                    System.out.println("2) Ver plantilla");
                                    System.out.println("3) Asignar pedido");
                                    System.out.println("4) Funcionamiento de la fábrica ");
                                    System.out.println("5) Volver"); 
                                    System.out.println("- - - - - - - - - - - - - - - - - - - - - - -  - -");
                                    
                                    option=fabrica.datos.option();
                                    
                                    switch(option) {
                                        case 0:
                                            fabrica.ayuda.ayudaEmpleadoJefe();
                                            fabrica.pulsaIntro.intro();
                                            break;
                                        case 1:
                                        
                                            do{
                                                fabrica.limpiar.limpiarConsola();
                                                fabrica.mensaje.bienvenida();
                                                
                                                System.out.println("--------------------------------------------------");
                                                System.out.println("Áre Empleado> Jefe> Contratos Altas/Bajas>" + trabajador.getNombre() + " ID-" + trabajador.getId() + ">" );
                                                System.out.println("--------------------------------------------------");
                                                System.out.println("0) Ayuda");
                                                System.out.println("--------------------------------------------------");
                                                System.out.println("1) Contratar Artesano fijo"); 
                                                System.out.println("2) Contratar Artesano Temporal");
                                                System.out.println("3) Contratar Comercial");
                                                System.out.println("4) Contratar Jefe");
                                                System.out.println("5) Dar de baja a un Empleado");
                                                System.out.println("6) Volver");
                                                System.out.println("--------------------------------------------------");
                                                
                                                option=fabrica.datos.option();
                                                
                                                switch(option) {
                                                    case 0:
                                                        fabrica.ayuda.ayudaEmpleadoJefeContratos();
                                                        fabrica.pulsaIntro.intro();
                                                        break;
                                                        
                                                    case 1:
                                                        System.out.println("Área Empleado> Jefe> Contratos Altas/Bajas> Contratar fijo>");
                                                        trabajador.contratarArtesanoFijo(fabrica.datos.nombre(), fabrica.datos.sueldo(), fabrica.sistema.empleado());
                                                        System.out.println("A realizado un nuevo contrato con exito");
                                                        fabrica.pulsaIntro.intro();
                                                        break;
                                                        
                                                    case 2:
                                                        System.out.println("Áre Empleado> Jefe> Contratos Altas/Bajas> Contratar Artesano temporal>");
                                                        trabajador.contratarArtesanoTemporal(fabrica.datos.nombre(), fabrica.datos.sueldo(),fabrica.sistema.empleado());
                                                        System.out.println("A realizado un nuevo contrato con exito");
                                                        fabrica.pulsaIntro.intro();
                                                        break;
                                                        
                                                    case 3:
                                                        System.out.println("Área Empleado> Jefe> Contratos Altas/Bajas> Contratar Comercial>");
                                                        trabajador.contratarComercial(fabrica.datos.nombre(), fabrica.datos.sueldo(),fabrica.sistema.empleado());
                                                        System.out.println("A realizado un nuevo contrato con exito");
                                                        fabrica.pulsaIntro.intro();
                                                        break;
                                                        
                                                    case 4:
                                                        System.out.println("Área Empleado> Jefe> Contratos Altas/Bajas> Contratar Jefe");
                                                        trabajador.contratarJefe(fabrica.datos.nombre(), fabrica.datos.sueldo(),fabrica.sistema.empleado());
                                                        System.out.println("A realizado un nuevo contrato con exito");
                                                        break;
                                                        
                                                    case 5:
                                                        
                                                        int id=fabrica.datos.getId();
                                                        trabajador.despedirEmpleado(id, fabrica.sistema.empleado());
                                                        fabrica.sistema.borrarAsignacionArtesano(id);

                                                        fabrica.pulsaIntro.intro();
                                                        break;
                                                        
                                                }
                                                
                                            }while(option != 6);
                                            break;
                                            
                                        case 2:// Ver la plantilla
                                            
                                            System.out.println("--------------------------------------------------");
                                            System.out.println("Área Empleado> Jefe> Ver plantilla> "  + trabajador.getNombre() + " ID-" + trabajador.getId() + ">");  
                                            System.out.println("--------------------------------------------------");
                                            trabajador.listarPlantilla(fabrica.sistema.empleado());
                                            fabrica.pulsaIntro.intro();
                                            break;
                                        
                                        case 3:
                                            if(fabrica.sistema.arrayPedido().size()==0) {
                                                System.out.println("La fábrica no tiene pedidos.");
                                                fabrica.pulsaIntro.intro();
                                            }
                                            else {
                                                trabajador.GestionPedidos(fabrica.sistema.arrayArtesano(), fabrica.sistema.arrayPedido());
                                                fabrica.pulsaIntro.intro();
                                            }
                                            break;
                                            
                                        case 4:
                                        
                                            do{
                                                
                                                fabrica.limpiar.limpiarConsola();
                                                fabrica.mensaje.bienvenida();
                                                
                                                System.out.println("--------------------------------------------------");
                                                System.out.println("Áre Empleado> Jefe> Funcionamiento de la Fabrica> "  + trabajador.getNombre() + " ID-" + trabajador.getId() + ">");
                                                System.out.println("--------------------------------------------------");
                                                System.out.println("0) Ayuda");
                                                System.out.println("--------------------------------------------------");
                                                System.out.println("1) Estado pedidos.");
                                                System.out.println("2) Historial Artesanos.");
                                                System.out.println("3) Cartera Clientes.");
                                                System.out.println("4) Historial de muebles");
                                                System.out.println("5) Volver");
                                                System.out.println("--------------------------------------------------");
                                                
                                                option=fabrica.datos.option();
                                            
                                                switch(option) {
                                                    case 0:
                                                        fabrica.ayuda.ayudaEmpleadoJefe();
                                                        fabrica.pulsaIntro.intro();
                                                    case 1:
                                                        
                                                        trabajador.estadoPedidos(fabrica.sistema.arrayPedido());
                                                        fabrica.pulsaIntro.intro();  
                                                        break;
                                                    
                                                    case 2:
                                                    
                                                        trabajador.historialArtesanos(fabrica.sistema.empleado());
                                                        fabrica.pulsaIntro.intro();
                                                        break;
                                                        
                                                   case 3:
                                                        trabajador.listarClientes(fabrica.sistema.cliente()); 
                                                        fabrica.pulsaIntro.intro();
                                                        break;
                                                    
                                                   case 4:
                                                        System.out.println(fabrica.pedido.historialPedidos());
                                                        fabrica.pulsaIntro.intro();
                                                        break;
                                                        
                                                }
                                                
                                            }while(option != 5);
                                            break;
                                            
                                    }
                                    
                                }while(option != 5);
                            
                        
                                break;//Menu Jefe
                                
                            case 2:
                                Comercial comercial=null;
                                do{
                                    encontrado=false;
                                    for(Empleado empleado: fabrica.sistema.empleado()) {

                                        
                                        if("Comercial".equalsIgnoreCase(empleado.getPuesto())) {
                                            comercial=(Comercial)empleado;
                                            encontrado=true;
                                            break;
                                        }

                                    }
                                    
                                    if(!encontrado) {
                                        System.out.println("Póngase en contacto con el Jefe para contratar a un comercial.");
                                        fabrica.pulsaIntro.intro();
                                        break;
                                    }else {               
                                    
                                        fabrica.limpiar.limpiarConsola();
                                        fabrica.mensaje.bienvenida();
                                        
                                        System.out.println("--------------------------------------------------");
                                        System.out.println("Área Empleado> Comercial> " + comercial.getNombre());
                                        System.out.println("--------------------------------------------------");
                                        System.out.println("0) Ayuda");
                                        System.out.println("--------------------------------------------------");
                                        System.out.println("1) Realizar presupuesto.");
                                        System.out.println("2) Consultar pedidos completados.");
                                        System.out.println("3) Mensaje a cliente.");
                                        System.out.println("4) volver.");
                                        System.out.println("--------------------------------------------------");
                                        
                                        option=fabrica.datos.option();
                                        
                                        switch(option) {
                                            case 0:
                                                fabrica.ayuda.ayudaEmpleadoComercial();
                                                fabrica.pulsaIntro.intro();
                                                break;
                                            case 1:
                                               comercial.presupuesto(fabrica.sistema.arrayPedido());
                                               fabrica.pulsaIntro.intro();
                                               break;
                                               
                                            case 2:
                                                comercial.verPedidoCompletado(fabrica.sistema.arrayPedido());
                                                fabrica.pulsaIntro.intro();
                                                break;
                                               
                                            case 3:
                                                System.out.println("Para enviar un mensaje debe introducir el ID del cliente:");
                                                System.out.println("1) Enviar mensaje");
                                                System.out.println("2) Volver.");
                                                
                                                option=fabrica.datos.option();
                                                
                                                if(option==1) {
                                                    //trabjador.envioMensaje(fabrica.datos.pideInt(),fabrica.datos.pideString()fabrica.datos.pideString())
                                                    System.out.println("ID cliente> ");
                                                    int id=fabrica.datos.pideId();
                                                
                                                    System.out.println("Asunto> ");
                                                    String asunto=fabrica.datos.pideString();
                                                
                                                    System.out.println("Mensaje> ");
                                                    String mensaje=fabrica.datos.pideString();
                                                                                                     
                                                    Notificacion sms=comercial.envioMensaje(id,asunto,mensaje);
                                                    fabrica.sistema.notificacion().add(sms);
                                                    
                                                    fabrica.pulsaIntro.intro();
                                                }
                                                break;
                                        }
                                    }    
                                }while(option != 4);
                                option=-1;    
                                break;
                                
                            case 3:
                                if(fabrica.sistema.empleado().size() == 0) {
                                    System.out.println("No hay Artesanos, contacte con el Jefe");
                                    fabrica.pulsaIntro.intro();
                                }else {
                                    boolean senial=false;
                                    
                                    System.out.println("--------------------------------------------------");
                                    System.out.println("Area Empleado> Artesano>");
                                    System.out.println("--------------------------------------------------");
                                    System.out.println("Introduzca su ID de empleado para acceder: ");
                                    
                                    int id=fabrica.datos.pideId();
                                    
                                    
                                    for(Empleado empleado: fabrica.sistema.arrayArtesano()) {
                                        
                                        if(id == empleado.getId()) {
                                            senial=true;
                                            Artesano person=(Artesano)empleado;
                                            
                                            do{
                                                fabrica.limpiar.limpiarConsola();
                                                fabrica.mensaje.bienvenida();
                                                
                                                System.out.println("--------------------------------------------------");
                                                System.out.println("Área Empleados> Artesano> " + empleado.getNombre() + " ID: [" + person.getId() + "]");
                                                System.out.println("--------------------------------------------------");
                                                System.out.println("Consejo: visualizar trabajos.");
                                                System.out.println("--------------------------------------------------");
                                                System.out.println("1) Ver trabajos."); 
                                                System.out.println("2) Actualizar trabajo.");
                                                System.out.println("3) Salir.");
                                                System.out.println("--------------------------------------------------");
                                                
                                                option=fabrica.datos.option();
                                               
                                                switch(option) {
                                                    
                                                    case 1:
                                                        person.verTrabajo(fabrica.sistema.arrayPedido());
                                                        fabrica.pulsaIntro.intro();
                                                        break;
                                                        
                                                    case 2:
                                                        person.verTrabajo(fabrica.sistema.arrayPedido());
                                                        System.out.print("Inserte la referencia del pedido>");
                                                        int referencia=fabrica.datos.refePedido();
                                                        boolean existe=false;
                                                        
                                                        for(Mueble mueble: fabrica.sistema.arrayPedido()) {
                                                            if(referencia == mueble.referencia()) {
                                                                if(mueble.estado.getIdArtesano() == person.getId()) {
                                                                    existe=true;
                                                                    break;
                                                                }
                                                            }
                                                        }
    
                                                        if(existe) {
                                                            System.out.println("1) Fabricando");
                                                            System.out.println("2) Parar(Faltan piezas)");
                                                            System.out.println("3) Terminado");
                                                            option=fabrica.datos.option();
                                                            for(Mueble mueble: fabrica.sistema.arrayPedido()) {
                                                                
                                                            }
                                                            switch(option) {
                                                                case 1:
                                                                    person.actualizaEstadoFabricando(referencia, fabrica.sistema.arrayPedido());
                                                                    break;
                                                                case 2:
                                                                    person.actualizaEstadoIncompleto(referencia, fabrica.sistema.arrayPedido());
                                                                    break;
                                                                case 3:
                                                                    person.actualizaEstadoFinalizado(referencia, fabrica.sistema.arrayPedido());
                                                                    break;
                                                            }
                                                            
                                                        }else {
                                                           System.out.println("La referencia no le pertenece.");
                                                           fabrica.pulsaIntro.intro();
                                                        }
                                                        break;
                                                }
                                                
                                            }while(option != 3);
                                            break;
                                         }
         
                                    }
                                    if(!senial) {
                                        System.out.println("Artesano no encontrado");
                                        fabrica.pulsaIntro.intro();
                                    }
    
                                }
                        }   
                    }while(option!=4); 
                
                    break;
                    
                case 3:
                
                    fabrica.limpiar.limpiarConsola();
                    System.out.println("Hasta la proxima\n\n");
                    break;
                    
            }
        }

    }
    

    /**
     * 
     */
    public byte confirmaSalir(byte option)
    {
        if(option==3) {
            System.out.println("*ATENCION*");
            System.out.println("Está cerrando el programa, ¿Esta segura? \n1)Salir del programa\n2)volver al programa.");
            option=datos.option();

            if(option==1) {
                option=3;
            }else {
                option=0;
            }
            
        }
        return option;
    }

    
}
