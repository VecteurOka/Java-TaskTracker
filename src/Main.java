import cli.TaskCLI;

public class Main {
    public static void main(String[] args) {
        try {
            TaskCLI cli = new TaskCLI();
            cli.start();
        } catch (Exception e) {
            System.err.println("Erreur critique lors de l'exécution de l'application : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
