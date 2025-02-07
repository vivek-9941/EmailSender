# 📧 Email Sender Application using Spring Boot  

## 🚀 Project Overview  
Sending bulk emails efficiently is a crucial task, but doing it incorrectly—such as adding multiple recipients in CC or BCC—can leave a poor impression. This project provides a solution to send personalized emails in bulk using **Spring Boot** and **JavaMailSender**, ensuring efficiency and professionalism.  

## ❌ Why Mass Emails (CC/BCC) Are a Bad Practice?  
Sending the same email to multiple companies by adding their email IDs in **CC or BCC** can be problematic for several reasons:  

### 🚫 Lack of Personalization  
- Recruiters can see that the email was sent to multiple recipients, making it feel **generic and lazy**.  
- Reduces the chances of getting shortlisted due to a lack of tailored communication.  

### 📛 Unprofessional & Spammy Look  
- Mass emails often get **flagged as spam**, meaning recruiters may not even open them.  
- Companies prefer candidates who apply **individually** and show genuine interest.  

---

## ✅ Solution: Personalized Bulk Email Sending  
To solve this, I built a **Spring Boot** application that allows users to send **individual, personalized emails to multiple recipients** while leveraging **Java’s multithreading** to optimize processing time.  

### ✨ Features  
✔ Send emails dynamically with personalized content.  
✔ Attach files (PDFs, images, etc.).  
✔ Fetch recipient details from a **database**.  
✔ Use **Java multithreading** to send multiple emails simultaneously, reducing processing time.  
✔ REST API-based trigger to send emails programmatically.  

---

## 🛠 How I Implemented It  
### 1️⃣ Spring Boot & JavaMailSender  
- Used **JavaMailSender** to send emails efficiently.  
- Configured **SMTP settings** for reliable email delivery.  

### 2️⃣ Java Multithreading for High Performance  
- Implemented **ExecutorService** to handle multiple email threads at once.  
- Each email is sent in a **separate thread**, drastically reducing wait times.  

### 3️⃣ REST API for Email Trigger  
- Created an endpoint where users can **pass recipient details** via an API request.  
- The API fetches recipient info from a **database** and processes emails asynchronously.  

---

