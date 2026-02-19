class Solution {
    public String solution(String new_id) {

        // 1단계 대문자 -> 소문자
        String new_id_lower = new_id.toLowerCase();
        
        // 2단계 영문소문자, 숫자, - , _ , . 를 제외한 모든 문자 제거
        String new_id_2 = "";
        for (char ch : new_id_lower.toCharArray()) {
            if ((ch >= 97 && ch <= 122) || Character.isDigit(ch) || ch == '-' || ch == '_' || ch == '.') {
                new_id_2 += ch;
            }    
        }
        
        // 3단계 .. 2번 이상 연속된 부분 -> .으로 치환
        while (new_id_2.contains("..")) {
            new_id_2 = new_id_2.replace("..", ".");
        }
        
        // 4단계 맨 앞이나 맨 뒤에 . 이 있으면 제거
        if (new_id_2.charAt(0) == '.') {
            new_id_2 = new_id_2.substring(1);
        }
        
        if (new_id_2.length() > 0 && new_id_2.charAt(new_id_2.length() - 1) == '.') {
            new_id_2 = new_id_2.substring(0, new_id_2.length() - 1);
        }
        
        // 5단계 빈 문자열이면 "a" 대입
        if (new_id_2.isEmpty()) {
            new_id_2 += "a";
        }
        
        // 6단계
        if (new_id_2.length() >= 16) {
             new_id_2 = new_id_2.substring(0, 15);
        }
        
        if (new_id_2.endsWith(".")) {
            new_id_2 = new_id_2.substring(0, new_id_2.length()-1);
        }
        
        // 7단계
        if (new_id_2.length() <= 2) {
            char last = new_id_2.charAt(new_id_2.length()-1);
            
            while (new_id_2.length() != 3) {
                new_id_2 += last;
            }
        }
        
        
            
        System.out.println(new_id_2);
        
        return new_id_2;
    }
}