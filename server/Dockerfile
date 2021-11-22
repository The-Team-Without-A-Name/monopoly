# get base image
FROM openjdk:16

# Arguments
ARG port=7000

# set the maintainer
MAINTAINER "Madison, Pawan, Rowan"

# create working directory
WORKDIR ./

# copy components
COPY ./build/distributions/server-monopoly-1.0-SNAPSHOT.zip ./server-monopoly-1.0-SNAPSHOT.zip

# create the user so root is not running the app
#USER appuser

# Install dependencies
RUN microdnf install zip unzip -y

# install the components
RUN unzip server-monopoly-1.0-SNAPSHOT

# expose the networking port
EXPOSE $port

# Setup the entrypoint
ENTRYPOINT ./server/bin/server-monopoly