# UI-TEST

## Installation
 ```
* git clone project : git@github.com:smitasppit/ui-test.git

* cd ui-test

* mvn clean compile

#RUN TESTS
mvn clean test -Dbrowser=chrome/firefox

#where -Dbrowser is a command line argument to choose the browser to run the tests, 
defaults to Chrome only.

#It automatically detects the OS version and picks up browser provided in param above.


