package Principal;

public class MyLinkedList<T> implements MyList<T>{


    private Node head;

    private int size;


    private class Node {
        T data;       // O valor guardado
        Node next;    // A referência para o próximo Node

        // Construtor do Node
        public Node(T data) {
            this.data = data;
            this.next = null; // Por padrão, o próximo é nulo até que se conecte a algo
        }
    }

    // Construtor da Lista
    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }


    @Override
    public void addFirst(T element) {
        // T
    }

    @Override
    public void addLast(T element) {
        // T
    }

    @Override
    public void insertAt(int index, T element) {
        // T
    }

    @Override
    public void addSorted(T element) {
        // T
    }

    @Override
    public T removeFirst() {
        // T
        return null;
    }

    @Override
    public T removeLast() {
        // T
        return null;
    }

    @Override
    public T removeAt(int index) {
        // T
        return null;
    }

    @Override
    public boolean remove(T element) {
        // T
        return false;
    }

    @Override
    public void clear() {
        // T
    }

    @Override
    public int find(T element) {
        // T
        return -1;
    }

    @Override
    public T get(int index) {
        // T
        return null;
    }

    @Override
    public void set(int index, T element) {
        // T
    }

    @Override
    public int size() {
        return this.size;
    }
}


