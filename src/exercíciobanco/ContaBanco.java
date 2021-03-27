package exercíciobanco;

public class ContaBanco {

    public int numConta;
    protected String tipoConta;
    private String nome;
    private double saldo;
    private boolean status;

    public ContaBanco() {
        this.saldo = 0;
        this.status = false;
    }

    public int getNumConta() {
        return this.numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipoConta() {
        return this.tipoConta;
    }
    
    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public double getSaldo () {
        return this.saldo;
    }
    
    public void setSaldo (double saldo) {
        this.saldo = saldo;
    }
    
    public boolean getStatus () {
        return this.status;
    }
    
    public void setStatus (boolean status) {
        this.status = status;
    }
    
    public void abrirConta(boolean status){
        this.status = true;
    }
    
    public void fecharConta(boolean status) {
        if (this.saldo == 0){
            this.status = false;
            System.out.println("Conta Fechada.");
        } else if (this.saldo < 0) {
            System.out.println("Impossível fechar a conta. Saldo negativo.");
        } else {
            System.out.println("Impossível fechar a conta. Saldo disponível");
        }
    }
    
    public void deposito (double deposito) {
        this.saldo += deposito;
    }
    
    public void saque (double saque) {
            this.saldo -= saque;
    }
    
    public void mensalidade () {
        if (this.tipoConta.equals("CC")){
            this.saldo -= 12;
        } else {
            this.saldo-=20;
        }
    }
    
    public String status() {
    return "Numero da conta: " + getNumConta()+ ". Tipo da conta: " + getTipoConta() 
            + ". Nome: " + getNome() + ". Saldo da Conta R$ " + getSaldo() + ". A conta está aberta? " + getStatus();   
    }
}
