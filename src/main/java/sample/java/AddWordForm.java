package sample.java;

import sample.Manager;

import javax.swing.*;
import java.awt.event.*;

public class AddWordForm extends JDialog {
    private JPanel rootPanel;
    private JPanel textPanel;
    private JPanel buttonPanel;
    private JTextField translationField;
    private JTextField wordField;
    private JButton addButton;

    public AddWordForm() {

        setContentPane(rootPanel);
        setModal(true);
        getRootPane().setDefaultButton(addButton);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);





        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                cancel();
            }
        });
        // call onCancel() on ESCAPE
        rootPanel.registerKeyboardAction(new ActionListener() {
                                             public void actionPerformed(ActionEvent e) {
                                                 cancel();
                                             }
                                         },
                KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);


        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addWord();
            }
        });
    }


    private void addWord() {

        String word = wordField.getText();
        String translation = translationField.getText();
        Manager manager = new Manager();
        manager.addWord(word, translation);
        dispose();
    }

    private void cancel() {
        dispose();
    }


}
