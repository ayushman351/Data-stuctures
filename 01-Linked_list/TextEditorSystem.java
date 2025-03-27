class TextState {
    String content;
    TextState next, prev;

    // Constructor to store text state
    TextState(String content) {
        this.content = content;
        this.next = this.prev = null;
    }
}

class TextEditor {
    private TextState head, tail, current;
    private int maxHistory;
    private int stateCount;

    // Constructor
    TextEditor(int maxHistory) {
        this.maxHistory = maxHistory;
        this.stateCount = 0;
        this.head = this.tail = this.current = null;
    }

    // Add a new text state
    void addState(String content) {
        TextState newState = new TextState(content);
        if (head == null) {
            head = tail = current = newState;
        } else {
            current.next = newState;
            newState.prev = current;
            current = newState;
            tail = newState;
        }
        stateCount++;
        if (stateCount > maxHistory) {
            head = head.next;
            head.prev = null;
            stateCount--;
        }
    }

    // Undo function
    void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo: " + current.content);
        } else {
            System.out.println("No more undo steps available.");
        }
    }

    // Redo function
    void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo: " + current.content);
        } else {
            System.out.println("No more redo steps available.");
        }
    }

    // Display current state of text
    void displayCurrentState() {
        if (current != null) {
            System.out.println("Current Text: " + current.content);
        } else {
            System.out.println("No text available.");
        }
    }
}

public class TextEditorSystem {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10);

        // Simulating text editing
        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.displayCurrentState();

        // Undo and Redo operations
        editor.undo();
        editor.displayCurrentState();
        editor.undo();
        editor.displayCurrentState();
        editor.redo();
        editor.displayCurrentState();
    }
}
