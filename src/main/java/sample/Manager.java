package sample;

import sample.Word;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Manager {

    private static ArrayList<Word> wordArray = new ArrayList<Word>();
    static private String fileName = "vocabulary.txt";
    static Random random = new Random();
    private int lang = 0;
    private String language;
    private String question, answer;
    static Word word;

    public void createVocabulary() {

        wordArray.clear();
        //dictionaryArray.clear();
        File vocabulary = new File(fileName);
        Scanner inputStream;
        String[] pair;

        try {
            inputStream = new Scanner(vocabulary);
            while (inputStream.hasNext()) {

                String string = inputStream.next();

                if (string.contains(",")) {
                    pair = string.split(",");
                }

                else {
                    System.out.println("Irrelevant value! " + string);

                    continue;}

                if ((pair[0] == null) || (pair[1] == null)) {

                    System.out.println("Empty value! " + string);

                    continue;

                } else {
                    wordArray.add(new Word(pair[0], pair[1]));

                }

            }
            inputStream.close();
            //System.out.println("Size = " + wordArray.size());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void createQuestion() {

        int randomWordPosition = random.nextInt(wordArray.size());

        word = wordArray.get(randomWordPosition);

        switch (getLang()) {


            case 0:
                setLanguage("Eng");
                setQuestion(word.getEng());
                setAnswer(word.getRus());
                break;

            case 1:
                setLanguage("Rus");
                setQuestion(word.getRus());
                setAnswer(word.getEng());
                break;
        }

    }

    public static void remooveWordFromVocabulary() {

        System.out.println("Size is " + wordArray.size());
        wordArray.remove(word);
        //dictionaryArray.remove(s);
        System.out.println("After removing size now is " + wordArray.size());
    }

    public void addWord(String word, String translation) {

        if ((word.equals("")) || (translation.equals(""))) {
            JOptionPane.showMessageDialog(null, "Enter the word, you punk!",
                    "Error",
                    JOptionPane.INFORMATION_MESSAGE);

        } else {

            String newWord = word + "," + translation;


            try {

                FileOutputStream fos = new FileOutputStream(fileName, true);
                PrintStream printStream = new PrintStream(fos);
                printStream.println();
                printStream.print(newWord);

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }

        }


    }


    //Getters and setters

    public void setLang(int langnum) {

        lang = langnum;

    }

    public int getLang() {

        return lang;

    }

    public void setLanguage(String lang) {

        language = lang;

    }

    public String getLanguage() {

        return language;

    }

    public void setQuestion(String quest) {

        question = quest;

    }

    public String getQuestion() {

        return question;

    }

    public void setAnswer(String answ) {

        answer = answ;

    }

    public String getAnswer() {

        return answer;

    }

    public int getArraySize() {

        return wordArray.size();

    }


}
