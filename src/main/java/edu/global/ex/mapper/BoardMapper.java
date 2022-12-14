package edu.global.ex.mapper;

import edu.global.ex.vo.BoardVO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface BoardMapper {

    public List<BoardVO> getList();
    public BoardVO read(int bid);   // 파라미터는 URL 로 넘어오는 BID 값을 의미
    void insert(BoardVO boardVO);   // 글 작성
    void content(int bid);
    void delete(int bid);
    int delete(BoardVO boardVO);
}
