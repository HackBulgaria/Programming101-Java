### 1. Download a file with java
Using only URL and the stream classes, download this photo: http://d3dsacqprgcsqh.cloudfront.net/photo/aozrdx0_700b.jpg to a location of your choosing

##### Now accept files from the command line and label your program the 'java wget'. Woohoo!

### 2. Make a simple website crawler
Have you grown tiiiiiiired of looking for stuff on websites that simply seems is not in the navigation menu at all?
You grow tired of that... and suddenly, baaaam! Someone skypes you the link. It was there, how could I have not seen it.


Today, we will put an end to that.

Write a simple web crawler, that is receiving a URL as a command line parameter and a "needle" to search for.
Needle is text, usually a sentence.

What your crawler should do is simple
- GET the contents of the URL received
- Check if the contents contain "needle"
- If they do, output the URL and exit
- If they don't, **get all the links** from the URL given and repeat for every link.

Hints/tips:
- **Don't go out of the website's scope** - if a link in `abv.bg` points to google, well, don't follow google, please...
- **Don't visit the same URL twice**
- **Use regular expressions** for getting links. If you are unfamiliar with them, use the following method:
```java
	private static List<String> getAllLinks(String content) {
		ArrayList<String> resultList = new ArrayList<>();
		String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			resultList.add(matcher.group(1));
		}
		return resultList;
	}
```
- **If you are not comfortable with even using something as ugly as regular expressions, you can do it with regular string matching. It will be harder though :(**
- Use small websites for testing. For example, http://ebusiness.free.bg is one site you can use. It has very, very few links. (Search for the word 'Револвираща'.)

### 3. Create a weather forcasting tool
First start with getting the weather in a concrete location using [OpenWeatherMap](http://openweathermap.org/current#name) REST service API. (You can use [Jettison library](http://jettison.codehaus.org/) and [Apache HttpClient](https://hc.apache.org/httpcomponents-client-ga/tutorial/html/)).

Second thing is to think for a simple algorithm which can work for weather prediction.

And the third thing (the most important one!!!) is how to design the entire tool (software design).
