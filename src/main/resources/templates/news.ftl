<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>News</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
    <style>
img {
    border: 0px solid;
    border-radius: 4px;
    padding: 5px;
    width: 100%;
    height: 100%;
}

.category_article_body {
    position: relative;
    display: block;
    font-size: 10px !importent;
    float:left;
}

.top_article_img {
    display: block;
}

a, a:active, a:focus, a:active {
    text-decoration: none;
    outline: none;
}
</style>
</head>
<body>
<h1 style="text-align:center">News Headlines from Different Sources</h1>
<div style="text-align:center">
	<form action="/news" method="get">
	    	<input type="text"name="search"/>
	        <input type="submit" value="Submit" />
	</form>
</div>
<br><br>
<#list newsList as article>

	<#if article?index % 3 == 0><div class="clearfix"></div></#if>
    <div class="container col-md-4 category_article_body">
	    <div class="top_article_img">
	        <#if article.urlToImage??><img src="${article.urlToImage}"/><#else></#if>
	    </div>
	
	    <div class="category_article_title">
	        <h4>
	            <a href="${article.url}" target="_self">${article.title}</a>
	        </h4>
	    </div>
	
	    <div class="category_article_date">
	        <a href="#">${article.source.name}</a>&nbsp;
	        <span>${article.publishedAt}</span>, by:
	        <a href="#"> <#if article.author??>${article.author}<#else></#if></a>
	    </div>
	
	    <div class="category_article_description">
	        <span>${article.description}</span>
	    </div>
	</div>
</#list>
</body>
</html>
<script>
$(function() {
    $(".category_article_body").each(function() {
        var hue = 'rgb(' + (Math.floor((256-199)*Math.random()) + 200) + ',' + (Math.floor((256-199)*Math.random()) + 200) + ',' + (Math.floor((256-199)*Math.random()) + 200) + ')';
         $(this).css("background-color", hue);
    });
});
</script>


