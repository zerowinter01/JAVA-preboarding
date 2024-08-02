package team_08_김서현_박민경_이지은;

public class Message {
	private final String main_message = """
			----------------------------------------------------------
			자바로 구현하는 SSAFIT
			----------------------------------------------------------
			     1.영상 정보    |    2. 사용자 정보 관련     |    2. 종료하기
			----------------------------------------------------------
			선택>""";
	
	private final String select_message = """
			----------------------------------------------------------
			                        [영상 목록]
			    1. 전체 목록  |    2. 테마 우선 선택    |     3. 처음으로 돌아가기
			----------------------------------------------------------
			선택>""";
	
//	private final String returnsel_message = """
//			----------------------------------------------------------
//			                        [영상 목록]
//			             1. 음악 선택하기   |     2. 처음으로 돌아가기
//			----------------------------------------------------------
//			선택>""";

	private final String review_message = """
			----------------------------------------------------------
			             1. 리뷰 등록하기 
			             2. 이전으로 돌아가기
			----------------------------------------------------------
			선택>""";

	private final String detail_message = """
			----------------------------------------------------------
			             1. 영상 상세
			             2. 이전으로 돌아가기
			----------------------------------------------------------
			선택>""";
	
	
	private final String genre_message = """
			----------------------------------------------------------
			            1. 전신          |        3. 상체
			            2. 하체          |        4. 복부
			            5. 이전으로 돌아가기
			----------------------------------------------------------
			선택>""";
	
	
	private final String user_message = """
			----------------------------------------------------------
			       1. 회원 가입           |     3. 아이디 찾기 
			       2. 로그인 
			----------------------------------------------------------
			선택>""";
	
	public String getMain_message() {
		return main_message;
	}

	public String getSelect_message() {
		return select_message;
	}

//	public String getReturnsel_message() {
//		return returnsel_message;
//	}

	public String getReview_message() {
		return review_message;
	}
	
	public String getDetail_message() {
		return detail_message;
	}
	
	public String getGenre_message() {
		return genre_message;
	}
	
	public String getUser_message() {
		return user_message;
	}
	
}