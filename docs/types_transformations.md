# Datatype transformations

This file documents the transformations that are applied to the datatypes.

## File level
- Download TS types from lemmy-js-client
- Filters out the types that are not used in the API
- Convert TS to Kotlin using Dukat
- It loops over the lines of converted datatypes

## Line level
- Drops the first 15 dukat imports
- Converts the interfaces to data class
- Adds default null to nullable types
- Add missing commas
- Replaces vars with vals
- Replace Arrays with Lists
- Converts numbers to Longs except if they are in a manual `int` list
- Replaces `my_vote` default
- Replaces types that should be prebuilt enums

## Final steps
- Adds imports
- Adds above line level steps
- Adds missing last newline
- Remove remnants