# Brew Calc

Offline pour-over calculator. No network permission, no external libraries.

Inputs: bean weight (g), brew ratio. Outputs:
- Total water   = beans x ratio
- Total bloom   = total water x 0.4
- Bloom 1       = total bloom x 50/120
- Bloom 2       = total bloom x 70/120
- Total phase 2 = total water x 0.6

## Build option A: Android Studio
1. File > Open > select this folder (accept the prompt to set up the Gradle wrapper if shown).
2. Build > Build App Bundle(s) / APK(s) > Build APK(s).
3. APK: app/build/outputs/apk/debug/app-debug.apk

## Build option B: GitHub (no local install)
1. Push this folder to a GitHub repo.
2. Actions tab > "Build APK" runs automatically.
3. Download the BrewCalc-apk artifact from the run.

## Install
Copy the APK to your phone and open it (allow "install unknown apps" for your file manager).
