public class BoletoFactory extends PagamentoFactory {
    @Override
    public Pagamento criarPagamento() {
        return new PagamentoBoleto();
    }
}
