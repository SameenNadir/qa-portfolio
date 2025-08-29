# 🛒 Daraz Automation & Manual QA Portfolio

## 📌 Project Overview
This portfolio demonstrates **manual** and **automation** testing skills on an e‑commerce flow (Daraz.pk):
- Manual test cases & bug reports
- Simple Selenium WebDriver (Java) script for login + search
- Clean structure so recruiters can quickly review scope & impact

## ⚙️ Tech/Tools
- Java (JDK 8+), Selenium WebDriver, ChromeDriver
- Excel/Word for test cases & bug reports
- Git/GitHub for version control

## 🚀 How to Run the Selenium Script
1. Install Java JDK and Chrome.
2. Download **ChromeDriver** that matches your Chrome version.
3. Update this line in `Automation-Testing/DarazAutomation.java` with your driver path:
   ```java
   System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");
   ```
4. Replace placeholder credentials in the script with test data (DO NOT commit real passwords).
5. Compile & run from your IDE (IntelliJ/Eclipse) or `javac`/`java`.

## ✅ Contents
```
QA-Portfolio/
├─ Automation-Testing/
│  └─ DarazAutomation.java
├─ Manual-Testing/
│  ├─ Daraz_Test_Cases.xlsx
│  └─ Daraz_Bug_Report.docx
└─ README.md
```

## 🌟 Notes
- Keep secrets out of source control. Use environment variables or config files excluded via `.gitignore`.
- Future improvements: add TestNG, assertions, Page Object Model (POM), CI pipeline.

## 📬 Contact (sample placeholders)
- LinkedIn: https://www.linkedin.com/in/sameennadir2003?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app
- GitHub: https://github.com/SameenNadir/qa-portfolio.git
- Email: sameen.nadir25@gmail.com
