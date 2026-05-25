package Principal;

public class MyLinkedList<T> implements MyList<T> {

    private Node head;
    private Node tail; // Adicione esta linha aqui
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
        this.tail = null;
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

    //*********************************************************




    public void deleteNodeWithoutPredecessor(Node p) {
        if (p == null || p.next == null) {
            return;
        }


        p.data = p.next.data;


        Node nodeToDelete = p.next;


        p.next = nodeToDelete.next;


        if (p.next == null) {
            this.tail = p;
        }

        size--;
    }


    public void removerNoIntermediarioPorIndice(int index) {
        if (index < 0 || index >= size - 1) return; // Garante que seja um nó intermediário
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        deleteNodeWithoutPredecessor(current);
    }


    // QUESTÃO 3: (Linked List Reversal)

    @Override
    public void reverse() {
        if (head == null || head.next == null) {
            this.tail = this.head;
            return;
        }

        Node prev = null;
        Node current = head;
        Node next = null;


        this.tail = head;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }


        head = prev;
    }


    // QUESTÃO 4: (Merge Two Sorted Lists)

    @SuppressWarnings("unchecked")
    public void merge(MyLinkedList<T> otherList) {
        if (otherList == null || otherList.head == null) return;


        if (this.head == null) {
            this.head = otherList.head;
            this.tail = otherList.tail;
            this.size = otherList.size;
            otherList.clear();
            return;
        }


        Node dummy = new Node(null);
        Node current = dummy;

        Node p1 = this.head;
        Node p2 = otherList.head;


        while (p1 != null && p2 != null) {
            if (((Comparable<T>) p1.data).compareTo(p2.data) <= 0) {
                current.next = p1;
                p1 = p1.next;
            } else {
                current.next = p2;
                p2 = p2.next;
            }
            current = current.next;
        }


        if (p1 != null) {
            current.next = p1;
        } else {
            current.next = p2;
        }


        this.head = dummy.next;
        this.size += otherList.size;


        Node temp = this.head;
        while (temp != null && temp.next != null) {
            temp = temp.next;
        }
        this.tail = temp;


        otherList.clear();
    }


    // QUESTÃO 5: (Remove Nth Node From End)

    @Override
    public void removeNthFromEnd(int n) {
        if (head == null || n <= 0) return;

        Node dummy = new Node(null);
        dummy.next = head;
        Node fast = dummy;
        Node slow = dummy;


        for (int i = 0; i <= n; i++) {
            if (fast == null) return;
            fast = fast.next;
        }


        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }


        if (slow.next == head) {
            head = head.next;
        }


        if (slow.next == tail) {
            tail = slow;
        }


        slow.next = slow.next.next;
        size--;
    }
}