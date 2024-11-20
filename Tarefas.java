import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Tarefas {

    // Lista para armazenar as tarefas
    private static ArrayList<String> tarefas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opçao;

        do {
            exibirMenu();
            System.out.println("Escolha uma opção: ");
            opçao = scanner.nextInt();
            scanner.nextLine();

            switch (opçao) {
                case 1:
                    adicionarTarefa(scanner);
                    break;
                case 2:
                    listarTarefa();
                    break;
                case 3:
                    removerTarefa(scanner);
                    break;
                case 4:
                    salvarTarefaEmArquivo();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    ;
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
                    ;
            }
        } while (opçao != 5);

        scanner.close();
    }

    // Exibe o menu principal
    private static void exibirMenu() {
        System.out.println("\n=== Gerenciador de Tarefas ===");
        System.out.println("1. Adicionar tarefa");
        System.out.println("2. Listar tarefas");
        System.out.println("3. Remover tarefa");
        System.out.println("4. Salvar tarefas em arquivo");
        System.out.println("5. Sair");
    }

    // Adicionar nova tarefa
    private static void adicionarTarefa(Scanner scanner) {
        System.out.println("Digite a descrição da tarefa: ");
        String tarefa = scanner.nextLine();
        tarefas.add(tarefa);
        System.out.println("Tarefa adicionada com sucesso");
    }

    // Listar todas as tarefas
    private static void listarTarefa() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada");
        } else {
            System.out.println("Tarefas: ");
            for (int i = 0; i < tarefas.size(); i++) {
                System.out.println((i + 1) + ". " + tarefas.get(i));
            }
        }
    }

    // Remover tarefa pelo índice
    private static void removerTarefa(Scanner scanner) {
        listarTarefa();
        if (!tarefas.isEmpty()) {
            System.out.println("Digite o número da tarefa a ser removida: ");
            int indice = scanner.nextInt() - 1;
            scanner.nextLine();

            if (indice >= 0 && indice < tarefas.size()) {
                String tarefaRemovida = tarefas.remove(indice);
                System.out.println("Tarefa removida: " + tarefaRemovida);
            } else {
                System.out.println("Índice inválido");
            }
        }
    }

    // Salvar as tarefas no arquivo tarefas.txt
    private static void salvarTarefaEmArquivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("tarefas.txt"))) {
            for (String tarefa : tarefas) {
                writer.write(tarefa);
                writer.newLine();

            }
            System.out.println("Tarefas salvas com sucesso");
        } catch (IOException e) {
            System.out.println("Erro ao salvar tarefas no arquivo: " + e.getMessage());
        }
    }
}