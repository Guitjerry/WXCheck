import com.xiaoyuan.WxCheckApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by dnys on 2017/10/1.
 */
@SpringBootApplication
public class ServletInitializer  extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WxCheckApplication.class);
    }
}
