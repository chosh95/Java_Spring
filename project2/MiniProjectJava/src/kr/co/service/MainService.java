package kr.co.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.beans.ContentBean;
import kr.co.dao.BoardDao;

@Service
public class MainService {
	
	@Autowired
	private BoardDao boardDao;
	
	public List<ContentBean> getMainList(int board_info_idx){
		RowBounds rowBounds = new RowBounds(0,5);
		return boardDao.getContentList(board_info_idx, rowBounds);
	}
}
