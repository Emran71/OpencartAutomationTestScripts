```markdown
# OpenCart Automation (Java + Selenium)

This repository contains automated test scripts for the **OpenCart e-commerce platform**, implemented in **Java** using **Selenium WebDriver** and **TestNG**. The project covers key modules such as login, product search, add-to-cart, and checkout.

---

## 🛠 Tech Stack
- **Language:** Java  
- **Framework:** Selenium WebDriver + TestNG  
- **Build Tool:** Maven  
- **Pattern:** Page Object Model (POM)  
- **Tools:** WebDriverManager, TestNG Reports  

---

## 📂 Project Structure
```

OpenCart-Automation/
├── pom.xml
├── testng.xml
├── src/main/java/... (Page Objects, Utils)
├── src/test/java/...  (Test Scripts)
└── reports/           (Execution Reports)

````

---

## ⚙️ How to Run
1. Clone the repo:
   ```bash
   git clone https://github.com/<your-username>/OpenCart-Automation.git
   cd OpenCart-Automation
````

2. Run all tests with Maven:

   ```bash
   mvn clean test
   ```
3. Reports available in:

   ```
   target/surefire-reports/ or target/test-output/
   ```

---

## ✅ Sample Test Case

```java
@Test
public void loginWithValidCredentials() {
    driver.get("https://your-opencart.com");
    loginPage.goToLogin();
    loginPage.login("user@example.com", "password123");
    Assert.assertTrue(loginPage.isLoggedIn());
}
```

---

## 👨‍💻 Author

**MD. EMRAN KHAN**
SQA Engineer | Manual & Automation Tester
Email: [Ekhan4475@gmail.com](mailto:Ekhan4475@gmail.com)

```
```
