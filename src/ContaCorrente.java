/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author renat
 */
public class ContaCorrente extends ContaBancaria implements Imprimivel{
    private double limite = 1000;   

    public ContaCorrente(int nConta, double saldo) {
        super(nConta, saldo);
    }

    public double getLimite() {
        return limite;
    }

    @Override
    public boolean sacar(double valor) {
        if(valor <= (this.getSaldo() + limite)){
            double valorFinal = this.getSaldo() - valor;
            this.setSaldo(valorFinal);
            if(this.getSaldo() < 0) limite += this.getSaldo();
            System.out.println("Saque efetuado com sucesso!");
            return true;
        }else{
            System.out.println("Saldo indisponível!");
            return false;
        }
    }

    @Override
    public void depositar(double valor) {
        this.setSaldo(valor + this.getSaldo());
        System.out.println("Depósito efetuado com sucesso!");
    }

    @Override
    public void mostraDados() {
        System.out.println("---Conta Corrente---");
        System.out.println("Numero da conta:" + this.getnConta());
        System.out.println("Saldo:" + this.getSaldo());
        System.out.println("Limite:" + this.limite);
        
    }
    
    
}
