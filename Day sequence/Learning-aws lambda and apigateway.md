## I. Trying to get through the basic statistic aspects of AWS
1. lambda using java (not python)
- one lambda function can be triggered by many services (cause' they are the serverless type)
    -. triggered: event sources
    by s3, database, api gateway, event bridge..
    -. when a file uploaded to s3 then will trigger the lambda function
    -. request from the api gateway too.
- service call from inside lambda: you can also call any aws sdk client: aws s3, dynamodb, and so on.
    -. by over 200 services, we will look over the project to decide which services should be choose.

2. Java syntax:
(cause lambda use java for coding)
    **note:**
    -. every line code in java must be belongs to one class, like the only oop language
    -. 