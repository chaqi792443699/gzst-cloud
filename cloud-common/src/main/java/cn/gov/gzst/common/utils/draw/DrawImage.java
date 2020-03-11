package cn.gov.gzst.common.utils.draw;

public class DrawImage {
	private String img;// 字体
	private int x;// 坐标 x
	private int y; // 坐标 y

	public DrawImage(String img, int x, int y) {
		this.img = img;
		this.x = x;
		this.y = y;
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}