import org.junit.jupiter.api.*;

public class PortariaTest {

    Main main = new Main();
    String menorDeIdade = "Negado. Menores de idade nao sao permitidos.";
    String conviteInvalido = "Negado. Convite invalido.";
    String conviteAceito = "Welcome :)";

    // ANNOTATION
    @Test
    @DisplayName("Nega entrada para menores de idade.")
    public void negaEntradaParaMenoresDeIdade() {
        Assertions.assertEquals(main.controlePortaria(15, "comum", "xt38522"), menorDeIdade);
        Assertions.assertEquals(main.controlePortaria(-5, "comum", "xt38522"), menorDeIdade);
        Assertions.assertEquals(main.controlePortaria(0, "comum", "xt38522"), menorDeIdade);
    }

    @Test
    @DisplayName("Valida o tipo de convite.")
    public void validaTipoDeConvite() {
        Assertions.assertEquals(main.controlePortaria(25, "xpto", "xt38522"), conviteInvalido);
        Assertions.assertEquals(main.controlePortaria(25, "", "xt38522"), conviteInvalido);
        Assertions.assertEquals(main.controlePortaria(25, "COMUN", "xt38522"), conviteInvalido);
    }

    @Test
    @DisplayName("Permite a entrada com convite e código válido.")
    public void entradaPermitida() {
        Assertions.assertEquals(main.controlePortaria(25, "comum", "xt37559"), conviteAceito);
        Assertions.assertEquals(main.controlePortaria(25, "premium", "xl1u4u"), conviteAceito);
        Assertions.assertEquals(main.controlePortaria(25, "luxo", "xl65432"), conviteAceito);
    }

    @Test
    @DisplayName("Nega a entrada com convite válido e código inválido.")
    public void entradaNegadaComCodigoInvalido() {
        Assertions.assertEquals(main.controlePortaria(25, "comum", "dftjtre"), conviteInvalido);
        Assertions.assertEquals(main.controlePortaria(25, "premium", "wfgj40"), conviteInvalido);
        Assertions.assertEquals(main.controlePortaria(25, "luxo", "--235n@"), conviteInvalido);
    }

    // Usado para cenários importantes que precisam ser testados. (PARA NÂO ESQUECER!!!)
    @Test
    @Disabled("Funcionalidade ainda não foi finalizada!")
    public void naoImplementado() {

    }
    // OU:
    @Test
    public void naoImplementadoMasInvalido() {
        // Vai falhar
        Assertions.fail("Ainda não finalizado!");
    }

    @Test
    @DisplayName("Vai rodar baseado em uma condição.")
    public void rodaSomenteBaseadoEmCondicao() {
        // Suposição
        Assumptions.assumeTrue(main.controlePortaria(17, "comum", "xt123").equals(menorDeIdade));
        // Resto do código só é executado se a suposição for verdadeira
        Assertions.assertEquals(main.controlePortaria(36, "comum", "xt123"), conviteAceito);
    }

    @Test
    @DisplayName("Teste com lançamento de exceção.")
    public void lancaExcecao() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            String str = null;
            str.length();
        });
    }

    @Test
    @DisplayName("Teste de não nulo.")
    public void testeNotNull() {
        // Testa se o retorno da função é diferente de nulo.
        Assertions.assertNotNull(main.controlePortaria(17, "", ""));

        // Muito cuidado em cenários desse tipo, pois pode ser que a função nunca tenha o retorno nulo
        // Nesse caso, esse teste nunca falha, mesmo que a função esteja com comportamento incorreto.
    }
}
