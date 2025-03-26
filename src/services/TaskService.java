package services;

import models.Task;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe gérant les opérations sur les tâches.
 */
public class TaskService {
    private final List<Task> tasks = new ArrayList<>(); // Liste des tâches

    /**
     * Ajoute une nouvelle tâche.
     * @param description Description de la tâche
     */
    public void addTask(String description) {
        int id = tasks.size() + 1;
        tasks.add(new Task(id, description, "todo"));
    }

    /**
     * Met à jour la description d'une tâche.
     * @param id Identifiant de la tâche
     * @param newDescription Nouvelle description de la tâche
     */
    public void updateTask(int id, String newDescription) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setDescription(newDescription);
                return;
            }
        }
    }

    /**
     * Supprime une tâche.
     * @param id Identifiant de la tâche
     */
    public void deleteTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
    }

    /**
     * Marque une tâche comme en cours.
     * @param id Identifiant de la tâche
     */
    public void markInProgress(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setStatus("in-progress");
                return;
            }
        }
    }

    /**
     * Marque une tâche comme terminée.
     * @param id Identifiant de la tâche
     */
    public void markDone(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setStatus("done");
                return;
            }
        }
    }

    /**
     * Liste toutes les tâches.
     * @return Liste des tâches
     */
    public List<Task> listTasks() {
        return new ArrayList<>(tasks);
    }

    /**
     * Liste les tâches par statut.
     * @param status Statut des tâches à lister
     * @return Liste des tâches correspondant au statut
     */
    public List<Task> listTasksByStatus(String status) {
        List<Task> result = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getStatus().equalsIgnoreCase(status)) {
                result.add(task);
            }
        }
        return result;
    }
}