package exercíciobanco;

import java.util.Locale;
import java.util.Scanner;

public class Banco {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        ContaBanco conta = new ContaBanco();
        String resp;

        System.out.print("Número da conta: ");
        conta.setNumConta(sc.nextInt());
        sc.nextLine();
        do {
            System.out.print("Tipo da conta:[CC/CP] ");
            resp = sc.nextLine();
            conta.setTipoConta(resp);
            if (resp.equals("CC")) {
                conta.setSaldo(50);
                System.out.println("Você recebeu R$ 50,00 por abrir a conta conosco.");
            } else if (resp.equals("CP")) {
                conta.setSaldo(150);
                System.out.println("Você recebeu R$ 150,00 por abrir a conta conosco.");
            } else {
                System.out.println("Tipo de conta inválida.");
            }
        } while (!(resp.equals("CC") || (resp.equals("CP"))));
        conta.setStatus(true);
        System.out.println("");
        System.out.print("Nome: ");
        conta.setNome(sc.nextLine());
        System.out.println("");
        System.out.println(conta.status());
        System.out.println("");
        System.out.println("Olá, " + conta.getNome() + ". O que você deseja fazer? ");
        int r;
        do {
            System.out.println("Escolha a opção correspondente: ");
            System.out.println("");
            System.out.println("1 Deposito");
            System.out.println("2 Saque");
            System.out.println("3 Saldo");
            System.out.println("4 Pagar Mensalidade");
            System.out.println("5 Fechar a conta");
            System.out.println("6 Ver dados da conta");
            System.out.println("7 Sair ");
            System.out.println("");
            r = sc.nextInt();
            System.out.println("");
            switch (r) {
                case 1:
                    if (conta.getStatus() == true) {
                        System.out.print("Qual o valor do depósito:");
                        conta.deposito(sc.nextDouble());
                        System.out.println("Operação realizada com sucesso! Seu novo saldo é de R$" + conta.getSaldo());
                    } else {
                        System.out.println("Impossível realizar a operação. Sua conta está fechada!");
                    }
                    System.out.println("");
                    break;
                case 2:
                    if (conta.getStatus() == true) {
                        System.out.print("Quanto você quer sacar? ");
                        double saque = sc.nextDouble();
                        if (conta.getSaldo() >= saque) {
                            conta.saque(saque);
                            System.out.println("Operação realizada com sucesso! Seu novo saldo é de R$ " + conta.getSaldo());
                        } else {
                            System.out.println("Você não tem saldo suficiente para realizar esta operação.");
                            System.out.println("Seu saldo é de R$ " + conta.getSaldo());
                        }
                    } else {
                        System.out.println("Impossível realizar a operação. Sua conta está fechada!");
                    }
                    System.out.println("");
                    break;
                case 3:
                    if (conta.getStatus()== true) {
                    System.out.println("Seu saldo é de R$ " + conta.getSaldo());
                    } else {
                        System.out.println("Impossível realizar a operação. Sua conta está fechada!");
                    }
                    System.out.println("");
                    break;
                case 4:
                    if (conta.getStatus()== true) {
                    conta.mensalidade();
                    System.out.println("Operação realizada com sucesso. Seu novo saldo é de R$ " + conta.getSaldo());
                    } else {
                        System.out.println("Impossível realizar a operação. Sua conta está fechada!");
                    }
                    System.out.println("");
                    break;
                case 5:
                    if (conta.getStatus() == true) {
                    conta.fecharConta(true);
                    } else {
                        System.out.println("Impossível realizar a operação. Sua conta já está fechada!");
                    }
                    System.out.println("");
                    break;
                case 6:
                    System.out.println("Conta número: " + conta.getNumConta());
                    System.out.println("Tipo da conta: " + conta.getTipoConta());
                    System.out.println("Nome: " + conta.getNome());
                    System.out.println("Conta aberta? " + conta.getStatus());
                    System.out.println("");
                    break;
                case 7:
                    System.out.println("Atendimento finalizado.");
                    System.out.println("");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente. ");
                    System.out.println("");
            }
        } while (r != 7);

        sc.close();
    }

}
