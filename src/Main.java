import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entradaTeclado = new Scanner(System.in);
        
        // Entrada dos dados do cliente
        System.out.print("Digite a renda mensal: ");
        double rendaMensal = entradaTeclado.nextDouble();
        
        System.out.print("Digite o nível de endividamento (em %): ");
        double nivelEndividamento = entradaTeclado.nextDouble();
        
        System.out.print("Digite a pontuação de crédito (score de 300 a 850): ");
        double pontuacaoCredito = entradaTeclado.nextDouble();
        
        // Cálculo da avaliação do risco
        String risco = calcularRiscoCredito(rendaMensal, nivelEndividamento, pontuacaoCredito);
        
        System.out.println("O risco de crédito é: " + risco);
    }

    public static String calcularRiscoCredito(double rendaMensal, double nivelEndividamento, double pontuacaoCredito) {
        // Definição das variáveis fuzzy
        String renda = classificarRenda(rendaMensal);
        String endividamento = classificarEndividamento(nivelEndividamento);
        String credito = classificarPontuacaoCredito(pontuacaoCredito);
        
        // Avaliação do risco com base nas regras fuzzy
        if (renda.equals("Muito Baixa") && (endividamento.equals("Alto") || endividamento.equals("Muito Alto"))) {
            return "Muito Alto";
        } else if ((renda.equals("Baixa") && endividamento.equals("Muito Alto")) || (credito.equals("Muito Baixa"))) {
            return "Muito Alto";
        } else if (renda.equals("Baixa") && endividamento.equals("Alto")) {
            return "Alto";
        } else if (renda.equals("Média") && credito.equals("Média")) {
            return "Moderado";
        } else if (renda.equals("Alta") && endividamento.equals("Baixo") && credito.equals("Alta")) {
            return "Baixo";
        } else if (renda.equals("Muito Alta") && endividamento.equals("Muito Baixo") && credito.equals("Muito Alta")) {
            return "Muito Baixo";
        } else if (renda.equals("Baixa") && credito.equals("Baixa") && endividamento.equals("Médio")) {
            return "Alto";
        } else if (renda.equals("Média") && endividamento.equals("Médio")) {
            return "Moderado";
        } else if (renda.equals("Média") && endividamento.equals("Baixo") && credito.equals("Alta")) {
            return "Baixo";
        } else if (renda.equals("Alta") && credito.equals("Média") && endividamento.equals("Médio")) {
            return "Moderado";
        } else if (renda.equals("Alta") && endividamento.equals("Alto") && credito.equals("Baixa")) {
            return "Alto";
        } else {
            return "Indeterminado"; // Para casos não cobertos
        }
    }

    // Funções para classificar as entradas fuzzy
    public static String classificarRenda(double rendaMensal) {
        if (rendaMensal <= 1500) {
            return "Muito Baixa";
        } else if (rendaMensal <= 3000) {
            return "Baixa";
        } else if (rendaMensal <= 7000) {
            return "Média";
        } else if (rendaMensal <= 15000) {
            return "Alta";
        } else {
            return "Muito Alta";
        }
    }

    public static String classificarEndividamento(double nivelEndividamento) {
        if (nivelEndividamento <= 15) {
            return "Muito Baixo";
        } else if (nivelEndividamento <= 30) {
            return "Baixo";
        } else if (nivelEndividamento <= 60) {
            return "Médio";
        } else if (nivelEndividamento <= 80) {
            return "Alto";
        } else {
            return "Muito Alto";
        }
    }

    public static String classificarPontuacaoCredito(double pontuacaoCredito) {
        if (pontuacaoCredito <= 400) {
            return "Muito Baixa";
        } else if (pontuacaoCredito <= 500) {
            return "Baixa";
        } else if (pontuacaoCredito <= 700) {
            return "Média";
        } else if (pontuacaoCredito <= 800) {
            return "Alta";
        } else {
            return "Muito Alta";
        }
    }
}
