FROM debian:stretch

RUN echo 'deb http://ftp.debian.org/debian stretch-backports main' | tee /etc/apt/sources.list.d/stretch-backports.list && \
    apt-get update && \
    apt-get install -y --no-install-recommends \
        git \
        openssh-client \
        openjdk-11-jdk-headless \
        openjdk-8-jdk-headless && \
    rm -rf /var/lib/apt/lists/* && \
    update-java-alternatives -s java-1.8.0-openjdk-amd64 && \
    mkdir -p /gks/{templates,tools}

COPY templates/code.java. /gks/templates/code.java.
COPY tools/* /gks/tools/

ENV PATH="/gks/tools:${PATH}"