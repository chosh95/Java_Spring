package kr.co.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.beans.ContentBean;

@Repository
public class BoardDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void addContentInfo(ContentBean writeContentBean) {
		sqlSessionTemplate.insert("board.addContentInfo",writeContentBean);
	}

}
