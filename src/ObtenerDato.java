
/**
 * Esta clase contiene diversos metodos que piden informacion necesaria para el
 * funcionamiento del sistema
 * 
 * @author Oscar Rico Martinez 
 * @version 19/05/2020
 */
import java.util.Scanner;
import java.util.ArrayList;

public class ObtenerDato
{
    private ArrayList <String> comprueba= new ArrayList();
    Scanner entrada= new Scanner(System.in);
    
    public ObtenerDato()
    {
    
    }
    
    /**
     * Pide un nombre
     * @return nombre
     */
    public String nombre()
    {
        System.out.print("> Nombre: ");
        entrada.useDelimiter("\n");
        String nombre=entrada.next();
        return nombre;
    }
    
    /**
     * Metodo que devulve el array donde se guarda una copia de los nombres de los clientes registrados
     * con el fin de evitar registros con el mismo nombre.
     * @return ArrayList<String>
     */
    public ArrayList<String> arrayComprueba()
    {
        return comprueba;
    }
    
    /**
     * Metodo que devuelve la opcion seleccionada por el usuario.
     * @return option 
     */
    public byte option()
    {
        //entrada.reset();
        System.out.print("> Seleccione una opcion: ");
        
        while(!entrada.hasNextInt()) {
            entrada.next();
            System.out.print("Inserte una opcion valida>");
        }        
        
        byte nombre=entrada.nextByte();
        System.out.println();
        return nombre;
    }
    
    /**
     * Añade un nombe registrado en el array comprueba
     */
    public void setnom(String nom)
    {
        comprueba.add(nom);
    }
    
    /**
     * Pide nombre para registrar cuenta, comprueba que el nombre este libre
     * @return nombre
     */
    public String nombreRegistro() {
        boolean usuarioRepetido=false;
        String nombre;
        do{
            usuarioRepetido=false;
            System.out.print("> Nombre: ");
            entrada.useDelimiter("\n");
            nombre=entrada.next().trim();
            
            for(String a: comprueba) {   
                if(nombre.equalsIgnoreCase(a) && usuarioRepetido==false) {
                    System.out.println("ATENCION: El nombre de usuario no esta disponible. Porfavor vuelva a intentarlo.");
                    usuarioRepetido=true;
                }
            }
            
            if(nombre.length() < 2) {
                System.out.println("Nombre muy corto, porfavor vuelca a intentarlo.");
                nombre=null;
            }else if(!usuarioRepetido) {
                comprueba.add(nombre);
                System.out.println("** El registro se ha completado con exito, gracias. **\n");
            }
        }while(usuarioRepetido);
        
        return nombre;
    }
    
    /**
     * Libera un nombre de usuario que a sido eliminado
     */
    public void borrarCliente(String nombre)
    {
        for(int i=0; i<comprueba.size(); i++) {
            if(nombre.equalsIgnoreCase(comprueba.get(i)))
            {
                comprueba.remove(i);
            }
        }
    }
    
    /**
     * pide el id de un empleado para darlo de baja
     * @return id
     */
    public int getId() {
        System.out.println("Dar de baja al empleado con ID: ");
        
        while(!entrada.hasNextInt()) {
            entrada.next();
            System.out.print("Inserte un id correcto>");
        }        
        
        int id=entrada.nextInt();
        
        return id;
    }
    
    /**
     * Pide el sueldo que se quiere asignar a un empleado
     * @return sueldo
     */
    public int sueldo()
    {
        System.out.print("> Sueldo: ");
        
        while(!entrada.hasNextInt()) {
            entrada.next();
            System.out.print("Inserte una cantidad correcta>");
        }
        
        int sueldo=entrada.nextInt();
        return sueldo;
    }
    
    /**
     * pide el precio para asignarlo a un pedido
     * @return precio
     */
    public int precio()
    {
        System.out.print("> Precio: ");
        
        while(!entrada.hasNextInt()) {
            entrada.next();
            System.out.print("Inserte una cantidad correcta>");
        }
        
        int precio=entrada.nextInt();
        return precio;
    }    
    
    /**
     * pide la altura de un mueble
     * @return altura
     */
    public int altura()
    {
        System.out.print("> Altura Centimetros: ");
        
        while(!entrada.hasNextInt()) {
            entrada.next();
            System.out.print("Inserte un tamaño valido>");
        } 
        
        int altura=entrada.nextInt();
        System.out.println();
        return altura;
    } 
    
    /**
     * Pide el largo de un mueble
     * @return largo
     */
    public int largo()
    {
        System.out.print("> Largo Centimetros: ");
        
        while(!entrada.hasNextInt()) {
            entrada.next();
            System.out.print("Inserte un tamaño valido>");
        }        
        
        int largo=entrada.nextInt();
        System.out.println();
        return largo;
    }   
    
    /**
     * Pide el ancho de un mueble
     * @return ancho
     */
    public int ancho()
    {
        System.out.print("> Ancho Centimetros: ");
        
        while(!entrada.hasNextInt()) {
            entrada.next();
            System.out.print("Inserte un tamaño valido>");
        }        
        
        int ancho=entrada.nextInt();
        System.out.println();
        return ancho;
    }
    
    /**
     * Pide la cantidad de un mismo mueble
     * @return cantidad
     */
    public int cantidad()
    {
        System.out.print("> Cantidad: ");
        
        while(!entrada.hasNextInt()) {
            entrada.next();
            System.out.print("Inserte una cantidad valida>");
        }        
        
        int cantidad=entrada.nextInt();
        System.out.println();
        return cantidad;
    }    
    
    /**
     * Pide el numero de cajones para el mueble
     * @return cajones
     */
    public int cajones()
    {
        System.out.print("> Nº Cajones: ");

        while(!entrada.hasNextInt()) {
            entrada.next();
            System.out.print("Inserte una cantidad valida>");
        }        
        
        int cajones=entrada.nextInt();
        System.out.println();
        return cajones;
    }
    
   
    /**
     * pide confirmacion
     * return boolean
     */
    public boolean confirmacion()
    {
        System.out.println("1) Confirmar pedido.");
        System.out.println("2) Eliminar pedido");
        int i=option();
        switch(i) {
            case 1:
                return true;
                
            case 2:
                return false;
                
        }
    
        return true;
    }
    
    /**
     * Pide un id de empleado
     * @return id
     */
    public int pideId()
    {

        while(!entrada.hasNextInt()) {
            entrada.next();
            System.out.print("Inserte un ID valido>");
        }        
        
        int id=entrada.nextInt();
        System.out.println();
        return id;
    }  
    
    /**
     * Pide la referencia de un pedido
     * @return referencia
     */
    public int refePedido()
    {
        
        while(!entrada.hasNextInt()) {
            entrada.next();
            System.out.print("Inserte una referencia valida>");
        }        
        
        int referencia=entrada.nextInt();
        System.out.println();
        return referencia;
    }  
    

    public String pideString()
    {
        entrada.useDelimiter("\n");
        String nombre=entrada.next();
        return nombre;
    }
    
    public boolean reposabrazos()
    {
        System.out.println("Reposabrazos: si/no");
        String respuesta=entrada.next();
        
        if("si".equalsIgnoreCase(respuesta)) {
            return true;
        }else {
            return false;
        }
        
    }    
    
}

