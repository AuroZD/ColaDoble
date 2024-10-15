
import java.util.Iterator;
import java.util.NoSuchElementException;

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

    public void insertaInicio(Item item) /* Mueve el índice hacia atrás primero y luego inserta*/
    {
    IndicePrimero = (IndicePrimero - 1 + MaximaCapacidad) % MaximaCapacidad; /*para que sea circular lo disminuyo en uno*/
    if (estaLlena()) 
    {
        amortizar(MaximaCapacidad * 2);
    }
    arreglo[IndicePrimero] = item;
    tamanio++;
}

public void insertaFinal(Item item)  /*Inserta primero y luego mueve el índice hacia adelante*/
{
    if (estaLlena()) 
    {
        amortizar(MaximaCapacidad * 2);
    }
    arreglo[IndiceUltimo] = item;
    IndiceUltimo = (IndiceUltimo + 1) % MaximaCapacidad; /*para que sea circular lo ahumento en uno*/
    tamanio++;
}
public void amortizar(int TamanioNuevo) /*metodo para cuando la pila este llena o a 1/4 de su capacidad*/
 {
  int i;
  Item[] arregloCopia = (Item[]) new Object[TamanioNuevo];
  for (i=0; i<tamanio; i++)
  {
   arregloCopia[i] = arreglo[(IndicePrimero+i)%MaximaCapacidad];
  }
  arreglo = arregloCopia;
  IndicePrimero = 0;
  IndiceUltimo = tamanio;
  MaximaCapacidad = TamanioNuevo;
 }
 
    /**
     *
     * @return
     * @throws NoSuchElementException
     */
    public Item suprimeInicio() throws  NoSuchElementException
/*Desencolar un dato generico*/
    {
    if (estaVacia()) 
    {
        throw new NoSuchElementException("Cola Vacia");
    }
    Item dato = arreglo[IndicePrimero];
    IndicePrimero = (IndicePrimero + 1) % MaximaCapacidad; /* forma de hacerlo circular*/
    tamanio--;
    if (tamanio == MaximaCapacidad/4)
    {
    amortizar(MaximaCapacidad/2);
    }
    return dato;
    }
    
     /**
     *
     * @return
     * @throws NoSuchElementException
     */
public Item suprimeFinal() throws  NoSuchElementException 
    /*Desencolar un dato generico*/
{
    if (estaVacia()) 
    {
        throw new NoSuchElementException("Cola Vacia");
    }
    Item dato = arreglo[IndiceUltimo];
    IndiceUltimo = (IndiceUltimo - 1) % MaximaCapacidad; /* forma de hacerlo circular*/
    tamanio--;
    if (tamanio == MaximaCapacidad/4)
    {
    amortizar(MaximaCapacidad/2);
    }
    return dato;
    }

public Iterator<Item> iterator() {
    return new Iterator<Item>() 
    {
        private int actual = IndicePrimero;
        private int contador = 0;

        @Override
        public boolean hasNext()
        {
            return contador < tamanio;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = arreglo[actual];
            actual = (actual + 1) % MaximaCapacidad;
            contador++;
            return item;
        }
    };
}

}