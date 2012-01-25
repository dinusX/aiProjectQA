/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package QuestionParser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import com.softcorporation.util.Logger;
import com.softcorporation.suggester.util.Constants;
import com.softcorporation.suggester.util.SpellCheckConfiguration;
import com.softcorporation.suggester.Suggestion;
import com.softcorporation.suggester.tools.SpellCheck;
import com.softcorporation.suggester.dictionary.BasicDictionary;
import com.softcorporation.suggester.BasicSuggester;
import java.util.ArrayList;
/**
 *
 * @author Dinu
 */
public class MainKnowledge {
    
    static SpellCheckConfiguration configuration = null;
    static BasicSuggester suggester = null;
    static
    {
        //prepare spellchecker
        try
        {
            String language = "en";
            String dictName = "english.jar";

            String dictFileName = "file://./" + dictName;

            BasicDictionary dictionary = new BasicDictionary(dictFileName);
            configuration = new SpellCheckConfiguration("file://spellCheck.config");

            suggester = new BasicSuggester(configuration);
            suggester.attach(dictionary);
        }
        catch(Exception ex)
        {
            System.err.println("Error loading dictionary");
        }
    }
    
    
    public static String answer(String questionText)
    {
        Question question = Parser.parse(questionText);
        
        return "Hello World";
    }
    
    public static void loadKnowledge(String path)
    {
        //TODO
    }
    
    public static String getWiki(String inputString) throws MalformedURLException, IOException  {
//        StringBuffer inputSb = new StringBuffer(inputString);
        
        String parsedText = inputString.trim().replaceAll("\\s+", "%20");
        if(parsedText.length() == 0)
            return "";

        URL wikiURL = new URL("http://www.google.com/search?btnI=I'm+Feeling+Lucky&q=" + parsedText + "%20site%3Aen.wikipedia.org");
        
        HttpURLConnection connection = (HttpURLConnection) wikiURL.openConnection();
        connection.addRequestProperty("User-Agent", "Mozilla/4.76");
        connection.setConnectTimeout(15000);
        connection.setReadTimeout(15000);
        connection.setInstanceFollowRedirects(true);
        connection.connect();

                
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream())); //oracle.openStream()
        
        String inputLine;

        StringBuilder sb = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            sb.append(inputLine);
//            System.out.println(inputLine);
        }
        
        String text = sb.toString();

        int start = 0;
        int end = 0;
        
        Pattern p = Pattern.compile("<\\s*body[^>]+>",Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(text);
        if(m.find())
        {
            start = m.end();
        }
        p = Pattern.compile("<\\s*/\\s*body\\s*>", Pattern.CASE_INSENSITIVE);
        m = p.matcher(text);
        if(m.find(start))
        {
            end = m.start();
        }
        
        text = text.substring(start, end);
        text = text.replaceAll("</?\\w+(\\s+\\w+\\s*=\\s*('[^']+'|\"[^\"]+\"))*\\s*>?","").replaceAll("<!--[^>]+>", "").replaceAll("\\s+", " "); 
        
        return text;
    }
    
    public static String checkAndCorrect(String text)
    {
        if(suggester == null || configuration == null)
            return text;
        try {

            ArrayList suggestions = null;

            SpellCheck spellCheck = new SpellCheck(configuration);
            spellCheck.setSuggester(suggester);
            spellCheck.setSuggestionLimit(5);

            spellCheck.setText(text, Constants.DOC_TYPE_TEXT, "en");

            spellCheck.check();

            while (spellCheck.hasMisspelt()) {
                String misspeltWord = spellCheck.getMisspelt();

                suggestions = spellCheck.getSuggestions();

                if(suggestions.size() > 0)
                {
                    Suggestion suggestion = (Suggestion) suggestions.get(0);
                    spellCheck.change(suggestion.getWord());
                }

                spellCheck.checkNext();
            }
            text = spellCheck.getText();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        
        return text;
    }
}
