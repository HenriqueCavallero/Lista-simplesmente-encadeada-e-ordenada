import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um numero: ");
        ListaEncadeada lista = new ListaEncadeada();
        int numero = sc.nextInt();
        while(numero != -0) {
            lista.inserirOrdenado(numero);
            numero = sc.nextInt();
        }

        lista.exibirLista();

    }
}