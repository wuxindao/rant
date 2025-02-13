package wxdgaming.spring.boot.rant;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import wxdgaming.spring.boot.core.CoreScan;
import wxdgaming.spring.boot.data.batis.DataJdbcScan;
import wxdgaming.spring.boot.net.NetScan;
import wxdgaming.spring.boot.web.WebScan;
import wxdgaming.spring.boot.webclient.WebClientScan;

@Slf4j
@EnableScheduling
@SpringBootApplication(
        scanBasePackageClasses = {
                CoreScan.class,
                DataJdbcScan.class,
                NetScan.class,
                WebScan.class,
                WebClientScan.class,
                RantMain.class,
        },
        exclude = {
                DataSourceAutoConfiguration.class,
                MongoAutoConfiguration.class
        }
)
public class RantMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(RantMain.class);
        run.getBean(RantSpringReflect.class).content().executorAppStartMethod();
    }
}