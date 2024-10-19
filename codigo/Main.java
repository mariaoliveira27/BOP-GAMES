package codigo;

import codigo.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Ciclista> ciclistas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1. Adicionar Ciclista");
            System.out.println("2. Registrar Etapa");
            System.out.println("3. Exibir Ciclistas");
            System.out.println("4. Calcular Diferença de Tempo");
            System.out.println("5. Ver Vencedor da Etapa");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    adicionarCiclista();
                    break;
                case 2:
                    registrarEtapa();
                    break;
                case 3:
                    exibirCiclistas();
                    break;
                case 4:
                    calcularDiferencaTempo();
                    break;
                case 5:
                    verVencedorEtapa();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void adicionarCiclista() {
        System.out.print("Nome do Ciclista: ");
        String nome = scanner.nextLine();
        System.out.print("Número do Ciclista: ");
        int numero = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha
        System.out.print("Cidade de Origem: ");
        String cidade = scanner.nextLine();

        Ciclista ciclista = new Ciclista(nome, numero, cidade);
        ciclistas.add(ciclista);
        System.out.println("Ciclista adicionado com sucesso!");
    }

    private static void registrarEtapa() {
        System.out.print("Número da Etapa: ");
        int numeroEtapa = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        System.out.print("Data (dd mm aaaa): ");
        String[] dataInput = scanner.nextLine().split(" ");
        Data data = new Data(Integer.parseInt(dataInput[0]), Integer.parseInt(dataInput[1]), Integer.parseInt(dataInput[2]));

        System.out.print("Hora Inicial (hh mm ss): ");
        String[] horaInput = scanner.nextLine().split(" ");
        Hora horaInicial = new Hora(Integer.parseInt(horaInput[0]), Integer.parseInt(horaInput[1]), Integer.parseInt(horaInput[2]));

        System.out.print("Duração em Segundos: ");
        int duracaoEmSegundos = scanner.nextInt();
        Duracao duracao = new Duracao(horaInicial, duracaoEmSegundos);

        System.out.print("Número do Ciclista: ");
        int numeroCiclista = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        Ciclista ciclista = encontrarCiclista(numeroCiclista);
        if (ciclista != null) {
            ciclista.registrarEtapa(new Etapa(numeroEtapa, data, horaInicial, duracao));
            System.out.println("Etapa registrada com sucesso!");
        } else {
            System.out.println("Ciclista não encontrado.");
        }
    }

    private static void exibirCiclistas() {
        if (ciclistas.isEmpty()) {
            System.out.println("Nenhum ciclista cadastrado.");
        } else {
            for (Ciclista ciclista : ciclistas) {
                System.out.println(ciclista);
            }
        }
    }

    private static void calcularDiferencaTempo() {
        System.out.print("Número do Primeiro Ciclista: ");
        int numero1 = scanner.nextInt();
        System.out.print("Número do Segundo Ciclista: ");
        int numero2 = scanner.nextInt();

        Ciclista ciclista1 = encontrarCiclista(numero1);
        Ciclista ciclista2 = encontrarCiclista(numero2);

        if (ciclista1 != null && ciclista2 != null) {
            String diferenca = ciclista1.tempoEntreCiclistas(ciclista2);
            System.out.println(diferenca);
        } else {
            System.out.println("Um ou ambos os ciclistas não foram encontrados.");
        }
    }

    private static void verVencedorEtapa() {
        System.out.print("Número da Etapa: ");
        int numeroEtapa = scanner.nextInt();
        System.out.print("Número do Primeiro Ciclista: ");
        int numero1 = scanner.nextInt();
        System.out.print("Número do Segundo Ciclista: ");
        int numero2 = scanner.nextInt();

        Ciclista ciclista1 = encontrarCiclista(numero1);
        Ciclista ciclista2 = encontrarCiclista(numero2);

        if (ciclista1 != null && ciclista2 != null) {
            Ciclista vencedor = ciclista1.vencedorDaEtapa(ciclista2, numeroEtapa);
            if (vencedor != null) {
                System.out.println("Vencedor da Etapa " + numeroEtapa + ": " + vencedor.getNome());
            } else {
                System.out.println("Ambos ciclistas não completaram a etapa.");
            }
        } else {
            System.out.println("Um ou ambos os ciclistas não foram encontrados.");
        }
    }

    private static Ciclista encontrarCiclista(int numero) {
        for (Ciclista ciclista : ciclistas) {
            if (ciclista.getNumero() == numero) {
                return ciclista;
            }
        }
        return null;
    }
}