package calculadora;

/**
 * Operações matemáticas inteiras para o projeto FinançApp.
 * Versão refatorada a partir do exemplo dos slides 41 e 46.
 * Contém métodos independentes e delega a seleção ao método calcular. 
 *
 * @author Guilherme Hatada Yonezawa
 * @version 2.0
 */
public class Calculadora {

    /** Guarda o último resultado devolvido pela interface de compatibilidade calc. */
    public int r = 0;

    /**
     * Soma dois inteiros.
     * @param a primeiro operando
     * @param b segundo operando
     * @return soma de a e b
     */
    public int somar(int a, int b) {
        return a + b;
    }

    /**
     * Subtrai dois inteiros.
     * @param a primeiro operando
     * @param b segundo operando
     * @return diferença entre a e b
     */
    public int subtrair(int a, int b) {
        return a - b;
    }

    /**
     * Multiplica dois inteiros.
     * @param a primeiro operando
     * @param b segundo operando
     * @return produto de a e b
     */
    public int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * Divide dois inteiros com validação prévia do divisor.
     * @param a dividendo
     * @param b divisor
     * @return quociente inteiro de a por b
     * @throws IllegalArgumentException se b for zero
     */
    public int dividir(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisao por zero nao e permitida.");
        }
        return a / b;
    }

    /**
     * Seleciona a operação por switch, seguindo o slide 46.
     *
     * @param a primeiro operando
     * @param b segundo operando
     * @param operador símbolo da operação: +, -, * ou /
     * @return resultado da operação escolhida
     * @throws IllegalArgumentException se o operador for inválido ou o divisor for zero
     */
    public int calcular(int a, int b, String operador) {
        if (operador == null) {
            throw new IllegalArgumentException("Operacao invalida: null");
        }
        return switch (operador) {
            case "+" -> somar(a, b);
            case "-" -> subtrair(a, b);
            case "*" -> multiplicar(a, b);
            case "/" -> dividir(a, b);
            default -> throw new IllegalArgumentException("Operacao invalida: " + operador);
        };
    }

    /**
     * Mantém o comportamento externo do método calc da versão inicial.
     * Um erro imprime mensagem e retorna 0 sem encerrar o programa.
     *
     * @param a primeiro operando
     * @param b segundo operando
     * @param op símbolo da operação
     * @return resultado inteiro da operação, ou zero em caso de erro
     */
    public int calc(int a, int b, String op) {
        try {
            r = calcular(a, b, op);
        } catch (IllegalArgumentException erro) {
            if ("/".equals(op) && b == 0) {
                System.out.println("Erro: divisao por zero, operacao irregular");
            } else {
                System.out.println("Operacao invalida");
            }
            r = 0;
        }
        System.out.println("Resultado = " + r);
        return r;
    }
}
