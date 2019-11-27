package com.example.swaggerapi;

import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import org.asciidoctor.cli.AsciidoctorInvoker;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URL;
import java.nio.file.Paths;

@SpringBootTest
class SwaggerApiApplicationTests {

	@Test
	public void generateAsciiDocs() throws Exception {
		//    输出Ascii格式
		Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
				.withGeneratedExamples()
				.withMarkupLanguage(MarkupLanguage.ASCIIDOC)
				.build();

		Swagger2MarkupConverter.from(new URL("http://114.67.100.79:8085/v2/api-docs?group=APP%20Service"))
				.withConfig(config)
				.build()
				.toFile(Paths.get("src/docs/asciidoc/generated/api"));
	}
	@Test
	public void generatePDF() {
		//样式
		String style = "pdf-style=C:\\Git_Java\\swagger-api\\src\\themes\\default-theme.yml";
		//字体
		String fontsdir = "pdf-fontsdir=C:\\Git_Java\\swagger-api\\src\\fonts";
		//需要指定adoc文件位置
		String adocPath = "C:\\Git_Java\\swagger-api\\src\\docs\\asciidoc\\generated\\api.adoc";
//		AsciidoctorInvoker.main(new String[]{"-a",style,"-a",fontsdir,"-b","pdf",adocPath});
		AsciidoctorInvoker.main(new String[]{"-a",style,"-a",fontsdir,"-b","pdf",adocPath});
	}

}
