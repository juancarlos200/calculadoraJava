import java.util.ArrayList;

public class VPila<T> implements Pila<T> {

    ArrayList<T> elementos = new ArrayList<>();
// agregar elemento a el top de la pila
    @Override
    public void push(T elemento) {
        elementos.add(elemento);
    }
//obtiene el ultimo elemento de la pila y lo elimina
    @Override
    public T pop() {
        T valor = elementos.get(elementos.size() - 1);
        elementos.remove(elementos.size() - 1);
        return valor;
    }
//Obtiene ultimo elemento sin eliminar 
    @Override
    public T peek() {
        T valor = elementos.get(elementos.size() - 1);
        return valor;
    }
// ver si la pila esta vacia
    @Override
    public boolean empty() {
        if (elementos.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
//cantidad elementos en pila
    @Override
    public int size() {
        int cantidad = elementos.size();
        return cantidad;
    }
}
