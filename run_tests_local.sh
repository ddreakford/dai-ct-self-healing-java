#!/bin/sh
#
# Run sample tests locally via Docker

export CT_URL=
export CT_ACCESS_KEY=

docker run -it --rm --name ct-self-healing-tests \
-v "$(pwd)":/usr/src/mymaven \
-w /usr/src/mymaven \
maven:3.8.6-openjdk-11 mvn clean test -DxmlFile=regular_tests.xml

docker run -it --rm --name ct-self-healing-tests \
-v "$(pwd)":/usr/src/mymaven \
-w /usr/src/mymaven \
maven:3.8.6-openjdk-11 mvn clean test -DxmlFile=self_healing_tests.xml
