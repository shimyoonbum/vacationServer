package com.metanet.vacation.filter;

import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsOriginFilter {
	
   @Bean
   public CorsFilter corsFilter() {
      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      CorsConfiguration config = new CorsConfiguration();
      config.setAllowCredentials(true);///내 서버가 응답할때 JSON을 JS에서 처리할 수 있게 할지
      //모든 IP의 응답을 허용		
      config.addAllowedOriginPattern("*");
      config.addAllowedHeader("*");		//모든 HEADER의 응답 허용
      config.addAllowedMethod("*");		//모든 POST,GET 허용
      config.addExposedHeader("Authorization");	
      //CORS response header 이슈가 있어(ACCESS-ORIGIN-EXPOSED-HEADERS) exposedHeaders 관련 설정 추가

      source.registerCorsConfiguration("/**", config);
      return new CorsFilter(source);
   }
}