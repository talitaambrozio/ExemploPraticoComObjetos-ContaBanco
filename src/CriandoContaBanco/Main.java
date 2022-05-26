package CriandoContaBanco;

public class Main {
    public static void main(String[] args) {
        ContaBanco c1 = new ContaBanco();
        c1.setNumConta(123);
        c1.setTitular("João");
        c1.abrirConta("cc");

        ContaBanco c2 = new ContaBanco();
        c2.setNumConta(1234);
        c2.setTitular("Maria");
        c2.abrirConta("cp");


        c1.depositar(100);
        c2.depositar(500);

        c2.sacar(100);

        c1.pagarMensalidade();
        c2.pagarMensalidade();

        c1.estadoAtual();
        c2.estadoAtual();

    }

}
