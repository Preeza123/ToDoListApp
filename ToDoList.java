import java.util.ArrayList;
import java.io.*;

public class ToDoList {
    private ArrayList<Task> tasks;
    private final String FILE_NAME = "tasks.txt";

    public ToDoList() {
        tasks = new ArrayList<>();
        loadTasks();
    }

    public void addTask(String desc) {
        tasks.add(new Task(desc));
        saveTasks();
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            saveTasks();
        }
    }

    public void markTaskCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markCompleted();
            saveTasks();
        }
    }

    public void displayTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private void saveTasks() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Task task : tasks) {
                writer.write(task.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks.");
        }
    }

    private void loadTasks() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                tasks.add(new Task(line));
            }
        } catch (IOException e) {
            System.out.println("No saved tasks found.");
        }
    }
}
