rootProject.name = "DamageIndicator"

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

include(
    "API",
    "DamageIndicator",
    ":NMS:26_1_R1",
)
