package webprj.board.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webprj.board.service.board.ReplyService;
import webprj.board.vo.ReplyVO;

@RestController
@Log4j2
@RequestMapping("/board/reply")
public class ReplyController {

    @Autowired
    @Qualifier("replyServiceImpl")
    private ReplyService replyService;

    @PostMapping("/write")
    public ResponseEntity<String> write(@RequestBody ReplyVO rvo){
        log.info(rvo);
        replyService.write(rvo);
        log.info(rvo);
        return new ResponseEntity<String>("success.write", HttpStatus.OK);
    }
}
