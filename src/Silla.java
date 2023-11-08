
/**
 * Clase que contiene las caracteristicas basica de una silla
 * 
 * @author Oscar Rico Martinez 
 * @version 25/05/2020
 */
public abstract class Silla extends Mueble
{
    // instance variables - replace the example below with your own
    private boolean reposaBrazos;
    private String tipoSilla;

    /**
     * Constructor for objects of class Silla
     */
    public Silla(int idCliente, int cantidad, boolean reposaBrazos)
    {
        // initialise instance variables
        super(idCliente);
        this.reposaBrazos=reposaBrazos;
        setCantidad(cantidad);
    }
    
    /**
     * Establece el tipo de silla
     */
    public void setTipoSilla(String tipoSilla)
    {
        this.tipoSilla=tipoSilla;
    }
    
    /**
     * devuelve el tipo de silla
     */
    public String getTipoSilla()
    {
        return tipoSilla;
    }
    
    /**
     * Define si tiene reposa brazos
     */
    public boolean getReposaBrazos()
    {
        return reposaBrazos;
    }
    
    public String reposaBrazos()
    {
        if(getReposaBrazos()) {
            return "si";
        }
        else {
            return "no";
        }
    }
}
