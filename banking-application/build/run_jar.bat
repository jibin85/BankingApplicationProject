@echo off
echo *********************
echo run_jar.bat Begins...
echo *********************

REM Store the original directory
SET "ORIGINAL_DIR=%CD%"

REM Change to the directory containing the JAR files and set directories
CD /D "%ORIGINAL_DIR%\..\..\banking-application\banking-application-core\target" || (
    echo Error: Failed to change directory to banking-application-core/target
    exit /b 1
)
SET "banking_core_dir=%CD%"

CD /D "%ORIGINAL_DIR%\..\..\banking-application\banking-reference-data\target" || (
    echo Error: Failed to change directory to banking-reference-data/target
    exit /b 1
)
SET "banking_ref_data_dir=%CD%"

REM Change back to the original directory before running the JAR files
CD /D "%ORIGINAL_DIR%" || (
    echo Error: Failed to return to original directory
    exit /b 1
)

REM Check if the JAR files exist before trying to run them
if not exist "%banking_ref_data_dir%\banking-reference-data-0.0.1-SNAPSHOT.jar" (
    echo Error: JAR file not found: %banking_ref_data_dir%\banking-reference-data-0.0.1-SNAPSHOT.jar
    exit /b 1
)

if not exist "%banking_core_dir%\banking-application-core-0.0.1-SNAPSHOT.jar" (
    echo Error: JAR file not found: %banking_core_dir%\banking-application-core-0.0.1-SNAPSHOT.jar
    exit /b 1
)

REM Run the JAR files
START "banking-reference-data" CMD /k java -jar "%banking_ref_data_dir%\banking-reference-data-0.0.1-SNAPSHOT.jar"
START "banking-application-core" CMD /k java -jar "%banking_core_dir%\banking-application-core-0.0.1-SNAPSHOT.jar"

REM Check the error level of the last command
if %ERRORLEVEL% neq 0 (
    echo Error: JAR file execution failed with error code %ERRORLEVEL%.
    exit /b %ERRORLEVEL%
)

REM Return to the original directory
CD /D "%ORIGINAL_DIR%" || (
    echo Error: Failed to return to original directory
    exit /b 1
)