import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        m = replaceStr(m);
        List<String[]> realInfo = new ArrayList<>();
        List<String[]> realM = new ArrayList<>();
        List<String[]> result = new ArrayList<>();
        
        for (int i = 0; i < musicinfos.length; i++) {
            String[] info = musicinfos[i].split(",");
            int realTime = calculateTime(info[0], info[1]);
            realInfo.add(new String[]{String.valueOf(i), String.valueOf(realTime), info[2]});
            realM.add(calculateRealM(realTime, replaceStr(info[3])));
        }
        
        for (int i = 0; i < realInfo.size(); i++) {
            String realMStr = String.join("", realM.get(i));
            if (realMStr.contains(m)) {
                result.add(new String[]{realInfo.get(i)[0], realInfo.get(i)[1], realInfo.get(i)[2]});
            }
        }
        
        if (result.size() == 0) {
            return "(None)";
        }
        
        Collections.sort(result, (o1, o2) -> {
            if (Integer.valueOf(o1[1]) > Integer.valueOf(o2[1])) {
                return -1;
            } else if (Integer.valueOf(o1[1]) < Integer.valueOf(o2[1])) {
                return 1;
            } else {
                return Integer.valueOf(o1[0]).compareTo(Integer.valueOf(o2[0]));
            }
        });

        return result.get(0)[2];
    }
    
    public int calculateTime(String start, String end) {
        String[] startArr = start.split(":");
        String[] endArr = end.split(":");
        int startTotalTime = Integer.valueOf(startArr[0]) * 60 + Integer.valueOf(startArr[1]);
        int endTotalTime = Integer.valueOf(endArr[0]) * 60 + Integer.valueOf(endArr[1]);
        return endTotalTime - startTotalTime;
    }
    
    public String[] calculateRealM(int time, String M) {
        String[] arr = M.split("");
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("#")) {
                arr[i-1] = arr[i-1] + arr[i];
            }
        }
        
        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("#")) {
                continue;
            } else {
                list.add(arr[i]);
            }
        }
        List<String> realList = new ArrayList<>();
        for (int i = 0; i < time; i++) {
            realList.add(list.get(i % list.size()));
        }
        
        String[] realArr = new String[realList.size()];
        for (int i = 0; i < realArr.length; i++) {
            realArr[i] = realList.get(i);
        }
        
        return realArr;
    }
    
    public String replaceStr(String str) {
        return str.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a");
    }
}