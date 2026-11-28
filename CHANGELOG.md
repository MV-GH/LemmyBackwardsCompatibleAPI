# Changelog

All notable changes to this project are documented here.

## [Unreleased]

### Added

- `getModlog` now works on Lemmy 0.18 and 0.19.

### Changed

- Pre-1.0: community `description` maps to `sidebar` instead of `summary`; create/edit send `sidebar`, falling back to `summary`.

## [1.0.0-rc.5] - 2026-11-21

### Breaking changes

- `ListCommunities.sort` is now a `CommunitySortType` instead of the post `SortType`.
- `connect` and `connectForVersion` fail with a `LemmyConnectException` (`NodeInfoUnavailable`, `NotLemmy`, `InvalidVersion`, `UnsupportedVersion`) instead of `NotSupportedException`.
- `NodeInfoClient.getLemmyVersion` fails with `LemmyConnectException.NotLemmy` for other software.
- On Lemmy 0.18, a request failure whose message would contain the token (error statuses without a Lemmy error, timeouts) is now a `TokenRedactedException`.

### Added

- `LemmyApiOptions.onAuthRejected`: called with the token of a request the server rejected as not logged in.

### Fixed

- `connect` no longer throws when the instance reports a version that isn't a version number; it fails with `LemmyConnectException.InvalidVersion`.
- Lemmy 1.0: `Top*` sorts work; they are sent as `top` with a `time_range_seconds`.
- Lemmy 1.0: a `top` default post sort no longer makes `getSite` and `getMyUser` fail.
- Pre-1.0: `listPersonSaved` and `listPersonContent` return posts and comments woven together newest first, like 1.0, instead of all comments followed by all posts.
- `getSupportedEntries` includes report, notification, and person-content types supported by legacy wrappers.

## [1.0.0-rc.4] - 2026-11-18

### Breaking changes

- `EditSite.enable_nsfw` was removed, as it was in 1.0. Use its inverse `nsfw_content_disallowed`, which now also works on 0.18 and 0.19.
- `leaveAdmin` was removed, as it was in 1.0. Use `addAdmin(AddAdmin(person_id, added = false))` instead.
- `hideCommunity` and `HideCommunity` were removed, as they were in 1.0. Use `createCommunity` or `editCommunity` with `visibility = CommunityVisibility.Unlisted`. On 0.18 and 0.19 this hides the community (admins only), and `Public` unhides it. `Public` and `Unlisted` are now supported entries from 0.18.

### Added

- Feature flags `instanceBlockPersons()`, `modlog()` and `listPersonReadHiddenLiked()` for endpoints that only work on Lemmy 1.0.
- `hidePosts` works on Lemmy 1.0 by hiding the posts one by one.

### Fixed

- Only GET requests are retried after network errors, so POST/PUT/DELETE requests are no longer sent twice.
- `localhost:<port>` and `127.0.0.1:<port>` instances use http.
- An uploaded image is deleted again when applying it is cancelled.
- Creating and listing registration invitations works on Lemmy 1.0 (wrong list route, and responses failed to deserialize).
- Post notifications no longer make `listNotifications` fail on Lemmy 1.0.
- `deleteCustomEmoji` uses the correct route on Lemmy 1.0.
- `resolveObject` works on Lemmy 1.0.
- Lemmy 0.18: admins are reported as admins (`is_admin`, `local_user.admin`, `creator_is_admin`).
- Lemmy 0.18: all timestamps have a timezone.
- Lemmy 0.18: the report count no longer counts comment reports twice, and is null when it isn't available.
- Pre-1.0: partial `editCustomEmoji` edits keep the current values instead of crashing (0.18) or blanking them (0.19).
- Lemmy 0.18: `markManyPostsAsRead` stops at the first failure.
- Lemmy 0.19.2-0.19.3: `GetComments.max_depth` and `SaveUserSettings.animated_images_enabled` are sent.
- Lemmy 0.19.4-0.19.5: `listReports` filters post reports by `post_id`.
- Lemmy 0.19.11: comment reports include their `resolver`.
- Lemmy 0.19.6+: `subscribers_local` is filled in.
- Pre-1.0: `listReports` with `post_id` or `community_id` no longer returns unrelated post, comment or private message reports, and paging continues past pages without matches.
- Pre-1.0: `getComments` with `max_depth` returns no `next_page`, because the server always returns the whole tree.

## [1.0.0-rc.3] - 2026-11-17

### Breaking changes

- Pagination is cursor-only: `page` was removed from all unified request types (`GetPosts`, `GetComments`, `GetModlog`, `Search`, `ListCommunities`, `ListReports`, `ListNotifications`, `ListMedia`, `ListPersonContent`, `ListPersonSaved`, `ListPostLikes`, `ListCommentLikes`, `ListRegistrationApplications`). 
Pass `page_cursor` and read `next_page`/`prev_page` from the response. 
On pre-1.0 instances these are synthetic cursors that map to page-based pagination internally, so the same flow works on every supported version.
- `getPosts` on Lemmy 0.19 passes the server's own cursor through and now returns its `next_page`.

## [1.0.0-rc.2] - 2026-11-17

### Changed

- v1 types bumped to `1.0.0-feed-only-jwt.1`.
- Legacy getMyUser endpoints now report rejected auth tokens as `LemmyBadRequestException(401, "not_logged_in")`, matching v1 behavior.
- `listPersonSaved` supports saved posts and comments on Lemmy 0.18 and 0.19 using page-based pagination.
- Lemmy 0.19 unread counts now return a null report count when the report request fails instead of reporting zero.

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

[1.0.0-rc.3]: https://github.com/MV-GH/LemmyBackwardsCompatibleAPI/releases/tag/1.0.0-rc.3
[1.0.0-rc.2]: https://github.com/MV-GH/LemmyBackwardsCompatibleAPI/releases/tag/1.0.0-rc.2
[1.0.0-rc.1]: https://github.com/MV-GH/LemmyBackwardsCompatibleAPI/releases/tag/1.0.0-rc.1
