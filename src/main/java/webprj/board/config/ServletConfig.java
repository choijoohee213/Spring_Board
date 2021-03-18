package webprj.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan("webprj.board.controller")
public class ServletConfig implements WebMvcConfigurer {
  // 정적 콘텐츠 처리  설정
  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    // 고정적인 리소스에 대한 요청을 직접 처리하지 않고, 서블릿 컨테이너의 디폴트 서블릿 전달 요청
    configurer.enable();
  }

  @Override
  public void configureViewResolvers(ViewResolverRegistry registry) {
    registry.jsp("/WEB-INF/views/",".jsp");
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/**").addResourceLocations("/static/");
  }

  @Bean
  public StringHttpMessageConverter stringHttpMessageConverter() {
    final StringHttpMessageConverter stringConverter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
    stringConverter.setSupportedMediaTypes(
          Arrays.asList(MediaType.TEXT_PLAIN, MediaType.TEXT_HTML, MediaType.APPLICATION_JSON));
    return stringConverter;
  }

  @Bean
  public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
    MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
    mappingJackson2HttpMessageConverter.setSupportedMediaTypes(
          Arrays.asList(MediaType.APPLICATION_JSON)
    );
    return mappingJackson2HttpMessageConverter;
  }

  @Override
  public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.add(stringHttpMessageConverter());
    converters.add(mappingJackson2HttpMessageConverter());
  }

  //파일 업로드 MultipartResolver
  @Bean
  public CommonsMultipartResolver multipartResolver(){
    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
    multipartResolver.setDefaultEncoding("utf-8");
    multipartResolver.setMaxUploadSize(1048575600);
    multipartResolver.setMaxUploadSizePerFile(20971520);
    try {
      multipartResolver.setUploadTempDir(new FileSystemResource(System.getProperty("user.dir") + "\\files"));
    } catch (IOException e){
      System.out.println(e);
    }
    multipartResolver.setMaxInMemorySize(10485756);
    return multipartResolver;
  }

}
