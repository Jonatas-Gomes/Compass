public class Funcionario {
    private String nome;
    private double salario;
    private double valorBonificao;
    private double salarioLiquido;
    private double valorDesconto;

    public Funcionario(String nome, double salario){
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return this.nome;
    }

    @Override
    public String toString() {
        if(salario >= 2000){
            return ("\nFuncionário "+ this.nome + "\n  Salario: " +this.salario +"\n  Desconto: " + this.valorDesconto + "\n  Salario Liquido: " +this.salarioLiquido);
        }
        return ("\nFuncionário "+ this.nome + "\n  Salario: " +this.salario +"\n  Bônus: " + this.valorBonificao+ "\n  Salario Liquido: " +this.salarioLiquido);
    }

    public void calculaNovoSalario(double salario){
        if(salario <= 1000){
            salarioLiquido = salario + (salario * 0.2);
            valorBonificao = salario * 0.2;
        }else if(salario > 1000 && salario < 2000){
            salarioLiquido = salario + (salario *0.1);
            valorBonificao = salario * 0.1;
        }else{
            salarioLiquido = salario - (salario*0.1);
            valorDesconto = salario * 0.1;

        }
    }
}
