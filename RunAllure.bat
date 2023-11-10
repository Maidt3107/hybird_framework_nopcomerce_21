set ProjectPath=%~dp0
cd %ProjectPath%
set p=%PATH%
java -javaagent:"%ProjectPath%libAllure\aspectjweaver-1.9.8.jar" -classpath "%ProjectPath%bin;%ProjectPath%libAllure\*;%ProjectPath%libAllureReport\*;%ProjectPath%libExtentV5\*;%ProjectPath%libLog4J\*;%ProjectPath%libWebDriverManager5\*;%ProjectPath%libReportNG\*;%ProjectPath%libraries\*" org.testng.TestNG "%ProjectPath%bin\runNopcommerceUser.xml"
pause