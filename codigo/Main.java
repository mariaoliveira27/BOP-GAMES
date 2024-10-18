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