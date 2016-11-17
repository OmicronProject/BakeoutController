#!/bin/bash

__AUTHOR__="Michal Kononenko"

cat << EndOfLogo
Mike's documentation generator

Set up script
EndOfLogo

# Exit with a non-zero exit code if something breaks
set -e

# Config

DIRECTORY_NAME="travis_documentation"
DOXYFILE_NAME="Doxyfile"

REPOSITORY_CLONE_URL="https://github.com/OmicronProject/BakeoutController.git"
REPOSITORY_FOLDER_NAME="BakeoutController"

# Travis CI parameters. Pretend to be a user called Travis CI

TRAVIS_USERNAME="Travis CI"
TRAVIS_EMAIL="travis@travis-ci.org"

git config user.name ${TRAVIS_USERNAME}
git config user.email ${TRAVIS_EMAIL}


mkdir ${DIRECTORY_NAME}
cd ${DIRECTORY_NAME}

echo "Cloning the repository from ${REPOSITORY_CLONE_URL}"
git clone -b gh-pages ${REPOSITORY_CLONE_URL} ${REPOSITORY_FOLDER_NAME}

cd ${REPOSITORY_FOLDER_NAME}

# Wipe the repository gh-pages branch
rm -r *

echo "" > .nojekyll

echo "Generating Doxygen code documentation..."

doxygen ${DOXYFILE_NAME} 2>&1 | tee doxygen.log

if [ -d "html" ] && [ -f "html/index.html" ]; then

    echo "Uploading documentation to the gh-pages branch"

    git add --all
    git commit -m "Deploy code docs to GitHub pages. Travis build: ${TRAVIS_BUILD_NUMBER}"
    git push > /dev/null 2>&1
else
    echo '' >&2
    echo 'Warning: No html documentation files have been found!' >&2
    echo 'Warning: No documentation pushed to GitHub' >&2
    exit 1
fi

