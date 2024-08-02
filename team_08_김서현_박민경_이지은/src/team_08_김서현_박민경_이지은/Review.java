package team_08_김서현_박민경_이지은;

public class Review {
    private int videoNo;
    private int reviewNo;
    private String nickName;
    private String content;
    
    // 생성자
    public Review() {
        
    }

    public Review(int videoNo, int reviewNo, String nickName, String content) {
        super();
        this.videoNo = videoNo;
        this.reviewNo = reviewNo;
        this.nickName = nickName;
        this.content = content;
    }

    // Getter & Setter
    public int getVideoNo() {
        return videoNo;
    }

    public void setVideoNo(int no) {
        this.videoNo = no;
    }

    public int getReviewNo() {
        return reviewNo;
    }

    public void setReviewNo(int reviewNo) {
        this.reviewNo = reviewNo;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // toString
    @Override
    public String toString() {
        return reviewNo + " " +  nickName + "  " + content;
    }
}