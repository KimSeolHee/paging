package com.iu.start.board.qna;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.impl.BoardService;
import com.iu.start.util.Pager;

@Service
public class QnaService implements BoardService {
	
	@Autowired
	private QnaDAO qnaDAO;

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		Long totalCount = qnaDAO.getCount(pager);
		pager.getNum(totalCount);
		pager.getRow();
		return qnaDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		return qnaDAO.getDetail(boardDTO);
	}

	public int setReply(QnaDTO qnaDTO) throws Exception {
		QnaDTO parent =(QnaDTO) qnaDAO.getDetail(qnaDTO);
		 Long ref =parent.getRef();
		 Long step = parent.getStep();
		 Long depth = parent.getDepth();
		 
		 qnaDTO.setRef(ref);
		 qnaDTO.setStep(step+1);
		 qnaDTO.setDepth(depth+1);
		 qnaDAO.setReply(qnaDTO);
		 
		 qnaDAO.setStep(parent);
		 
		
		return qnaDAO.setReply(qnaDTO);
	}
	
	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setAdd(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setDelete(boardDTO);
	}

}