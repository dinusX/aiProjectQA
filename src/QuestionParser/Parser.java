/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package QuestionParser;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Dinu
 */
public class Parser {

    /*
     *
    my %wordnet =(
    "persoane" => qr/(?>scorer|director|President|spouses|wife|writer|actor|artist\s|singer|historian|thinker|author|mortal|immortal|member.?|partner.?|goddess|representatives|disciple)/,
    "numere" => qr/(?>position.?|age|percentage|percent|number.?)/,
    "masuri" => qr/(?>area|height|mass|masses|amplitude|duration|depth|speed|length|quantity|size|density)/,
    "locatii" => qr/(?>region.?|district.?|City|Capital|Capital.?|island.?|Peak|territory|province|continent|state)/,
    "timp" => qr/(?>year|century|period.?|date.?|time|hour)/,
    "organizatii" => qr/(?>organization|Organizers|agents|University|group|company|companies|entity|entities|Manufacturer|institution.?|prison.?|Order.?|Party|CIA|Agency|UNESCO|Eesti|Solidarity|Ethers|led|NATO|European Union|EU)/,
    "obiecte" => qr/(?>a|an)?\s?(?>instrument|product|gun.?|machine|middle|unit|concrete-wood|equipment|toy.?|compass|compasses|armor.?|equipment|computer|device|Selena|stole)/
    );
    
    my %a_types = (
    "PERSON" =>      [qr/(?>Why|What|Name|With who|What is called)(?!\s*$wordnet{"organizatii"}).*?$wordnet{"persoane"}/,
    qr/What is (?>his|her) name/, qr/Who/, qr/Whom/, qr/Whos/, qr/With who/],
    "COUNT" =>       [qr/Approximately how many/,qr/Of how many/, qr/How many/, qr/How much/, qr/Of how much/, qr/(?>What|Who is)\s$wordnet{"numere"}/],
    "MEASURE" =>     [qr/How (>?much|manny)\s/, qr/(?>What is the).*?$wordnet{"masuri"}/],
    "LOCATION" =>    [qr/What (state|city)/, qr/From where/,qr/Where/, qr/(?>On\sWhat|What|On which|Name).*?$wordnet{"locatii"}/],
    "TIME" =>        [qr/When/, qr/(?>In what|From what|At what|After how (?>much|many))\s$wordnet{"timp"}/],
    "ORGANIZATION" =>[qr/Who produced/, qr/Who made/, qr/(?>What was the|What is the|At|From what|What was|What is).*?(?<!of\s)$wordnet{"organizatii"}/],
    "OBJECT" =>      [qr/What /, qr/What (>? give|gived|gives)/, qr/With what(?>he|she|it)\s/,
    qr/(?>What|Name|What is the name of the|For what|At what).*?$wordnet{"obiecte"}/]
    );
    
    my %q_types = (
    "PROCEDURE" =>[qr/What's the procedure/, qr/What is the procedure/, qr/What are the stages/, qr/What are the Community's procedures/,
    qr/What  measures/, qr/What are the Community's procedures for/,qr/Under what circumstances/,
    qr/In what circumstances/],
    "REASON" =>	[qr/Why/, qr/By what reason/,qr/For what reason/, qr/What is the motive/, qr/What is  the main reason/, qr/On what ground/],
    "PURPOSE" =>[qr/What is the purpose/, qr/What's the purpose/,qr/To what purpose/, qr/On what purpose/, qr/For what purpose/,
    qr/What's the aim/, qr/What is the aim/,qr/What's the objective/, qr/What is the objective/, qr/What are the goals/,
    qr/What are the objectives/, qr/What are the Community's objectives/, qr/What are the aims/, qr/What is the scope/],
    "DEFINITION" => [qr/What means\s+[A-Z]/,
    qr/What ( )?is (a|an)/,
    qr/What ( )?are the/,
    qr/Who (?>is|(?>was))\s+[A-Z]/,
    qr/What does the term/,
    qr/What is meant by/,
    qr/What(?>is|(?>was)|are)\s+(?!(?>a|an)\s)/, qr/What is the meaning/, qr/What is the definition/],
    "LIST" =>       [qr/What types/, qr/Who were/, qr/Whom/, qr/Through what/,
    qr/Name (?!(?>a|an)\s)/]);

     * 
     */
    
    /*
    my %q_types = (
    "PROCEDURE" =>["/What's the procedure/", "/What is the procedure/", "/What are the stages/", "/What are the Community's procedures/",
    "/What  measures/", "/What are the Community's procedures for/","/Under what circumstances/",
    "/In what circumstances/"],
    "REASON" =>	["/Why/", "/By what reason/", "/For what reason/", "/What is the motive/", "/What is  the main reason/", "/On what ground/]",
    "PURPOSE" =>["/What is the purpose/", "/What's the purpose/", "/To what purpose/", "/On what purpose/", "/For what purpose/",
    "/What's the aim/", "/What is the aim/", "/What's the objective/", "/What is the objective/", "/What are the goals/",
    "/What are the objectives/", "/What are the Community's objectives/", "/What are the aims/", "/What is the scope/"],
    "DEFINITION" => ["/What means\s+[A-Z]/, "/What ( )?is (a|an)/", "/What ( )?are the/", "/Who (?>is|(?>was))\s+[A-Z]/", "/What does the term/",
    "/What is meant by/", "/What(?>is|(?>was)|are)\s+(?!(?>a|an)\s)/", "/What is the meaning/", "/What is the definition/",
    "LIST" =>       ["/What types/", "/Who were/", "/Whom/", "/Through what/", "/Name (?!(?>a|an)\s)/"]);
    
     */

//        static final String[][] a_types = {{"/(?>Why|What|Name|With who|What is called)(?!\\s*" + wordnet[5] +").*?" +wordnet[0]+"/",
//        "/What is (?>his|her) name/", "/Who/", "/Whom/", "/Whos/", "/With who/"},
//            {"/Approximately how many/","/Of how many/", "/How many/", "/How much/", "/Of how much/", "/(?>What|Who is)\\s"+ wordnet[1] +"/"},
//            {"/How (>?much|manny)\\s/", "/(?>What is the).*?"+wordnet[2]+"/"},
//            {"/What (state|city)/", "/From where/","/Where/", "/(?>On\\sWhat|What|On which|Name).*?"+wordnet[3]+"/"},
//            {"/When/", "/(?>In what|From what|At what|After how (?>much|many))\\s"+wordnet[4]+"/"},
//            {"/Who produced/", "/Who made/", "/(?>What was the|What is the|At|From what|What was|What is).*?(?<!of\\s)"+wordnet[5]+"/"},
//            {"/What /", "/What (>? give|gived|gives)/", "/With what(?>he|she|it)\\s/", "/(?>What|Name|What is the name of the|For what|At what).*?"+wordnet[6]+"/"}
//    };


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
        {"What means\\s+[A-Z]", "What()?is (a|an)", "What ( )?are the", "Who (?>is|(?>was))\\s+[A-Z]", "What does the term",
            "What is meant by", "What(?>is|(?>was)|are)\\s+(?!(?>a|an)\\s)", "What is the meaning", "What is the definition"},
        {"What types", "Who were", "Whom", "Through what", "Name (?!(?>a|an)\\s)"}
    };
    
    static final String[][] a_types = {{"(Why|What|Name|With who|What is called).*?", // +wordnet[0],
        "What is (his|her) name", "Who", "Whom", "Whos", "With who"},
            {"Approximately how many","Of how many", "How many", "How much", "Of how much", "(What|Who is)\\s"+ wordnet[1]},
            {"How (much|manny) /", "/(What is the).*?"+wordnet[2]},
            {"What (state|city)/", "/From where/","/Where/", "/(On\\sWhat|What|On which|Name).*?"+wordnet[3]},
            {"When", "(In what|From what|At what|After how (much|many)) "+wordnet[4]},
            {"Who produced", "Who made", "(What was the|What is the|At|From what|What was|What is).*?(?<!of\\s)"+wordnet[5]},
            {"What ", "What (give|gived|gives)", "With what(he|she|it) ", "(What|Name|What is the name of the|For what|At what).*?"+wordnet[6]}
    };
    
    static String[] a_typesTitle = {"PERSON", "COUNT", "MEASURE", "LOCATION", "TIME", "ORGANIZATION", "OBJECT"};
    static String[] q_typesTitle = {"PROCEDURE", "RESON", "PURPOSE", "DEFINITION", "LIST"};
    //["/Approximately how many/","/Of how many/", "/How many/", "/How much/", "/Of how much/", "/(?>What|Who is)\s$wordnet{"numere"}/"]
    //"/(?>Why|What|Name|With who|What is called)(?!\s*$wordnet{"organizatii"}).*?$wordnet{"persoane"}/", "/What is (?>his|her) name/", "/Who/", "/Whom/", "/Whos/", "/With who/"
    
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

        return outputQuestion;
    }

}


