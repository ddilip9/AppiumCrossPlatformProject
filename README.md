# 📱 Appium Mobile Automation Project

This project demonstrates end-to-end mobile automation using Appium for Android (and supports iOS with configuration). It includes a sample login test that runs on a real device or emulator.

---

## 🚀 Features

- Run tests on Android using Appium and TestNG
- Dynamic Appium driver setup (can be extended for iOS)
- Clean test structure with `BaseTest` and reusable code
- Supports running on real devices or emulators
- Easy integration with CI tools like Jenkins

---

## 📁 Project Structure
```plaintext
Appium_Andriod_ios/
├── .idea/
├── apps/
│   ├── app-debug.apk                 # Android app under test
│   └── MyApp.app                     # iOS app under test
├── src/
│   └── test/
│       ├── java/
│       │   ├── base/                 # Base setup classes (e.g. BaseTest)
│       │   ├── pages/                # Page object classes
│       │   ├── tests/                # Test classes (e.g. LoginTest)
│       │   └── utils/                # Utility/helper classes
│       └── resources/
│           └── testng.xml           # TestNG configuration
├── .gitignore
├── Jenkinsfile                      # Jenkins pipeline script
├── pom.xml                          # Maven project file
├── README.md                        # You're reading it
└── verify_appium_environment.sh     # Shell script to verify setup
```


---

## ✅ Prerequisites

1. Java 11+
2. Maven
3. Android Studio (for emulator)
4. Appium Server:
    - Install via `npm install -g appium` or use Appium Desktop
5. Android Emulator or real device with USB debugging enabled
6. Environment variables:
    - `ANDROID_HOME` should point to the Android SDK path
    - `PATH` should include `$ANDROID_HOME/platform-tools`

---

## 🔧 Setup Steps

1. Clone the project:

git clone https://github.com/ddilip9/AppiumCrossPlatformProject.git
cd AppiumCrossPlatformProject

---

2. Install dependencies:
   mvn clean install

3. Place your .apk file under the apps/ folder.

🧪 Running the Test

🔹 Start Appium Server
appium

🔹 Start Emulator or Connect Device
Use Android Studio's Device Manager or:
---emulator -avd <your_avd_name>

Check connection:
adb devices

🔹 Run Test
mvn test

🔄 Jenkins Integration
✅ Overview: How Appium Tests Run in Jenkins
🧩 Jenkins does 4 main things:
1. Pulls your project from GitHub (or other source control)
2. Installs dependencies (e.g., via Maven or Gradle)
3. Starts the Appium server
4. Launches emulator/simulator, then runs the tests

🔧 1. Jenkins Node Configuration
Options:
* Run on macOS node (required for iOS tests)
* Run on Linux node (for Android-only tests)
* Can be your local machine or a Jenkins agent

✅ For iOS, Jenkins must run on macOS (with Xcode and Simulator installed).

📦 2. Required Tools on Jenkins Node
Make sure Jenkins has access to:

* Node.js & npm
* Appium & Appium Doctor (npm install -g appium appium-doctor)
* Android SDK (add ANDROID_HOME)
* Java
* Xcode (for iOS)
* Maven or Gradle (for Java-based projects)

✅ These can be pre-installed manually or through a shell script step (verify_appium_environment.sh) in your pipeline.

📁 3. Example Jenkins Pipeline (Declarative)

* refer Jenkinfile in project

📝 4. How to Handle iOS Simulators
* You must use a macOS Jenkins agent.
* Use xcrun simctl to boot and manage iOS simulators.
* Make sure Xcode is installed and CLI tools are configured.
