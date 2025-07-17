public class Desafio {

    /* Ana e Paula são duas programadoras da empresa XDM. A empresa XDM possui um benefício para incentivar os
    funcionários a pouparem dinheiro para a aposentadoria que funciona da seguinte maneira:
     Se o funcionário destinar 5% do seu salário para o investimento, a empresa acrescenta o mesmo valor. Ou seja, caso o
    funcionário invista 100 reais, a empresa investe mais 100. Este fundo de investimento possui rendimento de 0,2% ao
    mês.
     Ana adorou a ideia e vai investir. No entanto, Paula decidiu que vai investir os mesmos 5% por conta própria já que
    conhece investimentos que rendem mais que 0,2% ao mês. Paula vai escolher investimentos que rendem 0,8% ao mês.
     Considere o salário de Ana e Paula iguais e no valor de 10 mil reais e que as duas estão começando com saldo 0.
     Em quantos meses o patrimônio de Paula vai superar o patrimônio de Ana?
     */

    public static void main(String[] args) {
        double salarioAna = 10000;
        double salarioPaula = 10000;
        double patrimonioAna = 0;
        double patrimonioPaula = 0;
        int mes = 1;

        do {
            patrimonioAna += (salarioAna * 0.05) + (salarioAna * 0.05) + (patrimonioAna * 0.002);
            patrimonioPaula += (salarioPaula * 0.05) + (patrimonioPaula * 0.008);
            mes++;
        } while (patrimonioPaula < patrimonioAna);

        System.out.println("Paula vai ultrapassar a Ana no mês: " + mes);
    }
}
