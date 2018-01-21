# codeChallenge
This is an Implementation RecyclerView using <strong>Retrofit</strong> and <strong>Gson</strong> to Create a simple app that lists the most starred Github repositories that were created in the last 30 days. <br>
JSON Data is being fetched directly from the Github API(read more about Github API <a href="https://developer.github.com/v3/search/#search-repositories">here</a>)<br>

<strong>Features :</strong><br>
- listing the most starred Github repos that were created in the last 30 days.<br>
- listing One repository per row.<br>
- Diplaying the following details of each repository row :<br>
- Repository name<br>
- Repository description<br>
- Numbers of stars for the repo.<br>
- Username and avatar of the owner.<br>
<!--[BONUS] As a User I should be able to keep scrolling and new results should appear (pagination).-->
<strong>Getting data from Github :</strong><br>
In this app, we are getting the most starred Github repos created in the last 30 days (relative to 2017-11-22) <br>
using this endpoint:<br>

https://api.github.com/search/repositories?q=created:>2017-10-22&sort=stars&order=desc
