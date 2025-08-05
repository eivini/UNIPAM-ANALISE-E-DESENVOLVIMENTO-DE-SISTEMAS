public class SessaoUsuario {
    private static SessaoUsuario instancia;
    private Cliente cliente;

    private SessaoUsuario(Cliente cliente) {
        this.cliente = cliente;
    }

    public static SessaoUsuario autenticar(Cliente cliente) {
        if (instancia == null) {
            instancia = new SessaoUsuario(cliente);
            System.out.println("Sessão criada.");
        } else {
            System.out.println("Sessão já existente.");
        }
        return instancia;
    }

    public static SessaoUsuario getInstancia() {
        return instancia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setInformacaoCliente(String nome, String email) {
        cliente.setNome(nome);
        cliente.setEmail(email);
    }

    public void acessarPainel() {
        System.out.println("Acessando painel do cliente: " + cliente.getNome());
    }
}
