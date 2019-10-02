# springboot sleuth example

Minimal sample app to show case distributed tracing across micro services.
To have same trace Id across different downstream micro services just pass X-B3-TraceId and
X-B3-SpanId in headers when calling the downstream service. If these header parameters
are not passed. Spring sleuth will create new span and trace Ids if there are no existing traceid and span id headers

## Terminology

### Span: 
The basic unit of work.

### Trace:
Trace: A set of spans forming a tree-like structure. 



## Requirements

For building and running the application you need:
rest-api sample application - This is the downstream application (https://github.com/saagarwal-pivotal/rest-api.git).
Please download rest-api project and run it locally.

## Running the application locally

```shell
mvn spring-boot:run
```
