public class ListaDoblementeEnlazada<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;


    // Métodos para la lista doblemente enlazada

    // Insertar al inicio
    public void insertarInicio(E value) {
        Node<E> newNode = new Node<E>(value);
        if (null == head) {
            /* If list is empty */
            newNode.next = null;
            newNode.prev = null;
            head = newNode;
            tail = newNode;
            size++;
        } else {
            newNode.next = head;
            newNode.prev = null;
            head.prev = newNode;
            head = newNode;
            size++;
        }
    }

    // Insertar al final
    public void insertarFinal(E value) {
        Node<E> newNode = new Node<E>(value);
        if (null == tail) {
            /* If list is empty */
            newNode.next = null;
            newNode.prev = null;
            head = newNode;
            tail = newNode;
            size++;
        } else {
            tail.next = newNode;
            newNode.next = null;
            newNode.prev = tail;
            tail = newNode;
            size++;
        }
    }

    // Recorrer hacia adelante
    public void recorrerAdelante() {
        Node<E> temp = head;
        while (temp != null) {
            System.out.println(temp.item);
            temp = temp.next;
        }
    }

    // Recorrer hacia atrás
    public void recorrerAtras() {
        Node<E> temp = tail;
        while (temp != null) {
            System.out.println(temp.item);
            temp = temp.prev;
        }
    }

    // Mostrar tamaño de la lista
    public int size() {
        return size;
    }

    // Mostrar si la lista está vacía
    public boolean isEmpty() {
        return size == 0;
    }

    // Buscar elemento por valor
    public Node<E> elementoValor(E value) {
        Node<E> temp = head;
        while (null != temp.next && temp.item != value) {
            temp = temp.next;
        }
        if (temp.item == value) {
            return temp;
        }
        return null;
    }

    // Buscar elemento por índice
    public Node<E> elementoIndice(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Se pasó un índice no válido mientras se buscaba un valor");
        }
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }


    // Borrar un elemento
    public void deleteFromPosition(int position) {
        if (position < 0 || position >= size) {
            throw new IllegalArgumentException("La posición no es válida");
        }
        /* Conditions check passed, let's delete the node */
        Node<E> nodeToBeDeleted = head;
        for (int i = 0; i < position; i++) {
            nodeToBeDeleted = nodeToBeDeleted.next;
        }
        Node<E> previousNode = nodeToBeDeleted.prev;
        Node<E> nextNode = nodeToBeDeleted.next;
        previousNode.next = nextNode;
        nextNode.prev = previousNode;
        size--;
    }
}