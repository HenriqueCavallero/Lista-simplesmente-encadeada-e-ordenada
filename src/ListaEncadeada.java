public class ListaEncadeada {
    No cabeca;
    No cauda;

    public void inserirOrdenado(Paciente paciente) {
        No novoNo = new No(paciente);

        if (cabeca == null) {
            cabeca = novoNo;
            cauda = novoNo;
            return;
        }
        boolean urgenciaMaior = novoNo.paciente.urgencia.ordinal() < cabeca.paciente.urgencia.ordinal();
        boolean mesmaUrgencia = novoNo.paciente.urgencia == cabeca.paciente.urgencia;
        boolean chegouAntes = novoNo.paciente.chegada.isBefore(cabeca.paciente.chegada);

        if (urgenciaMaior || (mesmaUrgencia && chegouAntes)) {
            novoNo.proximo = cabeca;
            cabeca = novoNo;
            return;
        }
        No atual = cabeca;

        while (atual.proximo != null) {
            boolean proximoEMaisUrgente = atual.proximo.paciente.urgencia.ordinal() < novoNo.paciente.urgencia.ordinal();
            boolean proximoTemMesmaUrgencia = atual.proximo.paciente.urgencia == novoNo.paciente.urgencia;
            boolean proximoChegouAntes = !novoNo.paciente.chegada.isBefore(atual.proximo.paciente.chegada);

            if (proximoEMaisUrgente || (proximoTemMesmaUrgencia && proximoChegouAntes)) {
                atual = atual.proximo;
            } else {
                break;
            }
        }
        novoNo.proximo = atual.proximo;
        atual.proximo = novoNo;

        if (novoNo.proximo == null) {
            cauda = novoNo;
        }
    }

    public boolean removerPorNome(String pacienteCancelado) {
        if (cabeca == null) {
            return false;
        }
        if (cabeca.paciente.nome.equals(pacienteCancelado)) {
            cabeca = cabeca.proximo;

            if (cabeca == null) {
                cauda = null;
            }
            return true;
        }
        No atual = cabeca;

        while (atual.proximo != null) {
            if (atual.proximo.paciente.nome.equals(pacienteCancelado)) {

                atual.proximo = atual.proximo.proximo;

                if (atual.proximo == null) {
                    cauda = atual;
                }
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    public Paciente chamarProximoPaciente() {
        if (cabeca == null) {
            return null;
        }

        Paciente pacienteAtendido = cabeca.paciente;

        cabeca = cabeca.proximo;

        if (cabeca == null) {
            cauda = null;
        }

        return pacienteAtendido;
    }

    public void exibirLista() {
        No noAtual = cabeca;
        if (noAtual == null) {
            System.out.print("Lista vazia");
        } else {
            while (noAtual != null) {
                System.out.print(noAtual.paciente + "\n | \n" + " V \n");
                noAtual = noAtual.proximo;
            }
            System.out.print("nulo");
        }
    }
}