package im.dai;

import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author: roc
 * @date: 2020/9/11 下午 05:32
 * @description: TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SwaggerApiTest {
    @Test
    public void generateAsciiDocs() throws Exception {

        URL remoteSwaggerFile = new URL("http://localhost:8888/v2/api-docs");
        Path outputDirectory = Paths.get("src/docs/markdown/generated");

        // 输出Ascii格式
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(MarkupLanguage.MARKDOWN) //除了MARKDOWN外，还支持ASCIIDOC和CONFLUENCE
                .build();


        Swagger2MarkupConverter.from(remoteSwaggerFile) // 生成静态部署文档的源头配置
                .withConfig(config)
                .build()
                .toFolder(outputDirectory); // 最终生成文件的具体目录位置，且生成文件夹
        // .toFile(Paths.get("src/docs/asciidoc/generated/all"))  // 生成单一的文件
    }
}
