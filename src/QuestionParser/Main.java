/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package QuestionParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Dinu
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args){
        // TODO code application logic here
//        Parser parser = new Parser();
//        Question question = parser.Parse("What's your name?");
//
//        System.out.println("Question Type: " + question.getQuestionType());
//        System.out.println("Answer Type: " + question.getAnswerType());


//        System.out.println("out: " + Pattern.compile("What is?").matcher("What ").matches());
        
        String[] questions = TestingData.getMainQuestions();
        for(String question2 : questions)
        {
            Question parsedQuestion = Parser.parse(question2);
            System.out.println("Out: " + parsedQuestion);
        }
    }
}


