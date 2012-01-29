/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package QuestionParser;

import java.util.ArrayList;

/**
 *
 * @author Dinu
 */
public class Question
{

    private Multiplicity multiplicity = Multiplicity.UNKNOWN;
    
//    private String questionType = "FACTOID";
    private AnswerType answerType = AnswerType.OTHER;
    private String originalText = "";
    
    private String[] keywords=null;
    private ArrayList<FocusType> focusTypes = new ArrayList<FocusType>();
    private ArrayList<String> mainObjects = new ArrayList<String>();

    
    public void addMainObject(String mainObject) {
        this.mainObjects.add(mainObject);
    }

    public ArrayList<String> getMainObjects() {
        return this.mainObjects;
    }
    
    public void addFocusType(FocusType focus) {
        focusTypes.add(focus);
    }
    
//    private String focus = "";

    public Question(String text)
    {
        originalText = text;
    }
        
    public AnswerType getAnswerType() {
        return answerType;
    }

    public String getOriginalText() {
        return originalText;
    }

//    public String getQuestionType() {
//        return questionType;
//    }

    public void setAnswerType(AnswerType answerType) {
        this.answerType = answerType;
    }

    public void setOriginalText(String originalText) {
        this.originalText = originalText;
    }

//    public void setQuestionType(String questionType) {
//        this.questionType = questionType;
//    }
//
//    public void setFocus(String focus) {
//        this.focus = focus;
//    }
    
//    public String getFocus() {
//        return focus;
//    }

    public String[] getKeywords() {
        return keywords;
    }

//    public void setKeywords(ArrayList keywords) {
//        this.keywords = new String[keywords.size()];
//        keywords.toArray(this.keywords);
//    }
    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }
    
    
    public void setMulitplicity(Multiplicity multiplicity)
    {
        this.multiplicity = multiplicity;
    }

    public Multiplicity getMulitplicity() {
        return this.multiplicity;
    }
   
    
    @Override
    public String toString()
    {
        StringBuilder string = new StringBuilder();
        string.append("Original question: ");
        string.append(originalText);
        string.append("\n"); 
        
//        string.append("QuestionType: " + questionType + "\n");
        string.append("AnswerType: " + answerType + "\n");
        
        string.append("Focus: ");
        for (FocusType word : focusTypes) {
            string.append(word + ", ");
        }
        string.append("\n");
        
        string.append("Main Objects: ");
        for (String word : mainObjects) {
            string.append(word + ", ");
        }
        string.append("\n");

        string.append("Keywords: ");
        if(keywords != null)
        {
            for(String word : keywords)
            {
                string.append(word + ", ");
            }
        }
        
        string.append("\n");
        return string.toString();
    }

    
}


