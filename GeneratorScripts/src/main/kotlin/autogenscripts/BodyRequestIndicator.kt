package org.example.autogenscripts

// We decide if a DTO is a request body by checking if it starts with any of these indicators and does not end with 'Response'
val bodyRequestIndicators =
    setOf(
        "Create",
        "Update",
        "Delete",
        "Edit",
        "Add",
        "Approve",
        "Ban",
        "Block",
        "Change",
        "PasswordChange",
        "Get",
        "Mark",
        "List",
        "Purge",
        "Save",
        "Register",
        "Login",
        "PasswordReset",
        "Verify",
        "Resolve",
        "Remove",
        "Search",
        "Hide",
        "Follow",
        "Transfer",
        "Lock",
        "Feature",
        "Distinguish"
    )

val dataTypesExceptions = setOf(
    "LoginToken",
)
