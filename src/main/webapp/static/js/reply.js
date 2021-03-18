/* 게시판 댓글 처리를 위한 객체 선언 */

let replyService = (
    function (){
        function add(reply, callback){
            $.ajax({
              url: '/board/reply/write',
              type: 'POST',
              data: JSON.stringify(reply),
              contentType: "application/json; charset=utf-8",
              success: function(result, status, xhr){
                if(callback) callback();
              },
              error: function(xhr,status, er){
                alert(status);
                alert(reply);
              }
            });
        }
        return {add: add};
    }
);