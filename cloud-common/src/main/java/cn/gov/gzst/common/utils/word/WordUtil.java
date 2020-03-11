package cn.gov.gzst.common.utils.word;

import cn.gov.gzst.common.utils.PdfUtil;
import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import net.sf.json.JSONObject;
import org.apache.pdfbox.util.PDFMergerUtility;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WordUtil {

	static final int wdDoNotSaveChanges = 0;// 不保存待定的更改。
	static final int wdFormatPDF = 17;// PDF 格式

	@SuppressWarnings({ "deprecation" })
	public static Template getTemplate(String templatePath, String templateName)
			throws ParseException, IOException {

		Configuration configuration = new Configuration();
		configuration.setDefaultEncoding("UTF-8");
		File file = new File(templatePath);
		configuration.setDirectoryForTemplateLoading(file);
		Template template = configuration.getTemplate(templateName);
		template.setEncoding("UTF-8");
		return template;
	}

	@SuppressWarnings("unused")
	public static void write(String templatePath, String templateName, Map<String, Object> dataMap, Writer out)
			throws ParseException, IOException,
            TemplateException {
		Template t = getTemplate(templatePath, templateName);
		t.process(dataMap, out);
		out.flush();
		out.close();
	}

	/**
	 * 用aspose转pdf估计会快点
	 * @param inputFilePath 输入路径
	 * @param outFilePath 输出路径
	 */
	public static void wordToPdf(String inputFilePath, String outFilePath) {
		try {
			File tofile = new File(outFilePath);
			if (tofile.exists()) {
				tofile.delete();
			}
			PdfUtil.transfer(inputFilePath,outFilePath);
		} catch (Exception e) {
			System.out.println("========ERROR：" + e.getMessage() + "！！！");
		}
	}

	/**
	 * 通过word模板生成word到指定的word文件,并且生成pdf到指定pdf文件
	 * 
	 * @param modelFilePath（word模板在项目中的路径）
	 * @param modelName（word模板名称）
	 * @param tmpWordFile（生成的word文件）
	 * @param tmpPDFFile（生成的pdf文件）
	 * @param hashmap（生成word文件所需要的map数据源）
	 * @throws ParseException
	 * @throws IOException
	 * @throws TemplateException
	 */
	public static void createPdf(String modelFilePath, String modelName, String tmpWordFile, String tmpPDFFile,
			Map<String, Object> hashmap)
			throws ParseException, IOException, TemplateException {
		createWord(modelFilePath, modelName, tmpWordFile, hashmap);
		// String modelPath = "rmkkx.xml";
		// 将word转pdf
		WordUtil.wordToPdf(tmpWordFile, tmpPDFFile);
	}

	/**
	 * 通过word模板生成word到指定的word文件
	 * 
	 * @param modelFilePath（word模板在项目中的路径）
	 * @param modelName（word模板名称）
	 * @param tmpWordFile（生成的word文件）
	 * @param hashmap（生成word文件所需要的map数据源）
	 * @throws ParseException
	 * @throws IOException
	 * @throws TemplateException
	 */
	public static void createWord(String modelFilePath, String modelName, String tmpWordFile,
			Map<String, Object> hashmap)
			throws ParseException, IOException, TemplateException {
		File filepath = new File(tmpWordFile);
		// 将模板和数据模型合并生成文件
		FileOutputStream stream = new FileOutputStream(filepath);
		Writer out = new BufferedWriter(new OutputStreamWriter(stream, "UTF-8"));
		// 生成word文件
		// WordUtil.write("/pdfmodel", modelName, hashmap, out);
		WordUtil.write(modelFilePath, modelName, hashmap, out);
	}

	/**
	 * 将JSONObject转Map
	 * 
	 * @param obj（提供数据的JSONObject对象）
	 * @param keys（Map需要添加的key）
	 * @param hashmap（需要添加key的Map对象）
	 * @return
	 */
	public static Map<String, Object> jsonToMap(JSONObject obj, String[] keys, Map<String, Object> hashmap) {
		// 如果obj对象为null，把需要添加的key的值都设置为空字符串
		if (obj == null) {
			for (int i = 0; i < keys.length; i++) {
				Object value = "";
				String key = keys[i];
				hashmap.put(key, value);
			}
		} else {
			for (int i = 0; i < keys.length; i++) {
				Object value = "";
				String key = keys[i];
				// 如果obj对象中没有该key，则添加的该key，并把值设置为空字符串
				if (obj.containsKey(key)) {
					Object value1 = obj.get(key);
					value = value1;
				}
				hashmap.put(key, value);
			}
		}
		return hashmap;
	}

	/**
	 * 将JSONObject转Map
	 * 
	 * @param obj（提供数据的JSONObject对象）
	 * @param keys（Map需要添加的key）
	 * @param hashmap（需要添加key的Map对象）
	 *            指定 String String
	 * @return
	 */
	public static Map<String, String> jsonToMap(JSONObject obj, String[] keys, Map<String, String> hashmap,
                                                boolean isString) {
		// 如果obj对象为null，把需要添加的key的值都设置为空字符串
		if (obj == null) {
			for (int i = 0; i < keys.length; i++) {
				String value = "";
				String key = keys[i];
				hashmap.put(key, value);
			}
		} else {
			for (int i = 0; i < keys.length; i++) {
				String value = "";
				String key = keys[i];
				// 如果obj对象中没有该key，则添加的该key，并把值设置为空字符串
				if (obj.containsKey(key)) {
					String value1 = obj.get(key) + "";
					value = value1;
				}
				hashmap.put(key, value);
			}
		}
		return hashmap;
	}

	/**
	 * 合并PDF
	 * 
	 * @throws Exception
	 */
	public static void mergePdf(List<String> fileList, String savepaths) throws Exception {
		PDFMergerUtility mergePdf = new PDFMergerUtility();
		for (int i = 0; i < fileList.size(); i++) {
			mergePdf.addSource(fileList.get(i));
		}
		mergePdf.setDestinationFileName(savepaths);
		mergePdf.mergeDocuments();
	}

	/**
	 * 合并PDF
	 * 
	 * @throws Exception
	 */
	public static void mergeWordToPdf(List<String> fileList, String savepaths) throws Exception {
		List<String> pdfFileList = new ArrayList<String>();
		for (int i = 0; i < fileList.size(); i++) {
			String wordPath = fileList.get(i);
			String pdfPath = wordPath.substring(0, wordPath.length() - 4) + ".pdf";
			WordUtil.wordToPdf(wordPath, pdfPath);
			pdfFileList.add(pdfPath);
		}
		mergePdf(pdfFileList, savepaths);
	}
}
