
import java.util.Scanner;

public class MenuExecutavel {

    public void menu() {
        Banco banco = new Banco();
        Scanner sc = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("---Banco de Contas---");
            System.out.println("1 - Criar Conta");
            System.out.println("2 - Selecionar Conta");
            System.out.println("3 - Remover Conta");
            System.out.println("4 - Gerar Relatório");
            System.out.println("5 - Finalizar\n>>");
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("---Criar Conta---");
                    ContaBancaria cb;
                    System.out.println("Qual tipo de Conta deseja criar? (CC|CP)");
                    String st = sc.nextLine();
                    if (st.equals("CC")) {
                        int numero = sc.nextInt();
                        double saldo = sc.nextDouble();
                        cb = new ContaCorrente(numero, saldo);
                        banco.inserir(cb);
                    } else if (st.equals("CP")) {
                        int numero = sc.nextInt();
                        double saldo = sc.nextDouble();
                        double taxa = 2.5;
                        cb = new ContaPoupanca(numero, saldo, taxa);
                        banco.inserir(cb);
                    }
                    break;
                case 2:
                    System.out.println("---Selecione uma conta---");
                    System.out.println("Entre com o número da conta: ");
                    int numero = sc.nextInt();
                    ContaBancaria cb1;
                    cb1 = banco.procurarConta(numero);
                    if (cb1 != null) {
                        System.out.println("---Conta Encontrada---");
                        int repete;
                        do{
                            repete = subMenu(banco, cb1, sc);
                        }while(repete != 5);
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    break;
                case 3:
                    System.out.println("---Remover Conta---");
                    System.out.println("Entre com o número da conta: ");
                    int nconta = sc.nextInt();
                    ContaBancaria cb2;
                    cb2 = banco.procurarConta(nconta);
                    if (cb2 != null) {
                        banco.remover(cb2);
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    break;
                case 4:
                    System.out.println("---Gerar Relatório---");
                    banco.mostraDados();
                    break;
                case 5:
                    System.out.println("---Tchau, Até mais!---");
                    break;
                default:
                    System.out.println("Entrada inválida!");
            }
        } while (opcao != 5);

    }

    private int subMenu(Banco banco, ContaBancaria cb, Scanner sc) {
            int indice = banco.getContas().indexOf(cb);
            System.out.println("---Menu de Conta Selecionada---");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Transferir");
            System.out.println("4 - Gerar relatório");
            System.out.println("5 - Retornar ao menu anterior");
            int op = sc.nextInt();
            switch (op) {
            case 1:
                System.out.println("--Depósito bancário---");
                System.out.println("Entre com o valor:");
                double valor = sc.nextDouble();
                banco.getContas().get(indice).depositar(valor);
                break;
            case 2:
                System.out.println("--Saque bancário---");
                System.out.println("Entre com o valor:");
                double valorS = sc.nextDouble();
                if(banco.getContas().get(indice).sacar(valorS)){
                    System.out.println("Saque efetuado com sucesso!");
                }else{
                    System.out.println("Ocorreu um problema...");
                }
                break;
            case 3:
                System.out.println("--Transferência bancária---");
                System.out.println("Entre com o valor:");
                double valorT = sc.nextDouble();
                System.out.println("Entre com o numero da conta que deseja transferir:");
                int numcontat = sc.nextInt();
                ContaBancaria cbt = banco.procurarConta(numcontat);
                banco.getContas().get(indice).transferir(valorT, cbt);
                break;
            case 4:
                System.out.println("--Relatório da Conta---");
                Relatorio.gerarRelatorio((Imprimivel) banco.getContas().get(indice));
                break;
            case 5:
                System.out.println("retornando ao menu...");
            default:
                System.out.println("Opção inválida!");
        }
            return op;
    }

    public static void main(String[] args) {
        MenuExecutavel me = new MenuExecutavel();
        me.menu();
    }
}
