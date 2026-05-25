//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import Principal.MyLinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== TESTES DA ATIVIDADE DE ESTRUTURA DE DADOS ===\n");

        // TESTE DA QUESTÃO 1: Inserção Ordenada
        System.out.println("1. Teste addSorted (Questão 1):");
        MyLinkedList<Integer> lista1 = new MyLinkedList<>();
        lista1.addSorted(20);
        lista1.addSorted(5);
        lista1.addSorted(47);
        lista1.addSorted(4);
        lista1.addSorted(19);
        imprimirLista(lista1); // Deve mostrar: 4 -> 5 -> 19 -> 20 -> 47


        // TESTE DA QUESTÃO 2: Deletar sem predecessor
        System.out.println("\n2. Teste Delete Without Predecessor (Questão 2):");
        // Vamos remover o número 19 (que está no índice 2)
        lista1.removerNoIntermediarioPorIndice(2);
        imprimirLista(lista1); // Deve mostrar: 4 -> 5 -> 20 -> 47


        // TESTE DA QUESTÃO 3: Inverter a Lista
        System.out.println("\n3. Teste Reverse (Questão 3):");
        lista1.reverse();
        imprimirLista(lista1); // Deve mostrar a lista invertida: 47 -> 20 -> 5 -> 4


        // TESTE DA QUESTÃO 4: Merge de Listas
        System.out.println("\n4. Teste Merge Two Sorted Lists (Questão 4):");
        MyLinkedList<Integer> listaA = new MyLinkedList<>();
        listaA.addLast(1); listaA.addLast(3); listaA.addLast(5); listaA.addLast(7);

        MyLinkedList<Integer> listaB = new MyLinkedList<>();
        listaB.addLast(2); listaB.addLast(4); listaB.addLast(6); listaB.addLast(8);

        System.out.print("Lista A: "); imprimirLista(listaA);
        System.out.print("Lista B: "); imprimirLista(listaB);

        listaA.merge(listaB);
        System.out.print("Lista Merged: ");
        imprimirLista(listaA); // Deve mostrar: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8


        // TESTE DA QUESTÃO 5: Remover o N-ésimo do final
        System.out.println("\n5. Teste Remove Nth From End (Questão 5):");
        System.out.print("Lista original: "); imprimirLista(listaA);

        // Removendo o 2º elemento a partir do final (que será o número 7)
        System.out.println("Removendo o 2º nó a partir do final (n=2)...");
        listaA.removeNthFromEnd(2);
        imprimirLista(listaA); // O número 7 deve sumir da lista
    }

    // Método auxiliar para imprimir os elementos no console durante o teste
    public static void imprimirLista(MyLinkedList<Integer> lista) {
        if (lista.size() == 0) {
            System.out.println("Lista Vazia");
            return;
        }
        for (int i = 0; i < lista.size(); i++) {
            System.out.print(lista.get(i) + " -> ");
        }
        System.out.println("null");
    }
}
