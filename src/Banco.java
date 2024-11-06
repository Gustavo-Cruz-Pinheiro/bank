
import java.util.ArrayList;
import java.util.List;


public class Banco implements Imprimivel{
    private List<ContaBancaria> contas;

    public Banco() {
        this.contas = new ArrayList<>();
    }
    
    public void inserir(ContaBancaria cb){
        this.contas.add(cb);
    }
    
    public void remover(ContaBancaria cb){
        this.contas.remove(cb);
    }
    
    public ContaBancaria procurarConta(int nConta){
        for (ContaBancaria conta : contas) {
            if(conta.getnConta() == nConta)
                return conta;
        }
        return null;
    }

    @Override
    public void mostraDados() {
        for (ContaBancaria conta : contas) {
            Relatorio.gerarRelatorio((Imprimivel) conta);
        }
    }

    public List<ContaBancaria> getContas() {
        return contas;
    }
    
    
    
}
