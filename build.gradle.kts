plugins {
    java
    application
    id("org.beryx.jlink") version "2.23.8"
}

group = "net.eldelto"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val vertxVersion = "4.0.3"
val log4JVersion = "2.14.1"

dependencies {
    implementation("io.vertx:vertx-core:$vertxVersion")
    implementation("io.vertx:vertx-web:$vertxVersion")
    implementation("io.projectreactor:reactor-core:3.4.6")

    implementation("org.apache.logging.log4j:log4j-api:$log4JVersion")
    implementation("org.apache.logging.log4j:log4j-core:$log4JVersion")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

application {
    mainModule.set("pythia.main")
    mainClass.set("net.eldelto.pythia.Main")
}

jlink {
    launcher{
        name = "pythia"
    }

    mergedModule {
        uses("io.vertx.core.spi.VertxServiceProvider")
        uses("io.vertx.core.spi.VerticleFactory")
        excludeProvides(mapOf("service" to "reactor.blockhound.integration.BlockHoundIntegration") )
    }
}