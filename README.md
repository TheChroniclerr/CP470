# Android Assignment - Test Coverage

## How to Run Instrumented Tests & Generate JaCoCo Coverage Report

Android Studio does not have default Coverage Report configuration for Instrumental Tests.

1. Open the project in Android Studio.
2. Connect an Android Emulator or a physical device (API level 24+ recommended).
3. Open the Terminal tab at the bottom of Android Studio.
4. Run the following Gradle command:
   ```bash
   ./gradlew clean
   ./gradlew :app:createDebugAndroidTestCoverageReport
   ```
   - Alternatively, you can configure it to run with the IDE: 
   `Run/Debug Configurartions > Add New Configuration > Gradle > [insert command]`
5. View test results:
- Problem Report: `~/AndroidAssignments/app/build/reports/androidTests/connected/debug/index.html`
- Coverage Report: `~/AndroidAssignments/app/build/reports/coverage/androidTest/debug/connected/index.html`
- The terminal message should link to the files as well.