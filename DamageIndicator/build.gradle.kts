plugins {
    java
    id("com.gradleup.shadow") version "9.3.0"
    id("net.minecrell.plugin-yml.bukkit") version "0.5.3" // Generates plugin.yml
}

dependencies {
    implementation("com.tchristofferson:ConfigUpdater:2.2")
    compileOnly("org.jetbrains:annotations:22.0.0")
    compileOnly("org.spigotmc:spigot-api:26.1.2-R0.1-SNAPSHOT")
    implementation(project(":API"))
    implementation(project(":NMS:26_1_R1"))

    testImplementation("junit:junit:4.13.1")
    testImplementation("org.spigotmc:spigot-api:26.1.2-R0.1-SNAPSHOT")
}
tasks {
    test {
        useJUnit()
    }
    shadowJar {
        relocate("com.tchristofferson.ConfigUpdater", "io.github.magiccheese1.damageindicator.ConfigUpdater")
    }
    build {
        dependsOn(shadowJar)
    }
}

bukkit {
    main = "io.github.magiccheese1.damageindicator.DamageIndicatorImpl"
    apiVersion = "26.1"
    commands {
        register("damageindicator") {
            description = "Reload"
            permission = "Damageindicator.admin"
        }
    }
}
