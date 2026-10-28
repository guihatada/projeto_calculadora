@echo off
cd /d "%~dp0"
javadoc -private -author -version -encoding UTF-8 -charset UTF-8 -docencoding UTF-8 -d docs src\calculadora\Calculadora.java test\calculadora\TesteCalculadora.java
if errorlevel 1 exit /b 1
start "" docs\index.html
pause
