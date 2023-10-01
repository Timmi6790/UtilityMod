plugins {
    id("maven-publish")
    alias(libs.plugins.quilt.loom)
    id("io.freefair.lombok") version "8.3"
    id("com.diffplug.spotless") version "6.19.0"
    checkstyle
    jacoco
}

tasks.withType(Jar::class) {
    // archiveBaseName.set(project.archives_base_name)
}

version = "$project.version+${libs.versions.minecraft.get()}"
group = "de.timmi6790.utility"
// group = project.te

repositories {
    // Add repositories to retrieve artifacts from in here.
    // You should only use this when depending on other mods because
    // Loom adds the essential maven repositories to download Minecraft and libraries from automatically.
    // See https://docs.gradle.org/current/userguide/declaring_repositories.html
    // for more information about repositories.
}

loom {
    // Loom and Loader use this block to gather more information about your mod.
    mods {
        // This should match your mod's mod id.
        create("utilitymod") {
            // Tell Loom about each source set used by your mod here. This ensures that your mod's classes are properly transformed by Loader.
            sourceSet("main")
            // If you shade (directly include classes, not JiJ) a dependency into your mod, include it here using one of these methods:
            // dependency("com.example.shadowedmod:1.2.3")
            // configuration("exampleShadedConfigurationName")
        }
    }
}
// All the dependencies are declared at gradle/libs.version.toml and referenced with "libs.<id>"
// See https://docs.gradle.org/current/userguide/platforms.html for information on how version catalogs work.
dependencies {
    minecraft(libs.minecraft)
    mappings(
            loom.layered {
                mappings("org.quiltmc:quilt-mappings:${libs.versions.quilt.mappings.get()}:intermediary-v2")
                officialMojangMappings()
            }
    )

    modImplementation(libs.quilt.loader)
    modImplementation(libs.quilted.fabric.api)

    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0-M1")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.10.0-M1")
    testImplementation("org.mockito:mockito-core:4.11.0")
    testImplementation("org.mockito:mockito-inline:4.11.0")
    testImplementation("org.assertj:assertj-core:3.24.2")
}

tasks.processResources {
    duplicatesStrategy = DuplicatesStrategy.INCLUDE

    inputs.property("version", version)
    inputs.property("mcversion", "1.20")

    from(sourceSets["main"].resources.srcDir("resources")) {
        include("quilt.mod.json")
        include("utilitymod.mixins.json")

        expand(inputs.properties)
    }
}

tasks.withType(JavaCompile::class).configureEach {
    options.encoding = "UTF-8"
}

spotless {
    java {
        // Use the default importOrder configuration
        importOrder()
        removeUnusedImports()

        // Cleanthat will refactor your code, but it may break your style: apply it before your formatter
        cleanthat()

        palantirJavaFormat()

        formatAnnotations() // fixes formatting of type annotations
    }

    kotlinGradle {
        ktlint()
    }
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17

    // Loom will automatically attach sourcesJar to a RemapSourcesJar task and to the "build" task if it is present.
    // If you remove this line, sources will not be generated.
    withSourcesJar()
}

// Testing:
tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<JacocoReport> {
    reports {
        xml.required.set(true)
        csv.required.set(false)
        html.required.set(false)
    }
}

tasks.test.get().finalizedBy(tasks.jacocoTestReport)

// Hook tasks
fun registerHook(hookName: String) {
    tasks.register<Copy>(hookName) {
        from(layout.projectDirectory.file("hooks/$hookName"))
        into(layout.projectDirectory.dir(".git/hooks"))
        fileMode = Integer.getInteger("0755")
    }

    tasks.build.get().dependsOn(hookName)
}

registerHook("commit-msg")