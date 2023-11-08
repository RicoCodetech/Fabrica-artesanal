
/**
 * Contiene los metodos que instancia las subclases Mueble y contabiliza
 * el historico de pedidos 
 * 
 * @author Oscar Rico Martinez
 * @version 19/05/2020
 */
public class Pedido
{   
    int contador_mesaDormitorio;
    int contador_mesaComedor;
    int contador_mesaCafeMadera;
    int contador_mesaCafeCristal;
    int contador_sillasCocina;
    int contador_sillasPlegable;
    int contador_sillasConRuedas;
    int contador_sillasSinRuedas;
    
    public void Pedido()
    {
        contador_mesaDormitorio=0;
        contador_mesaComedor=0;
        contador_mesaCafeMadera=0;
        contador_mesaCafeCristal=0;
        contador_sillasCocina=0;
        contador_sillasPlegable=0;
        contador_sillasConRuedas=0;
        contador_sillasSinRuedas=0;
    }
    
    /**
     * Solo es para el inicio de la fabrica(Recomendado)
     */
    public void sumaLosPedidosIniciales()
    {
        contador_mesaDormitorio=contador_mesaDormitorio+2;
    }
    
    /**
     * Instancia mesa dormitorio
     * @param idCliente El del cliente
     * @param alturaCm La altura del mueble en centimetros
     * @param largoCm El largo del mueble en centimetros
     * @param anchoCm El ancho del mueble en centimetros
     * @param numeroCajones El numero de cajones en unidades
     * @param cantidad La cantidad del mismo mueble en unidades
     * @return mesaDormitorio
     */
    public Mueble addMesaDormitorio(int idCliente, int alturaCm, int largoCm, int anchoCm, int numeroCajones, int cantidad)
    {
        Mueble mesaDormitorio= new MesaDormitorio(idCliente,alturaCm,largoCm,anchoCm,numeroCajones,cantidad);
        contador_mesaDormitorio+=cantidad;
        return mesaDormitorio;
    }
    
     /**
     * Instancia mesa comedor
     * @param idCliente El del cliente
     * @param alturaCm La altura del mueble en centimetros
     * @param largoCm El largo del mueble en centimetros
     * @param anchoCm El ancho del mueble en centimetros
     * @param cantidad La cantidad del mismo mueble en unidades
     * @return mesaComedor
     */
    public Mueble addMesaComedor(int idCliente,int alturaCm, int largoCm, int anchoCm,int cantidad)
    {
        Mueble mesaComedor= new MesaComedor(idCliente,alturaCm, largoCm, anchoCm, cantidad);
        contador_mesaComedor+=cantidad;
        return mesaComedor;
    }    
    
     /**
     * Instancia mesa cafe de madera
     * @param idCliente El del cliente
     * @param alturaCm La altura del mueble en centimetros
     * @param largoCm El largo del mueble en centimetros
     * @param anchoCm El ancho del mueble en centimetros
     * @param cantidad La cantidad del mismo mueble en unidades
     * @return mesaCafeMadera
     */
    public Mueble addMesaCafeMadera(int idCliente,int alturaCm, int largoCm, int anchoCm,int cantidad)
    {
        Mueble mesaCafeMadera= new MesaCafeMadera(idCliente,alturaCm, largoCm, anchoCm, cantidad);
        contador_mesaCafeMadera+=cantidad;
        return mesaCafeMadera;
    } 
    
     /**
     * Instancia mesa cafe de cristal
     * @param idCliente El del cliente
     * @param alturaCm La altura del mueble en centimetros
     * @param largoCm El largo del mueble en centimetros
     * @param anchoCm El ancho del mueble en centimetros
     * @param cantidad La cantidad del mismo mueble en unidades
     * @return mesaCafeCristal
     */
    public Mueble addMesaCafeCristal(int idCliente,int alturaCm, int largoCm, int anchoCm,int cantidad)
    {
        Mueble mesaCafeCristal= new MesaCafeCristal(idCliente,alturaCm, largoCm, anchoCm, cantidad);
        contador_mesaCafeCristal+=cantidad;
        return mesaCafeCristal;
    }   
    
    /**
    * Instancia silla de cocina
    * @param idCliente El del cliente
    * @param cantidad El numero de unidades
    * @param reposaBrazos Tiene o no reposa brazos
    * @return sillaCocina
    */
    public Mueble addSillaCocina(int idCliente,int cantidad, boolean reposaBrazos)
    {
        Mueble sillaCocina= new SillaCocina(idCliente,cantidad, reposaBrazos);
        contador_sillasCocina+=cantidad;
        return sillaCocina;
    }   
    
    /**
    * Instancia silla plegable
    * @param idCliente El del cliente
    * @param cantidad El numero de unidades
    * @param reposaBrazos Tiene o no reposa brazos
    * @return sillaPlegable
    */
    public Mueble addSillaPlegable(int idCliente,int cantidad, boolean reposaBrazos)
    {
        Mueble sillaPlegable= new SillaPlegable(idCliente,cantidad, reposaBrazos);
        contador_sillasPlegable+=cantidad;
        return sillaPlegable;
    }
    
    /**
    * Instancia silla con ruedas
    * @param idCliente El del cliente
    * @param cantidad El numero de unidades
    * @param reposaBrazos Tiene o no reposa brazos
    * @return sillaConRuedas
    */
    public Mueble addSillaConRuedas(int idCliente,int cantidad, boolean reposaBrazos)
    {
        Mueble sillaConRuedas= new SillaConRuedas(idCliente,cantidad, reposaBrazos);
        contador_sillasConRuedas+=cantidad;
        return sillaConRuedas;
    }  
    
    /**
    * Instancia silla sin ruedas
    * @param idCliente El del cliente
    * @param cantidad El numero de unidades
    * @param reposaBrazos Tiene o no reposa brazos
    * @return sillaSinRuedas
    */
    public Mueble addSillaSinRuedas(int idCliente,int cantidad, boolean reposaBrazos)
    {
        Mueble sillaSinRuedas= new SillaSinRuedas(idCliente,cantidad, reposaBrazos);
        contador_sillasSinRuedas+=cantidad;
        return sillaSinRuedas;
    } 
    

    /**
     * Historial total del numero de muebles pedidos
     */
    public String historialPedidos()
    {
        return "TIPO DE MUEBLE:        Cantidad" + "\n---------------------- --------" + "\nMesa de dormitorio:       " + contador_mesaDormitorio + "\nMesa de comedor:          " + contador_mesaComedor + "\nMesa de cafe madera:      " + contador_mesaCafeMadera +  "\nMesa de cafe cristal:     " + contador_mesaCafeCristal +
               "\nSilla de cocina:          " + contador_sillasCocina + "\nSilla plegable:           " + contador_sillasPlegable + "\nSilla con ruedas:         " + contador_sillasConRuedas +
               "\nSilla sin ruedas:         " + contador_sillasSinRuedas;
    }

}
