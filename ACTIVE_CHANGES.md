# Active Changes

This document lists the changes that you will need to actively handle, through feature flags.


## V1

### Sort types split + `time_range_seconds`

The many `Top*` `SortType` variants (`TopDay`, `TopWeek`, `TopMonth`, `TopYear`, `TopAll`, `TopHour`, `TopSixHour`, `TopTwelveHour`, `TopThreeMonths`, `TopSixMonths`, `TopNineMonths`) have been collapsed into a single `Top` value in v1. Time range is now expressed via `time_range_seconds: Long?` on the query (`GetPosts`, `GetComments`, `ListCommunities`, `ListMultiCommunities`, `Search`).

- On v1, set `sort = SortType.Top` and pass `time_range_seconds` (e.g. `86400` for top day).
- On pre-v1, the old `Top*` variants are still used; `time_range_seconds` is ignored. The wrapper translates automatically.

### Image upload / delete compatibility

- Consumers should use `LemmyApiBaseController.uploadImage()` and `LemmyApiBaseController.deleteMedia()`.
- Pre-1.0 Lemmy instances are now wired internally to legacy pictrs endpoints; callers should not use pictrs APIs directly anymore.
- `UploadImageResponse` now includes `delete_filename`.
- Always pass `uploadImage(...).delete_filename` into `deleteMedia(DeleteImageParams(...))`.
- On Lemmy `1.x`, `delete_filename == filename`.
- On pre-`1.0`, `delete_filename` contains the full legacy pictrs delete path, like `/pictrs/image/delete/{delete_token}/{file}`.

### Avatar/Icon/Banner

Should now use the dedicated avatar/icon/banner upload/delete endpoints.

### Pagination: `page` replaced by `page_cursor`

`page: Long?` has been removed from all list/query types in v1 (`GetPosts`, `GetComments`, `GetModlog`, `Search`, `ListCommunities`, `ListReports`, `ListNotifications`, `ListMedia`, `ListPersonContent`, `ListPostLikes`, `ListCommentLikes`, `ListRegistrationApplications`).

- On v1, use `page_cursor` for cursor-based pagination.
- To support pre-v1 instances, populate **both** `page` (for older versions, handled internally) and `page_cursor` (for v1). The wrapper will pass the appropriate one.



## 0.19.11

- Added `last_donation_notification` field to LocalUser
- Donation Dialog Shown Endpoint

## 0.19.6

- ImageDetails
- Post Query Params: show_read, show_nsfw
- Title Search Query Param
- Registration Application Endpoint


## 0.19.4
- Hide post support 
- Alt text support.
- Voting types rework: 
A user can now individually set which voting type they want to see.
  (Upvotes, downvotes, total_score, ratio) This means there is now two `show_scores` account settings.
But each has different behaviour. The old behaviour is to hide all voting types and the new one is to hide only the total.


## 0.19.0
- Log out support (invalidates the current JWT)
- Instance block support
- 2FA rework, one must now provide a valid 2FA code to enable 2FA. Added routes to support this.
