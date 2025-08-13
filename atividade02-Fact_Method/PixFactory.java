public class PixFactory extends PagamentoFactory {
    @Override
    public Pagamento criarPagamento() {
        return new PagamentoPix();
    }
}
