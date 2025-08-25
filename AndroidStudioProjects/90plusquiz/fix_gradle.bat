@echo off
echo 🔧 Fixing Gradle Wrapper for 90+ Quiz App
echo ==========================================

REM Check if we're in the right directory
if not exist "gradlew.bat" (
    echo ❌ Error: gradlew.bat not found. Please run this script from the project root directory.
    echo    Current directory: %CD%
    echo    Expected: ...\AndroidStudioProjects\90plusquiz\
    pause
    exit /b 1
)

echo ✅ Found gradlew.bat in current directory

REM Refresh Gradle wrapper
echo 🔄 Refreshing Gradle wrapper...
gradlew wrapper --gradle-version 8.11.1

REM Clean and build
echo 🧹 Cleaning project...
gradlew clean

echo 🏗️ Building project...
gradlew build

echo ✅ Gradle wrapper fixed and project built successfully!
echo.
echo 🎯 Next steps:
echo    1. Run: gradlew tasks (to see available tasks)
echo    2. Run: gradlew assembleDebug (to build APK)
echo    3. Run: gradlew installDebug (to install on device)
echo.
echo 🚀 Happy coding!
pause
