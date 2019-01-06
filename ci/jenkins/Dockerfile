FROM jenkins/jenkins:lts-alpine

USER root
RUN apk add --update --no-cache \
  cargo \
  g++ \
  rust

USER jenkins

COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt

COPY init.groovy.d/ /usr/share/jenkins/ref/init.groovy.d/

COPY config.xml /usr/share/jenkins/ref/config.xml
COPY jobs/ /usr/share/jenkins/ref/jobs/
COPY credentials.xml /usr/share/jenkins/ref/credentials.xml