@echo off
echo Compiling Follow the White Rabbit v2...
javac WhiteRabbit.java
if %errorlevel% neq 0 (
    echo.
    echo ERROR: Compilation failed. Make sure Java JDK is installed.
    echo Download Java from: https://www.oracle.com/java/technologies/downloads/
    pause
    exit /b 1
)
echo.
echo Starting the game...
echo.
java WhiteRabbit
