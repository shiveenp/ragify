# RAGify

Ragify (Ra-gee-fi) is a local or hostable app to run ollama against some documents. 

What it is:

- A locally run or hostable application
- An app to enhance context of ollama using your local/remote PDFs and RAG (support for other documents, including Excel, JSON, CSVs etc. to be added i future)
- An app to get answers from the PDF cache based on your given prompt, with a web based chatgpt like interface
- An app for the author to learn more about LLM/Spring AI/RAG and other associated technologies.

More importantly though, what it is not:

- A full time maintained OSS, it's simply done in my free time for myself for my own learning (although I won't say no to contributions)
- A project with any kind of warranty around input/output


## How to run

1. First start all the core containers by running:

```shell
docker-compose up
```

2. Run the Springboot App

```shell
./gradlew bootRun
```

3. Call the endpoints
