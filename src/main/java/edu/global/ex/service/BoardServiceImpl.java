package edu.global.ex.service;

import java.util.List;

import edu.global.ex.mapper.BoardMapper;
import edu.global.ex.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;

    // 글 전체 목록
    @Override
    public List<BoardVO> getList() {

        log.info("getList() ..");     // log 시/분/초 로 표현해준다. Spring 내장

        return boardMapper.getList();
    }

    @Override
    public void register(BoardVO boardVO) {

        log.info("register() ..");
        boardMapper.insert(boardVO);
    }

    @Override
    public BoardVO read(int bid) {

        log.info("read() ..");

        return boardMapper.read(bid);
    }

    @Override
    public void delete(int bid) {

        log.info("delete() ..");

        boardMapper.delete(bid);
    }

    @Override
    public int remove(BoardVO board) {

        log.info("remove() ..");
        return boardMapper.delete(board);
    }


}
