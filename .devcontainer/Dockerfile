FROM debian:stretch

RUN echo 'deb http://ftp.debian.org/debian stretch-backports main' | tee /etc/apt/sources.list.d/stretch-backports.list && \
    apt-get update && \
    apt-get install -y --no-install-recommends \
        sudo \
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

# Create the user
ARG USERNAME=vscode
ARG USER_UID=1000
ARG USER_GID=$USER_UID

RUN groupadd --gid $USER_GID $USERNAME \
    && useradd --uid $USER_UID --gid $USER_GID -m $USERNAME \
    && echo $USERNAME ALL=\(root\) NOPASSWD:ALL > /etc/sudoers.d/$USERNAME \
    && chmod 0440 /etc/sudoers.d/$USERNAME

USER $USERNAME