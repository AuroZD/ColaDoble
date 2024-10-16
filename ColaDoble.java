package colaDoble;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Clase que implementa una cola doble.
 * @param <Item> tipo de elementos que almacena la cola.
 */
public class ColaDoble<Item> implements Iterable<Item> {
    private static final int VACIO = 0;
    private static final int CUARTOCAPACIDAD = 4;
    private static final int CAPACIDAD_INICIAL = 2;
    private int tamanio; /* para saber cuando puedo hacer la amortizacion */
    private int maximaCapacidad;
    private int indicePrimero; /* el primer elemento */
    private int indiceUltimo; /* el ultimo elemento */
    private Item[] arreglo;

    /**
 * Crea una nueva instancia de ColaDoble.
 * Inicializa la cola con una capacidad inicial definida
 * y establece los indices y el tamanio en cero.
 */
    public ColaDoble() { /* Construye una cola */
        arreglo = (Item[]) new Object[CAPACIDAD_INICIAL];
        indicePrimero = 0; // Asignar 0 a indicePrimero
        indiceUltimo = 0;  // Asignar 0 a indiceUltimo
        tamanio = 0;       // Asignar 0 a tamanio
        maximaCapacidad = CAPACIDAD_INICIAL; // Asignar la capacidad inicial
    }
  /**
     * Verifica si la cola esta llena.
     * @return true si la cola esta llena, false en caso contrario.
     */
    public boolean estaLlena() { /* Esta llena la cola?*/
        return tamanio == maximaCapacidad;
    }
/**
     * Verifica si la cola esta vacia.
     * @return true si la cola esta vacia, false en caso contrario.
     */
    public boolean estaVacia() { /* Esta vacia la cola? */
        return tamanio == VACIO;
    }

/**
     * Verifica el tamanio de la cola.
     * @return tamanio el tamanio del arreglo
     */
    public int tamanyo() { /* Cuantos elementos hay? */
        return tamanio;
    }
/**
     * Inserta un elemento al inicio de la cola.
     * @param item el elemento a insertar.
     * @throws NullPointerException si el item es nulo.
     */
    public void insertaInicio(Item item) {
        /* Mueve el indice hacia atras primero y luego inserta */
        if (item == null) {
            throw new NullPointerException("El item no puede ser nulo");
        }
        if (estaLlena()) {
            amortizar(maximaCapacidad * 2);
        }
        indicePrimero = (indicePrimero - 1
        + maximaCapacidad) % maximaCapacidad;
        /* para que sea circular lo disminuyo en uno */
        arreglo[indicePrimero] = item;
        tamanio++;
    }
    /**
     * Inserta un elemento al final de la cola.
     * @param item el elemento a insertar.
     * @throws NullPointerException si el item es nulo.
     */
    public void insertaFinal(Item item) {
        /* Inserta primero y luego mueve el indice hacia adelante */
        if (item == null) {
            throw new NullPointerException("El item no puede ser nulo");
        }
        if (estaLlena()) {
            amortizar(maximaCapacidad * 2);
        }
        arreglo[indiceUltimo] = item;
        indiceUltimo = (indiceUltimo + 1) % maximaCapacidad;
         /* para que sea circular lo aumento en uno */
        tamanio++;
    }
 /**
     * Realiza la amortizacion de la cola.
     * @param tamanioNuevo el nuevo tamanio de la cola.
     */
    public void amortizar(int tamanioNuevo) {
        /* metodo para cuando la cola esta llena o a 1/4 de su capacidad */
        if (tamanioNuevo < 1) {
            throw new IllegalArgumentException(
                "El tamanio nuevo debe ser al menos 1");
        }
        Item[] arregloCopia = (Item[]) new Object[tamanioNuevo];
        for (int i = 0; i < tamanio; i++) {
            arregloCopia[i] = arreglo[(indicePrimero + i) % maximaCapacidad];
        }
        arreglo = arregloCopia;
        indicePrimero = 0;
        indiceUltimo = tamanio;
        maximaCapacidad = tamanioNuevo;
    }
    /**
     * Suprime un elemento del inicio de la cola.
     * @return el elemento suprimido.
     * @throws NoSuchElementException si la cola esta vacia.
     */
    public Item suprimeInicio() throws NoSuchElementException {
        /* Desencolar un dato generico */
        if (estaVacia()) {
            throw new NoSuchElementException("Cola vacia");
        }
        Item dato = arreglo[indicePrimero];
        indicePrimero = (indicePrimero + 1) % maximaCapacidad;
        /* forma de hacerlo circular */
        tamanio--;
        if (tamanio == maximaCapacidad / CUARTOCAPACIDAD
         && maximaCapacidad > 1) {
            amortizar(maximaCapacidad / 2);
        }
        return dato;
    }
    /**
     * Suprime un elemento del final de la cola.
     * @return el elemento suprimido.
     * @throws NoSuchElementException si la cola esta vacia.
     */
    public Item suprimeFinal() throws NoSuchElementException {
        /* Desencolar un dato generico */
        if (estaVacia()) {
            throw new NoSuchElementException("Cola vacia");
        }
        indiceUltimo = (indiceUltimo - 1 + maximaCapacidad) % maximaCapacidad;
        /* forma de hacerlo circular */
        Item dato = arreglo[indiceUltimo];
        tamanio--;
        if (tamanio == maximaCapacidad / CUARTOCAPACIDAD
         && maximaCapacidad > 1) {
            amortizar(maximaCapacidad / 2);
        }
        return dato;
    }
  /**
     * Crea un iterador para la cola.
     * @return un iterador sobre los elementos de la cola.
     */
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private int actual = indicePrimero;
            private int contador = 0;

            @Override
            public boolean hasNext() {
                return contador < tamanio;
            }

            @Override
            public Item next() {
                if (!hasNext()) {
                    throw new NoSuchElementException(
                        "No hay mas elementos en el iterador");
                }
                Item item = arreglo[actual];
                actual = (actual + 1) % maximaCapacidad;
                contador++;
                return item;
            }
        };
    }
}