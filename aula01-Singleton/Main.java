/* 
 *  Client que vai usar várias vezes o DBConnection(Singleton)
*/

public class Main {
    public static voi main (String[] args) {

        DBConnection conexao1 = DBConnection.getInstance();
        System.out.println(conexao1.getStatusConexao());

        DBConnection conexao2 = DBConnection.getInstance();
        System.out.println(conexao1.getStatusConexao());

        if(conexao1.equals(conexao2)){
            System.out.println("Mema coisa");
        }
    }
}