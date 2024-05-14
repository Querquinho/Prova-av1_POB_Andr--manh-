import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorProdutos gerenciador = new GerenciadorProdutos();

        gerenciador.processa(scanner);

        scanner.close();
    }
}
