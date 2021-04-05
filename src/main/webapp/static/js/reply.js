/* 게시판 댓글 처리를 위한 객체 선언 */

let replyService = (
  function () {
    /* AJAX
    - contentType : 보내는 데이터 형식
    - dataType : 받는 데이터 형식
    */
    function list(info, callback){
      $.ajax({
        url: '/board/reply/list',
        type: 'POST',
        data: JSON.stringify(info),
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function (list){
          if(callback) {
            callback(list);
            console.log(JSON.stringify(list));
          }
        },
        error: function (error){
          alert(error);
        }
      });
    }

    //댓글 쓰기
    function add(reply, callback) {
      $.ajax({
        url: '/board/reply/write',
        type: 'POST',
        data: JSON.stringify(reply),
        contentType: "application/json; charset=utf-8",
        success: function () {
          alert("댓글 쓰기 완료!");
          if (callback) callback();
        },
        error: function (xhr, status, er) {
        }
      });
    }

    return {
      list: list,
      add: add
    }
  }
)();

