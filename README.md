<!--suppress HtmlDeprecatedAttribute -->
<div align="center">

![badge][badge-ios]
![badge][badge-js]
![badge][badge-jvm]
![badge][badge-linux]
![badge][badge-windows]
![badge][badge-mac]
![badge][badge-watchos]
![badge][badge-tvos]
![example workflow](https://github.com//mv-gh/lemmybackwardsCompatibleAPi/actions/workflows/ci.yml/badge.svg)
[![License: AGPL v3](https://img.shields.io/badge/License-AGPL_v3-blue.svg)](https://www.gnu.org/licenses/agpl-3.0)
![GitHub stars](https://img.shields.io/github/stars/mv-gh/lemmybackwardsCompatibleAPi?style=social)
</div>


# LemmyBackwardsCompatibleAPI

A backwards compatible API for Lemmy made with Kotlin Multiplatform. Supports Lemmy 0.18+

## Usage

```kotlin
val api =  LemmyApi.getLemmyApi("voyager.lemmy.ml", auth)

api.getSite()

// Some features are version dependent, so we can check if they are supported
if(api.FF.instanceBlock()) {
    api.instanceBlock()
}

// These enums can be different depending on the version of the API
api.getSupportedEntries<SortType>()

```

## Installation
```
implementation("it.vercruysse.lemmyapi:lemmy-api:VERSION")

```


## Backwards Compatibility Strategy

The API is backwards compatible by using the following strategy:
- API route gets added.
  Add a function that returns if this feature is supported. 
  Older versions implement this route by throwing an error (nonSupported).
- API route gets removed.
  newer versions implement this route by throwing an error (nonSupported).
  Is added to the `oldRoutes` interface
- API routes its request/response changes. 
  For this, we transform response/requests to a "universal" type.
  Concrete this means, it will usually be the modified latest datatypes.
  So that the response will be the same regardless of which version.
  Here are some examples from how this will look concrete:
    - [Move admin flag from person to local_user](https://github.com/LemmyNet/lemmy/pull/3403), pre 0.19 version APIs will map their datatype to the latest datatype by moving that field from person to local_user
    - ... TODO: add more examples
- Enum entries keep an added/removed version.
  Using get `getSupportedEntries<Type>` we can retrieve the supported entries for a given enum. 
  This is useful, for example, for sorting, where the sorting options can change between versions.

There will be a concrete API version for every Lemmy minor version (0.18, 0.19).

## AutoGenerated Code
To minimize the maintenance burden, many aspects have been automated.
 TODO: add more info about this




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