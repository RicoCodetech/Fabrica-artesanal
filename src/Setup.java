

/**
 * Write a description of class Setup here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.io.File;
import java.util.Scanner;

public class Setup
{
    // instance variables - replace the example below with your own


    /**
     * Constructor for objects of class Setup
     */
    public Setup()
    {
        // initialise instance variables

    }
    
    /**
     * Inserta un pequeño retardo 
     */
    public void retardo(String caracter, int delay)
    {
            System.out.print(caracter);
            try {
                Thread.sleep(delay);
            }catch(InterruptedException e){
            
            }
    }
    
    
    /**
     * Inserta los pedidos
     * @param ArrayList<Mueble> 
     */
    public void addPedidos(ArrayList<Mueble> arrayPedido)
    {
        System.out.print("Cargando pedidos");
        for(int i=0; i<12; i++) {
            retardo(".", 50);
        }
        System.out.println("Ok");
        
        File fichero= new File("addPedido.txt");
        Scanner s = null;
        
        try {
            s = new Scanner(fichero);
            String[] cortaString;
            
            while(s.hasNext()) {
                String linea= s.nextLine();
                cortaString = linea.split("::");
                Mueble mueble= new MesaDormitorio(Integer.parseInt(cortaString[0]),
                                                  Integer.parseInt(cortaString[1]),
                                                  Integer.parseInt(cortaString[2]),
                                                  Integer.parseInt(cortaString[3]),
                                                  Integer.parseInt(cortaString[4]),
                                                  Integer.parseInt(cortaString[5]));
                arrayPedido.add(mueble);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            retardo(" ",80000);
        }
    }
    
    
    
    /**
     * Inserta los empleados
     * @param ArrayList<Empleado> 
     */
    public void addEmpleados(ArrayList<Empleado> arrayEmpleado)
    {
        System.out.print("Cargando Empleados");
        for(int i=0; i<10; i++) {
            retardo(".", 50);
        }
        System.out.println("Ok");
        
        File fichero= new File("addEmpleado.txt");
        Scanner s = null;
        
        try {
            s = new Scanner(fichero);
            String[] cortaString;
            int contador=0;
            while(s.hasNext()) {
                String linea= s.nextLine();
                cortaString = linea.split("::");
                if(contador == 0) {
                    Empleado empleado= new Jefe(cortaString[0], Integer.parseInt(cortaString[1]));
                    arrayEmpleado.add(empleado);
                    contador++;
                }
                else if(contador == 1) {
                   Empleado empleado= new Comercial(cortaString[0], Integer.parseInt(cortaString[1])); 
                   arrayEmpleado.add(empleado);
                   contador++;
                }
                else if(contador == 2 || contador == 3){
                   Empleado empleado= new ArtesanoPlantilla(cortaString[0], Integer.parseInt(cortaString[1]));
                   arrayEmpleado.add(empleado);
                   contador++;
                }
                else {
                   Empleado empleado= new ArtesanoTemporal(cortaString[0], Integer.parseInt(cortaString[1]));
                   arrayEmpleado.add(empleado);
                   contador++;
                }
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Inserta los clientes 
     */
    public void addClientes(ArrayList<Cliente> arrayCliente)
    {
        System.out.print("Cargando clientes");
        for(int i=0; i<11; i++) {
            retardo(".", 50);
        }
        System.out.println("Ok");
        
        File fichero= new File("addClientes2.txt");
        Scanner s = null;
        
        try {
            s = new Scanner(fichero);
            String[] cortaString;
            int contador=0;
            while(s.hasNext()) {
                String linea= s.nextLine();
                cortaString = linea.split("::");
                if(contador == 0) {
                Cliente cliente= new Ciudadano(cortaString[0],Integer.parseInt(cortaString[1]));
                arrayCliente.add(cliente);
                contador++;
                }
                else {
                    Cliente cliente= new Ciudadano(cortaString[0]);
                    arrayCliente.add(cliente);
                }
                
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    /**
     * Inserta los nombres de los clientes en un array de ObterDatos para
     * evitar que se pueda registrar una cuenta con un nombre de usuario
     * que ya esta en uso
     */
    public void addClientesComprueba(ArrayList<String> comprueba)
    {
        System.out.print("Organizando datos");
        for(int i=0; i<11; i++) {
            retardo(".", 50);
        }
        System.out.println("Ok");
        
        File fichero= new File("addClientes.txt");
        Scanner s = null;
        
        try {
            s = new Scanner(fichero);
            String[] cortaString;
            
            while(s.hasNext()) {
                String linea= s.nextLine();
                cortaString = linea.split("::");
                String cliente=cortaString[0];
                //Cliente cliente= new Ciudadano(cortaString[0]);
                comprueba.add(cliente);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Inserta el precio a un pedido y lo deja pendiente de confirmacion
     */
    public void organizandoPedidos(ArrayList<Mueble> pedido)
    {
        System.out.print("Organizando pedidos");
        for(int i=0; i<9; i++) {
            retardo(".", 50);
        }
        System.out.println("Ok");   
        
        File fichero= new File("addEstadoPedido.txt");
        Scanner s= null;
        
        try {
            s = new Scanner(fichero);
            String[] cortaString;
            
            while(s.hasNext()) {
                String linea= s.nextLine();
                cortaString = linea.split("::");
                String cliente=cortaString[0];
                pedido.get(0).setPrecio(Integer.parseInt(cortaString[0]));
                //Cliente cliente= new Ciudadano(cortaString[0]);
                //comprueba.add(cliente);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
