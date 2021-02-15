FROM jboss/wildfly:18.0.0.Final
COPY target/AppEnggUserMgmt.war /opt/jboss/wildfly/standalone/deployments/