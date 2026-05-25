package Principal;

public interface MyList<T> {

    void addFirst(T element);
    void addLast(T element);
    void insertAt(int index, T element);
    void addSorted(T element);

    // Operações de remoção
    T removeFirst();
    T removeLast();
    T removeAt(int index);
    boolean remove(T element);

    // --- NOVOS MÉTODOS ADICIONADOS PARA A ATIVIDADE ---
    void reverse();
    void removeNthFromEnd(int n);

    // Operações de consulta e gerenciamento
    void clear();
    int find(T element);
    T get(int index);
    void set(int index, T element);
    int size();

}
