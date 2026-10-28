@echo off
cd /d "%~dp0"
if not exist bin mkdir bin
javac -encoding UTF-8 -d bin src\calculadora\Calculadora.java test\calculadora\TesteCalculadora.java
if errorlevel 1 exit /b 1
java -cp bin calculadora.TesteCalculadora
pause
