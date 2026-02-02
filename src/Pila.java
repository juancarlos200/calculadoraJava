// T es generico que acepta cualquier tipo de dato
interface Pila<T> {
    // Elememtno en el tope de la pila
    void push(T elemento);
// elimina y devuelve el elemento del tope de la pila
    T pop();
//Elemento del tope sin borrarlo 
    T peek();
//Pila vacia 
    boolean empty();
//Dice la cantidad de elementos en una pila
    int size();
}