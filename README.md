# ✈️ Flight Details Extractor using LLM (NER with `phi3:mini`)

This project is a lightweight NLP microservice that uses a local LLM (`phi3:mini`) to extract flight booking details from user input in natural language.

## 🚀 Features

- Uses **LLM-based Named Entity Recognition (NER)** with `phi3:mini`
- Extracts:
  - `from` (departure city)
  - `to` (arrival city)
  - `start` (departure time in `HH:mm:ss` format)
- Parses natural input like:  
  `"Book a flight from Delhi to Mumbai at 7AM"`
- Returns structured output:
  ```json
  {
    "from": "Delhi",
    "to": "Mumbai",
    "start": "07:00:00"
  }
