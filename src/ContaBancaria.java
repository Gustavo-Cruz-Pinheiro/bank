
public abstract class ContaBancaria {
    private int nConta;
    private double saldo;

    public ContaBancaria(int nConta, double saldo) {
        this.nConta = nConta;
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getnConta() {
        return nConta;
    }

    public void setnConta(int nConta) {
        this.nConta = nConta;
    }
    
    public abstract boolean sacar(double valor);
    public abstract void depositar(double valor);
    
    public void transferir(double valor, ContaBancaria cb){
        if(this.sacar(valor)){
            cb.depositar(valor);
            System.out.println("Transferencia para n" + cb.getnConta() + " realizada com sucesso!");
        }else{
            System.out.println("Não foi possível realizar a transferência!");
        }
    }
}
