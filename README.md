# springboot sleuth example

Minimal sample app to show case distributed tracing across micro services.
To have same trace Id across micro services just pass X-B3-TraceId and
X-B3-SpanId in headers to downstream service. If these header parameters
are not passed. Spring sleuth will create new span and trace Ids.

## Requirements

For building and running the application you need:
rest-api sample application - This is the downstream application

## Running the application locally

```shell
mvn spring-boot:run
```
