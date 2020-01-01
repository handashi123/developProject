#!/bin/sh
export LANG=ko_KR.UTF-8

export ORACLE_BASE=/app/oracle-instantclient
export ORACLE_HOME=/app/oracle-instantclient
export PATH=/app/jdk/bin/:$ORACLE_HOME/sdk:$ORACLE_HOME:/app/vsftpd/sbin/:/usr/local/bin:/bin:/usr/bin:/usr/local/sbin:/usr/sbin:/sbin:/app/tomcat/bin
export TNS_ADMIN=$ORACLE_HOME/network/admin
export NLS_LANG=KOREAN_KOREA.AL32UTF8

export APP_HOME=/app/tomcat/sqlLoader

export CLASSPATH=${CLASSPATH}:/app/jdk1.7.0_80/lib/tools.jar
export CLASSPATH=${CLASSPATH}:${APP_HOME}/lib/ojdbc14.jar
export CLASSPATH=${CLASSPATH}:${APP_HOME}/lib/jazzlib.jar
export CLASSPATH=${CLASSPATH}:${APP_HOME}/util/BatchUtil.class
export CLASSPATH=${CLASSPATH}:${APP_HOME}/util/DateUtil.class
export CLASSPATH=${CLASSPATH}:${APP_HOME}/util/SendMail.class

export CLASSPATH=${CLASSPATH}:${APP_HOME}/lib/javax.mail-1.6.2.jar
export CLASSPATH=${CLASSPATH}:${APP_HOME}/lib/javax.mail-api-1.6.2.jar
export CLASSPATH=${CLASSPATH}:${APP_HOME}/lib/commons-lang3-3.1.jar

echo `date` --start-- >> /app/tomcat/sqlLoader/daemon/logs/mailbatch_cron-$DATE.log

cd /app/tomcat/sqlLoader
DATE=$(date +%Y%m%d -d -0days)
java -Xmx1024m -Duser.home= batch.MailBatchRunnerRisk $1 >> /app/tomcat/sqlLoader/daemon/logs/mailbatchrisk_cron-$DATE.log

echo `date` --end-- >> /app/tomcat/sqlLoader/daemon/logs/mailbatchrisk_cron-$DATE.log
