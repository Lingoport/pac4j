# pac4j
# Instructions to build the pac4j jars needed for Localyzer-Express and Globalyzer-Express

## Overview
Localyzer-Express and Globalyzer-Expres use the grails spring-security-rest plugin for oauth2 authentication of users 
via GitHub, Bitbucket, and Gitlab.

The grails plugin depends on pac4j to define the various oauth2 client profiles (GitHub, Bitbucket, Gitlab).

The particular pac4j version (3.8.x) used by the plugin had an error in the GitHub client profile, and did not support Bitbucket or Gitlab.

I forked the pac4j repository and created a Lingoport_3.8.x branch, which fixes the GitHub issue and implements Bitbucket and Gitlab.

## Clone Lingoport/pac4j repository
1. Clone git repository: https://github.com/Lingoport/pac4j
2. Use branch Lingoprt_3.8.x

## Build Jars
To build: 
'''
cd git/pac4j
mvn clean package -Dcheckstyle.skip
'''
Location of resulting jars:
'''
git/pac4j/pac4j-cas/target/pac4j-cas-3.8.4-SNAPSHOT.jar
git/pac4j/pac4j-core/target/pac4j-core-3.8.4-SNAPSHOT.jar
git/pac4j/pac4j-oauth/target/pac4j-oauth-3.8.4-SNAPSHOT.jar
'''

## Deploy Jars
1. Copy the resulting jars to git/localyzer-express/translation-express/lib 
2. Copy the resulting jars to git/i18nexpress/i18nexpress/lib
