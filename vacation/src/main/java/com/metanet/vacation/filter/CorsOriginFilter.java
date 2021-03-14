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
      config.setAllowCredentials(true);///�� ������ �����Ҷ� JSON�� JS���� ó���� �� �ְ� ����
      //��� IP�� ������ ���		
      config.addAllowedOriginPattern("*");
      config.addAllowedHeader("*");		//��� HEADER�� ���� ���
      config.addAllowedMethod("*");		//��� POST,GET ���
      config.addExposedHeader("Authorization");	
      //CORS response header �̽��� �־�(ACCESS-ORIGIN-EXPOSED-HEADERS) exposedHeaders ���� ���� �߰�

      source.registerCorsConfiguration("/**", config);
      return new CorsFilter(source);
   }
}