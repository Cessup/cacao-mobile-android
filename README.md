# cacao

Cacao is a example of an e-commerce. It's mobile application in Android by kotlin so that is a mobile part. 

I'm still developing it so my idea is make a system by my knowledge because I wanted to show you how I can make any system. If any one needs it for consult that will a pleasure be reference.

If you want to more information about me you can visit my website.
- [cessup.com](https://www.cessup.com)


## Pre-Requirements
Before your run, you need to have the next project in a local environment because there is API to this project. If you don't have that the application doesn't work correctly.


- [cacao-general-api-ktor](https://github.com/Cessup/cacao-general-api-ktor)



## Features
Here's a list of features included in this project:

| Name                                                                                                                                      | Description                                                   |
|-------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------|
| [Session](https://www.postman.com/cessupx/cacao-workspace/folder/goo6ezk/session-services) | There are all services about session like sign in or sing up. |
| [Eatable](https://www.postman.com/cessupx/cacao-workspace/folder/fjmlivp/eatable-services) | There are all services about eatable like drinks and meals.   |

## Figma Design

You can visit Figma if you would like watch the mobile application

[Figma Design Preview](https://www.figma.com/proto/uWNc0eOwt7pp30qCtgrC7W/Cocoa-App?node-id=3-6272&t=kVK7v8WPemA62hsb-1&scaling=min-zoom&content-scaling=fixed&page-id=0%3A1&starting-point-node-id=3%3A6749&show-proto-sidebar=1)


## Building & Running

To build or run the project, use one of the following tasks:

| Task                          | Description                                                          |
|-------------------------------|----------------------------------------------------------------------|
| `./gradlew test`              | Run the tests                                                        |
| `./gradlew build`             | Build everything                                                     |
| `buildFatJar`                 | Build an executable JAR of the server with all dependencies included |
| `buildImage`                  | Build the docker image to use with the fat JAR                       |
| `publishImageToLocalRegistry` | Publish the docker image locally                                     |
| `run`                         | Run the server                                                       |
| `runDocker`                   | Run using the local docker image                                     |

If the application starts successfully, you'll see the following output:

```
Executing tasks: [:app:assembleDebug] in project /Users/user/StudioProjects/cacaomobileandroid

Starting Gradle Daemon...
Gradle Daemon started in 1 s 218 ms
> Task :app:preBuild UP-TO-DATE
> Task :app:preDebugBuild UP-TO-DATE
> Task :app:mergeDebugNativeDebugMetadata NO-SOURCE
> Task :app:checkKotlinGradlePluginConfigurationErrors SKIPPED
> Task :app:generateDebugResValues
> Task :app:checkDebugAarMetadata
> Task :app:mapDebugSourceSetPaths
> Task :app:generateDebugResources
> Task :app:packageDebugResources
> Task :app:createDebugCompatibleScreenManifests
> Task :app:extractDeepLinksDebug
> Task :app:mergeDebugResources
> Task :app:parseDebugLocalResources
> Task :app:processDebugMainManifest
> Task :app:processDebugManifest
> Task :app:mergeDebugShaders
> Task :app:compileDebugShaders NO-SOURCE
> Task :app:generateDebugAssets UP-TO-DATE
> Task :app:javaPreCompileDebug
> Task :app:mergeDebugAssets
> Task :app:compressDebugAssets
> Task :app:processDebugManifestForPackage
> Task :app:desugarDebugFileDependencies
> Task :app:mergeDebugJniLibFolders
> Task :app:checkDebugDuplicateClasses
> Task :app:mergeDebugNativeLibs
> Task :app:processDebugResources
> Task :app:mergeExtDexDebug
> Task :app:mergeLibDexDebug
> Task :app:validateSigningDebug
> Task :app:writeDebugAppMetadata
> Task :app:writeDebugSigningConfigVersions
> Task :app:stripDebugDebugSymbols
> Task :app:kspDebugKotlin
> Task :app:compileDebugKotlin
> Task :app:compileDebugJavaWithJavac
> Task :app:processDebugJavaRes
> Task :app:dexBuilderDebug
> Task :app:mergeProjectDexDebug
> Task :app:mergeDebugJavaResource
> Task :app:packageDebug
> Task :app:createDebugApkListingFileRedirect
> Task :app:assembleDebug

BUILD SUCCESSFUL in 1m 16s
36 actionable tasks: 36 executed

Build Analyzer results available
```

To run the code you need a physical device or an emulation with a minimum API of 30.

If you need more information about it you should visit next site.

- [Run apps on the Android Emulator](https://developer.android.com/studio/run/emulator)







