package Heranca;

public class Main {
    public static void main(String[] args) {
       Pessoa pe1 = new Pessoa();
       Aluno a1 = new Aluno();
       Professor pr1 = new Professor();
       Funcionario f1 = new Funcionario();

        pe1.setNome("Pedro");
        a1.setNome("Joao");
        pr1.setNome("Thiago");
        f1.setNome("Joaquim");

        System.out.println(pe1.toString());
        System.out.println(a1.toString());
        System.out.println(pr1.toString());
        System.out.println(f1.toString());

        a1.setCurso("Medicina");
        pr1.setSalario(2500.75f);
        f1.setSetor("estoque");
        pe1.setIdade(52);

        pr1.receberAumento(1000f);
        f1.mudarTrabalho();
        a1.cancelarMatricula();
        pe1.fazerAniversario();
    }
}
