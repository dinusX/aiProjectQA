/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package QuestionParser;

import com.softcorporation.suggester.tools.SpellCheck;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
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
  
        //Parsing Main Questions
            String[] questions = TestingData.getMainQuestions();
            for(String question : questions)
            {
                Question parsedQuestion = Parser.parse(MainKnowledge.checkAndCorrect(question));
                System.out.println("Out: " + parsedQuestion);
            }

    

        
        
        
        
        
        //Examples: (Nu sterge)
        
//          Correcting spelling errors
//        String response = MainKnowledge.checkAndCorrect("Wher are you from?"); 
//        System.out.println("Response: " + response);
        
        
        
        //Search Wikipedia
//        try {
//            String y = MainKnowledge.getWiki("A Christmas Carol");
//            System.out.println("received: " + y);
//        } catch (MalformedURLException ex) {
//            System.err.println("Error wiki");
//        } catch (IOException ex) {
//            System.err.println("Error wiki");
//        }

        
        
        
    }
}


