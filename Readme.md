# IHMC Pub Sub

An allocation free Java library for DDSI-RTPS messaging.

## Features

- Allocation free Publisher and Subscriber API in Java
- Java data type generator for Object Management Group (OMG) IDL files (*.idl)

##### Third Party Vendored Libraries

Uses eProsima's Fast-RTPS C++ via JNI. We also vendor a highly customized version of their IDL parser.

## Toolchain
- [IHMC Pub/Sub](https://github.com/ihmcrobotics/ihmc-pub-sub): IHMC Pub/Sub RTPS library
- [IHMC Pub/Sub generator](https://github.com/ihmcrobotics/ihmc-pub-sub): Gradle plugin and standalone application to generate java classes from .idl messages.
- [IHMC RTPS Visualizer](https://github.com/ihmcrobotics/ihmc-rtps-visualizer): GUI to display partitions, topics, participants, subscribers, publisher and publisher data on a RTPS domain.
- [IHMC Pub/Sub serializers extra](https://github.com/ihmcrobotics/ihmc-pub-sub): Optional serializer to generated JSON, BSON, YAML, Java Properties and XML(limited) output from .idl messages. 

## License
The IHMC Pub/Sub library is licensed under the Apache 2.0. See LICENSE.txt

## Usage

### Generating Java code from .idl messages

Use the IDLGenerator to compile your .idl messages into [MessageType].java and [MessagePubSubType].java.

```java
FileTools.deleteQuietly(Paths.get("generated-java")); // remove old files

// Generate Java types for all (*.idl) files in `src/test/idl` and put them in `src/test/generated-java`
for (Path idl : Files.list(Paths.get("idl")).toArray(Path[]::new))
{
   IDLGenerator.execute(idl.toFile(), // *.idl file
                        "us.ihmc.idl.generated", // package prefix
                        Paths.get("generated-java").toFile(), // output directory
                        Arrays.asList(Paths.get("idl").toFile())); // include path
}
```

### Supported operating systems
IHMC Pub Sub has a native component that is compiled for different operating systems
#### Linux
- Tested on Ubuntu 14.04, Ubuntu 16.04 and Ubuntu 17.04
- Requires a 64 bit Java 8 compatible JRE.
- Native library is compiled statically, should work on most distributions with a recent glibc

#### Windows 
- Tested on Windows 10
- Requires a 64 bit Java 8 compatible JRE.
- Requires Microsoft Visual C++ 2017 Redistributable (x64). [Download](https://go.microsoft.com/fwlink/?LinkId=746572)

#### Mac OSX
- Compiled and tested on Sierra

### Gradle
Add the IHMC Pub Sub library as dependency
```
repositories {
   maven { url  "http://dl.bintray.com/ihmcrobotics/maven-release" }
}
	
dependencies {
   classpath "us.ihmc:ros2-msg-to-pubsub-generator:0.6.11-alpha"
}
```

### Quick start

Examples for a simple publisher and subscriber can be found in [ihmc-pub-sub-generator/src/test/java/us/ihmc/pubsub/examples](ihmc-pub-sub-generator/src/test/java/us/ihmc/pubsub/examples).

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

### See also
The eProsima Fast RTPS documentation can be useful as a reference guide on more advanced features and the inner working of the RTPS layer [http://eprosima-fast-rtps.readthedocs.io/en/latest/](http://eprosima-fast-rtps.readthedocs.io/en/latest/). 

## Compilation

### Java code compilation
```
gradle build
gradle publishToMavenLocal
```

### Native code Compilation

This step is optional, the native libraries have been included in the source code repository.

FastRTPS is included as a Git submodule. The CMake build system will automatically build FastRTPS if neccessary.

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

# IHMC Pub/Sub Generator

The IHMC Pub/Sub generator creates Java classes from OMG DDS IDL formatted files. The resulting classes can be used in conjunction with [IHMC Pub/Sub](https://github.com/ihmcrobotics/ihmc-pub-sub) to serialize and deserialize to the Common Data Representation(CDR) format.

## Features
- Pure Java serialization/deserialization. Allows message generation without having to compile native libraries.
- Allocation free during serialization/deserialization. All elements of the message are preallocated. 
- StringBuilder instead of string allow allocation free string deserialzation.
- Support for wchar and wstring to map directly to Java's UTF-16.
- Automatically generated equals() and toString() methods for testing and debugging.
- Support for #include directives and other C preprocessor directives. The include search path is the current directory and the parent directory of the .idl file.
- Optional (using [IHMC pub/sub serializers extra](https://github.com/ihmcrobotics/ihmc-pub-sub) ) serialization and deserialization to JSON/BSON/YAML and XML.
- @Abstract(type="[fully qualified class name]") annotation to generate an abstract Pub/Sub type. This allows reusing exisiting Java data objects in combination with IDL specified data without marshalling. Use [Name]PubSubType.setImplementation() to implement.  
 
### Limitations
- Sequences of arrays and arrays of sequences are not supported.
- Long Doubles are not supported due to limitations in the Java language.
- Union, alias, value, sparse, set and map are not implemented.
- Interfaces are not implemented.

### Compatibility notes
- CDR Byte stream is validated against FastCDR generated byte stream.
- FastRTPS's fastrtpsgen does not seem to support wstring and Sequence\<Enum\>


## Usage

The IHMC Pub/Sub generator can either be used as a gradle plugin (recommended) or standalone library.

This creates a task to compile IDL files. The following properties can be set
- idlFiles: FileCollection of idl files to compile [Required]
- inludeDirs: FileCollection of include directories
- targetDirectory: File target directory

```
task generateIDL(type: us.ihmc.idl.generator.IDLGeneratorTask) {
	idlFiles = fileTree(dir: 'idl')
	includeDirs = files(".")
	targetDirectory = file("generated")
	packagePrefix = "us.ihmc.idl.generated"
}
```

### Java application
Run us.ihmc.idl.generator.IDLGenerator. There are three options for generating IDL files

- No command line arguments: Dialogs will popup to select the IDL file and provide a target directory and package name.
- Command line arguments: us.ihmc.idl.generator.IDLGenerator \[idl filename\] \[package\] \[target directory\] 
- Call directly from Java: us.ihmc.idl.generator.IDLGenerator.execute(String idlFilename, String packageName, File targetDirectory)

# IHMC Pub/Sub Extra datatypes

The IHMC pub sub extra datatypes library provides support for serializing and deserialization of IDL datatypes to the following other formats

- JSON
- BSON
- YAML
- XML

This library uses Jackson internally. Unlike IHMC Pub Sub, the functionality in this library will allocate objects when used.

## Usage

### Gradle

Add the IHMC Pub Sub Serializers Extra library as dependency
```
repositories {
    maven { url  "http://dl.bintray.com/ihmcrobotics/maven-release" }
}
	
dependencies {
	compile group: 'us.ihmc', name: 'ihmc-pub-sub-serializers-extra', version: '0.6.11-alpha'
}
```

See [test/us/ihmc/idl/serializers/extra](ihmc-pub-sub-serializers-extra/src/test/java/us/ihmc/idl/serializers/extra) for examples as test cases.




