public class Task {
    private String description;
    private boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    public void markCompleted() {
        this.isCompleted = true;
    }

    public String toString() {
        return (isCompleted ? "[✔] " : "[ ] ") + description;
    }
}
