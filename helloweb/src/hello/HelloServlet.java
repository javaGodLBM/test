package hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
	/*
	 * Servlet 클래스 구현
	 * 1. public class 선언.
	 * 2. javax.servlet.http.HttpServlet을 상속(extends) =>Java EE API다. Core - API가 아니다
	 * 3. 매개변수가 없는 생성자(no-argument 생성자) => 생성자는 default 생성자로 만든다.
	 * 4. doGet() / 		doPost() 메소드를 오버라이딩, => 서블릿이 서비스할 내용을 구현한다.
	 *    GET방식 요청처리	POST방식 요청처리
	 * ------------
	 * 5. 구현한 Servlet class를 톰켓에 등록
	 * 	- web.xml , Annotation을 이용해 등록(서블릿 3.0부터 - 톰켓7) 
	 */
public class HelloServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
					throws IOException, ServletException{
		Date date = new Date(); 		//실행시점의 일시
		String current =String.format("%tY-%<tm-%<td %<tH:%<tM:%<tS", date);
		/*가변인자의 적용 - jdk1.5부터 적용됨(동적사용)
		
		SimpleDateFormat : java.util.Date --> String으로 변환해준다.(String(format())
							 String --> java.util.Date로도 바꿔준다.(parse())
		yyyy:년도 (4자리) MM:월(2자리), dd:일(2자리) HH:시간(24시간-2자리), mm:분(2), ss:초(2)*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String current2 = sdf.format(date);
//		Date dd = sdf.parse("2015-11-20 21:21:05");
		
		response.setContentType("text/html;charset=UTF-8"); //공백주지말것
		PrintWriter out = response.getWriter();
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head><title>현재시간</title></head>");
		out.println("<body>");
		out.printf("현재 시간1 : %s<br>", current);
		out.printf("현재 시간2 : %s<br>", current2);
		out.println("</body></html>");
		
	}
	public static void main(String[] args) {
		Date date = new Date(); 		//실행시점의 일시
		String current =String.format("%tY-%<tm-%<td %<tH:%<tM:%<tS", date);
		System.out.println("현재 시간 1 : " + current);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String current2 = sdf.format(date);
		System.out.println("현재 시간 2 : " + current2);
	}

}
