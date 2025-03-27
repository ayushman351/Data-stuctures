class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    // Constructor to initialize task details
    Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    private Task head;
    private Task currentTask;

    // Add a task at the beginning of the circular linked list
    void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            head.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
            head = newTask;
        }
        if (currentTask == null) {
            currentTask = head;
        }
    }

    // Add a task at the end of the circular linked list
    void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            head.next = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
        }
        if (currentTask == null) {
            currentTask = head;
        }
    }

    // Remove a task by task ID
    void removeTask(int taskId) {
        if (head == null) return;
        Task temp = head, prev = null;
        do {
            if (temp.taskId == taskId) {
                if (prev != null) {
                    prev.next = temp.next;
                    if (temp == head) head = temp.next;
                } else {
                    if (head.next == head) {
                        head = null;
                    } else {
                        Task last = head;
                        while (last.next != head) last = last.next;
                        head = head.next;
                        last.next = head;
                    }
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    // View the current task and move to the next task in circular order
    void viewAndMoveToNextTask() {
        if (currentTask != null) {
            System.out.println("Current Task: " + currentTask.taskName + " (Priority: " + currentTask.priority + ")");
            currentTask = currentTask.next;
        }
    }

    // Display all tasks starting from the head
    void displayTasks() {
        if (head == null) return;
        Task temp = head;
        do {
            System.out.println("Task ID: " + temp.taskId + ", Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for a task by priority
    void searchTaskByPriority(int priority) {
        if (head == null) return;
        Task temp = head;
        do {
            if (temp.priority == priority) {
                System.out.println("Task Found: " + temp.taskName + " (Due: " + temp.dueDate + ")");
            }
            temp = temp.next;
        } while (temp != head);
    }
}

public class TaskSchedulerSystem {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        
        // Adding tasks
        scheduler.addTaskAtBeginning(1, "Task A", 1, "2024-04-10");
        scheduler.addTaskAtEnd(2, "Task B", 2, "2024-04-12");
        scheduler.addTaskAtEnd(3, "Task C", 3, "2024-04-15");
        
        // Display tasks
        System.out.println("Task List:");
        scheduler.displayTasks();
        
        // View and move to the next task
        System.out.println("\nViewing and Moving to Next Task:");
        scheduler.viewAndMoveToNextTask();
        scheduler.viewAndMoveToNextTask();
        
        // Searching for a task by priority
        System.out.println("\nSearching for Priority 2 Tasks:");
        scheduler.searchTaskByPriority(2);
        
        // Removing a task
        System.out.println("\nRemoving Task B");
        scheduler.removeTask(2);
        scheduler.displayTasks();
    }
}
