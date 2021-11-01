FROM ubuntu:21.04

# Update packages and install necessary programs
RUN apt update && apt upgrade -y
RUN apt install -y curl zip unzip

# Create new user
RUN useradd -ms /bin/bash admin && adduser admin sudo

# Switch to admin
USER admin
WORKDIR /home/admin/

# Insatll sdkman
RUN curl -s "https://get.sdkman.io" | bash
RUN chmod a+x "$HOME/.sdkman/bin/sdkman-init.sh"

# Install Java, Gradle and Kotlin
RUN /bin/bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && sdk install java 11.0.13.8.1-amzn"
RUN /bin/bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && sdk install gradle 7.2"
RUN /bin/bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && sdk install kotlin 1.5.31"

# Set environmental paths to use commands like 'java --version' outside of container
ENV PATH=/home/admin/.sdkman/candidates/java/current/bin:$PATH
ENV PATH=/home/admin/.sdkman/candidates/gradle/current/bin:$PATH
ENV PATH=/home/admin/.sdkman/candidates/kotlin/current/bin:$PATH
