package jp.co.sample.javamarathonmiddle.form;

import javax.validation.constraints.Pattern;

/**
 * ホテル検索フォーム.
 * 
 * @author igamasayuki
 */
public class HotelForm {
	/** 値段 */
	@Pattern(message = "数字を入力してください", regexp = "[0-9]+")
	private String price;

	public int getIntPrice() {
		return Integer.parseInt(price);
	}
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}
