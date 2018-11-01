package jp.co.sample.javamarathonmiddle.form;

import javax.validation.constraints.NotEmpty;

/**
 * 商品検索フォーム.
 * 
 * @author igamasayuki
 */
public class ShopForm {
	/** 性別 */
	@NotEmpty(message = "性別を入力してください")
	private String gender;
	/** 色 */
	private String color;

	/**
	 * 性別をint型で返す.
	 * 
	 * @return 性別を表すint型の変数
	 */
	public int getIntGender() {
		return Integer.parseInt(gender);
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
