
public class Executavel {
    public static void main(String[] args) {
        ContaBancaria cbc = new ContaCorrente(12345, 3000);
        ContaBancaria cbp = new ContaPoupanca(56789, 5000, 2.5);
        
        cbc.depositar(400);
        if(cbc.sacar(3600)==true){
            System.out.println("Ok");
        }else{
            System.out.println("Não OK");
        }
        Relatorio.gerarRelatorio((Imprimivel) cbc);
        Relatorio.gerarRelatorio((Imprimivel) cbc);
        
        cbp.depositar(1000);
        cbp.sacar(500);
        Relatorio.gerarRelatorio((Imprimivel) cbp);
        
        cbc.transferir(200, cbp);
        
        System.out.println("----------------------");
        Relatorio.gerarRelatorio((Imprimivel) cbc);
        Relatorio.gerarRelatorio((Imprimivel) cbp);
    }
}
