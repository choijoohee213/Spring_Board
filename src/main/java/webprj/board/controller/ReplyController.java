package webprj.board.controller;

import lombok.extern.log4j.Log4j2;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import webprj.board.ReplyObject;
import webprj.board.service.board.ReplyService;
import webprj.board.vo.ReplyVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Log4j2
@RequestMapping("/board/reply")
public class ReplyController {

    @Autowired
    @Qualifier("replyServiceImpl")
    private ReplyService replyService;

    @PostMapping("/write")
    public ResponseEntity<String> write(@RequestBody ReplyVO rvo){
        replyService.write(rvo);
        log.info(rvo);
        return new ResponseEntity<String>("success.write", HttpStatus.OK);
    }

    @PostMapping(
          value="/list",
          produces="application/json; charset=utf-8"
          )
    public ResponseEntity<List<ReplyVO>> list(@RequestBody ReplyObject replyObject){
        List<ReplyVO> list = replyService.list(replyObject);
        System.out.println(replyObject);

        return (list != null && list.size() > 0)
              ? new ResponseEntity<>(list, HttpStatus.OK)
              : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
