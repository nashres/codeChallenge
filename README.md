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
- Pagination to show more data when Scrolling down
<strong>Getting data from the server using Github API :</strong><br>

<h2>Open source API used :</h2> <br>

<strong>- Retrofit : </strong>Retrofit is a type-safe REST client for Android (or just Java) developed by Square. The library provides a powerful framework for authenticating and interacting with APIs and sending network requests with OkHttp. See this guide to understand how OkHttp works.<br>
This library makes downloading JSON or XML data from a web API fairly straightforward. Once the data is downloaded then it is parsed into a Plain Old Java Object (POJO) which must be defined for each "resource" in the response.<br>

<strong>- Gson :</strong> This is a Java library that can be used to convert Java Objects into their JSON representation. It can also be used to convert a JSON string to an equivalent Java object. Gson can work with arbitrary Java objects including pre-existing objects that you do not have source-code of.<br>

- We are using RecyclerView to Display data, this component is more powerfull then a ListView<br>

<h2> Data structure explained </h2>

In this app, we are getting the most starred Github repos created in the last 30 days (relative to 2017-11-22) <br>
using this endpoint:<br>

https://api.github.com/search/repositories?q=created:>2017-10-22&sort=stars&order=desc <br>

This is how the result looks like : <br>
`
![capture](https://user-images.githubusercontent.com/4353553/35209859-cbbc70e0-ff47-11e7-8eb0-1ff26c3b4599.JPG) 
`
Rows structure is being like bellow : <br>

![row-explained](https://user-images.githubusercontent.com/4353553/35209538-7c91149a-ff46-11e7-9bb0-e300dd144110.png)
]()

<h2> Pagination explained : </h2>

The JSON data from Github is be paginated (30 repos per Json page)

To get the 2nd page, we add &page=2 to the end of the API request like bellow : <br>

https://api.github.com/search/repositories?q=created:>2017-10-22&sort=stars&order=desc&page=2 <br>

Using Retrofit Library, it is easy to do that by adding the 'page' parameter to the QueryMap like bellow : <br>

![3](https://user-images.githubusercontent.com/4353553/35211200-5fa0f89e-ff4d-11e7-9d7c-cf888b9c2c6a.JPG)

<strong>currentPage</strong> is an incrementing variable according to every load



<h2>Video walkthrough</h2>

![gif](https://user-images.githubusercontent.com/4353553/35209564-92635f4e-ff46-11e7-8044-37fa6d235ea4.gif)

<h2> How to use this project </h2>

Please clone the repository's link to your android studio like bellow : 

![1](https://user-images.githubusercontent.com/4353553/35209972-4b8d9c72-ff48-11e7-80c1-e600d3c5f994.JPG)

![2](https://user-images.githubusercontent.com/4353553/35210047-8d8d8164-ff48-11e7-82e0-d4f31a5764b8.JPG)

<h2> Licence </h2>
The MIT License (MIT)

Copyright (c) 2018 Nisrine Zbadi
Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:<br>
The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.<br>
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.<br>



