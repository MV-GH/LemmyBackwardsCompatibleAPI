# Changelog

All notable changes to this project are documented here.

## [1.0.0-rc.1] - 2026-10-20

The first release candidate for the stable 1.0.0 API.

### Added

- Lemmy 1.0 API support, including version-specific routing, datatypes, transformations, and unified wrappers.
- Unified datatypes based on the Lemmy 1.0 API while retaining compatibility with supported 0.18 and 0.19 instances.
- Version-aware feature flags and supported enum entry discovery.
- A dedicated `NodeInfoClient` for instance discovery and version detection.
- `LemmyAuth.fromToken()` for creating authentication from an existing token.
- End-to-end coverage for major Lemmy 1.0 endpoints.

### Changed

- Refined `connect()` and `connectForVersion()` around typed instances, authentication, and resolved Lemmy versions.
- Added explicit authentication lifecycle operations through `updateAuth()` and `clearAuth()`.
- Improved HTTP client ownership, resource cleanup, request cancellation, and retry/timeout handling.
- Reworked image uploads and deletion behind `uploadImage()` and `deleteMedia()`, including legacy pictrs compatibility for pre-1.0 instances.
- Consolidated unified routes and removed obsolete API surface.

### Breaking changes

- Unified request and response types now follow Lemmy 1.0 where the API changed; older instances are adapted internally by the version-specific wrappers.
- Consumers should use `uploadImage()` and `deleteMedia()` instead of calling legacy pictrs APIs directly.
- Consumers using page-based pagination should provide both `page` and `page_cursor` when supporting both pre-1.0 and 1.x instances.

[1.0.0-rc.1]: https://github.com/MV-GH/LemmyBackwardsCompatibleAPI/releases/tag/1.0.0-rc.1
