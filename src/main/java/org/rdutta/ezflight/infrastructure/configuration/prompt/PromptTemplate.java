package org.rdutta.ezflight.infrastructure.configuration.prompt;

import org.springframework.stereotype.Component;

@Component
public class PromptTemplate {
    public static String buildPrompt(String sentence) {
        return """
        You are a NER model. Extract 'from', 'to', and 'start' (start in HH:mm:ss) from the sentence.

        Example 1:
        Sentence: "Book flight from Delhi to Mumbai at 7AM"
        Output:
        {
          "from": "Delhi",
          "to": "Mumbai",
          "start": "07:00:00"
        }
        
        Return JSON format only and also in same valid format:
        {
          "from": "",
          "to": "",
          "start": ""
        }
        """.formatted(sentence);
    }
}
