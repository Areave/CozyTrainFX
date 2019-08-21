package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {

    static Manager manager = new Manager();
    static Controller controller = new Controller();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button restartBut;

    @FXML
    private Button hintBut;

    @FXML
    private static Text questionField;

    @FXML
    private Button addBut;

    @FXML
    private static Label languageField;

    @FXML
    private static Label messageField;

    @FXML
    private static TextField answerField;

    @FXML
    private Button changeBut;

    @FXML
    private static Label counterLabel;


    @FXML
    void initialize() {

        System.out.println("Controller initialize");

        questionField = new Text();

        manager.createVocabulary();

        start();

        /*

        answerField.setOnAction(event -> {
            makeProcesing();
        });

        restartBut.setOnAction(event -> {
            manager.createVocabulary();
            messageField.setText("Try to translate!");

            addBut.setVisible(true);
            hintBut.setVisible(true);
            changeBut.setVisible(true);
            languageField.setVisible(true);
            answerField.setVisible(true);
            counterLabel.setVisible(true);

            controller.start();
        });
*/
        /*
        addBut.setOnAction(event -> {
                AddWordForm myDialog = new AddWordForm();
                myDialog.setTitle("Cozy Train 3.0");
                myDialog.setLocation(510, 250);
                //myDialog.setIconImage(makeIcon());
                myDialog.pack();
                myDialog.setVisible(true);
        });

*/
        hintBut.setOnAction(event -> {

            messageField.setText(manager.getAnswer());

        });

        changeBut.setOnAction(event -> {

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
        );


    }

    public static void start() {

        System.out.println("Controller start");

        manager.createQuestion();

        System.out.println(manager.getAnswer());

        questionField.setText("HJJHV");

        //questionField.setText("HJJHV");//manager.getQuestion());
                        /*
        answerField.setText("");
        counterLabel.setText("Remain " + manager.getArraySize() + " words");
        languageField.setText("Current language: " + manager.getLanguage());

         */
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

    /*
    private static Image makeIcon() {

        String path = "iconpng.png";
        URL imgURL = TrainForm.class.getResource(path);
        ImageIcon icon = new ImageIcon(imgURL);
        Image iconImage = icon.getImage();
        return iconImage;


    }
    */

}
