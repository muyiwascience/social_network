$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("News.feature");
formatter.feature({
  "line": 1,
  "name": "Confirm a news article is valid",
  "description": "As a product owner\nI want to check the guardian news on line\nSo I can confirm that news article is valid",
  "id": "confirm-a-news-article-is-valid",
  "keyword": "Feature"
});
formatter.before({
  "duration": 2901179526,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "Valid news article",
  "description": "",
  "id": "confirm-a-news-article-is-valid;valid-news-article",
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
  "line": 8,
  "name": "I am on the home page",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "I check a news article",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I should a valid news article",
  "keyword": "Then "
});
formatter.match({
  "location": "NewsSteps.iAmOnTheHomePage()"
});
formatter.result({
  "duration": 39287536782,
  "status": "passed"
});
formatter.match({
  "location": "NewsSteps.iCheckANewsArticle()"
});
formatter.result({
  "duration": 187413526,
  "status": "passed"
});
formatter.match({
  "location": "NewsSteps.iShouldAValidNewsArticle()"
});
formatter.result({
  "duration": 267452858,
  "status": "passed"
});
formatter.write("The Scenario name is Valid news article and the status is passed");
formatter.after({
  "duration": 269242248,
  "status": "passed"
});
});