public class EstoqueProdutos {
  public ProdutoEstoque[] produtos;

  EstoqueProdutos() {
    this.produtos = new ProdutoEstoque[4];
  }

  EstoqueProdutos(int tamanho) {
    this.produtos = new ProdutoEstoque[tamanho];
  }

  public void adicionaProduto(ProdutoEstoque produto) {
    for (int i = 0; i < this.produtos.length; i++) {
      if (this.produtos[i] == null) {
        this.produtos[i] = produto;
        break;
      }
    }
  }
}
