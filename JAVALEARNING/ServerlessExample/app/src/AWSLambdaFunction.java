public class AWSLambdaFunction {
    public String alterPayload(String payload) {
        System.out.println("hello");
        return payload.toLowerCase().replace('e','3').replace('i','1');
    }
}
