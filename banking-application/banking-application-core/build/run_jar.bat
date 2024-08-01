@echo off
echo ***************************
echo run_jar.bat Begins...
echo ***************************

REM Change to the directory containing the JAR file
CD /D "C:\Preparations\BankingApplicationProject\banking-application\banking-application-core\target"

REM Check if the JAR file exists before trying to run it
if not exist "banking-application-core-0.0.1-SNAPSHOT.jar" (
    echo Error: JAR file not found.
    exit /b 1
)

REM Run the JAR file
java -jar banking-application-core-0.0.1-SNAPSHOT.jar

REM Check the error level of the last command
if %ERRORLEVEL% neq 0 (
    echo Error: JAR file execution failed with error code %ERRORLEVEL%.
    exit /b %ERRORLEVEL%
)

REM Return to the original directory
CD /D "C:\Preparations\BankingApplicationProject\banking-application\banking-application-core\"

echo ***************************
echo run_jar.bat Ends...
echo ***************************