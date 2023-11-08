
/**
 *La clase abstracta Empleado define los atributos que tiene un empleado
 * 
 * @author Oscar Rico Martinez 
 * @version 19/05/2020
 */

import java.util.*;

public abstract class Empleado extends Persona
{
    
    private static int idSiguiente=1; //incrementa el id en cada instancia de empleado
    private int id;                   //asigna id al empleado
    private int sueldo;               //Salario del empleado
    private String puesto;            //Cargo que ocupa en la fabrica

    
    /**
    * Constructor de la clase Empleado
    * @param nombre El nombre del empleado
    * @param sueldo El sueldo del empleado
    */
    public Empleado(String nombre, int sueldo)
    {
        // initialise instance variables
        super(nombre);
        this.sueldo=sueldo;
        id=idSiguiente;
        idSiguiente++;
        puesto=null;
    }
    
    /**
     * Establece el sueldo del empleado
     * @param sueldo del empleado
     */
    public void setSueldo(int sueldo)
    {
        this.sueldo=sueldo;
    }
    
    /**
     * Devuelve el sueldo del empleado
     * @return sueldo del empleado
     */
    public int getSueldo()
    {
        return sueldo;
    }
    
    /**
     * Establece puesto del empleado
     * @param puesto del empleado
     */
    public void setPuesto(String puesto)
    {
        this.puesto=puesto;
    }
    
    /**
     * Establece el puesto que ocupa el empleado
     * @return puesto del empleado
     */
    public String getPuesto()
    {
        return puesto;
    }
    
    
    /**
     * Establece id del empleado
     * @param id asignacion de id
     */
    public void setId(int id)
    {
        this.id=id;
    }
    
    /**
     * Devuelve el id del empleado
     * @return id del empleado
     */
    public int getId()
    {
        return id;
    }
    
    public String toString()
    {
        return "ID: " + id + " Sueldo: " + sueldo + " Nombre: " + getNombre();
    }

}
