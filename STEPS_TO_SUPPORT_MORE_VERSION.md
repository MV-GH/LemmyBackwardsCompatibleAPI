# Steps to support more versions of Lemmy

This document helps you with the changes you need to do to add more support for more recent versions of Lemmy.

- First decide if we can reuse an existing implementation or if we need to create a new one.
  - We can only reuse when its a minor version change with no API or *VERY* minor API changes.
- Generate new Types, using the new genTypes script. Must exist a `lemmy-js-client` version that can be used to generate the types.
  - Compare the types with previous version, add new stuff to Universal Types
- Generate new Router, using the new genRouter script. `lemmy_openapi_spec` must already have the new version.
  - Compare the router with previous version, add new endpoints to the Universal Router
  - Implement existing ones with `nonSupported`
- Generate the transformer from the new types to the universal types. By running the MapperRoutes script and adding the right annotations.
  - Copy it from the GeneratorScripts build folder
  - Store a version of the MapperGenerator interface
- Create a new LemmyApiUniWrapper, by copying the previous one and adapting it
    - Make sure you point to the right version of the MapperGenerator
- Add correct mapping in LemmyApi for the new LemmyApi implementation
- Add a new version to JvmTests\controllers.kt
- Add FeatureFlags
  - Update `ACTIVE_CHANGES.md` with the new FeatureFlags