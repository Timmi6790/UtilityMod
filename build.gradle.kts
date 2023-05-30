plugins {
    idea
    java
    id("org.jetbrains.kotlin.jvm") version "1.8.21"
    id("gg.essential.loom") version "0.10.0.+"
    id("dev.architectury.architectury-pack200") version "0.1.3"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

val baseGroup = "de.timmi6790"
val modid = rootProject.name
val mcVersion = "1.8.9"
group = "$baseGroup.utility"
// x-release-please-start-version
version = "1.0.0"
// x-release-please-end
val mixinGroup = "$group.mixin"

// Toolchains:
java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(8))
}

// Minecraft configuration:
loom {
    launchConfigs {
        "client" {
            property("mixin.debug", "true")
            property("asmhelper.verbose", "true")
            arg("--tweakClass", "org.spongepowered.asm.launch.MixinTweaker")
            arg("--mixin", "mixins.$modid.json")
        }
    }
    forge {
        pack200Provider.set(dev.architectury.pack200.java.Pack200Adapter())
        mixinConfig("mixins.$modid.json")
        accessTransformer("src/main/resources/${modid}_at.cfg")
    }

    mixin {
        defaultRefmapName.set("mixins.$modid.refmap.json")
    }
}

sourceSets.main {
    output.resourcesDir = file("$buildDir/classes/java/main")
}

// Dependencies:
repositories {
    mavenCentral()
    maven("https://repo.spongepowered.org/maven/")
    maven("https://pkgs.dev.azure.com/djtheredstoner/DevAuth/_packaging/public/maven/v1")
    maven("https://repo.essential.gg/repository/maven-public")
}

val shadowImpl: Configuration by configurations.creating {
    configurations.implementation.get().extendsFrom(this)
}

val lombokVersion = "1.18.28"

dependencies {
    minecraft("com.mojang:minecraft:$mcVersion")
    mappings("de.oceanlabs.mcp:mcp_stable:22-$mcVersion")
    forge("net.minecraftforge:forge:$mcVersion-11.15.1.2318-$mcVersion")

    shadowImpl("org.spongepowered:mixin:0.7.11-SNAPSHOT") {
        isTransitive = false
    }
    annotationProcessor("org.spongepowered:mixin:0.8.5")

    compileOnly("org.projectlombok:lombok:$lombokVersion")
    annotationProcessor("org.projectlombok:lombok:$lombokVersion")

    testCompileOnly("org.projectlombok:lombok:$lombokVersion")
    testAnnotationProcessor("org.projectlombok:lombok:$lombokVersion")

    runtimeOnly("me.djtheredstoner:DevAuth-forge-legacy:1.1.2")

    shadowImpl("gg.essential:elementa-$mcVersion-forge:590")
    shadowImpl("gg.essential:vigilance-$mcVersion-forge:284")
}

// Tasks:
tasks.withType(JavaCompile::class) {
    options.encoding = "UTF-8"
}

tasks.withType(Jar::class) {
    archiveBaseName.set(modid)
    manifest.attributes.run {
        this["FMLCorePluginContainsFMLMod"] = "true"
        this["ForceLoadAsMod"] = "true"

        this["TweakClass"] = "org.spongepowered.asm.launch.MixinTweaker"
        this["MixinConfigs"] = "mixins.$modid.json"
    }
}

tasks.processResources {
    duplicatesStrategy = DuplicatesStrategy.INCLUDE

    inputs.property("version", project.version)
    inputs.property("mcversion", mcVersion)
    inputs.property("modid", modid)
    inputs.property("mixinGroup", mixinGroup)

    //replace stuff in mcmod.info, nothing else
    from(sourceSets["main"].resources.srcDir("resources")) {
        include("mcmod.info")
        include("mixins.utilitymod.json")

        expand(inputs.properties)
    }

    rename("(.+_at.cfg)", "META-INF/$1")
}

val remapJar by tasks.named<net.fabricmc.loom.task.RemapJarTask>("remapJar") {
    archiveClassifier.set("")
    from(tasks.shadowJar)
    input.set(tasks.shadowJar.get().archiveFile)
}

tasks.jar {
    archiveClassifier.set("without-deps")
    destinationDirectory.set(layout.buildDirectory.dir("buildjars"))
}

tasks.shadowJar {
    destinationDirectory.set(layout.buildDirectory.dir("buildjars"))
    archiveClassifier.set("all-dev")
    configurations = listOf(shadowImpl)

    doLast {
        configurations.forEach {
            println("Copying jars into mod: ${it.files}")
        }
    }

    exclude(
            "**/LICENSE.*",
            "**/LICENSE",
            "**/NOTICE",
            "**/NOTICE.*",
            "pack.mcmeta",
            "dummyThing",
            "**/module-info.class",
            "META-INF/proguard/**",
            "META-INF/maven/**",
            "META-INF/versions/**",
            "META-INF/com.android.tools/**",
    )

    // Required for the update checker code
    manifest.attributes["Implementation-Version"] = project.version

    // If you want to include other dependencies and shadow them, you can relocate them in here
    fun relocate(name: String) = relocate(name, "$baseGroup.deps.$name")

    relocate("gg.essential.vigilance")
    relocate("gg.essential.elementa")
    relocate("gg.essential.universalcraft")
}

tasks.assemble.get().dependsOn(tasks.remapJar)

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


