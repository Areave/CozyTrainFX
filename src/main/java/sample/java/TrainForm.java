package sample.java;

import sample.Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class TrainForm {
    private JTextField answerField;
    private JButton addBut;
    private JButton hintBut;
    private JButton changeBut;
    private JButton restartBut;
    private JLabel questionField;
    private JLabel messageField;
    private JPanel rootPanel;
    private JLabel languageField;
    private JPanel backgroundPanel;
    private JPanel ButtonPanel;
    private JPanel TextPanel;
    private JLabel counterLabel;
    private static Color blue = new Color(63, 147, 145);
    private static Manager manager = new Manager();
    private static TrainForm trainForm = new TrainForm();


    public TrainForm() {


        answerField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                makeProcesing();
            }
        });
        restartBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                manager.createVocabulary();
                messageField.setText("Try to translate!");

                addBut.setVisible(true);
                hintBut.setVisible(true);
                changeBut.setVisible(true);
                languageField.setVisible(true);
                answerField.setVisible(true);
                counterLabel.setVisible(true);

                trainForm.start();
            }
        });
        hintBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                messageField.setText(manager.getAnswer());
            }
        });
        addBut.addActionListener(new ActionListener() {
           // @Override
            public void actionPerformed(ActionEvent e) {
                AddWordForm myDialog = new AddWordForm();
                myDialog.setTitle("Cozy Train 3.0");
                myDialog.setLocation(510, 250);
                //myDialog.setIconImage(makeIcon());
                myDialog.pack();
                myDialog.setVisible(true);
            }
        });
        changeBut.addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {

                switch (manager.getLang()) {

                    case 0:
                        manager.setLang(1);
                        manager.setLanguage("Russian");
                        break;

                    case 1:
                        manager.setLang(0);
                        manager.setLanguage("English");
                        break;

                }

                start();

            }
        });
    }


    public static void main(String[] args) {

        JFrame frame = new JFrame("Cozy Train 3.0");
        frame.setContentPane(trainForm.rootPanel);
        //frame.setBackground(blue);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setIconImage(makeIcon());
        frame.setBounds(400, 200, 500, 250);
        manager.createVocabulary();
        trainForm.start();

    }

    public void start() {
        System.out.println("Start");
        manager.createQuestion();
        questionField.setText(manager.getQuestion());
        answerField.setText("");
        counterLabel.setText("Remain " + manager.getArraySize() + " words");
        languageField.setText("Current language: " + manager.getLanguage());

    }

    private void makeProcesing() {

        if (manager.getArraySize() == 0) {

            finalState();

        } else if (answerField.getText().equals(manager.getAnswer())) {

            messageField.setText("Right!");

            if (manager.getArraySize() == 1) {
                manager.remooveWordFromVocabulary();
                finalState();

            } else {
                manager.remooveWordFromVocabulary();
                start();
            }

        } else {
            messageField.setText("No, it's not the answer");
            start();
        }


    }

    public void finalState() {
        questionField.setText("All words are tranlated!");
        answerField.setText("");
        messageField.setText("Congrats you smartass!");
        languageField.setText("You are smartass!");
        addBut.setVisible(false);
        hintBut.setVisible(false);
        changeBut.setVisible(false);
        languageField.setVisible(false);
        answerField.setVisible(false);
        counterLabel.setVisible(false);

    }

    private static Image makeIcon() {

        String path = "iconpng.png";
        URL imgURL = TrainForm.class.getResource(path);
        ImageIcon icon = new ImageIcon(imgURL);
        Image iconImage = icon.getImage();
        return iconImage;


    }

}



