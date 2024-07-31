echo ***************************
echo run_jar.bat Begins...
echo ***************************

CD /D "C:\Preparations\BankingApplicationProject\BankingApplication\target"

REM Run the JAR file with the specified properties
REM Ensure the path to the JAR file is correct
java -jar BankingApplication-0.0.1-SNAPSHOT.jar || exit /b %ERRORLEVEL%

echo ***************************
echo run_jar.bat Ends...
echo ***************************