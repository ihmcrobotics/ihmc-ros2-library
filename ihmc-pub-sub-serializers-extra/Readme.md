# IHMC Pub/Sub Extra datatypes

The IHMC pub sub extra datatypes library provides support for serializing and deserialization of IDL datatypes to the following other formats

- JSON
- BSON
- YAML
- XML

This library uses Jackson internally. Unlike IHMC Pub Sub, the functionality in this library will allocate objects when used.

## Toolchain
- [IHMC Pub/Sub](https://github.com/ihmcrobotics/ihmc-pub-sub): IHMC Pub/Sub RTPS library
- [IHMC Pub/Sub generator](https://github.com/ihmcrobotics/ihmc-pub-sub): Gradle plugin and standalone application to generate java classes from .idl messages.
- [IHMC RTPS Visualizer](https://github.com/ihmcrobotics/ihmc-rtps-visualizer): GUI to display partitions, topics, participants, subscribers, publisher and publisher data on a RTPS domain.
- [IHMC Pub/Sub serializers extra](https://github.com/ihmcrobotics/ihmc-pub-sub): Optional serializer to generated JSON, BSON, YAML, Java Properties and XML(limited) output from .idl messages. 

## License
The IHMC Pub/Sub Serializers Extra library is licensed under the Apache 2.0. See LICENSE.txt

## Usage

### Gradle
Add the IHMC Pub Sub Serializers Extra library as dependency
```
repositories {
    maven {
        url  "http://dl.bintray.com/ihmcrobotics/maven-release"
    }
}
	
dependencies {
	compile group: 'us.ihmc', name: 'IHMCPubSubSerializersExtra', version: '0.2.4'
}
```

See [test/us/ihmc/idl/serializers/extra](test/us/ihmc/idl/serializers/extra) for examples as test cases.
