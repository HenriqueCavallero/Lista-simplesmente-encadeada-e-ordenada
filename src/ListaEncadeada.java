public class ListaEncadeada {
    No cabeca;
    No cauda;

    public void inserirOrdenado(int dado) {
        No novoNo = new No(dado);

        if (cabeca == null || cabeca.dado >= novoNo.dado) {
            novoNo.proximo = cabeca;
            cabeca = novoNo;

            if (cauda == null) {
                cauda = novoNo;
            }
        } else {
            No atual = cabeca;

            while (atual.proximo != null && atual.proximo.dado < novoNo.dado) {
                atual = atual.proximo;
            }

            novoNo.proximo = atual.proximo;
            atual.proximo = novoNo;

            if (novoNo.proximo == null) {
                cauda = novoNo;
            }
        }
    }

    public void exibirLista() {
        No noAtual = cabeca;
        if (noAtual == null) {
            System.out.println("Lista vazia");
        } else {
            while (noAtual != null) {
                System.out.print(noAtual.dado + " -> ");
                noAtual = noAtual.proximo;
            }
            System.out.println("nulo");
        }
    }
}

