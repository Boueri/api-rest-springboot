@REM ----------------------------------------------------------------------------
@REM Licensed to the Apache Software Foundation (ASF) under one
@REM or more contributor license agreements.  See the NOTICE file
@REM distributed with this work for additional information
@REM regarding copyright ownership.  The ASF licenses this file
@REM to you under the Apache License, Version 2.0 (the
@REM "License"); you may not use this file except in compliance
@REM with the License.  You may obtain a copy of the License at
@REM
@REM    http://www.apache.org/licenses/LICENSE-2.0
@REM
@REM Unless required by applicable law or agreed to in writing,
@REM software distributed under the License is distributed on an
@REM "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
@REM KIND, either express or implied.  See the License for the
@REM specific language governing permissions and limitations
@REM under the License.
@REM ----------------------------------------------------------------------------

@REM ----------------------------------------------------------------------------
@REM Maven Start Up Batch Script
@REM
@REM Required ENV vars:
@REM JAVA_HOME - location of a JDK home dir
@REM
@REM Optional ENV vars
@REM MAVEN_BATCH_ECHO - set to 'on' to enable the echoing of the batch commands
@REM MAVEN_BATCH_PAUSE - set to 'on' to pause the give error message
@REM MAVEN_OPTS - parameters passed to the Java VM when running Maven
@REM     e.g. to debug Maven itself, use
@REM     set MAVEN_OPTS=-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=8000
@REM ----------------------------------------------------------------------------

@REM Begin all REM lines with a blank line in between so that doing a
@REM "findstr /V '^@REM' mvnw.cmd | findstr /V '^$'" will show the amount
@REM of actual code in this script.

@set MAVEN_BATCH_ECHO=off
@if "%MAVEN_BATCH_ECHO%" == "on"  echo %MAVEN_BATCH_ECHO%

@set MAVEN_BATCH_PAUSE=off
@if "%MAVEN_BATCH_PAUSE%" == "on" set pause=pause
@if "%MAVEN_BATCH_PAUSE%" == "off" set pause=rem

@setlocal

@set DIRNAME=%~dp0
@if "%DIRNAME%" == "" set DIRNAME=.\

@set APP_BASE_NAME=%~n0
@set APP_ARGS=%*

@REM Protect quote from MACRO expansion
@set SPECIFIC_ARGUMENTS=%APP_ARGS%

@REM Find the project base dir, i.e. the directory that contains the folder .mvn.
@REM Fallback to current working directory if not found.

@set BASE_DIR=%DIRNAME%
:findBaseDir
@if exist "%BASE_DIR%\.mvn" goto init
@set BASE_DIR=%BASE_DIR%\..
@goto findBaseDir

:init
@set MAVEN_PROJECTBASEDIR=%BASE_DIR%
@cd /d "%BASE_DIR%"

@set WRAPPER_JAR="%MAVEN_PROJECTBASEDIR%\.mvn\wrapper\maven-wrapper.jar"
@set WRAPPER_PROPERTIES="%MAVEN_PROJECTBASEDIR%\.mvn\wrapper\maven-wrapper.properties"

@REM Find JAVA_HOME if not set
@if not "%JAVA_HOME%" == "" goto checkJava

@set JAVA_EXE=java.exe
@%JAVA_EXE% -version >NUL 2>&1
@if "%ERRORLEVEL%" == "0" goto run

@echo.
@echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
@echo.
@echo Please set the JAVA_HOME variable in your environment to match the
@echo location of your Java installation.
@goto error

:checkJava
@set JAVA_HOME=%JAVA_HOME:"=%
@set JAVA_EXE=%JAVA_HOME%\bin\java.exe

@if exist "%JAVA_EXE%" goto run

@echo.
@echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
@echo.
@echo Please set the JAVA_HOME variable in your environment to match the
@echo location of your Java installation.
@goto error

:run
@REM Extension to allow automatically downloading the maven-wrapper.jar
@if exist %WRAPPER_JAR% goto boot

@set WRAPPER_URL="https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.1.0/maven-wrapper-3.1.0.jar"
@REM Find out if property wrapperUrl is set in maven-wrapper.properties
@if not exist %WRAPPER_PROPERTIES% goto download
@for /F "tokens=2 delims==" %%i in ('findstr /I "wrapperUrl" %WRAPPER_PROPERTIES%') do @set WRAPPER_URL=%%i

:download
@echo Downloading Maven Wrapper JAR...
@set DOWNLOAD_VALID=no
@REM Check for powershell
@powershell -Command "[]" >NUL 2>&1
@if NOT "%ERRORLEVEL%" == "0" goto downloadWget
@powershell -Command "[Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12; (New-Object Net.WebClient).DownloadFile('%WRAPPER_URL%', '%WRAPPER_JAR%')" >NUL 2>&1
@if "%ERRORLEVEL%" == "0" set DOWNLOAD_VALID=yes
@if "%DOWNLOAD_VALID%" == "yes" goto boot

:downloadWget
@wget %WRAPPER_URL% -O %WRAPPER_JAR% >NUL 2>&1
@if "%ERRORLEVEL%" == "0" set DOWNLOAD_VALID=yes
@if "%DOWNLOAD_VALID%" == "yes" goto boot

:downloadCurl
@curl -sFo %WRAPPER_JAR% %WRAPPER_URL% >NUL 2>&1
@if "%ERRORLEVEL%" == "0" set DOWNLOAD_VALID=yes
@if "%DOWNLOAD_VALID%" == "yes" goto boot

@echo ERROR: Failed to download Maven Wrapper JAR.
@goto error

:boot
@set CLASSPATH=%WRAPPER_JAR%

@REM Execute Maven Wrapper
@"%JAVA_EXE%" %MAVEN_OPTS% -classpath %CLASSPATH% org.apache.maven.wrapper.MavenWrapperMain %SPECIFIC_ARGUMENTS%
@if "%ERRORLEVEL%" == "0" goto end

:error
@set ERROR_CODE=1
@%pause%
@exit /b %ERROR_CODE%

:end
@@endlocal
@exit /b 0