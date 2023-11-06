Feature: Search and Place the Order for Products
@OffersPage
Scenario Outline: Search Experience for product search in both home and offers page.

Given User is on GreenCart Landing Page
When User searched wih Shortname <Name> and extracted actual name of product
Then User searched for <Name> shortname in offers page
And validate product name in offers page matches with Landing Page

Examples:
| Name |
| Tom  |
| Car  |
| Beet |
