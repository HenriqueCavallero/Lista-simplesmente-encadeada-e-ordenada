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

                System.out.println("Paciente cadastrado e posicionado na fila!");

            } else if (opcao == 2) {
                System.out.println("\n-- FILA DE ATENDIMENTO ATUAL --\n");
                filaTriagem.exibirLista();
                System.out.println();

            } else if (opcao != 0) {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        System.out.println("Sistema encerrado.");
        sc.close();
    }
}