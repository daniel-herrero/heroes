# Newman integration

In order to launch all the tests from the collection, directly from the CLI, simply follow these steps.

#### 1. Install Newman

Newman is built on Node.js. To run Newman, make sure you have Node.js installed.

Once Node.js is installed, Newman is just a command away. Install Newman from npm globally on your system allowing you to run it from anywhere.

> $ npm install -g newman

If you will also want the test results to be exported to html:

> npm install -g newman-reporter-html

#### 2. Run Newman 
You should provide both the api Collection and a Environment to attack to (it should be firstly created in Postman)

> $ newman run Heroes.postman_collection.json --timeout-request 20000 -e Heroes.localhost.environment.json -r html,cli,json,junit

Or simply call the script to do this for you:

>   $./runAllTests.sh

#### 3. Reviewing the Results (CLI/reports)
Appart from the data shown in the console, there should be a newman directory with other requested report formats (html, xml, json)

Example: newman-run-report-2017-12-13-12-21-42-061-0.html

*NOTE*: Both the collection and environment .JSON files should be updated to reflect any changes in the project API

#### Further info...
Postman
https://www.getpostman.com/docs/postman/launching_postman/installation_and_updates

Newman
https://www.getpostman.com/docs/postman/collection_runs/command_line_integration_with_newman
- Type some Markdown on the left
- See HTML in the right
- Magic

