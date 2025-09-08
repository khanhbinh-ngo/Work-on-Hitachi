package app.src.test;
public class TestClass {
    public string alterPayload(String payload){
        System.out.println("hello users");
        return payload.toLowerCase().replace('e', '3').replace('i', '1');
    }
}
