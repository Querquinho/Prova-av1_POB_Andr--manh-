import java.util.ArrayList;
import java.util.Scanner;

public class gerenciadorProdutos {
    private ArrayList<produto> produtos;

    public gerenciadorProdutos() {
        this.produtos = new ArrayList();
    }

    public void processa(Scanner scanner) {
        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1- Incluir produto");
            System.out.println("2- Alterar produto");
            System.out.println("3- Excluir produto");
            System.out.println("4- Listar todos produtos");
            System.out.println("5- Listar um produto");
            System.out.println("6- Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    incluirProduto(scanner);
                    break;
                case 2:
                    alterarProduto(scanner);
                    break;
                case 3:
                    excluirProduto(scanner);
                    break;
                case 4:
                    listarTodosProdutos();
                    break;
                case 5:
                    listarUmProduto(scanner);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void incluirProduto(Scanner scanner) {
        System.out.println("\nInclusão de Produto");
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Código de Barras: ");
        String codigoBarras = scanner.nextLine();
        System.out.print("SKU: ");
        String sku = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = Double.parseDouble(scanner.nextLine());
        System.out.print("Peso: ");
        double peso = Double.parseDouble(scanner.nextLine());
        System.out.print("Fabricante: ");
        String fabricante = scanner.nextLine();

        produto novoProduto = new produto(id, codigoBarras, sku, nome, descricao, categoria, preco, peso, fabricante);
        produtos.add(novoProduto);

        System.out.println("Produto incluído com sucesso!");
    }

    private void alterarProduto(Scanner scanner) {
            System.out.println("\nAlteração de Produto");
            System.out.print("Informe o SKU do produto que deseja alterar: ");
            String sku = scanner.nextLine();
            boolean produtoEncontrado = false;

            for (produto produto : produtos) {
                if (produto.getSku().equals(sku)) {
                    produtoEncontrado = true;
                    System.out.println("Produto encontrado:");
                    System.out.println(produto);
                    System.out.print("Informe o novo nome do produto: ");
                    String novoNome = scanner.nextLine();
                    produto.setNome(novoNome);
                    System.out.println("Produto alterado com sucesso!");
                    break;
                }
            }

            if (!produtoEncontrado) {
                System.out.println("Produto não encontrado!");
            }
        }

    private void excluirProduto(Scanner scanner) {
            System.out.println("\nExclusão de Produto");
            System.out.print("Informe o SKU do produto que deseja excluir: ");
            String sku = scanner.nextLine();
            boolean produtoRemovido = produtos.removeIf(produto -> produto.getSku().equals(sku));

            if (produtoRemovido) {
                System.out.println("Produto excluído com sucesso!");
            } else {
                System.out.println("Produto não encontrado!");
            }
        }

        private void listarTodosProdutos() {
            System.out.println("\nLista de Todos os Produtos");
            if (produtos.isEmpty()) {
                System.out.println("Não há produtos cadastrados.");
            } else {
                for (Produto produto : produtos) {
                    System.out.println(produto);
                }
            }
        }

        private void listarUmProduto(Scanner scanner) {
            System.out.println("\nListar um Produto");
            System.out.print("Informe o SKU do produto que deseja listar: ");
            String sku = scanner.nextLine();
            boolean produtoEncontrado = false;

            for (Produto produto : produtos) {
                if (produto.getSku().equals(sku)) {
                    produtoEncontrado = true;
                    System.out.println("Detalhes do produto:");
                    System.out.println(produto);
                    break;
                }
            }

            if (!produtoEncontrado) {
                System.out.println("Produto não encontrado!");
            }
        }
    }

}
