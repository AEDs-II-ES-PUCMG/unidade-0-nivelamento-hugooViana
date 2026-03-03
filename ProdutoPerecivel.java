public class ProdutoPerecivel extends Produto{
    
    private static final double MARGEM_PADRAO = 0.25;
    private static final double PRAZO_DESCONTO = 7;
	private LocalDate dataValidade;
    
    public ProdutoNaoPerecivel(String desc, double precoCusto, double margemLucro, LocalDate dataValidade) {
        super(desc, precoCusto, margemLucro);
        this.dataValidade = dataValidade;
    }

    public ProdutoNaoPerecivel(String desc, double precoCusto, LocalDate dataValidade) {
        super(desc, precoCusto, MARGEM_PADRAO);
        this.dataValidade = dataValidade;
    }

    @Override
    public double valorDeVenda() {
        LocalDate hoje = LocalDate.now();
        long diasParaValidade = ChronoUnit.DAYS.between(hoje, dataValidade);
        
        if (diasParaValidade <= PRAZO_DESCONTO) {
            return super.valorDeVenda() * 0.9; 
        } else {
            return super.valorDeVenda();
        }
    }
    /**
* Gera uma linha de texto a partir dos dados do produto. Preço e margem de lucro vão formatados com 2 casas
decimais.
* @return Uma string no formato "1; descrição;preçoDeCusto;margemDeLucro"
*/
@Override
public String gerarDadosTexto() {
  DateTimeFormatter formato = DataTimeFormatter.ofPattern("dd/MM/yyyy");
  String precoFormatado = String.format("%.2f",precoCusto).replace(",",".");
  String margemFormatada = String.format("%.2f",margemLucro).replace(",",".");
  String dataValidadeFormatada = dataValidade.format(formato);
  return String.format("2;%s;%s;%s;%s",descricao , precoFormatado, margemFormatada, dataValidadeFormatada);
}


}
	