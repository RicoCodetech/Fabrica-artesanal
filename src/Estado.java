
/**
 * Esta clase le da un estado de fabricacion a cada mueble un artesano hace uso
 * de los metodos para actualizar el pedido.
 * Hay tres estados posibles: Fabricando, Incompleto y finalizado.
 * 
 * @author Oscar Rico Martinez 
 * @version 19/05/2020
 */
public class Estado
{
    // instance variables - replace the example below with your own

    private boolean realizando;
    private boolean incompleto;
    private boolean completado;
    private boolean aprobado;
    private boolean asignado;
    private int idArtesano;
    private int idReg;

    
    /**
     * Constructor for objects of class Sistema
     */
    public Estado()
    {
        // initialise instance variables
        realizando=false;
        incompleto=false;
        completado=false;
        aprobado=false;
        asignado=false;
        idArtesano=0;
        idReg=0;
    }
    
     /**
     * Define si el mueble a sido asignado a un artesano
     */
    public void setAsignado(boolean asignado)
    {
        this.asignado=asignado;
    }
    
     /**
     * Devuelve si el mueble esta asignado
     */
    public boolean getAsignado()
    {
        return asignado;
    }
    
    /**
    * Define si el mueble esta aprobado
    */
    public void setAprobado(boolean aprobado)
    {
        this.aprobado=aprobado;
    }
    
    /**
    * Devuelve si el mueble esta confirmado por parte del cliente
    */
    public boolean getAprobado()
    {
        return aprobado;
    }
    
    public int getIdArtesano()
    {
        return idArtesano;
    }
    
    public void setIdArtesano(int idArtesano)
    {
        this.idArtesano=idArtesano;
    }
    
    public void setIdReg(int idArtesano)
    {
        idReg=idArtesano;
    }
    
    public int getIdReg()
    {
        return idReg;
    }
    
    public void setFabricando()
    {
        realizando=true;
        incompleto=false;
        completado=false;
    }
    
    public boolean getFabricando()
    {
        return realizando;
    }
    
    public void setIncompleto()
    {
        realizando=false;
        incompleto=true;
        completado=false;
    }
    
    public boolean getIncompleto()
    {
        return incompleto;
    }
    
    public void setFinalizado()
    {        
        realizando=false;
        incompleto=false;
        completado=true;
    }
    
    public boolean getFinalizado()
    {
        return completado;
    }
    //public
    public String toString()
    {
        if(realizando)
        {
            return "Realizando";
        }
        else if(incompleto)
        {
            return "Sin completar";
        }
        else if(completado)
        {
            return "Completo";
        }
        
        return "En espera";
    }
}
