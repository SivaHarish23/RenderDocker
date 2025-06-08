# Use official Tomcat base image with Java
FROM tomcat:9.0

# Remove all default apps in Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy your WAR file into the webapps directory as ROOT.war
COPY target/RenderDocker.war /usr/local/tomcat/webapps/ROOT.war

# Expose port (Render will map it automatically)
EXPOSE 8080

# Start Tomcat server
CMD ["catalina.sh", "run"]