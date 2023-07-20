import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivoEstoque {

    public static void criarArquivoEstoque(EstoqueProdutos estoque) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("estoque.txt"))) {
            writer.write("Estoque Disponível:");
            writer.newLine();
            for (ProdutoEstoque produto : estoque.produtos) {
                if (produto != null) {
                    writer.write(produto.nome + " | Quantidade: " + produto.quantidade + "Valor(R$): " + produto.valor);
                    writer.newLine();
                    writer.write("--------------------------------------------------------");
                    writer.newLine();
                }
            }
            System.out.println("Arquivo de estoque criado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao criar o arquivo de estoque: " + e.getMessage());
        }
    }
}
