/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package QuestionParser;

/**
 *
 * @author Dinu
 */
public class Question
{


    private String questionType = "FACTOID";
    private String answerType = "OTHER";
    private String originalText = "";
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

}