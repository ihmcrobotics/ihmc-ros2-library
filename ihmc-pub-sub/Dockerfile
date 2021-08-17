# An image for building the IHMC Pub Sub natives.
# Current version: 0.2
FROM nvidia/cuda:11.2.2-cudnn8-devel-ubuntu18.04

ARG DEBIAN_FRONTEND=noninteractive

RUN apt-get --quiet 2 --yes update  \
 && apt-get --quiet 2 --yes install \
    nano \
    git \
    wget \
    curl \
    unzip \
    locales \
    apt-transport-https \
    ca-certificates \
    curl \
    software-properties-common \
    sudo \
    build-essential \
    swig \
    cmake \
    openjdk-8-jdk \
    iproute2 \
    > /dev/null \
 && rm -rf /var/lib/apt/lists/*

RUN locale-gen en_US.UTF-8
ENV LANG en_US.UTF-8
ENV LANGUAGE en_US:en
ENV LC_ALL en_US.UTF-8

# Install OpenGL libraries on nvidia-docker2
# Reference: (https://medium.com/@benjamin.botto/opengl-and-cuda-applications-in-docker-af0eece000f1)
RUN apt-get --quiet 2 --yes update \
 && apt-get --quiet 2 --yes install \
    opencl-headers \
    ocl-icd-opencl-dev \
    libgflags-dev \
    libglvnd-dev \
    libgl1-mesa-dev \
    libegl1-mesa-dev \
    libgles2-mesa-dev \
    libxext6 \
    libx11-6 \
    freeglut3-dev \
    mesa-utils \
    > /dev/null \
 && rm -rf /var/lib/apt/lists/*

# Configure OpenCL (https://stackoverflow.com/questions/54243119/how-to-run-opencl-opengl-inside-a-docker-container)
RUN apt-get --quiet 2 --yes update \
 && apt-get --quiet 2 --yes install clinfo > /dev/null \
 && rm -rf /var/lib/apt/lists/* \
 && mkdir -p /etc/OpenCL/vendors \
 && echo "libnvidia-opencl.so.1" > /etc/OpenCL/vendors/nvidia.icd

#Configure NVIDIA runtime for Docker
ENV NVIDIA_VISIBLE_DEVICES all
ENV NVIDIA_DRIVER_CAPABILITIES graphics,utility,compute

# Install Gradle
ARG gradleVersion=7.1.1
RUN curl -sL https://services.gradle.org/distributions/gradle-$gradleVersion-all.zip -o gradle.zip
RUN unzip -q gradle.zip -d gradle
RUN mv gradle/gradle-$gradleVersion/ /opt/.
RUN ln -s /opt/gradle-$gradleVersion/ /opt/gradle
RUN ln -s /opt/gradle/bin/gradle /usr/bin/gradle

# CLion (https://www.jetbrains.com/clion/download/#section=linux)
RUN mkdir -p Downloads \
 && cd Downloads \
 && curl -sL https://download.jetbrains.com/cpp/CLion-2021.1.tar.gz -o clion.tar.gz \
 && tar -xzf clion.tar.gz \
 && mv clion-2021.1/ /opt/clion \
 && ln -s /opt/clion/bin/clion.sh /usr/local/bin/clion \
 && cd .. \
 && rm -rf Downloads

# Setup a robotlab user as the development user, to avoid using root.
# Allows using sudo with robotlab user without a password.
RUN addgroup robotlab \
 && adduser --home /home/robotlab --gecos "Rosie Robot,1117,1234567,2345678" --ingroup robotlab --disabled-password robotlab \
 && chown -R robotlab /home/robotlab \
 && adduser robotlab sudo \
 && echo '%sudo ALL=(ALL) NOPASSWD:ALL' >> /etc/sudoers
USER robotlab
WORKDIR /home/robotlab

RUN mkdir -p /home/robotlab/.gradle
RUN echo "org.gradle.java.home=/usr/lib/jvm/java-8-openjdk-amd64" > /home/robotlab/.gradle/gradle.properties
ENV JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64

RUN mkdir -p /home/robotlab/dev/.git
RUN mkdir -p /home/robotlab/dev/ihmc-pub-sub/build
RUN mkdir -p /home/robotlab/dev/ihmc-pub-sub/cmake
RUN mkdir -p /home/robotlab/dev/ihmc-pub-sub/cppsrc
RUN mkdir -p /home/robotlab/dev/ihmc-pub-sub/src
RUN mkdir -p /home/robotlab/dev/ihmc-pub-sub/swig
RUN mkdir -p /home/robotlab/dev/ihmc-pub-sub/thirdparty
VOLUME /home/robotlab/dev/.git
VOLUME /home/robotlab/dev/ihmc-pub-sub/build
VOLUME /home/robotlab/dev/ihmc-pub-sub/cmake
VOLUME /home/robotlab/dev/ihmc-pub-sub/cppsrc
VOLUME /home/robotlab/dev/ihmc-pub-sub/src
VOLUME /home/robotlab/dev/ihmc-pub-sub/swig
VOLUME /home/robotlab/dev/ihmc-pub-sub/thirdparty
WORKDIR /home/robotlab/dev/ihmc-pub-sub
