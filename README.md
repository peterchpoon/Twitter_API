# Twitter_API
This API is to demonstrate API service creation via Dropwizard on Twitter.
To run the Timeline API (GET):
http://localhost:8080/v1/twitter/{id}/timeline
ex:
http://localhost:8080/v1/twitter/2305278770/timeline

To run the Tweet API (POST):
http://localhost:8080/v1/twitter/{id}?message={text}
ex:
http://localhost:8080/v1/twitter/2305278770?message=PingPong

*Note: the pom.xml and config.yml and credential.db files have been excluded.
