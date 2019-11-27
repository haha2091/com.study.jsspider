package com.study.jsspider;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Hello world!
 *
 */
public class App {

	// 新版捷顺官网
	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder();
		System.out.println("--------------------------捷顺spider开工啦！" + "----------------------------");
		builder.append("--------------------------捷顺spider开工啦！----------------------------");
		builder.append("\r\n");
		SpiderUtilsNew utils = new SpiderUtilsNew();
		int sum = 0;
		try {
			for (int i = 1; i < 22; i++) {
				utils.getDownloadURL("https://www.jieshun.cn/xzzx/?page=" + i, builder);
				System.out.println();
				System.out.println("第" + i + "页爬取完成！");
				builder.append("第" + i + "页爬取完成！");
				builder.append("\r\n\r\n\r\n");
				System.out.println();
				System.out.println();
				sum++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("--------------------------搞定收工！！" + "----------------------------");
		builder.append("--------------------------搞定收工！！----------------------------");
		String filename = "捷顺官网软件、文件下载地址" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".txt";
		writeToFile(System.getProperty("user.dir") + "\\", filename, builder.toString());
		System.out.println("文件保存到：" + System.getProperty("user.dir") + "\\" + filename);
	}

	/**
	 * 将内容写入到文件
	 * 
	 * @param path
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	private static boolean writeToFile(String path, String fileName, String content) {
		boolean flag = false;
		File file = new File(path + fileName);
		FileWriter writer = null;
		try {
			writer = new FileWriter(file);
			writer.write(content);
			flag = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false;
		} finally {
			try {
				writer.flush();
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flag = false;
			}
		}
		return flag;
	}
}
