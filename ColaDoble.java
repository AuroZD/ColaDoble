
import java.util.Iterator;

public class ColaDoble <Item> implements iterable <Item>
{
    public static int VACIO = 0;
    public static int TIERRA = -1;
    public static int CAPACIDAD_INICIAL = 2;
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
    dato = tamanio == MaximaCapacidad; /*tambien puede ser si el que sigue de ultimo es primero, y el que antecede a primero es ultimo*/ /*si esto es cierto debe ser amortizada*/
    return dato;
   }
    
    public boolean estaVacia() /*¿Esta vacia la cola?*/
 {
   boolean dato;
                dato = tamanio == VACIO; /*si ambos apuntan al mismo no hay ningun elemento */
    return dato;
   }


    public int tamanyo() /*¿Cuántos elemento hay?*/
        {
        return tamanio;
        }

    public void insertaInicio(Item item) /*Encolar un dato generico*/
        {
        if (--IndicePrimero != TIERRA) /* si el que antecede es tierra no se puede introducir nada*/
        {
        arreglo[IndicePrimero] = item; /*Se almacena el dato en el anterior al indice*/
        tamanio++;
        }
        else/*Si el que antecede es tierra */
        {
        if(!estaLlena()) /*Si no esta llena se puede mover al otro extremo*/
        {
        IndicePrimero = MaximaCapacidad - 1 ;
        arreglo[IndicePrimero] = item;
        tamanio++;
        }
        else
        {
        amortizar(tamanio*2); /*redimenciona la pila*/
        }    
        }   
        }
    
    public void insertaFinal(Item item) /*Encolar un dato generico*/
    {
    if (++IndiceUltimo == MaximaCapacidad)
    {
        IndiceUltimo = 0;  /* lo devuelve al inicio*/
    }
    if (!estaLlena()) 
     
    {
        arreglo[IndiceUltimo] = item;
        tamanio++;
    }
     else {
      amortizar(tamanio*2); /* Redimensionar el arreglo */
    }

    }
public void amortizar(int TamanioNuevo) /*metodo para cuando la pila este llena o a 1/4 de su capacidad*/
 {
  int i;
  Item[] arregloCopia = (Item[]) new Object[TamanioNuevo];
  for (i=0; i<tamanio; i++)
  {
   arregloCopia[i] = arreglo[(IndicePrimero+i)%MaximaCapacidad];
  }
  arregloCopia = arreglo;
  IndicePrimero = 0;
  IndiceUltimo = tamanio;
  MaximaCapacidad = TamanioNuevo;
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
