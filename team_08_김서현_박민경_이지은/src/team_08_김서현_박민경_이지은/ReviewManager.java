package team_08_김서현_박민경_이지은;

import java.util.ArrayList;
import java.util.List;

public class ReviewManager {
    private List<Review> reviewList = new ArrayList<>();
    
      
    
    public Review[] selectReview(int videoNo) {
        List<Review> list = new ArrayList<>();
        
        for (Review r : reviewList) {
            if (r.getVideoNo() == videoNo) {
                list.add(r);
            }
        }
        
        Review[] res = new Review[list.size()];
        return list.toArray(res);
    }

	public void addAllList(Review[] r) {
		for(int i = 0;i<r.length; i++) {
			reviewList.add(r[i]);
		}
		
	}
	
	public Review[] addnewList(int size, int no, String nickname, String content) {
		Review[] n = new Review[size+1];
		for(int i = 0; i<size; i++) {
			n[i] = reviewList.get(i);
		}
		
		n[size] = new Review(no, size + 1, nickname, content);
		reviewList.add(n[size]);
		return n;
	}
	
	
    
    
}