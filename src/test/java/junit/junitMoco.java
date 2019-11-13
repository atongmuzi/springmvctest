package junit;

import com.github.dreamhead.moco.*;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.junit.Test;
import java.io.IOException;
import static com.github.dreamhead.moco.Moco.httpServer;
import static com.github.dreamhead.moco.Runner.runner;


public class junitMoco {
//    @Autowired
//    HttpServer server;

    @Test
    public void moco() throws IOException {

       HttpServer server = httpServer(8080);
       server.redirectTo("http://ninety-five.lifengkong.cn/api/v1.0/captcha/phone/captchaId");
     //  server.get("http://koala-admin-dev.lifengkong.cn/test/login");


        runner(server).start();
     //  HttpResponseSetting acb= server.request(by("foo")).response("bar");
      //  String content= Request.Get("http://localhost:8080").execute().returnContent().toString();
        Content httpResponse= Request.Get("http://localhost:8080").execute().returnContent();
        Content httpResponse1= Request.Get("http://ninety-five.lifengkong.cn/api/v1.0/captcha/phone/captchaId").execute().returnContent();
        server.response("bar");
        System.out.println(httpResponse);


    }

}
