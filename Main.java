import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ToDoList todo = new ToDoList();

        while (true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Mark Completed");
            System.out.println("4. View Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter task: ");
                    String desc = sc.nextLine();
                    todo.addTask(desc);
                    break;
                case 2:
                    System.out.print("Enter task number to remove: ");
                    int removeIndex = sc.nextInt() - 1;
                    todo.removeTask(removeIndex);
                    break;
                case 3:
                    System.out.print("Enter task number to mark as completed: ");
                    int completeIndex = sc.nextInt() - 1;
                    todo.markTaskCompleted(completeIndex);
                    break;
                case 4:
                    todo.displayTasks();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
