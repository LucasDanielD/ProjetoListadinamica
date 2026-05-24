package Principal;

public class MyLinkedList<T> implements MyList<T> {

    private Node head;
    private int size;

    private class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }



    @Override
    public void addFirst(T element) {
        Node newNode = new Node(element);

        newNode.next = head;

        head = newNode;
        size++;

    }

    @Override
    public void addLast(T element) {
        Node newNode = new Node(element);


        if (head == null) {
            head = newNode;
        } else {

            Node current = head;
            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }
        size++;

    }

    @Override
    public void insertAt(int index, T element) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("Índice fora dos limites");

        if (index == 0) {
            addFirst(element);
            return;
        }

        Node newNode = new Node(element);
        Node current = head;


        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }


        newNode.next = current.next;

        current.next = newNode;
        size++;

    }

    @Override
    @SuppressWarnings("unchecked")
    public void addSorted(T element) {

        Node newNode = new Node(element);

        if (head == null || ((Comparable<T>) head.data).compareTo(element) >= 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null && ((Comparable<T>) current.next.data).compareTo(element) < 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }


    @Override
    public T removeFirst() {
        if (head == null) return null;

        T removedData = head.data;

        head = head.next;
        size--;
        return removedData;

    }

    @Override
    public T removeLast() {
        if (head == null) return null;

        if (head.next == null) {
            return removeFirst();
        }

        Node current = head;

        while (current.next.next != null) {
            current = current.next;
        }

        T removedData = current.next.data;

        current.next = null;
        size--;
        return removedData;

    }

    @Override
    public T removeAt(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Índice fora dos limites");

        if (index == 0) return removeFirst();

        Node current = head;

        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        T removedData = current.next.data;

        current.next = current.next.next;
        size--;
        return removedData;
    }

    @Override
    public boolean remove(T element) {
        if (head == null) return false;


        if (head.data.equals(element)) {
            head = head.next;
            size--;
            return true;
        }

        Node current = head;

        while (current.next != null && !current.next.data.equals(element)) {
            current = current.next;
        }


        if (current.next != null) {
            current.next = current.next.next;
            size--;
            return true;
        }

        return false;
    }



    @Override
    public void clear() {

        head = null;
        size = 0;
    }

    @Override
    public int find(T element) {
        Node current = head;
        int index = 0;

        while (current != null) {
            if (current.data.equals(element)) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Índice fora dos limites");

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public void set(int index, T element) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Índice fora dos limites");

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = element;
    }

    @Override
    public int size() {
        return this.size;
    }
}