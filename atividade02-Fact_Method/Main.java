import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PagamentoFactory factory = null;
        int tentativasMetodo = 0;
        final int MAX_TENTATIVAS = 3;

        while (tentativasMetodo < MAX_TENTATIVAS) {
            System.out.println("Escolha o método de pagamento (paypal, boleto, pix):");
            String metodo = scanner.nextLine().toLowerCase();

            switch (metodo) {
                case "paypal":
                    factory = new PayPalFactory();
                    break;
                case "boleto":
                    factory = new BoletoFactory();
                    break;
                case "pix":
                    factory = new PixFactory();
                    break;
                default:
                    tentativasMetodo++;
                    int restantes = MAX_TENTATIVAS - tentativasMetodo;
                    System.out.println("Método de pagamento inválido. " +
                        (restantes > 0 ? "Tentativas restantes: " + restantes : "Nenhuma tentativa restante."));
                    continue;
            }

            break;
        }

        if (factory == null) {
            System.out.println("Número de tentativas excedido. Operação cancelada.");
            scanner.close();
            return;
        }

        double valor = -1;
        int tentativasValor = 0;

        while (tentativasValor < MAX_TENTATIVAS) {
            System.out.print("Digite o valor do pagamento: R$");
            String entrada = scanner.nextLine();

            try {
                valor = Double.parseDouble(entrada);

                if (valor > 0) {
                    break;
                } else {
                    tentativasValor++;
                    int restantes = MAX_TENTATIVAS - tentativasValor;
                    System.out.println("O valor deve ser maior que zero. " +
                        (restantes > 0 ? "Tentativas restantes: " + restantes : "Nenhuma tentativa restante."));
                }
            } catch (NumberFormatException e) {
                tentativasValor++;
                int restantes = MAX_TENTATIVAS - tentativasValor;
                System.out.println("Valor inválido. Digite um número. " +
                    (restantes > 0 ? "Tentativas restantes: " + restantes : "Nenhuma tentativa restante."));
            }
        }

        if (valor <= 0) {
            System.out.println("Número de tentativas excedido. Operação cancelada.");
            scanner.close();
            return;
        }

        Pagamento pagamento = factory.criarPagamento();
        pagamento.processarPagamento(valor);

        scanner.close();
    }
}
