# BuddyAndMe

An Android application (Java + XML) built for Assignment 2 — Android Application Development.
It implements a full "common screens" flow: Welcome → Login → Register / Forgot Password →
Reset Password → Dashboard → Profile → Logout.

## About the App

BuddyAndMe is a lightweight demo app designed around the set of screens that almost
every real-world mobile app needs before a user ever reaches its "real" features — a
splash/welcome screen, account creation, login, password recovery, a home dashboard, and
a profile with logout. Rather than building a single-purpose tool, the goal was to produce
a small, reusable template that shows these common screens working together with proper
navigation and validation, themed around a location-finder concept (the Dashboard's module
cards represent location-related features such as Find My Location, Saved Places, and Map
View).

**Why it was built:** This assignment required demonstrating core Android fundamentals —
multiple Activities, explicit Intent-based navigation, form validation, and both default
and alternative (day/night) resources — inside one cohesive, realistic app rather than
isolated exercises. Building it as a believable mini-app (instead of disconnected test
screens) made it possible to show how these pieces fit together the way they would in a
production app: a user registers, logs in, recovers a forgotten password, lands on a
dashboard of features, and can view their profile or log out, all through clean,
consistent screens.

## Features Implemented

- **Welcome Screen** — displays the app logo/name with Login and Register buttons.
- **Login Screen** — email + password fields, Login button, links to Register and
  Forgot Password. Validates empty fields.
- **Register Screen** — Name, Email, Password, Confirm Password with full validation
  (empty check, email format, password length ≥ 6, password match).
- **Forgot Password Screen** — accepts an email, validates it, and simulates sending
  recovery instructions, then navigates to Reset Password.
- **Reset Password Screen** — New Password + Confirm Password with validation.
- **Dashboard Screen** — main app modules shown as a grid of cards with icon + text.
- **Profile Screen** — displays the logged-in user's name and email, with a Logout
  button that clears the back stack and returns to Login.

## Technical Requirements Covered

- **Resources:** all user-facing text is in `res/values/strings.xml`; `res/values/colors.xml`
  and `res/values-night/colors.xml` provide light/dark color sets, switched automatically
  by the system theme.
- **Layouts:** `ConstraintLayout` (Welcome, Login, Forgot Password), `LinearLayout`
  (Register, Reset Password, Profile, Dashboard's outer wrapper), `GridLayout`
  (Dashboard's module cards).
- **Input controls:** `EditText` with `inputType` set appropriately for name, email
  (`textEmailAddress`), and password (`textPassword`).
- **Validation:** empty-field checks, email format validation, password length and
  confirm-password matching, shown via `Toast` messages.
- **Navigation:** all screen transitions use **explicit Intents**
  (`new Intent(this, TargetActivity.class)`).
- **Simulated authentication:** login/registration/password recovery are simulated
  locally (no backend), as permitted by the assignment.

## Navigation Flow

```
WelcomeActivity
      │
      ├────────► RegisterActivity ──► (back to) LoginActivity
      │
      ▼
LoginActivity
      │
      ├────────► ForgotPasswordActivity ──► ResetPasswordActivity ──► LoginActivity
      │
      ▼ (on successful login)
DashboardActivity ──► ProfileActivity ──(Logout)──► LoginActivity (back stack cleared)
```

## How to Run

1. Open the project folder in Android Studio.
2. Let Gradle sync.
3. Run on an emulator or physical device (minSdk 21+).
4. Log in or register a new account first.
