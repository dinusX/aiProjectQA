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
        Parser parser = new Parser();
        Question question = parser.Parse("What's your name?");

        System.out.println("Question Type: " + question.getQuestionType());
        System.out.println("Answer Type: " + question.getAnswerType());
        //        Pattern r = Pattern.compile("\"(\\w)+\"");
        //        Matcher m = r.matcher("Who is \"Jora\" or \"Borea\" ?");
        //        
        ////        Matcher m = Pattern.("\"", "")
        //        int end = 0;
        //        while(m.find(end))
        //        {
        //            System.out.println("Zorro: " + m.group(0));
        //            end = m.end();
        //        }

//        HashMap<String, Character> wordType = new HashMap<String, Character>();
//        Scanner scanner = null;
//        try {
//            scanner = new Scanner(new FileInputStream("./lemmeEN.txt"));
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
////                System.out.println("type: " + line.charAt(0));
//                Pattern r = Pattern.compile("\"(\\w)+\"");
//                Matcher m = r.matcher(line);
//                
//                int end = 0;
//                while(m.find(end))
//                {
//                    wordType.put(m.group(0), line.charAt(0));
////                    System.out.println("Zorro: " + m.group(0));
//                    end = m.end();
//                }
////                System.out.println(scanner.nextLine());
////                break;
//            }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            if(scanner != null)
//                scanner.close();
//        }
        
        String[] questions = TestingData.getRandomQuestions(10);
        for(String question2 : questions)
        {
            Question parsedQuestion = parser.Parse(question2);
            System.out.println("Out: " + parsedQuestion);
        }
    }
}


