FROM java:openjdk-8-jdk
MAINTAINER Vuong Nguyen <vuongnq00291@gmail.com>

ENV APP_HOME=/opt/app/


# Install startup and shutdown scripts
RUN mkdir $APP_HOME
ADD target/springmedia-assignment.jar $APP_HOME
ADD extconfig/** $APP_HOME
ADD app_service /etc/init.d
RUN chmod a+x /etc/init.d/app_service

# Expose and start SSHD
EXPOSE 8090
#CMD ["/bin/bash", "-c", "service app_service start"]
