# 🧪 Selenium Automation Test Suite (JUnit + Gradle)

This repository contains automated test scripts using **Selenium WebDriver**, **JUnit 5**, and **Gradle**. It covers:

1. ✅ Form submission test at DigitalUnite
2. ✅ Guest registration form automation
3. ✅ Web scraping of stock data from DSEBD

---


---

## 🔧 Prerequisites\\\

- Java (JDK 17) installed   
- Chrome browser installed

---

## 📦 Dependencies

Your `build.gradle` should include:

```groovy
plugins {
    id 'java'
}

group = 'org.example'
version = '1.0-SNAPSHOT'

repositories {
    mavenCentral()
}

dependencies {
    testImplementation platform('org.junit:junit-bom:5.10.0')
    testImplementation 'org.junit.jupiter:junit-jupiter'
    // https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
    implementation("org.seleniumhq.selenium:selenium-java:4.31.0")
}

test {
    useJUnitPlatform()
}

```
## ⚙️ How to Run

-Clone this project and run it in intelliJ
 
## Video and Reports of Aumotaions
 ### Test Case 1: Digital Unite Webform
   ```https://www.digitalunite.com/practice-webform-learners ```
-  upload  any file (gif, jpg, png, bmp, rtf, pdf, doc, docx, pptx, xlsx.) (2 MB limit) and give your file location in the code
  ``` uploadElement.sendKeys("<Your File location>"); ```


https://github.com/user-attachments/assets/7a12dee0-421f-47a3-9863-d22bd9e9a0f0


  ![17 04 2025_22 43 02_REC](https://github.com/user-attachments/assets/16791d07-d35c-40ba-aecc-6eb3742349bd)

   ### Test Case 2:  Guest registration Form
   ```https://demo.wpeverest.com/user-registration/guest-registration-form/ ```


https://github.com/user-attachments/assets/1601de99-2e3e-40f3-92a3-7fc9f5339999




   ### Test Case 3: Web scraping of stock data from DSEBD
   ```https://dsebd.org/latest_share_price_scroll_by_value.php ```

   

https://github.com/user-attachments/assets/8a542dee-f514-4f41-9ccb-172c3d4b0348


![17 04 2025_21 06 43_REC](https://github.com/user-attachments/assets/1b0263b6-cc3c-4f04-8767-578568a494e0)
