package main;

import javafx.scene.control.TextArea;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * An print stream that print stuff onto the log text area
 * @author Chengcheng Ding
 */
public class TextFieldPrintStream extends PrintStream {

    private TextArea textArea;

    public TextFieldPrintStream(OutputStream out, TextArea textArea) {
        super(out);
        this.textArea = textArea;
    }

    @Override
    public void println(String s) {
        textArea.appendText(s+"\n");
    }

    @Override
    public void print(String s) {
        textArea.appendText(s);
    }
}
