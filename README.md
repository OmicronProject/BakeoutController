# BakeoutController
GUI application to control the temperature and pressure control for introduction into a vacuum chamber

## Build Status
[![Build Status](
    https://travis-ci.org/OmicronProject/BakeoutController.svg?branch=master)](
    https://travis-ci.org/OmicronProject/BakeoutController
)
[![codecov](
    https://codecov.io/gh/OmicronProject/BakeoutController/branch/master/graph/badge.svg
)](https://codecov.io/gh/OmicronProject/BakeoutController)
[![Codacy Badge](
    https://api.codacy.com/project/badge/Grade/9575688447ef42fbaffa1f9a4eef6dea)](
    https://www.codacy.com/app/michalkononenko/BakeoutController?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=OmicronProject/BakeoutController&amp;utm_campaign=Badge_Grade)
[![Documentation](
    https://img.shields.io/badge/documentation-running-green.svg)](
    https://omicronproject.github.io/BakeoutController/
)
## Building the Project
This project uses [Gradle](https://gradle.org/) to build and test the code.
To view available Gradle tasks for building, run

```bash
    ./gradlew tasks
```

from this project's directory, or 

```cmd
    .\gradlew.bat tasks
```

if on Windows. To build and test the code, as well as prepare a coverage report, run

```bash
    ./gradlew check
```

or

```cmd
    .\gradlew.bat check
```

if on Windows. The compiled code should be available in 
``./build/libs/BakeoutController.jar``, for now. Coverage reports are in
``./build/reports/jacoco/test/html/index.html`` for human-readable data.
XML and CSV files are also available for loading into third-party monitoring
tools; the most notable of these being codecov.


