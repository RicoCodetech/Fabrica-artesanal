
/**
 * La clase abstracta Persona define los atributos que adquiere una persona
 * 
 * @author: Oscar Rico Martinez
 * Date:    16-3-2020
 */
public abstract class Persona
{
    // instance variables - replace the example below with your own
  
    private String nombre;
          
    /**
     * Constructor de la clase persona
     * @param nombre De la persona
     */
    public Persona(String nombre)
    {
        // put your code here
        this.nombre=nombre;
    }
    
    /**
     * Establece el nombre de la persona
     */
    public void setNombre(String nombre)
    {
        this.nombre=nombre;
    }
    
    /**
     * @return nombre De la persona
     */
    public String getNombre()
    {
        return nombre;
    }
    
    public String toString()
    {
        return "Nombre: "+nombre;
    }
    
    
}
