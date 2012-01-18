/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package QuestionParser;

/**
 *
 * @author Dinu
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Parser parser = new Parser();
        Question question = parser.Parse("What's your name?");

        System.out.println("Question Type: " + question.getQuestionType());
        System.out.println("Answer Type: " + question.getAnswerType());
    }

}
