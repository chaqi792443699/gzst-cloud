package cn.gov.gzst.common.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class IpUtils {
	private IpUtils() {
	}

	public static String getIpAddr(HttpServletRequest request) {
		if (request == null) {
			return "unknown";
		}
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Forwarded-For");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Real-IP");
		}

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}


	/**
	 * 根据ip地址解析地理位置
	 */
	public static String getAddress(String content, String encoding) {
		String urlStr = "http://ip.taobao.com/service/getIpInfo.php";
		String returnStr = getReturn(urlStr, content, encoding);
		if (returnStr != null) {
			System.out.println("(1) unicode转换成中文前的returnStr : " + returnStr);
			returnStr = decodeUnicode(returnStr);
			System.out.println("(2) unicode转换成中文后的returnStr : " + returnStr);
			String[] temp = returnStr.split(",");
			if (temp.length < 3) {
				return "0";
			}
			return returnStr;
		}
		return null;
	}

	private static String getReturn(String urlStr, String content, String encoding) {
		URL url = null;
		HttpURLConnection connection =null;
		try{
			url  = new URL(urlStr);
			connection =(HttpURLConnection) url.openConnection(); //新建链接实例
			connection.setConnectTimeout(2000);
			connection.setReadTimeout(2000);
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.connect(); //打开端口
			DataOutputStream out = new DataOutputStream(connection.getOutputStream());// 打开输出流往对端服务器写数据
			out.writeBytes(content);
			out.flush();
			out.close();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),encoding));// 往对端写完数据对端服务器返回数据  
			StringBuffer buffer = new StringBuffer();
			String line = "";
			while ((line = reader.readLine())!=null){
				buffer.append(line);
			}
			reader.close();
			return buffer.toString();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			if(connection!=null){
				connection.disconnect(); //关闭连接
			}
		}
		return null;
	}

	public static String decodeUnicode(String theString) {
		char aChar;
		int len = theString.length();
		StringBuffer outBuffer = new StringBuffer(len);
		for (int x = 0; x < len; ) {
			aChar = theString.charAt(x++);
			if (aChar == '\\') {
				aChar = theString.charAt(x++);
				if (aChar == 'u') {
					int value = 0;
					for (int i = 0; i < 4; i++) {
						aChar = theString.charAt(x++);
						switch (aChar) {
							case '0':
							case '1':
							case '2':
							case '3':
							case '4':
							case '5':
							case '6':
							case '7':
							case '8':
							case '9':
								value = (value << 4) + aChar - '0';
								break;
							case 'a':
							case 'b':
							case 'c':
							case 'd':
							case 'e':
							case 'f':
								value = (value<<4)+10+aChar-'a';
								break;
							case 'A':
							case 'B':
							case 'C':
							case 'D':
							case 'E':
							case 'F':
								value = (value<<4)+10+aChar-'A';
								break;
							default:
								throw  new IllegalArgumentException("Malformed encoding");
						}
					}
					outBuffer.append((char) value);
				}else {
					if(aChar=='t'){
						aChar = '\t';
					} else if(aChar == 'r'){
						aChar = '\r';
					}else if(aChar == 'n'){
						aChar = '\n';
					}else if(aChar == 'f'){
						aChar = '\f';
					}
					outBuffer.append(aChar);
				}
			}else {
				outBuffer.append(aChar);
			}
		}
		return outBuffer.toString();
	}

}
