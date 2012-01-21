/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package QuestionParser;

/**
 *
 * @author Dinu
 */
public class MainKnowledge {
    
    
    public String answer(String questionText)
    {
        Question question = Parser.parse(questionText);
        
        return "Hello World";
    }
    
    public void loadKnowledge(String path)
    {
        //TODO
    }
}
