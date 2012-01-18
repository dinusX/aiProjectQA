/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package QuestionParser;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Dinu
 */
public class Parser {

    static 
    {
        loadKeywords();
    }


//persoane, numere, masuri, locatii, timp, organizatii, obiecte
    static final String[]wordnet =
    {
        "/(?>scorer|director|President|spouses|wife|writer|actor|artist\\s|singer|historian|thinker|author|mortal|immortal|member.?|partner.?|goddess|representatives|disciple)/",
        "/(?>position.?|age|percentage|percent|number.?)/",
        "/(?>area|height|mass|masses|amplitude|duration|depth|speed|length|quantity|size|density)/",
        "/(?>region.?|district.?|City|Capital|Capital.?|island.?|Peak|territory|province|continent|state)/",
        "/(?>year|century|period.?|date.?|time|hour)/",
        "/(?>organization|Organizers|agents|University|group|company|companies|entity|entities|Manufacturer|institution.?|prison.?|Order.?|Party|CIA|Agency|UNESCO|Eesti|Solidarity|Ethers|led|NATO|European Union|EU)/",
        "/(?>a|an)?\\s?(?>instrument|product|gun.?|machine|middle|unit|concrete-wood|equipment|toy.?|compass|compasses|armor.?|equipment|computer|device|Selena|stole)/"
    };
    
    static final String[][] q_types = {
        {"What's the procedure", "What is the procedure", "What are the stages", "What are the Community's procedures",
            "What  measures", "What are the Community's procedures for","Under what circumstances", "In what circumstances"},
        {"Why", "By what reason", "For what reason", "What is the motive", "What is  the main reason", "On what ground"},
        {"What is the purpose", "What's the purpose", "To what purpose", "On what purpose", "For what purpose",
            "What's the aim", "/What is the aim", "What's the objective", "What is the objective", "What are the goals",
            "What are the objectives", "What are the Community's objectives", "What are the aims", "What is the scope"},
        {"What means\\s+[A-Z]", "What is (a|an)", "What are the", "Who (is|was)\\s+[A-Z]", "What does the term",
            "What is meant by", "What(is|was|are)\\s+(?!(?>a|an)\\s)", "What is the meaning", "What is the definition"},
        {"What types", "Who were", "Whom", "Through what", "Name (?!(?>a|an)\\s)"}
    };
    
    static final String[][] a_types = {{"(Why|What|Name|With who|What is called)", // .*?+wordnet[0],
        "What is (his|her) name", "Who", "Whom", "Whos", "With who"},
            {"Approximately how many","Of how many", "How many", "How much", "Of how much", "(What|Who is)\\s"+ wordnet[1]},
            {"How (much|manny) ", "(What is the).*?"+wordnet[2]},
            {"What (state|city)", "From where", "Where", "(On what|What|On which|Name).*?"+wordnet[3]},
            {"When", "(In what|From what|At what|After how (much|many)) "+wordnet[4]},
            {"Who produced", "Who made", "(What was the|What is the|At|From what|What was|What is).*?(?<!of\\s)"+wordnet[5]},
            {"What ", "What (give|gived|gives)", "With what(he|she|it) ", "(What|Name|What is the name of the|For what|At what).*?"+wordnet[6]}
    };
    
    static String[] a_typesTitle = {"PERSON", "COUNT", "MEASURE", "LOCATION", "TIME", "ORGANIZATION", "OBJECT"};
    static String[] q_typesTitle = {"PROCEDURE", "RESON", "PURPOSE", "DEFINITION", "LIST"};
    
    public Question Parse(String question)
    {
        Question outputQuestion = new Question(question);

        Match match = new Match();
        Pattern r = Pattern.compile(a_types[0][0]);

        boolean found = false;
        for(int i=0; i<a_types.length; i++)
        {
            for(String pattern : a_types[i])
            {
                if(Pattern.matches(pattern, question))
                {
                    outputQuestion.setAnswerType(a_typesTitle[i]);
                    found = true;
                    break;
                }
            }
            if(found)
                break;
        }

        found = false;
        for(int i=0; i<q_types.length; i++)
        {
            for(String pattern : q_types[i])
            {
                if(Pattern.matches(pattern, question))
                {
                    outputQuestion.setQuestionType(q_typesTitle[i]);
                    found = true;
                    break;
                }
            }
            if(found)
                break;
        }

        findKeywords(outputQuestion);
        
        return outputQuestion;
    }
    
    public void findKeywords(Question question)
    {
        ArrayList list = new ArrayList();
        
        String text = question.getOriginalText();
        Pattern r = Pattern.compile("([\"\'](\\w)+[\"\'])|(\\s(([A-Z]\\w+\\s*)+))");
        Matcher m = r.matcher(text);
        int end = 0;
        while (m.find(end)) {
//            System.out.println("2: " + m.group(2));
//            System.out.println("4: " + m.group(4));
            
            if(m.group(2) != null)
                question.setFocus(m.group(2).trim());
            else
                question.setFocus(m.group(4).trim());
            end = m.end();
        }
        //TODO if not found focus set first noun.
        
//        r = Pattern.compile("Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday|January|February|March|April|June|July|August|September|October|November|December");
//        m = r.matcher(text);
//        end = 0;
//        while (m.find(end)) {
////            System.out.println("Zorro: " + m.group(0));
//            list.add(m.group(0)); //emphisize words
//            end = m.end();
//        }
        
//        System.out.println("words count: " + text.split(" ").length);
        
        
        text = text.replaceAll("[\\?,.!]", text);
        
        String[] words = text.split("\\s+");
        
        //TODO filter words
        
        question.setKeywords(words);
        
        //TODO continue parsing
    }
    
    static HashMap<String, Character> wordType = null;
    private static void loadKeywords()
    {
        if(wordType != null)
            return;
        wordType = new HashMap<String, Character>();
        Scanner scanner = null;
        String last = "";
        char type= 'A';
        try {
            scanner = new Scanner(new FileInputStream("./lemmeEN.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                Pattern r = Pattern.compile("\"(\\w)+\"");
                Matcher m = r.matcher(line);

                int end = 0;
                
                type = line.charAt(0);
                while (m.find(end) && !m.group(0).equals(last)) {
                    last = m.group(0);
                    wordType.put(m.group(0), type);
                    end = m.end();
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}


