package models;

import java.time.LocalDateTime;

/**
 * Classe représentant une tâche avec ses propriétés et méthodes.
 */
public class Task {
    private final int id; // Identifiant unique de la tâche
    private String description; // Description de la tâche
    private String status; // Statut de la tâche (todo, in-progress, done)
    private final LocalDateTime createdAt; // Date de création de la tâche
    private LocalDateTime updatedAt; // Date de dernière mise à jour de la tâche

    /**
     * Constructeur de la classe Task.
     * @param id Identifiant unique de la tâche
     * @param description Description de la tâche
     * @param status Statut de la tâche
     */
    public Task(int id, String description, String status) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Getters et setters pour les propriétés de la tâche
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        this.updatedAt = LocalDateTime.now();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        this.updatedAt = LocalDateTime.now();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}