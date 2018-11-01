package jp.co.sample.javamarathonmiddle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.sample.javamarathonmiddle.domain.Hotel;
import jp.co.sample.javamarathonmiddle.repository.HotelRepository;

/**
 * ホテル関連のサービス.
 * 
 * @author igamasayuki
 */
@Service
public class HotelService {
	@Autowired
	private HotelRepository repository;
	
	/**
	 * 引数の値段以下のホテルを検索する.
	 * 
	 * @param price　値段
	 * @return List<Hotel> 検索されたホテルのリスト
	 */
	public List<Hotel> findByPriceOrLess(int price){
		return repository.findByPriceOrLess(price);
	}
}
