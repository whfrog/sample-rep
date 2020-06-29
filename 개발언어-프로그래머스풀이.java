/*******************************************************************************
2020 데모 테스트 - 프로그래밍1
*******************************************************************************/
import java.util.*;

class Solution {
    public int[] solution(int[][] v) {
        int[] answer = new int[2];
        HashMap<Integer, Integer> x = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> y = new HashMap<Integer, Integer>();

        int xx = 0;
        int yy = 0;

        for(int i =0; i < 3; i++){
            if(x.containsKey(v[i][0])) {
                x.put(v[i][0], x.get(v[i][0])+1);
            } else {
                x.put(v[i][0], 1);
            }
        }

        for(int i =0; i < 3; i++){
            if(y.containsKey(v[i][1])) {
                y.put(v[i][1], y.get(v[i][1])+1);
            } else {
                y.put(v[i][1], 1);
            }
        }

        for(Integer key : x.keySet()){
            System.out.println(key + " " + x.get(key));
            if(x.get(key) == 1) xx = key;

        }

        for(Integer key : y.keySet()){
            System.out.println(key + " " + y.get(key));
            if(y.get(key) == 1) yy = key;
        }

        answer[0] = xx;
        answer[1] = yy;



        return answer;
    }
}

/*******************************************************************************
2020 데모 테스트 - 프로그래밍1
*******************************************************************************/
import java.util.*;

class Solution {
    public int[] solution(int[][] v) {
        int[] answer = new int[2];

        HashMap<Integer, Integer> xmap = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> ymap = new HashMap<Integer, Integer>();

        for(int i=0; i< v.length; i++){
            xmap.put(v[i][0], xmap.getOrDefault(v[i][0], 0)+1);
            ymap.put(v[i][1], ymap.getOrDefault(v[i][1], 0)+1);
        }

        int x = 0;
        int y = 0;
        for(Integer i : xmap.keySet()){
            if(xmap.get(i) == 1) x = i;
        }
        for(Integer i : ymap.keySet()){
            if(ymap.get(i) == 1) y = i;
        }
        answer = new int[]{x, y};

        return answer;
    }
}
/*******************************************************************************
2020 데모 테스트 - 프로그래밍2
20.0
*******************************************************************************/
import java.util.*;

class Solution {
    public boolean solution(int[] arr) {
        boolean answer = false;

        Arrays.sort(arr);
        if(arr[arr.length-1] == arr.length) answer = true;

        return answer;
    }
}

/*******************************************************************************
2020 데모 테스트 - 프로그래밍2
16.3
*******************************************************************************/
import java.util.*;

class Solution {
    public boolean solution(int[] arr) {
        boolean answer = false;

        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int i =0; i < arr.length; i++){
            set.add(arr[i]);
        }

        if(arr.length == set.last()) answer = true;

        return answer;
    }
}

/*******************************************************************************
2020 데모 테스트 - 프로그래밍2
8.4
*******************************************************************************/
import java.util.*;

class Solution {
    public boolean solution(int[] arr) {
        boolean answer = true;

        for(int i=0; i< arr.length; i++){
            answer = false;
            for(int j=0; j < arr.length; j++){
                if(arr[j] == i) answer = true;
            }
        }
        return answer;
    }
}

/*******************************************************************************
2020 데모 테스트 - 프로그래밍3
*******************************************************************************/
class Solution {
    public int solution(int[] nums) {
        int answer = -1;

        answer = 0;
    for(int i= 0; i < nums.length-2; i++){
        for(int j=i+1; j < nums.length-1; j++){
            for(int k=j+1; k < nums.length; k++){
                int num = nums[i] + nums[j] + nums[k];
                boolean isPrime = false;
                // 1은 소수도 합성수도 아니므로 i는 2부터 시작한다.
                // 2의 경우 반복문이 실행되지 않으므로 defalt값으로 실행된다.
                for (int l = 2; l < num; l++) {
                // 1과 num 자신 외에 나누어지는 수가 있는지 검사할 조건문
                    if (num % l == 0) {
                // 나누어지는 수가 있을 경우 isPrime의 값을 true로 바꾼다.
                        isPrime = true;
                // 한 번이라도 이 조건문이 실행될 경우 num은 소수가 아니므로 반복문을 빠져나온다.
                        break;
                    }
                }
                if(!isPrime) answer++;
            }
        }
    }
        if(answer == 0) answer = -1;

        return answer;
    }
}

/*******************************************************************************
2020 데모 테스트 - 프로그래밍3
소수 만들기
*******************************************************************************/
class Solution {
    public int solution(int[] nums) {
        int answer = -1;
        int n = nums.length;

        answer = 0;
		for(int i=0;i<n;i++)
			for(int j=i+1;j<n;j++)
				for(int k=j+1;k<n;k++){
                    int sum = nums[i]+nums[j]+nums[k];
					if(isPrime2(sum)) answer++;
				}
    return answer;
    }

     public static boolean isPrime2(int num) {
        boolean result = true;
        int end = num/2;
        for(int i = 2; i <= end; i++) {
            if( num%i == 0) {
                result = false;
                break;
            } else {
                result = true;
            }
        }
        return result;
    }
}

/*******************************************************************************
2020 데모 테스트 - 프로그래밍4
스킬트리
*******************************************************************************/
import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(int i=0; i< skill_trees.length; i++ ){
            int[] match = new int[skill.length()];
            for(int j=0; j< skill.length(); j++)
                match[j] = skill_trees[i].indexOf(skill.substring(j, j+1));
            System.out.println(Arrays.toString(match));

            boolean ordered = true;
            for(int j=0; j< skill.length()-1; j++){
                if(match[j+1] == -1) continue;
                else if (match[j] == -1 && match[j+1] != -1)   ordered = false;
                else if (match[j] > match[j+1]) ordered = false;
            }
            if(ordered) answer++;
        }

        return answer;
    }
}
/*******************************************************************************
2020 데모 테스트 - 프로그래밍4
스킬트리
*******************************************************************************/
import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        String[] comp = skill.split("");

        int[] index = new int[comp.length];

        for(int i =0; i< skill_trees.length; i++){
            for(int j = 0; j < comp.length; j++){
                index[j] = skill_trees[i].indexOf(comp[j]);
            }
            boolean end = false;
            boolean order = true;

            for(int j = 0; j < comp.length-1; j++){
                if(index[j] >= 0){
                    if(index[j+1] == -1 || index[j] < index[j+1]) {

                    } else {
                        order = false;
                    }
                } else {
                    if(index[j+1] == -1) {

                    } else {
                        order = false;
                    }
                }
            }
            System.out.println(Arrays.toString(index)+ " "+ order);
            if(order) answer++;
        }


        return answer;
    }
}


/*******************************************************************************
*******************************************************************************/
import java.util.*;

class Solution {
    public boolean solution(int[] arr) {
        boolean answer = true;

        Set<Integer> set = new TreeSet<Integer>();
        for(int i = 0 ; i < arr.length; i++) {
            set.add(arr[i]);
        }

        Iterator<Integer> it = set.iterator();

        int cnt = 1;
        while(it.hasNext()){
            if (it.next() != cnt) {
                answer = false;
                break;
            }
            cnt++;
         }

        return answer;
    }
}


/*******************************************************************************
해시 - 완주하지 못한 선수
풀이 1
*******************************************************************************/
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        ArrayList <String> pSet = new ArrayList<String>();
        ArrayList <String> cSet = new ArrayList<String>();

        for(int i = 0; i < participant.length; i++){
            pSet.add(participant[i]);
        }
        for(int i = 0; i < completion.length; i++){
            pSet.remove(completion[i]);
        }
        Iterator it = pSet.iterator();
	      while(it.hasNext()){
		        answer = (String)it.next();
	       }

        return answer;
    }
}

/*******************************************************************************
해시 - 완주하지 못한 선수
풀이 2
*******************************************************************************/
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        ArrayList<String> plist = new ArrayList<String> (Arrays.asList(participant));

        for(int i = 0; i< completion.length; i++){
            plist.remove(completion[i]);
        }

        answer = plist.get(0);

        return answer;
    }
}

/*******************************************************************************
해시 - 전화번호 목록
풀이 1
*******************************************************************************/
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        for(int i = 0; i<phone_book.length; i++){
            for(int j = 0; j<phone_book.length; j++){
                if( i == j) break;
                if(phone_book[i].startsWith(phone_book[j])) {
                    answer = false;
                    break;
                 }
            }
            if(answer == false) break;
         }
        return answer;
    }
}

/*******************************************************************************
해시 - 전화번호 목록
풀이 2
*******************************************************************************/
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        ArrayList<String> list = new ArrayList<String>(Arrays.asList(phone_book));

        for(int i = 0; i < phone_book.length; i++){
            for(String s : list){
                if(s.equals(phone_book[i])) continue;
                if(s.startsWith(phone_book[i])) {
                    answer = false;
                    break;
                }
            }
            if(answer == false) break;
        }
        return answer;
    }
}

/*******************************************************************************
해시 - 전화번호 목록
풀이 3
*******************************************************************************/
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        for(int i=0; i<phone_book.length; i++)
            for(int j=i+1; j<phone_book.length; j++) {
                if(phone_book[j].startsWith(phone_book[i])) return answer = false;
                if(phone_book[i].startsWith(phone_book[j])) return answer = false;

            }
        return answer;
    }
}

/*******************************************************************************
해시 - 위장
*******************************************************************************/
import java.util.*;

class Solution {
  public int solution(String[][] clothes) {
       int answer = 1;

        HashMap<String, Integer> clothesMap = new HashMap<String, Integer>(); // 종류 : 갯수

        for (int i = 0; i < clothes.length; i++) {
            // 종류 여부 판단. 같은 종류 일 경우 Value + 1
            clothesMap.put(clothes[i][1], clothesMap.getOrDefault(clothes[i][1], 0)+1);
        }
        System.out.println(clothesMap);

        // 경우의 수 체크 answer *= (옷 가지수 + 안 입을 경우)
        for (int val : clothesMap.values()){
            answer *= (val+1);
        }

        // 모두 다 안입는 경우는 존재하지 않으므로 -1
        return answer-1;
    }
}

/*******************************************************************************
해시 - 베스트앨범
*******************************************************************************/
import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        String[][] list = new String[genres.length][3];
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for(int i =0; i< genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);
            list[i][0] = String.valueOf(i);
            list[i][1] = genres[i];
            list[i][2] = String.valueOf(plays[i]);
        }

        List<String> keySetList = new ArrayList<>(map.keySet());
        Collections.sort(keySetList, (o1, o2) -> (map.get(o2) - map.get(o1)));
        System.out.println(map);

Comparator<String[]> comp = new Comparator<String[]>() {

	@Override
	public int compare(String[] o1, String[] o2) {
		// TODO Auto-generated method stub
		String s1 = o1[1];
		String s2 = o2[1];

		if (s1.equals(s2)){
            int n1 = Integer.parseInt(o1[2]);
            int n2 = Integer.parseInt(o2[2]);
			return n2-n1;
		} else 	{
			return s1.compareTo(s2);
		}
	}
};

        Arrays.sort(list, comp);
        for(int i=0; i< list.length; i++)
            System.out.println(Arrays.toString(list[i]));

        System.out.println(keySetList);
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(String s : keySetList){
            int cnt = 0;
            for(int j =0; j < list.length; j++){
                if(list[j][1].equals(s)) {
                    result.add(Integer.parseInt(list[j][0]));
                    cnt++;
                }
                if(cnt >= 2) break;
            }
        }

        System.out.println(result);
        answer = result.stream().mapToInt(i->i).toArray();


        return answer;
    }
}

/*******************************************************************************
정렬 - K번째수
풀이 1
*******************************************************************************/
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] list = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            System.out.println(Arrays.toString(list));

            Arrays.sort(list);
            System.out.println(Arrays.toString(list));

            answer[i] = list[commands[i][2]-1];
        }
        return answer;
    }
}

/*******************************************************************************
정렬 - K번째수
풀이 2
*******************************************************************************/
import java.util.*;


class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i =0; i<commands.length; i++){
            int[] subList = new int[commands[i][1] - commands[i][0]+1];
            subList = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            System.out.println(Arrays.toString(subList));

            Arrays.sort(subList);
            answer[i] = subList[commands[i][2]-1];
        }


        return answer;
    }
}

/*******************************************************************************
정렬 - K번째수
풀이 3
*******************************************************************************/
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0; i < commands.length; i++){
            ArrayList<Integer> list = new ArrayList<Integer>();
            System.out.println(commands[i][0] + " " + commands[i][1]);
            for(int j = commands[i][0]; j <= commands[i][1]; j++){
                list.add(array[j-1]);
            }
            Collections.sort(list);
            System.out.println(list.toString());
            answer[i] = list.get(commands[i][2]-1);
        }

        return answer;
    }
}


/*******************************************************************************
정렬 - 가장 큰 수
*******************************************************************************/
import java.util.*;

class Solution {
    public static String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++)
            arr[i] = String.valueOf(numbers[i]);

        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if(arr[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++)
            sb.append(arr[i]);

        return sb.toString();
    }
}

/*******************************************************************************
완전탐색 - 모의고사
*******************************************************************************/
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        System.out.println(Arrays.toString(citations));

        for(int i=0; i<citations.length; i++){
            int h = citations.length - i;
            if(citations[i]>=h) {
                answer = h;
                break;
            }
        }

        return answer;
    }
}

import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[][] result = new int[3][2];

        String[] list = new String[3];
        String[] pattern = {"12345", "21232425", "3311224455"};

        //답지 생성
        for(int i = 0; i < 3; i++){
            int inx = answers.length / pattern[i].length();
            int jnx = answers.length % pattern[i].length();

            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < inx; j++){
                sb.append(pattern[i]);
            }

            sb.append(pattern[i].substring(0, jnx));

            list[i] = sb.toString();
            System.out.println(list[i]);
        }
        // System.out.println(Arrays.toString(list));

        for(int i = 0; i < 3; i++){
            int cnt = 0;
            for(int j=0; j< answers.length; j++){
                if(Integer.parseInt(list[i].substring(j, j+1)) == answers[j]) cnt++;
            }
            result[i][0] = i+1;
            result[i][1] = cnt;
            System.out.println(Arrays.toString(result[i]));
        }

Comparator<int[]> comp = new Comparator<int[]>() {

	@Override
	public int compare(int[] o1, int[] o2) {
		// TODO Auto-generated method stub
		int no1 = o1[1];
		int no2 = o2[1];

		if (no1 == no2) {
			return o1[0] - o2[0];
		} else {
			return no2 - no1;
		}
	}
};
        Arrays.sort(result, comp);

        ArrayList<Integer> arr = new ArrayList<Integer>();
        int max = result[0][1];
        for(int i = 0; i < 3; i++){
            if(result[i][1] == max) {
                arr.add(result[i][0]);
            }
        }
        System.out.println(arr);
        answer = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++){
            answer[i] = arr.get(i);
        }

        return answer;
    }
}
/*******************************************************************************
완전탐색 - 모의고사
*******************************************************************************/

import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};

        int[] result = new int[3];

        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for(int i=0; i< answers.length; i++){
            if(answers[i] == a[i%a.length]) result[0]++;
            if(answers[i] == b[i%b.length]) result[1]++;
            if(answers[i] == c[i%c.length]) result[2]++;
        }

        System.out.println(Arrays.toString(result));
        int maxCnt = Math.max(result[0], Math.max(result[1], result[2]));
        System.out.println(maxCnt);

        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i < 3; i++){
            if(result[i] == maxCnt) arr.add(i+1);
        }

        Collections.sort(arr);

        answer = new int[arr.size()];
        for(int i =0; i< arr.size(); i++){
            answer[i] = arr.get(i);
        }

        System.out.println(arr);


        return answer;
    }
}

/*******************************************************************************
*******************************************************************************/
class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];

        for(int i=0; i< n; i++){
            if(i == 0 ) {
                answer[i] = x;
            } else {
                answer[i] = answer[i-1] + x;
            }
        }
        return answer;
    }
}

/*******************************************************************************
*******************************************************************************/
class Solution {
    public int solution(String s) {
        int answer = 0;

        if(s.startsWith("+")){
            answer = Integer.parseInt(s.substring(1));
        } else if(s.startsWith("-")){
            answer = -1 * Integer.parseInt(s.substring(1));
        } else {
            answer = Integer.parseInt(s);
        }
        return answer;
    }
}

/*******************************************************************************
*******************************************************************************/
class Solution {
    public String solution(int num) {
        String answer = "";

        if(num%2 == 0) {
            answer = "Even";
        } else {
            answer = "Odd";
        }
        return answer;
    }
}

/*******************************************************************************
*******************************************************************************/
class Solution {
    public long solution(int a, int b) {
        long answer = 0;

        if(a - b > 0){
            for(int i = 0; i<= a-b; i++){
                answer += b + i;
            }
        } else if (a - b < 0){
            for(int i = 0; i<= b-a; i++){
                answer += a + i;
            }
        } else  {
            answer = a;
        }

        return answer;
    }
}

/*******************************************************************************
*******************************************************************************/
class Solution {
    public String solution(String phone_number) {
        String answer = "";

        for(int i =0; i < phone_number.length()-4; i++){
            answer += "*";
        }
        answer += phone_number.substring(phone_number.length()-4);
        System.out.println(answer);

        return answer;
    }
}


/*******************************************************************************
*******************************************************************************/
class Solution {
    public String solution(String s) {
        String answer = "";
        // s = "abc  e";
        String[] tokens = s.trim().split(" ");
        for(String c : tokens){
            // c.replaceAll("\\p{Z}", "");
            System.out.println(c);
            // if(c.equals("")) continue;
            for(int i = 0; i < c.length(); i++){
                if(i%2 == 0) {
                    answer += c.substring(i, i+1).toUpperCase();
                } else{
                    answer += c.substring(i, i+1).toLowerCase();
                }

            }
            System.out.println(answer);
            answer += " ";
        }
        return answer.trim();
    }
}


/*******************************************************************************
에산
87.0
*******************************************************************************/
import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);
        int sum = 0;
        for(int i=0; i < d.length; i++){
            sum += d[i];
            if(sum > budget) {
                answer = i;
                break;
            } else if (sum == budget) {
                answer = i+1;
                break;
            }
        }
        if(d.length == 1 && d[0] < budget ) answer = 1;
        return answer;
    }
}

/*******************************************************************************
깊이 우선 탐색(DFS, Depth-First Search)
모든 노드를 방문하고자 하는 경우
*******************************************************************************/
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0, 0, target);
        return answer;
    }

    private int dfs(int[] numbers, int node, int sum, int target){
        if(node == numbers.length){
            if(sum==target)
                return 1;
            return 0;
        }
        return dfs(numbers, node+1, sum + numbers[node], target)
        	 + dfs(numbers, node+1, sum - numbers[node], target);
    }
}

/*******************************************************************************
2016년
*******************************************************************************/
class Solution {
    public String solution(int a, int b) {
        String answer = "";
        String[] day = {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = 0;
        for(int i = 0; i < a-1; i++) days += month[i];
        days += b;
        System.out.println(days);

        answer = day[(days%7+4)%7];

        return answer;
    }
}

/*******************************************************************************
가운데 글자 가져오기
*******************************************************************************/
class Solution {
    public String solution(String s) {
        String answer = "";

        if(s.length()%2 == 0)
            answer = s.substring(s.length()/2-1, s.length()/2+1);
        else
            answer = s.substring(s.length()/2, s.length()/2+1);

        return answer;
    }
}

/*******************************************************************************
같은 숫자는 싫어
*******************************************************************************/
import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(arr[0]);
        for(int i = 1; i<arr.length; i++) {
            if(arr[i-1] == arr[i]) continue;
            else list.add(arr[i]);
        }

        answer = list.stream().mapToInt(i->i).toArray();

        return answer;
    }
}

/*******************************************************************************
나누어서 떨어지는 숫자의 배열
*******************************************************************************/
import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};

        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0; i< arr.length; i++){
            if(arr[i]%divisor == 0) list.add(arr[i]);
        }
        Collections.sort(list);

        if(list.size() == 0) answer = new int[]{-1};
        else answer = list.stream().mapToInt(i->i).toArray();

        return answer;
    }
}

/*******************************************************************************
문자열 내 p와 y의 개수
*******************************************************************************/
class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int pCnt = 0, yCnt = 0;
        s = s.toLowerCase();
        for(int i=0; i< s.length(); i++){
            if(s.substring(i, i+1).equals("p")) pCnt++;
            if(s.substring(i, i+1).equals("y")) yCnt++;
        }
        if(pCnt != yCnt) answer = false;

        return answer;
    }
}

/*******************************************************************************
문자열 내림차순으로 배치하기
*******************************************************************************/
import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] tokens = s.split("");

        Arrays.sort(tokens);
        Arrays.sort(tokens, (o1, o2) -> (o2).compareTo(o1));

        StringBuilder sb = new StringBuilder();
        for(String str : tokens){
            sb.append(str);
        }
        return answer = sb.toString();
    }
}

/*******************************************************************************
문자열 다루기 기본
*******************************************************************************/
class Solution {
    public boolean solution(String s) {
        boolean answer = true;

        if(s.length() == 4 || s.length() == 6) {
            if(s.matches("^[0-9]*$")) answer = true;
            else answer = false;
        } else answer = false;

        return answer;
    }
}

/*******************************************************************************
최대값과 최소값
*******************************************************************************/
import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] tokens = s.split(" ");

        TreeSet<Integer> set = new TreeSet<Integer>();
        for(String str : tokens){
            set.add(Integer.parseInt(str));
        }
        answer = String.valueOf(set.first()) + " " + String.valueOf(set.last());
        return answer;
    }
}

/*******************************************************************************
점프와 순간이동
*******************************************************************************/
import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        while(n != 0){
            if(n % 2 == 0){
                n /= 2;
            } else {
                n--;
                ans++;
            }
        }

        return ans;
    }
}

/*******************************************************************************
영어 끝말잇기
*******************************************************************************/
import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        int inx = -1;
        HashSet<String> set = new HashSet<String>();

        for(int i=0; i< words.length; i++){
            if(words[i].length() < 2) {
                inx = i;
                break;
            }
            else if(i > 0 && ! words[i].startsWith(words[i-1].substring(words[i-1].length()-1))) {
                inx = i;
                break;
            }
            else if(set.contains(words[i])) {
                inx = i;
                break;
            }
            else set.add(words[i]);
        }

        if(inx != -1) {
            answer[0] = inx % n + 1;
            answer[1] = inx / n + 1;
        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }
}

/*******************************************************************************
124 나라의 숫자
*******************************************************************************/
import java.util.*;

class Solution {
    public String solution(int n) {
        String answer = "";
        String[] match = {"4", "1", "2"};

        int num = n;
        while(num > 0){
            int remain = num%3;
            if(num%3 == 0)
                num = num / 3 - 1;
            else
                num = num / 3;

            answer = match[remain] + answer;
        }

        return answer;
    }
}

/*******************************************************************************
문자열 내 마음대로 정렬하기
*******************************************************************************/
import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        Arrays.sort(strings);
        Arrays.sort(strings, (o1, o2) -> (o1.substring(n, n+1).compareTo(o2.substring(n, n+1))));

        answer = strings;
        return answer;
    }
}

/*******************************************************************************
서울에서 김서방 찾기
*******************************************************************************/

class Solution {
    public String solution(String[] seoul) {
        String answer = "";

        for(int i=0; i< seoul.length; i++){
            if(seoul[i].equals("Kim")) answer = "김서방은 "+i+"에 있다";
        }
        return answer;
    }
}

/*******************************************************************************
수박수박수박수박
*******************************************************************************/
class Solution {
    public String solution(int n) {
        String answer = "";

        for(int i = 0; i<(n/2); i++){
            answer += "수박";
        }
        if(n%2 != 0) answer += "수";

        return answer;
    }
}

/*******************************************************************************
시저 암호
*******************************************************************************/
import java.util.*;

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        String[] upper = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        String[] lower = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

        ArrayList<String> uList = new ArrayList<String>(Arrays.asList(upper));
        ArrayList<String> lList = new ArrayList<String>(Arrays.asList(lower));

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            String str = s.substring(i, i+1);
            // System.out.println(str);
            if(str.equals(" ")){
                sb.append(str);
            } else if(str.matches("[a-z]")){
                sb.append(lower[(lList.indexOf(str)+n)%26]);
                } else if(str.matches("[A-Z]")){
                sb.append(upper[(uList.indexOf(str)+n)%26]);
            }
        }
        answer = sb.toString();
        return answer;
    }
}
