package cn.gov.gzst.common.utils;

import java.io.IOException;
import java.util.Scanner;

/**
 * http://blog.csdn.net/oscar999/article/details/14291757
 * @title:  TaskUtils.java   
 * @package cn.gov.gzst.utils   
 * @description: 进程操作
 * @author: jianliaoliang
 * @date:   2017年3月14日 下午3:10:16   
 * @version V1.0 
 *
 */
public class TaskUtils {

	/**
	 * 显示当前机器的所有进程
	 */
	public static void showTaskList() {
		try {
			Process process = Runtime.getRuntime().exec("taskList");
			Scanner in = new Scanner(process.getInputStream());
			int count = 0;
			while (in.hasNextLine()) {
				count++;
				System.out.println(count + ":" + in.nextLine());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 启动一个进程
	 * @param task
	 */
	public static void startTask(String task) {
		try {
			Runtime.getRuntime().exec(task);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 杀死一个进程
	 * @param taskname
	 */
	public static void killTask(String taskname){
		try {
			Runtime.getRuntime().exec("taskkill /F /IM "+taskname);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		killTask("WINWORD.EXE");
	}

}
