public class Principal {
  public static void main(String[] args) {
    EstoqueProdutos estoque = new EstoqueProdutos();
    estoque.adicionaProduto(new ProdutoEstoque ("monitor", 500, 100));
    estoque.adicionaProduto(new ProdutoEstoque ("telefone", 150, 300));
    estoque.adicionaProduto(new ProdutoEstoque ("teclado", 70, 50));
    estoque.adicionaProduto(new ProdutoEstoque ("mouse", 50, 50));
    ArquivoEstoque.criarArquivoEstoque(estoque);
    CarrinhoCompra carrinho = new CarrinhoCompra(estoque);
    carrinho.adicionaItem("monitor", 2);
    carrinho.adicionaItem("telefone", 5);
    carrinho.adicionaItem("teclado", 2);
    carrinho.finalizaCompra();
    ArquivoNotaFiscal.criarArquivoNotaFiscal(carrinho);
    System.out.println("A soma dos produtos : " + carrinho.calculaTotal());
  }
}