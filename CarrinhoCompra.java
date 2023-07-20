public class CarrinhoCompra {
  EstoqueProdutos estoque;
  int tamanhoCarrinho;
  ProdutoEstoque[] carrinho;

  CarrinhoCompra(EstoqueProdutos estoque) {
    this.estoque = estoque;
    this.tamanhoCarrinho = estoque.produtos.length;
    this.carrinho = new ProdutoEstoque[this.tamanhoCarrinho];
  }

  public void adicionaItem(String nome, int quantidade) {
    for (ProdutoEstoque produto : this.estoque.produtos) {
      if(produto != null && produto.nome.equals(nome)) {
        if (quantidade <= produto.quantidade) {
          for (int z = 0; z < this.tamanhoCarrinho; z++) {
            if (this.carrinho[z] == null) {
              this.carrinho[z] = new ProdutoEstoque(produto.nome, produto.valor, quantidade);
              System.out.println(nome + " adicionado com sucesso!");
              return;
            }
          }
        }
        else
          System.out.println("erro ao adicionar " + nome + " ao carrinho! Estoque insuficiente.");
      }
    } 
  }
        
  public void finalizaCompra() {
    for(ProdutoEstoque itemCarrinho : this.carrinho) {
      for(ProdutoEstoque produto : this.estoque.produtos) {
        if(itemCarrinho != null) {
          if(produto.nome == itemCarrinho.nome) {
            produto.quantidade -= itemCarrinho.quantidade;
          }
        }
      }
    }
  }

  public int calculaTotal() {
    int total = 0;
    for(ProdutoEstoque itemCarrinho : this.carrinho) {
      if(itemCarrinho != null) {
        total += itemCarrinho.quantidade * itemCarrinho.valor;
      }
    }
    return total;
  }
}
