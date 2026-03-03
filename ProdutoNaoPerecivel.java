public class ProdutoNaoPerecivel extends Produto{
    
    public ProdutoNaoPerecivel(String desc, double precoCusto, double margemLucro) {
        super(desc, precoCusto, margemLucro);
    }

    public ProdutoNaoPerecivel(String desc, double precoCusto) {
        super(desc, precoCusto);
    }

    @Override
    public double valorDeVenda() {
        return (precoCusto * (1.0 + margemLucro));
    }
    /**
    * Gera uma linha de texto a partir dos dados do produto. Preço e margem de lucro vão formatados com 2 casas
    decimais.
    * @return Uma string no formato "1; descrição;preçoDeCusto;margemDeLucro"
    */
    @Override
    public String gerarDadosTexto() {
    String precoFormatado = String.format("%.2f",precoCusto).replace(",",".");
    String margemFormatada = String.format("%.2f",margemLucro).replace(",",".");
    return String.format("1;%s;%s;%s", descricao, precoFormatado, margemFormatada);
    }
    /**
    * Gera uma linha de texto a partir dos dados do produto. Preço e margem de lucro vão formatados com 2 casas
    decimais.
    * Data de validade vai no formato dd/mm/aaaa
    * @return Uma string no formato "2; descrição;preçoDeCusto;margemDeLucro;dataDeValidade"
    */
    @Override
    public String gerarDadosTexto() {
    /*Você deve implementar aqui a lógica que monta a String com os atributos do objeto ProdutoPerecivel,
    respeitando o formato do arquivo de dados. */
    }

}
	