:#!\bin\sh

SET APP_HOME=C:\eclipse\workspace\sqlLoader
SET LIB_HOME=%APP_HOME%\lib

SET CLASSPATH=".;C:\Program Files\Java\jdk1.7.0_80\lib\tools.jar"
SET CLASSPATH=%CLASSPATH%;%LIB_HOME%\ojdbc14.jar
SET CLASSPATH=%CLASSPATH%;%LIB_HOME%\jazzlib.jar
SET CLASSPATH=%CLASSPATH%;%LIB_HOME%\javax.mail-api-1.6.2.jar
SET CLASSPATH=%CLASSPATH%;%LIB_HOME%\javax.mail-1.6.2.jar
SET CLASSPATH=%CLASSPATH%;%LIB_HOME%\commons-lang3-3.1.jar

cd C:\eclipse\workspace\sqlLoader\target\classes

java -Xmx1024m -cp %CLASSPATH% batch.MailBatchRunnerRisk %1


