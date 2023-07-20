import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivoNotaFiscal {

    public static void criarArquivoNotaFiscal(CarrinhoCompra carrinho) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("nota_fiscal.txt"))) {
            writer.write("---------- CUPOM FISCAL -----------\n");
            writer.write("ITEM    QTD    PRECO(R$)\n");

            for (ProdutoEstoque produto : carrinho.carrinho) {
                if (produto != null) {
                    writer.write(produto.nome + "  " + produto.quantidade + "      " + produto.valor);
                    writer.newLine();
                    writer.write("-----------------------------------\n");
                }
            }
            writer.write("VALOR TOTAL(R$): " + carrinho.calculaTotal());
            System.out.println("Arquivo de nota fiscal criado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao criar o arquivo de nota fiscal: " + e.getMessage());
        }
    }
}
