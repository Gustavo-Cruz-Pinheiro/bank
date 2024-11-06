/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author renat
 */
public class ContaPoupanca extends ContaBancaria implements Imprimivel{
    private double taxaOperacao;

    public ContaPoupanca(int nConta, double saldo, double taxaOperacao) {
        super(nConta, saldo);
        this.taxaOperacao = taxaOperacao;
    }

    public double getTaxaOperacao() {
        return taxaOperacao;
    }

    public void setTaxaOperacao(double taxaOperacao) {
        this.taxaOperacao = taxaOperacao;
    }

    @Override
    public boolean sacar(double valor) {
        if(this.getSaldo() >= valor + taxaOperacao){
            double valorFinal = this.getSaldo() - (valor + taxaOperacao);
            this.setSaldo(valorFinal);
            System.out.println("Saque efetuado com sucesso!");
            return true;
        }else{
            System.out.println("Saldo Insuficiente!");
            return false;
        }
    }

    @Override
    public void depositar(double valor) {
        double valorFinal = this.getSaldo() + valor - taxaOperacao;
        this.setSaldo(valorFinal);
        System.out.println("Depósito efetuado com sucesso!");
    }
    
     @Override
    public void mostraDados() {
        System.out.println("---Conta Poupança---");
        System.out.println("Numero da conta:" + this.getnConta());
        System.out.println("Saldo:" + this.getSaldo());
        System.out.println("Taxa de Operação:" + this.taxaOperacao);
        
    }
}
