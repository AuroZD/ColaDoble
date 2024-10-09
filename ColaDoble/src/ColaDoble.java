import java.util.Iterator;

public class ColaDoble <Item> implements iterable <Item>
{
    public static int CAPACIDAD_INICIAL = 1;
    private int tamaño; //para saber cuando puedo hacer la amortizacion
    private int IndicePrimero; //el primer elemento
    private int IndiceUltimo; //el ultimo elemento 
    private Item[] arreglo;
   
    public ColaDoble () //Construye una cola
        {
        arreglo = (Item[]) new Object[CAPACIDAD_INICIAL];
        IndicePrimero = IndiceUltimo = tamaño = 0;

        }

   
    public boolean estaVacia() //¿Esta vacia la cola?
        {
        return true;
        }

    public int tamanyo() //¿Cuántos elemento hay?
        {
        return 1;
        }

    public void insertaInicio(Item item) //Encolar un dato generico
        {
        }
    
    public void insertaFinal(Item item) //Encolar un dato generico
    {

    }

    public Item suprimeInicio() //Desencolar un dato generico
{
return null;

}
public Item suprimeFinal() //Desencolar un dato generico
{
        return null;
}
public Iterator<Item> iterator() //retorna un iterador independiente sobre los datos de la cola desde el frente hacia el final
{

        return null;

}

}