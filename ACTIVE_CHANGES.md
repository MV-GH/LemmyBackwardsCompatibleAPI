# Active Changes

This document lists the changes that you will need to actively handle, through feature flags.



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



  