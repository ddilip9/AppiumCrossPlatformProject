pipeline {
  agent any

  environment {
    ANDROID_HOME = "${HOME}/Library/Android/sdk"
    PATH = "${ANDROID_HOME}/platform-tools:${PATH}"
  }

  tools {
      maven 'Maven 3'      // Defined in Jenkins > Global Tool Configuration
      jdk 'JDK 11'         // Defined in Jenkins > Global Tool Configuration
  }

  stages {
    stage('Checkout') {
      steps {
        git 'https://github.com/your-org/mobile-automation.git'
      }
    }

    stage('Install Dependencies') {
      steps {
        sh 'npm install -g appium appium-doctor'
        sh 'mvn clean install -DskipTests'
      }
    }

    stage('Start Appium Server') {
      steps {
        sh 'nohup appium > appium.log 2>&1 &'
        sh 'sleep 5' // wait for Appium to start
      }
    }

    stage('Start Emulator/Simulator') {
      steps {
        // Android example: replace with your AVD name
        sh '$ANDROID_HOME/emulator/emulator -avd Pixel_4_API_30 -no-audio -no-window &'
        sh 'sleep 15'

        // Optional: for iOS
        // sh 'xcrun simctl boot "iPhone 14"'
      }
    }

    stage('Run Tests') {
      steps {
        sh 'mvn test -Dplatform=android'  // or -Dplatform=ios
      }
    }
  }

  post {
    always {
      sh 'pkill -f appium || true'
      sh 'adb emu kill || true'
    }
  }
}
