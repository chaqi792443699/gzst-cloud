package cn.gov.gzst.common.utils.draw;

import java.awt.Color;
import java.awt.Font;

public class DrawContent {
	private Font font; // 内容字体样式
	private Color textColor;// 文字颜色
	private String content;// 字体
	private int x;// 坐标 x
	private int y; // 坐标 y

	public DrawContent(String content, int x, int y) {
		this.content = content;
		this.x = x;
		this.y = y;
		this.font = new Font("simsun", Font.PLAIN, 20);
		this.textColor = Color.BLACK;
	}

	public DrawContent(String content, int x, int y, Font font) {
		this.content = content;
		this.x = x;
		this.y = y;
		this.font = font;
		this.textColor = Color.BLACK;
	}

	public DrawContent(String content, int x, int y, Font font, Color textColor) {
		this.content = content;
		this.x = x;
		this.y = y;
		this.font = font;
		this.textColor = textColor;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public Color getTextColor() {
		return textColor;
	}

	public void setTextColor(Color textColor) {
		this.textColor = textColor;
	}
}