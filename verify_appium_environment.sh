#!/bin/bash

echo "🔍 Verifying Appium Mobile Automation Setup (macOS)..."

# Check Node.js
if command -v node &>/dev/null; then
  echo "✅ Node.js is installed: $(node -v)"
else
  echo "❌ Node.js is NOT installed"
fi

# Check npm
if command -v npm &>/dev/null; then
  echo "✅ npm is installed: $(npm -v)"
else
  echo "❌ npm is NOT installed"
fi

# Check Appium
if command -v appium &>/dev/null; then
  echo "✅ Appium is installed: $(appium --version)"
else
  echo "❌ Appium is NOT installed"
fi

# Check Appium Doctor
if command -v appium-doctor &>/dev/null; then
  echo "✅ Appium Doctor is installed"
else
  echo "❌ Appium Doctor is NOT installed"
fi

# Check Android Studio
if [ -d "/Applications/Android Studio.app" ]; then
  echo "✅ Android Studio is installed"
else
  echo "❌ Android Studio is NOT installed"
fi

# Check ADB
if command -v adb &>/dev/null; then
  echo "✅ ADB is installed: $(adb version | grep 'Android Debug Bridge')"
else
  echo "❌ ADB is NOT installed"
fi

# Check Java
if command -v java &>/dev/null; then
  echo "✅ Java is installed: $(java -version 2>&1 | head -n 1)"
else
  echo "❌ Java is NOT installed"
fi

# Check Xcode
if xcode-select -p &>/dev/null; then
  echo "✅ Xcode is installed"
else
  echo "❌ Xcode is NOT installed"
fi

# Check iOS Simulator
if [ -d "/Applications/Xcode.app" ]; then
  echo "✅ Xcode.app found - You can run: open -a Simulator"
else
  echo "❌ Xcode.app not found"
fi

# Run Appium Doctor
if command -v appium-doctor &>/dev/null; then
  echo -e "\n🔬 Running Appium Doctor..."
  appium-doctor
fi

echo "✅ Environment verification complete."
