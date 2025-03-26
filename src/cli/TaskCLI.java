package cli;

import services.TaskService;
import java.util.Scanner;

/**
 * Classe gérant l'interface en ligne de commande pour les tâches.
 */
public class TaskCLI {
    private final TaskService taskService; // Service de gestion des tâches
    private final Scanner scanner; // Scanner pour lire les entrées utilisateur

    public TaskCLI() {
        this.taskService = new TaskService();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Démarre l'interface CLI.
     */
    public void start() {
        System.out.println("Bienvenue dans Task Tracker !");
        System.out.println("Commandes disponibles :");
        System.out.println("  add <description>           - Ajouter une nouvelle tâche");
        System.out.println("  update <id> <description>   - Mettre à jour une tâche");
        System.out.println("  delete <id>                 - Supprimer une tâche");
        System.out.println("  in-progress <id>            - Marquer une tâche comme en cours");
        System.out.println("  done <id>                   - Marquer une tâche comme terminée");
        System.out.println("  list                        - Lister toutes les tâches");
        System.out.println("  list <status>               - Lister les tâches par statut");
        System.out.println("  exit                        - Quitter le programme");

        while (true) {
            System.out.print("\n> ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Fermeture de Task Tracker...");
                break;
            }
            handleCommand(input);
        }
    }

    /**
     * Traite les commandes de l'utilisateur.
     * @param input Commande utilisateur
     */
    private void handleCommand(String input) {
        String[] parts = input.split(" ", 2);
        String command = parts[0];

        try {
            switch (command) {
                case "add":
                    if (parts.length < 2) {
                        System.out.println("Erreur : Description requise.");
                    } else {
                        taskService.addTask(parts[1]);
                        System.out.println("Tâche ajoutée.");
                    }
                    break;

                case "update":
                    String[] updateParts = parts[1].split(" ", 2);
                    if (updateParts.length < 2) {
                        System.out.println("Erreur : ID et description requis.");
                    } else {
                        int id = Integer.parseInt(updateParts[0]);
                        taskService.updateTask(id, updateParts[1]);
                        System.out.println("Tâche mise à jour.");
                    }
                    break;

                case "delete":
                    int deleteId = Integer.parseInt(parts[1]);
                    taskService.deleteTask(deleteId);
                    System.out.println("Tâche supprimée.");
                    break;

                case "in-progress":
                    int progressId = Integer.parseInt(parts[1]);
                    taskService.markInProgress(progressId);
                    System.out.println("Tâche marquée comme en cours.");
                    break;

                case "done":
                    int doneId = Integer.parseInt(parts[1]);
                    taskService.markDone(doneId);
                    System.out.println("Tâche marquée comme terminée.");
                    break;

                case "list":
                    if (parts.length == 1) {
                        taskService.listTasks().forEach(System.out::println);
                    } else {
                        taskService.listTasksByStatus(parts[1]).forEach(System.out::println);
                    }
                    break;

                default:
                    System.out.println("Commande inconnue. Tapez 'help' pour voir les commandes.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Erreur : L'ID doit être un nombre valide.");
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        TaskCLI cli = new TaskCLI();
        cli.start();
    }
}