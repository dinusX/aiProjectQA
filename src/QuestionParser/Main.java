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
import java.util.ArrayList;
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
//            String[] questions = TestingData.getMainQuestions(1);
//            for(String question : questions)
//            {
//                Question parsedQuestion = Parser.parse(MainKnowledge.checkAndCorrect(question));
//                System.out.println("Out: " + parsedQuestion);
//            }


        
        
        
        
        
        
        
        
        
        
        //Exemple lematizare
//        System.out.println("rez: " + Lemmatizer.lemmatize("being able to answered: how would you like to be when you were young, or the biggest problem we have here is strongest boys from everywhere?"));
//        System.out.println("rez2:" + Lemmatizer.lemmatize(new String[]{"being able to answered how would you like to be when you were young or the biggest problem we have here is strongest boys from everywhere?"})[0]);
//        String[] words = Lemmatizer.lemmatize(new String[]{"being", "able", "to", "answered", "how", "would", "you", "like", "to", "be", "when", "you", "were", "young", "or", "the", "biggest", "problem", "we", "have", "here", "is", "strongest", "boys", "from", "everywhere"});
//        for(String word : words)
//        {
//            System.out.println("w: " + word);
//        }
//        ArrayList list = new ArrayList();
//        list.add("being able to answered: how would you like to be when you were young, or the biggest problem we have here is strongest boys from everywhere?");
//        System.out.println("rez3:" + Lemmatizer.lemmatize(new String[]{"being able to answered how would you like to be when you were young or the biggest problem we have here is strongest boys from everywhere?"})[0]);
//        list = new ArrayList();
//        list.add("being");
//        list.add("able");
//        list.add("to");
//        list.add("answered");
//        list.add("how");
//        list.add("would");
//        list.add("you");
//        list.add("like");
//        list.add("to");
//        list.add("be");
//        list.add("when");
//        list.add("you");
//        list.add("were");
//        list.add("young");
//        list.add("or");
//        list.add("the");
//        list.add("biggest");
//        list.add("problem");
//        list.add("we");
//        list.add("have");
//        list.add("here");
//        list.add("is");
//        list.add("strongest");
//        list.add("boys");
//        list.add("from");
//        list.add("everywhere");
//        ArrayList list2 = Lemmatizer.lemmatize(list) ;
//        for(Object s : list2)
//        {
//            System.out.println(s);
//        }
        
        
        
        //Examples: (Nu sterge)
        
//          Correcting spelling errors
//        String response = MainKnowledge.checkAndCorrect("Wher are you from?"); 
//        System.out.println("Response: " + response);
        
        
        
        //Search Wikipedia
        try {
            HashMap<String,String> data = new HashMap();
            String parsedText = MainKnowledge.getWiki("A Christmas Carol", data);
            System.out.println("received: " + parsedText);
            for(String key : data.keySet())
            {
                System.out.println(key + ": " + data.get(key));
            }
        } catch (MalformedURLException ex) {
            System.err.println("Error wiki");
        } catch (IOException ex) {
            System.err.println("Error wiki");
        }

        
        
        
    }
}


