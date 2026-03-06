plugins {
    java
}

group = "org.santiagom123"
version = "InDev5.0"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }
}

dependencies {
    implementation("com.google.code.gson:gson:2.10.1")

    // Links your local 18MB jfxrt.jar found in BellSoft Full JDK ZIP
    implementation(files("libs/jfxrt.jar"))

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")
}
