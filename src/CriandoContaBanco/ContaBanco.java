package CriandoContaBanco;

public class ContaBanco {

    //declaração de atributos:
    public int numConta;
    protected String tipo;
    private String titular;
    private double saldo;
    private boolean status; //status verdadeiro p/ conta aberta e falso p/ conta fechada


    //métodos especiais(getters and setters):

    public int getNumConta() {return numConta;}

    public void setNumConta(int numConta) {this.numConta = numConta;}

    public String getTipo() {return tipo;}

    public void setTipo(String tipo) {this.tipo = tipo;}//Tipo é um atributo, e tipo é uma variável

    public String getTitular() {return titular;}

    public void setTitular(String titular) {this.titular = titular;}

    public double getSaldo() {return saldo;}

    public void setSaldo(double saldo) {this.saldo = saldo;}

    public boolean getStatus() {return status;}

    public void setStatus(boolean status) {this.status = status;}

    //método construtor:

    public ContaBanco() {//sempre que uma nova conta for instanciada, o saldo será 0 e o status false
        this.setSaldo(0);
        this.setStatus(false);
    }

    //métodos personalizados:

    public void estadoAtual(){
        System.out.println("------------------------------");
        System.out.println("Conta:" + this.getNumConta());
        System.out.println("Tipo:" + this.getTipo());
        System.out.println("Titular:" + this.getTitular());
        System.out.println("Saldo:" + this.getSaldo());
        System.out.println("Status:" + this.getStatus());
    }
    public void abrirConta(String tipo){
        this.setTipo(tipo);
        this.setStatus(true);
        if(tipo == "cc"){
            this.setSaldo(50);
            System.out.println("Conta de " + this.getTitular() + " aberta com sucesso!");
        } else if (tipo == "cp") {
            this.setSaldo(150);
            System.out.println("Conta aberta com sucesso!");
        }

    }
    public void fecharConta(){
        if(this.getSaldo()>0d){
            System.out.println("Não é possível fechar conta com saldo positivo");
        }else if(this.getSaldo()<0d) {
            System.out.println("Não é possível fechar conta com saldo negativo");
        }else{
            this.setStatus(false);
            System.out.println("Conta fechada com sucesso.");
        }


    }
    public void depositar(double valor){
        if(this.getStatus()){ //se o status for true ele vai depositar
            this.setSaldo(this.getSaldo()+valor);
            System.out.println("Depósito realizado com sucesso na conta de " + this.getTitular());

            //essa conta saldo = saldo+valor poderia ser usada da forma abaixo, que é a forma mais correta de se fazer:
           // setSaldo(getSaldo()+valor); obs:dessa forma o getSaldo pega o valor do depósito soma ao saldo e
            // pelo setSaldo ele coloca o valor de volta no saldo
        }else{
            System.out.println("Impossível depositar em uma conta fechada!");
        }

    }
    public void sacar(double valor){
        if(this.getStatus()){
            if(this.getSaldo()>=valor){
                //saldo = saldo - valor; forma mais simples, ou:
                this.setSaldo(this.getSaldo()-valor);
                System.out.println("Saque realizado com sucesso na conta de " + this.getTitular());
            }else{
                System.out.println("Saldo insuficiente para saque");
            }
        }else {
            System.out.println("Impossível sacar de uma conta fechada!");
        }

    }
    public void pagarMensalidade(){
        //declaração de variável local - essas não são declaradas junto dos atributos:
        int mensalidade = 0;
        if(this.getTipo() == "cc"){
           mensalidade = 12;
        }else if(this.getTipo() == "cp"){
            mensalidade = 20;
        }
        if(this.getStatus()){
            if(this.getSaldo()>0) {
                this.setSaldo(this.getSaldo() - mensalidade);
                System.out.println("Mensalidade paga com sucesso na conta de " + this.getTitular());
            }else{
                System.out.println("Saldo insuficiente para realizar a operação!");
            }
        }else{
            System.out.println("Impossível pagar com um conta fechada!");
        }
    }

}
