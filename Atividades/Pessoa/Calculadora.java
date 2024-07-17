package Atividades.Pessoa;

import java.util.Scanner;

public class Calculadora {

    public static class EntradaDados {
        private Scanner scanner;

        public EntradaDados() {
            this.scanner = new Scanner(System.in);
        }

        public int lerInt(String mensagem) {
            System.out.print(mensagem);
            return scanner.nextInt();
        }

        public float lerFloat(String mensagem) {
            System.out.println(mensagem);
            return scanner.nextFloat();
        }

        public float[] lerDoisFloats() {
            float a = lerFloat("Digite o primeiro valor: ");
            float b = lerFloat("Digite o segundo valor: ");
            return new float[]{a, b};
        }

        public void fecharScanner() {
            scanner.close();
        }
    }

    public static class Operacao {
        public float adicao(float a, float b) {
            return a + b;
        }

        public float subtracao(float a, float b) {
            return a - b;
        }

        public float multiplicacao(float a, float b) {
            return a * b;
        }

        public float divisao(float a, float b) {
            if (b != 0) {
                return a / b;
            } else {
                throw new ArithmeticException("Divisão por zero não é permitida.");
            }
        }
    }

    public static class Menu {
        public static void main(String[] args) {
            EntradaDados entradaDados = new EntradaDados();
            Operacao operacao = new Operacao();

            while (true) {
                System.out.println();
                System.out.println("Menu:");
                System.out.println("1. Adição");
                System.out.println("2. Subtração");
                System.out.println("3. Multiplicação");
                System.out.println("4. Divisão");
                System.out.println("0. Sair");

                System.out.println();
                System.out.print("Escolha uma opção: ");
                int opcao = entradaDados.lerInt("");

                switch (opcao) {
                    case 1:
                        float[] valoresAdicao = entradaDados.lerDoisFloats();
                        System.out.println("Resultado da Adição: " + operacao.adicao(valoresAdicao[0], valoresAdicao[1]));
                        break;

                    case 2:
                        float[] valoresSubtracao = entradaDados.lerDoisFloats();
                        System.out.println("Resultado da Subtração: " + operacao.subtracao(valoresSubtracao[0], valoresSubtracao[1]));
                        break;

                    case 3:
                        float[] valoresMultiplicacao = entradaDados.lerDoisFloats();
                        System.out.println("Resultado da Multiplicação: " + operacao.multiplicacao(valoresMultiplicacao[0], valoresMultiplicacao[1]));
                        break;

                    case 4:
                        float[] valoresDivisao = entradaDados.lerDoisFloats();
                        try {
                            System.out.println();
                            System.out.println("Resultado da Divisão: " + operacao.divisao(valoresDivisao[0], valoresDivisao[1]));
                        } catch (ArithmeticException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 0:
                        System.out.println();
                        System.out.println("Saindo...");
                        entradaDados.fecharScanner();
                        return;

                    default:
                        System.out.println();
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            }
        }
    }
}
