Feature: My first feature

Scenario: This is first scenario	
	Given Firefox browser is launched
	And url is fully opened
	When user searches levis in search component
	And apply men filter in search result page
	Then verify that all results belong to men