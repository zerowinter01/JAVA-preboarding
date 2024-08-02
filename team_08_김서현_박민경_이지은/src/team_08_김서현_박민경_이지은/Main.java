package team_08_김서현_박민경_이지은;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import com.google.gson.Gson;

public class Main {

    private static UserManager userManager = new UserManager();
    private static User loggedInUser = null;

    public static void main(String[] args) throws IOException {
        Message ms = new Message();
        Scanner sc = new Scanner(System.in);
        Gson gson = new Gson();

        // JSON 파일 읽기 및 객체화
        exerciseList[] arr = readJson("data/video.json", exerciseList[].class, gson);
        Review[] arr2 = readJson("data/review.json", Review[].class, gson);

        exerciseManager em = new exerciseManager();
        ReviewManager rm = new ReviewManager();

        em.addAllList(arr);
        rm.addAllList(arr2);

        boolean select = true;

        while (select) {
            if (loggedInUser == null) {
                // 사용자 로그인 상태 확인
                System.out.println(ms.getMain_message());
                int sel = sc.nextInt();

                if (sel == 1) {
                    handleVideoSelection(em, rm, sc, ms, gson, arr2);
                } else if (sel == 2) {
                    handleUserOptions(sc, ms);
                } else if (sel == 3) {
                    select = false; // 종료
                }
            } else {
                System.out.println("현재 로그인된 사용자: " + loggedInUser.getNickName());
                System.out.print(ms.getMain_message());
                int sel = sc.nextInt();

                if (sel == 1) {
                    handleVideoSelection(em, rm, sc, ms, gson, arr2);
                } else if (sel == 2) {
                    loggedInUser = null; // 로그아웃
                } else if (sel == 3) {
                    select = false; // 종료
                }
            }
        }
        System.out.println("프로그램이 종료되었습니다. 다음에 만나요.");
    }

    private static <T> T readJson(String filePath, Class<T> clazz, Gson gson) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
        StringBuilder sb = new StringBuilder();
        String str;
        while ((str = br.readLine()) != null) {
            sb.append(str);
        }
        br.close();
        return gson.fromJson(sb.toString(), clazz);
    }

    private static void loginUser(Scanner sc) {
        System.out.print("아이디 입력: ");
        String userId = sc.next();
        System.out.print("비밀번호 입력: ");
        String password = sc.next();

        User user = userManager.login(userId, password);
        if (user != null) {
            loggedInUser = user;
            System.out.println("로그인 성공! 닉네임: " + loggedInUser.getNickName());
        } else {
            System.out.println("로그인 실패. 아이디 또는 비밀번호가 틀렸습니다.");
        }
    }

    private static void signUpUser(Scanner sc) {
        System.out.print("아이디 입력: ");
        String userId = sc.next();
        System.out.print("비밀번호 입력: ");
        String password = sc.next();
        sc.nextLine(); // 개행 문자 처리
        System.out.print("닉네임 입력: ");
        String nickName = sc.nextLine();
        System.out.print("이름 입력: ");
        String username = sc.nextLine();
        System.out.print("전화번호 입력: ");
        String phonenumber = sc.nextLine();

        boolean success = userManager.signUp(userId, password, nickName, username, phonenumber);
        if (success) {
            System.out.println("회원가입 성공!");
        } else {
            System.out.println("회원가입 실패. 아이디가 이미 존재합니다.");
        }
    }

    private static void findUserId(Scanner sc) {
        System.out.print("아이디를 입력하세요: ");
        String userId = sc.next();

        String result = userManager.findPassword(userId);
        System.out.println(result);
    }

    private static void handleUserOptions(Scanner sc, Message ms) {
        while (true) {
            System.out.println(ms.getUser_message());
            int option = sc.nextInt();

            if (option == 1) {
                signUpUser(sc);
            } else if (option == 2) {
                loginUser(sc);
            } else if (option == 3) {
                findUserId(sc);
            } else {
                System.out.println("잘못된 선택입니다. 다시 시도해 주세요.");
            }

            // 옵션 처리 후 메인 화면으로 돌아가기
            if (loggedInUser != null || option == 3) {
                break;
            }
        }
    }

    private static void handleVideoSelection(exerciseManager em, ReviewManager rm, Scanner sc, Message ms, Gson gson, Review[] arr2) throws IOException {
        System.out.print(ms.getSelect_message());
        int cnt = sc.nextInt();

        if (cnt == 1) {
            handleAllListSelection(em, rm, sc, ms, gson, arr2);
        } else if (cnt == 2) {
            handleThemeSelection(em, rm, sc, ms, gson, arr2);
        } else if (cnt == 3) {
            // 처음으로 돌아가기
            return;
        }
    }

    private static void handleAllListSelection(exerciseManager em, ReviewManager rm, Scanner sc, Message ms, Gson gson, Review[] arr2) throws IOException {
        boolean temp = true;
        while (temp) {
            OutputHelper.printAllList(em.getAllList());
            System.out.println(ms.getDetail_message());

            int d = sc.nextInt();

            if (d == 1) {
                handleDetailSelection(em, rm, sc, ms, gson, arr2);
            } else if (d == 2) {
                temp = false;
            }
        }
    }

    private static void handleThemeSelection(exerciseManager em, ReviewManager rm, Scanner sc, Message ms, Gson gson, Review[] arr2) throws IOException {
        while (true) {
            System.out.print(ms.getGenre_message());
            int g = sc.nextInt();
            if (g == 5) break;

            String part = getPartBySelection(g);
            OutputHelper.printThemeList(em.findTheme(part), part);

            boolean temp = true;
            while (temp) {
                handleDetailSelection(em, rm, sc, ms, gson, arr2);
                temp = false;
            }
        }
    }

    private static String getPartBySelection(int selectpart) {
        switch (selectpart) {
            case 1: return "전신";
            case 2: return "상체";
            case 3: return "하체";
            case 4: return "복부";
            default: return "";
        }
    }

    private static void handleDetailSelection(exerciseManager em, ReviewManager rm, Scanner sc, Message ms, Gson gson, Review[] arr2) throws IOException {
        System.out.print("영상 번호 입력 >> ");
        int no = sc.nextInt();
        System.out.println("----------------------------------------------------------");
        exerciseList el = em.getDetailList(no);
        if (el != null) {
            OutputHelper.printDetailList(el);
        }
        System.out.println("----------------------------------------------------------");

        Review[] rarr = rm.selectReview(no);
        for (Review review : rarr) {
            System.out.println(review.toString());
        }

        System.out.println(ms.getReview_message());
        int rs = sc.nextInt();
        if (rs == 1) {
            addReview(rm, sc, gson, arr2, no);
        }
    }

    private static void addReview(ReviewManager rm, Scanner sc, Gson gson, Review[] arr2, int no) throws IOException {
        if (loggedInUser == null) {
            System.out.println("로그인 후 리뷰를 작성할 수 있습니다.");
            return;
        }
        
        System.out.println("내용을 입력하세요.");
        sc.nextLine(); // 이전 nextInt() 이후의 개행 문자 처리
        String content = sc.nextLine();

        Review[] newr = rm.addnewList(arr2.length, no, loggedInUser.getNickName(), content);
        writeJson("data/review.json", newr, gson);
        System.out.println("리뷰가 성공적으로 추가되었습니다.");
    }

    private static void writeJson(String filePath, Object data, Gson gson) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)));
        String json = gson.toJson(data);
        bw.write(json);
        bw.close();
    }
}
