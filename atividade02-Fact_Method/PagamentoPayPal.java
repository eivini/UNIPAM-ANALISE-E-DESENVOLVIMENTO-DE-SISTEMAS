public class PagamentoPayPal implements Pagamento {
    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando pagamento via PayPal: R$" + valor);
    }
}
