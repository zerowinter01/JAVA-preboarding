package team_08_김서현_박민경_이지은;

import java.util.List;

public class OutputHelper {

    public static void printAllList(List<exerciseList> lists) {
        System.out.println("----------------------------------------------------------");
        for (exerciseList el : lists) {
            System.out.println(el.toString());
        }
        System.out.println("----------------------------------------------------------");
    }

    public static void printDetailList(exerciseList el) {
        System.out.println("1. 번호  " + el.getNo());
        System.out.println("2. 제목  " + el.getTitle());
        System.out.println("3. 부위  " + el.getPart());
        System.out.println("4. URL  " + el.getUrl());
    }

    public static void printThemeList(List<exerciseList> lists, String part) {
        for (exerciseList el : lists) {
            if (el.getPart().equals(part)) {
                System.out.println(el.toString());
            }
        }
    }

}

