import java.util.Stack;

interface Command {
    void execute();
    void undo();
}

class TextEditor {
    private StringBuilder text = new StringBuilder();

    public void addText(String newText) {
        text.append(newText);
    }

    public void removeText(int length) {
        text.delete(text.length() - length, text.length());
    }

    public String getText() {
        return text.toString();
    }
}

class AddTextCommand implements Command {
    private TextEditor editor;
    private String textToAdd;

    AddTextCommand(TextEditor editor, String text) {
        this.editor = editor;
        this.textToAdd = text;
    }

    @Override
    public void execute() {
        editor.addText(textToAdd);
    }

    @Override
    public void undo() {
        editor.removeText(textToAdd.length());
    }
}

public class CommandPatternExample {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Stack<Command> commandHistory = new Stack<>();

        Command addHello = new AddTextCommand(editor, "Hello ");
        addHello.execute();
        commandHistory.push(addHello);

        Command addWorld = new AddTextCommand(editor, "World!");
        addWorld.execute();
        commandHistory.push(addWorld);

        System.out.println("Current Text: " + editor.getText());

        // Undo the last command
        commandHistory.pop().undo();
        System.out.println("After Undo: " + editor.getText());
    }
}
