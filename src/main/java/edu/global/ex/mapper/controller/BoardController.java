package edu.global.ex.mapper.controller;


import edu.global.ex.service.BoardService;
import edu.global.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public String list(Model model) {

        log.info("list() ..");
        model.addAttribute("boards", boardService.getList());

        return "list";
    }

    @GetMapping("/write_view")
    public String write_view() {

        log.info("write_view() ..");

        return "write_view";
    }

    @PostMapping("/write")
    public String write(BoardVO boardVO) {

        log.info("write() ..");

        boardService.register(boardVO);

        return "redirect:list";
    }

    /* @GetMapping("/content_view")
    public String content_view(Model model, int bid) {

        log.info("content_view() ..");

        BoardVO boardVO = boardService.content_view(bid);
        model.addAttribute("content_view", boardVO);

        return "content_view";
    } */

    @GetMapping("/content_view")
    public String content_view(BoardVO boardVO, Model model) {  // 3가지 방법이 있다. 꼭 기억하자.

        log.info("content_view() ..");

        int bid = boardVO.getBid();
        model.addAttribute("content_view", boardService.read(bid));

        return "content_view";
    }

    /* @GetMapping("/delete")
    public String delete(BoardVO boardVO) {

        log.info("delete() ..");

        int bid = boardVO.getBid();
        boardService.delete(bid);

        return "redirect:list";
    } */

    // http://localhost:8282/delete?bid=28
    @GetMapping("/delete")
    public String delete(BoardVO boardVO) {

        log.info("remove() ..");

        boardService.remove(boardVO);

        return "redirect:list";
    }

}
