package team_08_김서현_박민경_이지은;

import java.util.ArrayList;
import java.util.List;

public class exerciseManager {
    private List<exerciseList> lists = new ArrayList<>();

    public void addAllList(exerciseList[] ex) {
        for (exerciseList el : ex) {
            lists.add(el);
        }
    }

    public List<exerciseList> getAllList() {
        return lists;
    }

    public exerciseList getDetailList(int no) {
        for (exerciseList el : lists) {
            if (el.getNo() == no) {
                return el;
            }
        }
        return null;
    }

    public List<exerciseList> findTheme(String part) {
        List<exerciseList> themeList = new ArrayList<>();
        for (exerciseList el : lists) {
            if (el.getPart().equals(part)) {
                themeList.add(el);
            }
        }
        return themeList;
    }
}
