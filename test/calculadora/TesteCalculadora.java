package calculadora;

/**
 * Testes da versão refatorada: seis testes de regressão usando calc
 * e três testes adicionais da interface calcular, incluindo try/catch.
 * Referência aos slides 42 e 44 da aula.
 *
 * @author Guilherme Hatada Yonezawa
 * @version 2.0
 */
public class TesteCalculadora {

    /** Total de verificações aprovadas. */
    private static int aprovados = 0;

    /** Total de verificações reprovadas. */
    private static int reprovados = 0;

    /** Evita instanciação acidental. */
    private TesteCalculadora() { }

    /**
     * Compara um resultado com o valor esperado.
     * @param nome título do cenário
     * @param entrada descrição da entrada usada
     * @param esperado valor esperado
     * @param obtido valor calculado
     */
    private static void verificar(String nome, String entrada, int esperado, int obtido) {
        boolean passou = esperado == obtido;
        if (passou) aprovados++; else reprovados++;
        System.out.printf("[%s] %s | Entrada: %s | Esperado: %d | Obtido: %d%n",
                passou ? "APROVADO" : "REPROVADO", nome, entrada, esperado, obtido);
    }

    /**
     * Verifica se um cálculo rejeitado lançou a exceção esperada.
     * @param nome título do teste
     * @param entrada descrição dos valores
     * @param calculadora instância a testar
     * @param a primeiro operando
     * @param b segundo operando
     * @param op operador
     */
    private static void verificarExcecao(String nome, String entrada,
            Calculadora calculadora, int a, int b, String op) {
        try {
            int obtido = calculadora.calcular(a, b, op);
            reprovados++;
            System.out.printf("[REPROVADO] %s | Entrada: %s | Esperado: IllegalArgumentException | Obtido: %d%n",
                    nome, entrada, obtido);
        } catch (IllegalArgumentException erro) {
            aprovados++;
            System.out.printf("[APROVADO] %s | Entrada: %s | Esperado: IllegalArgumentException | Obtido: %s%n",
                    nome, entrada, erro.getClass().getSimpleName());
        }
    }

    /**
     * Executa testes de regressão e de exceção.
     * @param args parâmetros de linha de comando não utilizados
     */
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        // Seis testes do exemplo inicial: garantem compatibilidade depois da refatoração.
        verificar("Soma", "2 + 3", 5, calc.calc(2, 3, "+"));
        verificar("Subtracao", "10 - 4", 6, calc.calc(10, 4, "-"));
        verificar("Multiplicacao", "3 * 5", 15, calc.calc(3, 5, "*"));
        verificar("Divisao", "8 / 2", 4, calc.calc(8, 2, "/"));
        verificar("Divisao por zero", "8 / 0", 0, calc.calc(8, 0, "/"));
        verificar("Operacao invalida", "5 x 5", 0, calc.calc(5, 5, "x"));

        // Testes adicionais da API refatorada, com tratamento de erros (slide 44).
        verificar("Metodo calcular", "7 + 3", 10, calc.calcular(7, 3, "+"));
        verificarExcecao("Excecao divisao por zero", "8 / 0", calc, 8, 0, "/");
        verificarExcecao("Excecao operador invalido", "5 x 5", calc, 5, 5, "x");

        System.out.printf("RESUMO: %d APROVADOS | %d REPROVADOS%n", aprovados, reprovados);
        if (reprovados > 0) System.exit(1);
    }
}
