package calculadora;

/**
 * Implementação inicial da calculadora FinançApp, conforme slide 41 da aula.
 * A versão inicial utiliza if/else e retorna zero em operações inválidas.
 *
 * @author Seu Nome
 * @version 1.0
 */
public class Calculadora {

    /** Resultado da última operação, como apresentado no exemplo da aula. */
    public int r = 0;

    /**
     * Realiza soma, subtração, multiplicação ou divisão de inteiros.
     * Imprime mensagens para divisão por zero e operador inválido, retornando zero.
     *
     * @param a primeiro número inteiro
     * @param b segundo número inteiro
     * @param op operador: +, -, * ou /
     * @return resultado inteiro, ou zero quando a operação for inválida
     */
    public int calc(int a, int b, String op) {
        // Implementação condicional baseada no slide 41 do professor.
        if ("+".equals(op)) {
            r = a + b;
        } else if ("-".equals(op)) {
            r = a - b;
        } else if ("*".equals(op)) {
            r = a * b;
        } else if ("/".equals(op)) {
            if (b != 0) {
                r = a / b;
            } else {
                System.out.println("Erro: divisao por zero, operacao irregular");
                r = 0;
            }
        } else {
            System.out.println("Operacao invalida");
            r = 0;
        }

        System.out.println("Resultado = " + r);
        return r;
    }
}
