package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Filter 구현
 * 1. javax.servlet.Filter 인터페이스 implements
 * 2. lifecycle(callback)메소드 오버라이딩
 * 3. web.xml에 등록
 */

public class EncodingFilter implements Filter{
	private String encoding; // 초기파라미터 encoding을 저장할 변수
	
	
	@Override
	public void destroy() {
		//Filter 객체가 소멸되기 전에 호출되는 메소드.
		System.out.println("EncodingFilter.destroy()실행");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 사용자 요청(Servlet이나 JSP)로 요청이 들어올 때마다 호출되는 메소드	
		
		System.out.println("EncodingFilter.doFilter() - 일 하기 전처리작업");
		request.setCharacterEncoding(encoding);
		
		
		// 사용자가 요청한 서블릿/jsp가 실행 - 사용자가 요청한 컴포넌트 호출
		chain.doFilter(request, response);
		
		System.out.println("EncodingFilter.doFilter() - 후처리작업");
		
	
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// Filter 객체가 생성되고 호출되는 초기화 메소드. - Web application 시작시 객체가 생성됨.
		// 매개변수 : FilterConfig - 이 필터 객체가 일할 때 필요한 정보 제공 => 초기파라미터
		
		this.encoding=config.getInitParameter("encoding");
		System.out.println("EncodingFilter.init()실행" +encoding);
		
	}



}
