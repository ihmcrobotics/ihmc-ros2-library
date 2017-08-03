# IHMC Pub/Sub

This library implements a Java Pub/Sub API for the RTPS protocol. RTPS is the interoperability wire protocol for DDS. This library also implements serialization methods for the 
Common Data Representation (CDR) format, allowing interoperability with DDS domains. The IHMC Pub/Sub generator can be used to generate a Java implementation from OMG DDS IDL formatted files.

The API is designed to avoid allocating memory except during initialization. 

## Toolchain
- [IHMC Pub/Sub](https://github.com/ihmcrobotics/ihmc-pub-sub): IHMC Pub/Sub RTPS library
- [IHMC Pub/Sub generator](https://github.com/ihmcrobotics/ihmc-pub-sub-generator): Gradle plugin and standalone application to generate java classes from .idl messages.
- [IHMC RTPS Visualizer](https://github.com/ihmcrobotics/ihmc-rtps-visualizer): GUI to display partitions, topics, participants, subscribers, publisher and publisher data on a RTPS domain.
- [IHMC Pub/Sub serializers extra](https://github.com/ihmcrobotics/ihmc-pub-sub-serializers-extra): Optional serializer to generated JSON, BSON, YAML, Java Properties and XML(limited) output from .idl messages. 

## License
The IHMC Pub/Sub library is licensed under the Apache 2.0. See LICENSE.txt

## Usage

## Generating Java code from .idl messages
Use the [IHMC Pub/Sub generator](https://github.com/ihmcrobotics/ihmc-pub-sub-generator) to compile your .idl messages into [MessageType].java and [MessagePubSubType].java.

### Supported operating systems
IHMC Pub Sub has a native component that is compiled for different operating systems
#### Linux
- Tested on Ubuntu 14.04, Ubuntu 16.04 and Ubuntu 17.04
- Requires OpenJDK JRE 8 or compatible JRE
- Native library is compiled statically, should work on most distributions with a recent glibc

#### Windows 
- Tested on Windows 10
- Requires Oracle JRE 8 or compatible JRE. [Download](https://java.com/en/download/)
- Requires Microsoft Visual C++ 2017 Redistributable (x64). [Download](https://go.microsoft.com/fwlink/?LinkId=746572)


### Gradle
Add the IHMC Pub Sub library as dependency
```
repositories {
    maven {
        url  "http://dl.bintray.com/ihmcrobotics/maven-release"
    }
}
	
dependencies {
	compile group: 'us.ihmc', name: 'IHMCPubSub', version: '0.3.4.1'
}
```

### Quick start

Examples for a simple publisher and subscriber can be found in src/us/ihmc/pubsub/example.

#### Participant
A single participant is needed to join a domain. Multiple publisher/subscribers can be added to a participant.
```
Domain domain = DomainFactory.getDomain(PubSubImplementation.FAST_RTPS);
ParticipantAttributes attributes = domain.createParticipantAttributes([numeric domain ID], [participant name]);
Participant participant = domain.createParticipant(attributes);
```

#### Publisher 
```
TopicDataType dataType = // IHMC Pub/Sub generator generated PubSubType
PublisherAttributes publisherAttributes = domain.createPublisherAttributes(participant, dataType, [Topic name], ReliabilityKind.RELIABLE);           
Publisher publisher = domain.createPublisher(participant, publisherAttributes);

[Type] message = // IHMC Pub/Sub generator generated message
publisher.write(message);
```

#### Subscriber
```
private class SubscriberListenerImpl implements SubscriberListener
{
   private final [Type] message = // IHMC Pub/Sub generator generated message
   private final SampleInfo info = new SampleInfo();

   @Override
   public void onNewDataMessage(Subscriber subscriber)
   {
      try
      {
         if (subscriber.takeNextData(message, info))	// Note: No memory is allocated as the message is re-used. 
         {
            // Use data here
         }
      }
      catch (IOException | InterruptedException e)
      {
         // Handle exception
      }
   }

   @Override
   public void onSubscriptionMatched(Subscriber subscriber, MatchingInfo info)
   {
   }
}

TopicDataType dataType = // IHMC Pub/Sub generator generated PubSubType
SubscriberAttributes subscriberAttributes = domain.createSubscriberAttributes(participant, dataType, [Topic name], ReliabilityKind.BEST_EFFORT);
domain.createSubscriber(participant, subscriberAttributes, new SubscriberListenerImpl());      

```


## Implementation

The IHMC Pub/Sub library consists of three parts. A generic Pub/Sub API, a RTPS implementation and an IDL serializer/deserializer. 

### Pub/Sub API

The Pub/Sub API is based on the eProsima Fast-RTPS C++ Api. The API is decoupled from the implementation, allowing multiple implementations. Currently only Fast-RTPS is provided as a backend.

### RTPS implementation

The RTPS implementation uses eProsima Fast-RTPS under the hood. Care has been taken to avoid any allocations in the Java code when reader/writing to topics. All functionality in the Pub/Sub API is implemented for 
the eProsima Fast-RTPS layer.  


## Documentation

All classes contain JavaDoc, which can be accessed on [https://readthedocs.org/projects/ihmc-pubsub/](https://readthedocs.org/projects/ihmc-pubsub/).


### See also
The eProsima Fast RTPS documentation can be useful as a reference guide on more advanced features and the inner working of the RTPS layer [http://eprosima-fast-rtps.readthedocs.io/en/latest/](http://eprosima-fast-rtps.readthedocs.io/en/latest/). 

## Supported platforms

The library is supported on the following Operating Systems
- Linux (Compiled and tested on Ubuntu 16.04)
- Windows 10 (Should Windows 8 not work, please file a bug report.)
- Mac OS (Compiled and tested on Sierra)


## Compilation
### Java code compilation
```
gradle build
gradle publishToMavenLocal

```

### Native code Compilation

This step is optional, the native libraries have been included in the source code repository.

FastRTPS is included as a GIT submodule. The CMake build system will automatically build FastRTPS if neccessary.

#### Linux
Requirements
- CMake 3.1 or later
- GNU C++
- Swig 3.0.8 or later
- OpenJDK 1.8

```
mkdir build
cd build
cmake ..
make 
make install
```

#### Windows
Requirements:
- CMake [https://cmake.org/download/](https://cmake.org/download/). Recommended edition: Windows win64-x64 installer
- Visual Studio 2017 Community [https://www.visualstudio.com/downloads/](https://www.visualstudio.com/downloads/). 
	- Make sure to select "Desktop Development with C++" and select "MFC and ATL support (x86 and x64)" under Optional.
- Swig: Version 3.0.8 or later
	- Unpack in C:\swigwin-3.0.8 or modify later commands accordingly
- JDK 1.8
- 64 bit Git for Windows  setup [https://git-scm.com/download/win](https://git-scm.com/download/win).
	- Make sure to have "Use Git from the Windows Command Prompt" selected so it gets added to your path.

##### Configuration:
Use CMake GUI to create the Visual Studio makefiles.
- Start the x64 Native Tools Command Prompt for VS 2017
- Create [source directory]]\build
- cd [source directory]\build
- Run "C:\Program Files\CMake\bin\cmake.exe" -G "Visual Studio 15 2017 Win64" -DSWIG_EXECUTABLE="C:\swigwin-3.0.8\swig.exe" ..
	
##### Compilation:

- Navigate to [source code directory]/build
- Run "C:\Program Files\CMake\bin\cmake.exe" --build . --config Release --target install

Note: Only the Release configuration builds.



