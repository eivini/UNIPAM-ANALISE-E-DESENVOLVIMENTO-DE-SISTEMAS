public class Sistema {
    public static void main(String[] args) {
        // Tenta acessar funções sem autenticar
        if (SessaoUsuario.getInstancia() == null) {
            System.out.println("Erro: usuário não autenticado!");
        }

        // Autenticar usuário
        Cliente cliente = new Cliente("Marcus", "marcus@email.com");
        SessaoUsuario sessao = SessaoUsuario.autenticar(cliente);

        // Acessar painel
        sessao.acessarPainel();

        // Ver informações do cliente
        System.out.println("Cliente atual: " + sessao.getCliente());

        // Alterar informações do cliente
        sessao.setInformacaoCliente("Marcus Vinícius", "marcusvinicius@email.com");
        System.out.println("Cliente atualizado: " + sessao.getCliente());

        // Tentar criar nova sessão (não deve criar outra)
        Cliente outroCliente = new Cliente("Josevaldo", "josevaldo@email.com");
        SessaoUsuario novaSessao = SessaoUsuario.autenticar(outroCliente);

        // Verificar se é a mesma instância
        System.out.println("Mesma instância? " + (sessao == novaSessao));
    }
}
