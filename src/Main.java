import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaEncadeada filaTriagem = new ListaEncadeada();

        int opcao = -1;

        System.out.println("=== SISTEMA DE TRIAGEM HOSPITALAR ===\n");

        while (opcao != 0) {
            System.out.println("1 - Cadastrar novo paciente");
            System.out.println("2 - Exibir fila atual");
            System.out.println("3 - Cancelar Atendimento");
            System.out.println("4 - Chamar primeiro paciente");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                System.out.println("\n-- DADOS DO PACIENTE --");

                System.out.print("Nome: ");
                String nome = sc.nextLine();

                System.out.print("Urgência (GRAVE, IDOSO, COMUM): ");
                String urgenciaTexto = sc.nextLine().toUpperCase();
                Urgencia urgencia = Urgencia.valueOf(urgenciaTexto);

                System.out.print("Horário de chegada (formato HH:MM, ex: 14:30): ");
                String horarioTexto = sc.nextLine();
                LocalTime chegada = LocalTime.parse(horarioTexto);

                Paciente novoPaciente = new Paciente(nome, urgencia, chegada);

                filaTriagem.inserirOrdenado(novoPaciente);

                System.out.println("\n Paciente cadastrado e posicionado na fila! \n");

            } else if (opcao == 2) {
                System.out.println("\n-- FILA DE ATENDIMENTO ATUAL --\n");
                filaTriagem.exibirLista();
                System.out.println();

            } else if (opcao == 3) {
                System.out.println("\n-- REMOVER PACIENTE --\n");
                System.out.print("Digite o nome exato do paciente que deseja remover: ");
                String nomeParaRemover = sc.nextLine();

                boolean sucesso = filaTriagem.removerPorNome(nomeParaRemover);
                if (sucesso) {
                    System.out.println("\n Paciente " + nomeParaRemover + " removido da fila com sucesso.\n");
                } else {
                    System.out.println("\n Paciente " + nomeParaRemover + " não encontrado na fila. \n");
                }

            } else if (opcao == 4) {
                System.out.println("\n-- CHAMADA MÉDICA -- \n");

                Paciente pacienteChamado = filaTriagem.chamarProximoPaciente();

                if (pacienteChamado != null) {
                    System.out.println("ATENÇÃO: Paciente " + pacienteChamado.nome +
                            " (" + pacienteChamado.urgencia + "), dirija-se ao consultório.");
                } else {
                    System.out.println("A fila de triagem está vazia no momento.");
                }
            } else if (opcao != 0) {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        System.out.println("Sistema encerrado.");
        sc.close();
    }
}