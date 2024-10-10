import java.util.Iterator;

public class ColaDoble <Item> implements iterable <Item>
{
    public static int CAPACIDAD_INICIAL = 1;
    private int tamanio; /*para saber cuando puedo hacer la amortizacion*/
    private int MaximaCapacidad;
    private int IndicePrimero; /*el primer elemento*/
    private int IndiceUltimo; /*el ultimo elemento */
    private Item[] arreglo;
   
    public ColaDoble () /*Construye una cola*/
        {
        arreglo = (Item[]) new Object[CAPACIDAD_INICIAL];
        IndicePrimero = IndiceUltimo = tamanio = 0;
        MaximaCapacidad = CAPACIDAD_INICIAL;
        }

   public boolean estaLlena() /*¿Esta llena la cola?*/
   {
    boolean dato;
    if(tamanio == MaximaCapacidad)
    /*tambien puede ser si el que sigue de ultimo es primero, y el que antecede a primero es ultimo*/
    {
    dato = true;
    /*si esto es cierto debe ser amortizada*/
    }
    else
    {
    dato = false;
    }
    return dato;
   }
    
    public boolean estaVacia() /*¿Esta vacia la cola?*/
        {
                boolean dato;
        if(IndicePrimero == IndiceUltimo)
        {
    dato = true;
    /*si esto es cierto debe ser amortizada*/
    }
    else
    {
    dato = false;
    }
    return dato;
   }


    public int tamanyo() /*¿Cuántos elemento hay?*/
        {
        return 1;
        }

    public void insertaInicio(Item item) /*Encolar un dato generico*/
        {
        
        
        }
    
    public void insertaFinal(Item item) /*Encolar un dato generico*/
    {

    }

    public Item suprimeInicio() /*Desencolar un dato generico*/
{
return null;

}
public Item suprimeFinal() /*Desencolar un dato generico*/
{
        return null;
}
public Iterator<Item> iterator() 
        /*retorna un iterador independiente sobre los datos de la cola desde el frente hacia el final*/
{

        return null;

}

}