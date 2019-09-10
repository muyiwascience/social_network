$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("CheckingRecord.feature");
formatter.feature({
  "line": 1,
  "name": "Getting records",
  "description": "As a user\nI want to get records\nSo I can display",
  "id": "getting-records",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 7,
  "name": "users make post via the services",
  "description": "",
  "id": "getting-records;users-make-post-via-the-services",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 6,
      "name": "@wip"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "I have access to webapi without authentication",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I make post via the services",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I should posts displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "MakePostsSteps.iHaveAccessToWebapiWithoutAuthentication()"
});
formatter.result({
  "duration": 541404801,
  "status": "passed"
});
formatter.match({
  "location": "MakePostsSteps.iMakePostViaTheServices()"
});
formatter.result({
  "duration": 43661,
  "status": "passed"
});
formatter.match({
  "location": "MakePostsSteps.iShouldPostsDisplayed()"
});
formatter.result({
  "duration": 337032,
  "status": "passed"
});
});