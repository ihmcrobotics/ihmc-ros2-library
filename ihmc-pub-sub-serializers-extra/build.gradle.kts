plugins {
   id("us.ihmc.ihmc-build")
}

ihmc {
   loadProductProperties("../group.gradle.properties")

   configureDependencyResolution()
   configurePublications()
}

mainDependencies {
    api("us.ihmc:ihmc-pub-sub:source")
    api("com.fasterxml.jackson.core:jackson-databind:2.18.1")
    api("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.18.1")
    api("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.18.1")
    api("com.fasterxml.jackson.dataformat:jackson-dataformat-properties:2.18.1")
    api("org.codehaus.woodstox:woodstox-core-asl:4.4.1")
    api("de.undercouch:bson4jackson:2.15.1")
}

testDependencies {
    api("us.ihmc:ihmc-pub-sub-generator-test:source")
}
