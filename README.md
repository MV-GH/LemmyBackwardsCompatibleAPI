<!--suppress HtmlDeprecatedAttribute -->
<div align="center">

![MavenCentral](https://img.shields.io/maven-central/v/it.vercruysse.lemmyapi/lemmy-api)
![badge][badge-js]
![badge][badge-jvm]
![badge][badge-android]
![badge][badge-linux]
![badge][badge-windows]
![badge][badge-mac]
![badge][badge-ios]
![badge][badge-watchos]
![badge][badge-tvos]
![example workflow](https://github.com//mv-gh/lemmybackwardsCompatibleAPi/actions/workflows/ci.yml/badge.svg)
[![License: AGPL v3](https://img.shields.io/badge/License-AGPL_v3-blue.svg)](https://www.gnu.org/licenses/agpl-3.0)
![GitHub stars](https://img.shields.io/github/stars/mv-gh/lemmybackwardsCompatibleAPi?style=social)
</div>


# LemmyBackwardsCompatibleAPI

## Project Overview

A **Kotlin Multiplatform** library that provides a single, unified API surface over multiple Lemmy server versions (0.18+, 0.19+, 1.0+). Consumers call one interface (`LemmyApiBaseController`) and receive unified ("uni") datatypes regardless of which Lemmy version the target instance is running.

Built with **Ktor** (HTTP), **kotlinx.serialization** (JSON), and targets JVM, Android, iOS, macOS, Linux, Windows, and JS.

## Usage

```kotlin
val factory = LemmyApiFactory()
val api = factory.create("voyager.lemmy.ml", auth).getOrThrow()

api.getSite()

// Some features are version dependent, so we can check if they are supported
if(api.FF.instanceBlock()) {
    api.instanceBlock()
}

// These enums can be different depending on the version of the API
api.getSupportedEntries<SortType>()

factory.close()
```

You can also supply any Ktor `HttpClient`. Its engine and configuration are retained, while the library adds the plugins required for Lemmy requests:

```kotlin
val httpClient = HttpClient(OkHttp) {
    install(Logging)
}
val factory = LemmyApiFactory(httpClient)
val api = factory.create("voyager.lemmy.ml").getOrThrow()
```

Keep the factory open while using controllers created by it. Controllers are `AutoCloseable` and can be closed individually; closing the factory closes every controller it created. A supplied `HttpClient` remains caller-owned and must be closed by the caller; when no client is supplied, the factory owns and closes its default client.


## Installation

```kts
implementation("it.vercruysse.lemmyapi:lemmy-api:VERSION")
```
It is currently in beta.

## Architecture

```
LemmyApiFactory (optional caller-owned HttpClient)
  └─ createForVersion(instance, version) → LemmyApiBaseController
        │
        └─ version-specific LemmyApiUniWrapper  (implements LemmyApiBaseController)
              ├─ LemmyApiController              (raw Ktor HTTP calls, version-specific datatypes)
              ├─ Transformer                     (maps version-specific ↔ unified datatypes)
              └─ MapperGenerator (interface)     (declares all toUni/fromUni signatures)
```


## Goals

The intention is to provide an easy-to-use API that supports a wide range of Lemmy instances.
The backwards compatibility is achieved by transforming the requests and responses to a "universal" type.
And by allowing you to check if a feature is supported by the instance. 
That way you can change the behavior of your app depending on the instance's version.

It is a non-goal to provide a stable API. The API can change with every iteration without warning nor deprecation.

## Extra features

- JVM datatypes implement `Serializable`
- Android datatypes implement `Parcelable` and `Serializable`


[badge-android]: http://img.shields.io/badge/-android-6EDB8D.svg?style=flat
[badge-android-native]: http://img.shields.io/badge/support-[AndroidNative]-6EDB8D.svg?style=flat
[badge-wearos]: http://img.shields.io/badge/-wearos-8ECDA0.svg?style=flat
[badge-jvm]: http://img.shields.io/badge/-jvm-DB413D.svg?style=flat
[badge-js]: http://img.shields.io/badge/-js-F8DB5D.svg?style=flat
[badge-js-ir]: https://img.shields.io/badge/support-[IR]-AAC4E0.svg?style=flat
[badge-nodejs]: https://img.shields.io/badge/-nodejs-68a063.svg?style=flat
[badge-linux]: http://img.shields.io/badge/-linux-2D3F6C.svg?style=flat
[badge-windows]: http://img.shields.io/badge/-windows-4D76CD.svg?style=flat
[badge-wasm]: https://img.shields.io/badge/-wasm-624FE8.svg?style=flat
[badge-apple-silicon]: http://img.shields.io/badge/support-[AppleSilicon]-43BBFF.svg?style=flat
[badge-ios]: http://img.shields.io/badge/-ios-CDCDCD.svg?style=flat
[badge-mac]: http://img.shields.io/badge/-macos-111111.svg?style=flat
[badge-watchos]: http://img.shields.io/badge/-watchos-C0C0C0.svg?style=flat
[badge-tvos]: http://img.shields.io/badge/-tvos-808080.svg?style=flat