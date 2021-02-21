package webprj.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageObject {
  //현재 페이지를 DB에서 가져올 때 필요한 정보
  private int page; //현재 페이지
  private int perPageNum; //페이지 당 보여지는 글의 갯수
  private int startRow, endRow; //현재 페이지의 시작 줄번호, 끝번호

  //JSP 화면에 페이지 표시를 할 때 필요한 정보
  private int perGroupPageNum; //기본값 10을 생성자에서 셋팅
  private int startPage;
  private int endPage;
  private int totalPage;
  private int totalRow; //DB에서 구한다.

  //검색에 필요한 변수 선언
  private String key;
  private String word;

  //공지 분류(기간)를 적용시키는 변수 - period
  //pre:현재공지, old:지난공지, res:예약공지, all:전체공지
  private String period;

  //메시지 처리를 위한 변수
  //받는 사람의 id
  private String accepter;

  public PageObject() {
    //처음 리스트로 들어올 때는 데이터가 안넘어오므로 초기값을 1페이지로.
    //한 페이지당 10개의 글이 보이도록 셋팅.
    this.page = 1;
    this.perPageNum = 10;

    //JSP 화면에 몇 개의 페이지를 표시할 지 정한다.
    perGroupPageNum = 10;

    //기본적으로 찾는 공지 분류 - 현재 공지:pre
    this.period = "pre";
  }

  public PageObject(int page, int perPageNum){
    this.page = page;
    this.perPageNum = perPageNum;

    //시작 줄번호와 끝 줄번호 계산
    //현재 페이지와 이전 페이지까지 데이터를 skip시키고 그 다음 번호 시작 번호로 한다.
    startRow = (page-1) * perPageNum + 1;
    endRow = startRow + perPageNum - 1;

    //JSP 화면에 몇 개의 페이지를 표시할 지 정한다.
    perGroupPageNum = 10;
  }



  public void setTotalRow(int totalRow) {
    this.totalRow = totalRow;

    //시작 줄번호와 끝 줄번호 계산
    //현재 페이지와 이전 페이지까지 데이터를 skip시키고 그 다음 번호 시작 번호로 한다.
    startRow = (page - 1) * perPageNum + 1;
    endRow = startRow + perPageNum - 1;

    //전체 페이지 계산
    totalPage = (totalRow-1)/perGroupPageNum + 1;
    startPage = (page/(perGroupPageNum+1)) * perGroupPageNum + 1;
    endPage = Math.min(totalPage, startPage + perGroupPageNum - 1);
  }

}
