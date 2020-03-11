package cn.gov.gzst.common.utils.http;

import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.Map;


/**
 * 这个Https协议工具类，采用HttpsURLConnection实现。
 * 提供get和post两种请求静态方法
 * 
 * @author marker
 * @date 2014年8月30日
 * @version 1.0
 */
public class HttpUtil {
	
	private static TrustManager myX509TrustManager = new X509TrustManager() {

		public void checkClientTrusted(X509Certificate[] arg0, String arg1)
				throws CertificateException { 

		}

		public void checkServerTrusted(X509Certificate[] arg0, String arg1)
				throws CertificateException { 

		}

		public X509Certificate[] getAcceptedIssuers() { 
			return null;
		}

	};

	
	
	
	
	
	
	
	
	public static String sendHttpsPOST(String url, String data) {
		String result = null;

		try {
			// 设置SSLContext
			SSLContext sslcontext = SSLContext.getInstance("TLS");
			sslcontext.init(null, new TrustManager[] { myX509TrustManager },
					null);

			// 打开连接
			// 要发送的POST请求url?Key=Value&amp;Key2=Value2&amp;Key3=Value3的形式
			URL requestUrl = new URL(url);
			HttpsURLConnection httpsConn = (HttpsURLConnection) requestUrl
					.openConnection();

			// 设置套接工厂
			httpsConn.setSSLSocketFactory(sslcontext.getSocketFactory());

			// 加入数据
			httpsConn.setRequestMethod("POST");
			httpsConn.setDoOutput(true);
			OutputStream out = httpsConn.getOutputStream() ;
			 
			if (data != null)
				out.write(data.getBytes("UTF-8")); 
			out.flush();
			out.close();

			// 获取输入流
			BufferedReader in = new BufferedReader(new InputStreamReader(
					httpsConn.getInputStream()));
			int code = httpsConn.getResponseCode();
			if (HttpsURLConnection.HTTP_OK == code) {
				String temp = in.readLine();
				/* 连接成一个字符串 */
				while (temp != null) {
					if (result != null)
						result += temp;
					else
						result = temp;
					temp = in.readLine();
				}
			}
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	
	
	public static String sendHttpsGET(String url) {
		String result = null;

		try {
			// 设置SSLContext
			SSLContext sslcontext = SSLContext.getInstance("TLS");
			sslcontext.init(null, new TrustManager[] { myX509TrustManager },
					null);

			// 打开连接
			// 要发送的POST请求url?Key=Value&amp;Key2=Value2&amp;Key3=Value3的形式
			URL requestUrl = new URL(url);
			HttpsURLConnection httpsConn = (HttpsURLConnection) requestUrl
					.openConnection();

			// 设置套接工厂
			httpsConn.setSSLSocketFactory(sslcontext.getSocketFactory());

			// 加入数据
			httpsConn.setRequestMethod("GET");
//			httpsConn.setDoOutput(true);
			  

			// 获取输入流
			BufferedReader in = new BufferedReader(new InputStreamReader(
					httpsConn.getInputStream()));
			int code = httpsConn.getResponseCode();
			if (HttpsURLConnection.HTTP_OK == code) {
				String temp = in.readLine();
				/* 连接成一个字符串 */
				while (temp != null) {
					if (result != null)
						result += temp;
					else
						result = temp;
					temp = in.readLine();
				}
			}
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public static String getBody(HttpServletRequest request, String charsetname) throws IOException {
	    String body = null;
	    StringBuilder stringBuilder = new StringBuilder();   
	    BufferedReader bufferedReader = null;  
	    try {  
	        InputStream inputStream = request.getInputStream();  
	        if (inputStream != null) {  
	            bufferedReader = new BufferedReader(new InputStreamReader(inputStream,charsetname));  
	            char[] charBuffer = new char[128];  
	            int bytesRead = -1;  
	            while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {  
	                stringBuilder.append(charBuffer, 0, bytesRead);  
	            }  
	        } else {  
	            stringBuilder.append("");  
	        }  
	    } catch (IOException ex) { 
	        throw ex;  
	    } finally {  
	        if (bufferedReader != null) {  
	            try {  
	                bufferedReader.close();  
	            } catch (IOException ex) {  
	                throw ex;  
	            }  
	        }  
	    }  
	    body = stringBuilder.toString();  
	    return body;  
	}
	
	public static JSONObject getBodyJSON(HttpServletRequest request, String charsetname)
	{
		String body;
		try {
			body = getBody(request,charsetname);
			//body=new String(body.getBytes("ISO8859-1"),"UTF-8");
			if (!StringUtils.isEmpty(body)) {
				JSONObject json= JSONObject.fromObject(body);
				return json;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static String getHttpResponse(String allConfigUrl) {
		BufferedReader in = null;
		StringBuffer result = null;
		try {
			URI uri = new URI(allConfigUrl);
			URL url = uri.toURL();
			URLConnection connection = url.openConnection();
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("Charset", "utf-8");
			connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36)");
			connection.connect();
			result = new StringBuffer();
			//读取URL的响应
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String line=null;
			while (!((line=in.readLine())==null)) {
				result.append(line);
			}
			return result.toString();

		} catch (Exception e) {
			e.printStackTrace();
		}finally {

		}
		return result.toString();
	}
	public static String getParameterMapString(HttpServletRequest request, String charsetname) throws Exception{
		StringBuffer json = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				json.append(line);
			}
			if(json.length()<1){
				Map<String, String[]> hm=request.getParameterMap();
				if (hm!=null && hm.size()>0){
					json.append(readJson(hm).toString());
				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		String resJson = json.toString();
		return new String(resJson.getBytes("ISO-8859-1"),charsetname);
	}
	public static JSONObject readJson(Map<String, String[]> hm){
		JSONObject jobj = new JSONObject();
        //通过循环遍历的方式获得key和value并set到JSONObject中
		Iterator it = hm.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next().toString();
			String[] values = (String[])hm.get(key);
			jobj.put(key, values[0]);
		}
		return jobj;
	}
	public static JSONObject getRequestJson(HttpServletRequest request, String charsetname) throws  Exception {

		JSONObject object = new JSONObject();
		try { //redis 处理
			String body = HttpUtil.getParameterMapString(request,"UTF-8");
			object = JSONObject.fromObject(body);
		}catch (Exception e){
			//普通 处理
			String body = getBody(request, "utf-8");
			String[] bodyList = body.split("&");
			for (String string : bodyList) {
				String[] keyAndValue = string.split("=");
				if (keyAndValue.length == 2) {
					object.put(keyAndValue[0], HttpUtil.getURLDecoderString(keyAndValue[1],"utf-8"));
				}
			}
		}
		return object;
	}

	/**
	 * 下载远程附件到本地
	 * @param remoteFilePath
	 * @param localFilePath
	 */
	public static void downloadRemoteFile(String remoteFilePath, String localFilePath) {
		URL urlfile = null;
		HttpURLConnection httpUrl = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		File f = new File(localFilePath);
		try {
			urlfile = new URL(remoteFilePath);
			httpUrl = (HttpURLConnection)urlfile.openConnection();
			httpUrl.setConnectTimeout(10000);
			httpUrl.setReadTimeout(10000);
			httpUrl.connect();
			bis = new BufferedInputStream(httpUrl.getInputStream());
			bos = new BufferedOutputStream(new FileOutputStream(f));
			int len = 2048;
			byte[] b = new byte[len];
			while ((len = bis.read(b)) != -1) {
				bos.write(b, 0, len);
			}
			bos.flush();
			bis.close();
			httpUrl.disconnect();
			bis.close();
			bos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//url解码
	public static String getURLDecoderString(String str, String ENCODE) {
		String result = "";
		if (null == str) {
			return "";
		}
		try {
			result = java.net.URLDecoder.decode(str, ENCODE);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
}
