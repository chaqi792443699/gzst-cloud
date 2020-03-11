package cn.gov.gzst.common.utils.draw;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class DrawImageUtil {
	/**
	 * 导入本地图片到缓冲区
	 */
	public BufferedImage loadImageLocal(String pathname) {
		try {
			return ImageIO.read(new File(pathname));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 导入网络图片到缓冲区
	 */
	public BufferedImage loadImageUrl(String imgName) {
		try {
			URL url = new URL(imgName);
			return ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 修改图片,返回修改后的图片缓冲区（只输出一行文本）
	 */
	public void writeContentToImage(BufferedImage img,
			List<DrawContent> drawContents) {
		for (DrawContent drawContent : drawContents) {
			writeContentToImage(img, drawContent);
		}
	}

	/**
	 * 修改图片,返回修改后的图片缓冲区（只输出一行文本）
	 */
	public void writeContentToImage(BufferedImage img, DrawContent drawContent) {
		try {
			int w = img.getWidth();
			int h = img.getHeight();
			Graphics2D g = img.createGraphics();
			g.setBackground(Color.WHITE);
			g.setColor(drawContent.getTextColor());
			Font font = drawContent.getFont();// 添加字体的属性设置
			String content = drawContent.getContent();

			int x = drawContent.getX();
			int y = drawContent.getY();
			int drawX = 0;
			int drawY = 0;
			if (font != null)
				g.setFont(font);
			// 验证输出位置的纵坐标和横坐标
			// 验证输出位置的纵坐标和横坐标
			if (x >= h || y >= w) {
				drawX = h - font.getSize() + 2;
				drawY = w;
			} else {
				drawX = x;
				drawY = y;
			}
			if (content != null) {
				g.drawString(content.toString(), drawX, drawY);
			}
			g.dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 修改图片,返回修改后的图片缓冲区（只输出一行文本）
	 */
	public void writeImageToImage(BufferedImage img, DrawImage drawImage) {
		try {
			BufferedImage toImage = loadImageLocal(drawImage.getImg());
			int w = toImage.getWidth();
			int h = toImage.getHeight();
			Graphics2D g = img.createGraphics();
			g.drawImage(toImage, drawImage.getX(), drawImage.getY(), w, h, null);
			g.dispose();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * 生成新图片到本地
	 */
	public void writeImageLocal(String newImage, BufferedImage img) {
		if (newImage != null && img != null) {
			try {
				File outputfile = new File(newImage);
				ImageIO.write(img, "jpg", outputfile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
