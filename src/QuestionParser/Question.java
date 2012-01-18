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


    private String questionType = "FACTOID";
    private String answerType = "OTHER";
    private String originalText = "";
    
    private String[] keywords=null;
    private String focus = "";

    public Question(String text)
    {
        originalText = text;
    }
        public String getAnswerType() {
        return answerType;
    }

    public String getOriginalText() {
        return originalText;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setAnswerType(String answerType) {
        this.answerType = answerType;
    }

    public void setOriginalText(String originalText) {
        this.originalText = originalText;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public void setFocus(String focus) {
        this.focus = focus;
    }
    
    public String getFocus() {
        return focus;
    }

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
    

   
    
    @Override
    public String toString()
    {
        StringBuilder string = new StringBuilder();
        string.append("Original question: " + originalText + "\n");
        string.append("QuestionType: " + questionType + "\n");
        string.append("AnswerType: " + answerType + "\n");
        string.append("Focus: " + focus + "\n");
        string.append("Keywords: ");
        for(String word : keywords)
        {
            string.append(word + " ");
        }
        
        string.append("\n");
        return string.toString();
    }
}