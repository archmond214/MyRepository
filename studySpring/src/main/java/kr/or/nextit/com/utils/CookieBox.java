package kr.or.nextit.com.utils;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieBox {

	// request 객체에서 쿠키를 가지고 와서cookieMap 변수에 담아줄꺼임!
	private Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
	// 인코딩 / 디코딩 시 utf - 8 타입으로 해석함
	private static String charType = "UTF-8";

	/**
	 * 초기화 쿠키 request 객체에서 가지고와서 쿠키맵 변수에 넣어줌
	 * 
	 * @author pc13
	 *
	 */

	public CookieBox(HttpServletRequest request) {
		Cookie cookies[] = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				// 생성된 쿠키명과 쿠키(Object) 값을 cookieMap(Map) 객체에 주입
				cookieMap.put(cookie.getName(), cookie);
			}
		}
	}

	public CookieBox(Cookie cookies[]) {
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				cookieMap.put(cookie.getName(), cookie);
			}
		}
	}

	/**
	 * 쿠키 맵 cookieMap(Map) 객체에서 꺼내오기위해(get)쿠키하기위해..
	 * 
	 * @author pc13
	 *
	 */
	public Cookie getCookie(String name) {
		return cookieMap.get(name);
	}

	/**
	 * 쿠키에 들어있는 값을 URLDecoder.decode() 메소드로 값을 반환.
	 * 
	 * @author pc13
	 *
	 */
	public String getValue(String name) throws IOException {
		Cookie cookie = cookieMap.get(name);
		if (cookie == null) {
			return null;
		}
		return URLDecoder.decode(cookie.getValue(), charType); // System win euc-kr
//		return cookie == null ? null:URLDecoder.decode(cookie.getValue(),charType); 
	}
	
	/*등록된 쿠키명이 있는지 없는지 확인 true false */
	public boolean exists(String name) {
		return cookieMap.containsKey(name);
	}
	//쿠키 생성시 기본 설정 생성될 쿠키명과 값
	public static Cookie createCookie(String name,String value) throws IOException {
		Cookie cookie = new Cookie(name,URLEncoder.encode(value,charType));
		cookie.setPath("/");
		return cookie;
	}
	//경로추가
	public static Cookie createCookie(String name,String value,String path) throws IOException {
		Cookie cookie = new Cookie(name,URLEncoder.encode(value,charType));
		cookie.setPath(path);
		return cookie;
	}
	
	//쿠키가 지속될 시간 추가
	public static Cookie createCookie(String name,String value,String path, int maxAge) throws IOException {
		Cookie cookie = new Cookie(name,URLEncoder.encode(value,charType));
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		return cookie;
	}
	
	public static Cookie createCookie(String name,String value,String path, int maxAge ,String domain) throws IOException {
		Cookie cookie = new Cookie(name,URLEncoder.encode(value,charType));
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		cookie.setDomain(domain);
		return cookie;
	}
	
	
	
}
