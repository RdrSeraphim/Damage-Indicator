plugins {
    id("java")
}

// The 26.1.2 server jar already ships Mojang-mapped classes and members directly
// (Spigot dropped the separate obfuscated/remapped-mojang layer for this version),
// so no compile-time remapped-mojang artifact or output remap step is needed here.
//
// It is also compiled for Java 25, so this module alone needs a newer toolchain to
// read it off the compile classpath (the other NMS modules stay on the Java 21 default).
configure<JavaPluginExtension> {
    toolchain.languageVersion.set(JavaLanguageVersion.of(25))
}

dependencies {
    compileOnly("org.jetbrains:annotations:22.0.0")
    compileOnly("org.spigotmc:spigot:26.1.2-R0.1-SNAPSHOT")

    implementation(project(":API"))
}
