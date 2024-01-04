package com.spring.mvc.config;

import com.spring.mvc.interceptor.AfterLoginInterceptor;
import com.spring.mvc.interceptor.BoardInterceptor;
import com.spring.mvc.member.entity.Board;
import com.spring.mvc.member.interceptor.AutoLoginInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//만든 인터셉터들을 스프링 컨텍스트에 등록하는 설정 파일
@Configuration
@RequiredArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {

    private final AutoLoginInterceptor autoLoginInterceptor;
    private final AfterLoginInterceptor afterLoginInterceptor;
    private final BoardInterceptor boardInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){

        //자동 로그인 인터셉터 설정
        registry.addInterceptor(autoLoginInterceptor) //어떤 인터셉터를 등록 할 것인가 ?
                .addPathPatterns("/**");//어떤 요청에서 인터셉터를 발동 시킬 것인가 ?


        //로그인 후 비회원전용 페이지 겁근 차단 인터셉터 설정
        registry.addInterceptor(afterLoginInterceptor)//어떤 인터셉터를 등록 할 것인가 ?
                .addPathPatterns("/login/sign-up","/login/sign-in"); //어떤 요청에서 인터셉터를 발동 시킬 것인가 ?

        //게시판 인터셉터 설정
        registry.addInterceptor(boardInterceptor) //어떤 인터셉터를 등록 할 것인가 ?
                .addPathPatterns("/board/room"); //어떤 요청에서 인터셉터를 발동 시킬 것인가 ?
    }


}
