# Student Learning Assistant 🤖📚

This is the deployment of the **Student Learning Assistant** — a simple AI-powered assistant that answers educational questions via a web interface and API.

---

## 🚀 Live Demo (Test it Out)
You can interact with the assistant here:
🔗 [https://zainabbee24-student-learning-assistant.hf.space](https://zainabbee24-student-learning-assistant.hf.space)

---

## 🖥️ API Usage Guide

You can integrate the assistant into other applications using API calls.

### Endpoint:
https://zainabbee24-student-learning-assistant.hf.space/api/predict/

### Request Payload (JSON):
```json
{
  "data": ["Your question here"]
}

**Example API Call (Python)**
import requests

API_URL = "https://zainabbee24-student-learning-assistant.hf.space/api/predict/"
data = {"data": ["What is photosynthesis?"]}

response = requests.post(API_URL, json=data)
print(response.json())

**Example API Call (JavaScript)**
async function fetchAnswer(question) {
    const response = await fetch("https://zainabbee24-student-learning-assistant.hf.space/api/predict/", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ data: [question] })
    });
    const result = await response.json();
    console.log(result);
}
fetchAnswer("Explain photosynthesis");

#**🌐Embed Assistant in Webpages**
Embed using iframe:
<iframe
	src="https://zainabbee24-student-learning-assistant.hf.space"
	frameborder="0"
	width="850"
	height="450"
></iframe>

#**Embed Using Gradio Web Component**
<script
	type="module"
	src="https://gradio.s3-us-west-2.amazonaws.com/5.0.1/gradio.js"
></script>

<gradio-app src="https://zainabbee24-student-learning-assistant.hf.space"></gradio-app>

##**🛠️ How to Update Questions/Answers**

All updates to questions, answers, or backend logic can be made in the Hugging Face Space code (app.py). Once pushed, changes will reflect live.

#**✉️ Contact:**
Maintained by Zainab Adam.
https://www.linkedin.com/in/zainab-b-adam1
adamzainabb1@gmail.com
