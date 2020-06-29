/*******************************************************************************
2016년 2차
1. 숫자 정렬
*******************************************************************************/

public class NumberOrdering {

	private int[] originalNumber;
    private int[] ascendingNumber;

    public int[] getOriginalNumber() {
    }
		return originalNumber;

    public int[] getAscendingNumber() {
        return ascendingNumber;
    }

    public void ascendOrder( int[] numberArray ) {
        this.originalNumber = numberArray.clone();
        this.ascendingNumber = numberArray;

        for( int inx = 0 ; inx < numberArray.length ; inx++ ){
            for( int jnx = 0 ; jnx < numberArray.length ; jnx++ ){
                if( ascendingNumber[inx] < ascendingNumber[jnx] ){
                    int temp = ascendingNumber[inx];
                    ascendingNumber[inx] = ascendingNumber[jnx];
                    ascendingNumber[jnx] = temp;
                }
            }
        }
    }
}

/*******************************************************************************
2. 개인정보 마스킹(Masking)
*******************************************************************************/
public class MaskingInfo {

	public static String maskName(String name) {
    	StringBuilder maskingName = new StringBuilder();
        for(int i=0; i < name.length(); i++){
        	char ch = name.charAt(i);
        	if(!Pattern.matches("[��-��]", ch+"")){
        		throw new IllegalArgumentException();
        	}

        }
        maskingName.append(name.substring(0, 1));
        for(int i=1; i < name.length()-1; i++) {
        	maskingName.append("*");
        }
        maskingName.append(name.substring(name.length()-1));
        return maskingName.toString();
    }

    public static String maskSsnId(String ssnId) {
    	StringBuilder maskingSsnId = new StringBuilder();
    	char sexNum = ssnId.charAt(7);
    	if(sexNum != '1' && sexNum != '2' && sexNum != '3' && sexNum != '4') {
    		throw new IllegalArgumentException();
    	}
    	maskingSsnId.append(ssnId.substring(0, 8));
    	maskingSsnId.append("******");
        return maskingSsnId.toString();
    }

    public static String maskCreditCardNo(String creditCardNo) {
    	StringBuilder maskingCreditCardNo = new StringBuilder();
    	String creditCardNoNum = creditCardNo.replaceAll("-", "");
    	if(creditCardNoNum.length() != 16) {
    		throw new IllegalArgumentException();
    	}
        for(int i=0; i < creditCardNoNum.length(); i++){
        	char ch = creditCardNoNum.charAt(i);
        	if(!Pattern.matches("[0-9]", ch+"")){
        		throw new IllegalArgumentException();
        	}

        }
        maskingCreditCardNo.append(creditCardNo.substring(0, 7));
        maskingCreditCardNo.append("**-****-****");
        return maskingCreditCardNo.toString();
    }
}

/*******************************************************************************
3. Anagram
*******************************************************************************/
public class Anagram {

	public static boolean isAnagram(String originalStr, String anagramStr){
        originalStr = originalStr.replaceAll( " ", "" ).toLowerCase();
        anagramStr = anagramStr.replaceAll( " ", "" ).toLowerCase();

        System.out.println("abcdefg".substring(0, 3));
        char[] chars = originalStr.toCharArray();
        for (char c: chars) {
          int index = anagramStr.indexOf(c);
            if (index != -1) {
            	anagramStr = anagramStr.substring(0, index) + anagramStr.substring(index + 1, anagramStr.length());
            } else {
                return false;
            }
        }
        return anagramStr.isEmpty();
    }
}

/*******************************************************************************
4. 자연수 사칙연산 계산기
*******************************************************************************/
public class Calculator {

    public static long calc( String pattern ) {

        Stack<Character> stack = new Stack<>();
        Stack<Long> stack2 = new Stack<>();

        char[] patternPost = new char[pattern.length()];
        boolean isFirst = true;
        int pos = 0;

        for (int i = 0; i < pattern.length(); i++) {
            char chr = pattern.charAt(i);
            if ("+-*/".indexOf(chr) == -1) {
                patternPost[pos++] = chr;
                continue;
            }

            if (isFirst) {
                stack.push(chr);
                isFirst = false;
            } else {
                if ("+-".indexOf(chr) >= 0) {
                    while (!stack.isEmpty()) {
                        patternPost[pos++] = stack.pop();
                    }
                    stack.push(chr);
                } else {
                    while (!stack.isEmpty()) {
                        char peeked = stack.peek();
                        if("*/".indexOf(peeked) >= 0) {
                            patternPost[pos++] = stack.pop();
                        } else {
                            stack.push(chr);
                            break;
                        }
                    }
                }
            }
        }

        while (!stack.isEmpty()) {
            patternPost[pos++] = stack.pop();
        }

        for (int i = 0; i < patternPost.length; i++) {
            char chr = patternPost[i];
            if ("+-*/".indexOf(chr) >= 0) {
                long operand2 = stack2.pop();
                long operand1 = stack2.pop();
                switch (chr) {
                case '+':
                    stack2.push(operand1 + operand2);
                    break;
                case '-':
                    stack2.push(operand1 - operand2);
                    break;
                case '*':
                    stack2.push(operand1 * operand2);
                    break;
                case '/':
                    stack2.push(operand1 / operand2);
                    break;
                default:
                    break;
                }
            } else {
                stack2.push(Long.parseLong(String.valueOf(chr)));
            }
        }

        return stack2.pop();
    }
}

/*******************************************************************************
2016년 5차
1. 팩토리얼
*******************************************************************************/
public class Factorial {

	public static BigInteger fact( BigInteger num ) {

		if ( num.intValue() > 100 ) {
			throw new IllegalArgumentException();
		}

        if ( num.intValue()==1||num.intValue()==0 ) {
            return BigInteger.ONE;
        } else {
            return num.multiply( fact( num.subtract( BigInteger.ONE ) ) );
        }
    }
}

/*******************************************************************************
2. 문자열 패턴 찾기
*******************************************************************************/
public class PatternSearch {

	private static String[] patternArray = { "GOL", "LOL" };

	public static int countPattern(String statement) {
		int matchCount = 0;
		int index = 0;
		while (true) {
			index = statement.indexOf(patternArray[0], index);
			if (index == -1)
				break;
			matchCount++;
			index = index + 2;
		}

		index = 0;
		while (true) {
			index = statement.indexOf(patternArray[1], index);
			if (index == -1)
				break;
			matchCount++;
			index = index + 2;
		}

		return matchCount;
	}
}

/*******************************************************************************
3. Parity Check
*******************************************************************************/
public class ParityCheck {

	public static String checkParity(int[][] matrix) {
		String result = "";
		int size = matrix.length;
		int i = 0, j = 0, k = 0, cc = 0, cr = 0;
		int[] row = new int[size];
		int[] col = new int[size];

		for (i = 0; i < size; i++) {
			for (j = 0; j < size; j++) {
				row[i] += matrix[i][j];
				col[j] += matrix[i][j];
			}
		}

		int p = 0, q = 0;
		for (k = 0; k < size; k++) {
			if (row[k] % 2 != 0) {
				cr++;
				p = k + 1;
			}
			if (col[k] % 2 != 0) {
				cc++;
				q = k + 1;
			}
		}

		if (cc == 0 && cr == 0) {
			result = "OK!\n";
		} else if (cc == 1 && cr == 1) {
			result = "Change(" + p + "," + q + ")\n";
		} else {
			result = "None";
		}
		return result;
	}
}

/*******************************************************************************
4. 데이터 목록 병합
*******************************************************************************/
public class DataListUtil {

    public static List<DataSet> mergeList(List<DataSet> list1, List<DataSet> list2) {
        List<DataSet> list = new ArrayList<>();

        Map<String, DataSet> atypeMap = new HashMap<>();
        Map<String, DataSet> btypeMap = new HashMap<>();

        for(DataSet data : list1) {
            if(data.getType().equals(DataSet.A_TYPE)) {
                atypeMap.put(data.getPattern(), data);
            } else {
                btypeMap.put(data.getPattern(), data);
            }
        }

        for(DataSet data : list2) {
            if(data.getType().equals(DataSet.A_TYPE)) {
                atypeMap.put(data.getPattern(), data);
            } else {
                btypeMap.put(data.getPattern(), data);
            }
        }

        for(String key : atypeMap.keySet()) {
            list.add(atypeMap.get(key));
        }
        for(String key : btypeMap.keySet()) {
            list.add(btypeMap.get(key));
        }
        return list;
    }


    public static List<DataSet> mergeListMiss(List<DataSet> list1, List<DataSet> list2) {
        List<DataSet> listTemp = new ArrayList<>();

        Map<String, DataSet> atypeMap = new HashMap<>();
        Map<String, DataSet> btypeMap = new HashMap<>();

        for(DataSet data : list1) {
            if(data.getType().equals(DataSet.A_TYPE)) {
                if(!listTemp.contains(data)) {
                    listTemp.add(data);
                }
            }
        }
        for(DataSet data : list2) {
            if(data.getType().equals(DataSet.A_TYPE)) {
                if(!listTemp.contains(data)) {
                    listTemp.add(data);
                }
            }
        }
        for(DataSet data : list1) {
            if(data.getType().equals(DataSet.B_TYPE)) {
                if(!listTemp.contains(data)) {
                    listTemp.add(data);
                }
            }
        }
        for(DataSet data : list2) {
            if(data.getType().equals(DataSet.B_TYPE)) {
                if(!listTemp.contains(data)) {
                    listTemp.add(data);
                }
            }
        }

        return listTemp;
    }
}

/*******************************************************************************
2017년 3차
1. Cube Sum
*******************************************************************************/
public class CubeSum {

	/**
	 * 입력받은 큐브를 시계방향으로 90도 회전하여 동일한 위치의 합을 리턴하는 메소드
	 *
	 * @param cube MXM 크기의 이차원 배열
	 * @return cube + 시게방향 90도 회전 cube
	 */
	public static int[][] sum(int[][] cube)
	{
		int [][] result = new int[cube.length][cube.length];
		int [][] change = new int[cube.length][cube.length];

		for (int i = 0; i < cube.length; i++){
			for (int j = 0; j < cube.length; j++){
				change[i][j] = cube[cube.length-1-j][i];
			}
		}

		for (int i = 0; i < cube.length; i++){
			for (int j = 0; j < cube.length; j++){
				result[i][j] = cube[i][j] + change[i][j];
			}
		}

		return result;
	}

}

/*******************************************************************************
2. 사원정보 출력
*******************************************************************************/
public class Employee {

	/**
	 * 사원정보를 출력하는 메소드
	 * 출력결과는 {부서명, 사원번호, 사원명} 순으로 저장된다.
	 *
	 * @param department 부서정보
	 * @param employee 사원정보
	 * @return
	 */
	public static String[][] print(String[][] department, String[][] employee) {
		String [][] result = new String[employee.length][3];
		String [] list =  new String[employee.length];

		for(int i = 0; i < employee.length; i++){
			for(int j = 0; j < department.length; j++) {
				if(department[j][0] == employee[i][2]){
					list[i] = department[j][0] + "," + department[j][1];
					list[i] += "," + employee[i][0] + "," + employee[i][1];
				}
			}
		}
//		System.out.println("정렬 전");
//		System.out.println(Arrays.toString(list));

		Arrays.sort(list);

//		System.out.println("정렬 후");
//		System.out.println(Arrays.toString(list));

		for(int i = 0; i < list.length; i++){
			String[] tokens = list[i].split(",");
			result[i][0] = tokens[1];
			result[i][1] = tokens[2];
			result[i][2] = tokens[3];
		}

		return result;
	}
}

/*******************************************************************************
3. Dense Ranking
*******************************************************************************/
public class DenseRank {

	/**
	 * Dense Ranking을 구하는 메소드
	 *
	 * @param input {사번, 점수} Array
	 * @return 정렬된 {사번, 점수, 순위} Array
	 */
	public static int[][] rank(int[][] input) {
		int[][] result = new int[input.length][3];

//		System.out.println("정렬 전");
//		for (int[] tmp : input) {
//			System.out.println(Arrays.toString(tmp));
//		}

		for (int i = 0; i < input.length-1; i++){
			for(int j = i; j < input.length; j++) {
				if(input[i][1] < input[j][1]){
					int[] temp = input[i];
					input[i] = input[j];
					input[j] = temp;
				}
//				if((input[i][1] == input[j][1]) && (input[i][0] > input[j][0])){
//					int[] temp = input[i];
//					input[i] = input[j];
//					input[j] = temp;
//				}
			}
		}

		int preScore = input[0][1];
		int rank = 1;
		for (int i = 0; i < input.length; i++){
			result[i][0] = input[i][0];
			result[i][1] = input[i][1];

			if (input[i][1] == preScore){
				result[i][2] = rank;
			} else {
				result[i][2] = ++rank;
				preScore = input[i][1];
			}
		}
//		System.out.println("정렬 후");
//		for (int[] tmp : result) {
//			System.out.println(Arrays.toString(tmp));
//		}
		return result;
	}
}

/*******************************************************************************
2017년 17차
1. Word Count
*******************************************************************************/
public class WordCount {

	/**
	 * 입력 받은 message에서 searchWord의 빈도수를 구하여 결과를 리턴한다.(구현)
	 *
	 * @param message 입력받은 문자열
	 * @param searchWord 검색단어
	 * @return 검색단어의 빈도수
	 */
	public int countWord(String message, String searchWord) {

		String[] tokens = message.split(" ");

		int count = 0;
		for(String token : tokens) {
			if(token.equals(searchWord)) {
				count++;
			}
		}
		return count;
	}

}

/*******************************************************************************
2. 직급별 평균연봉
*******************************************************************************/
public class Salary {

	/**
	 * 직급별 평균연봉을 출력하는 메소드(구현)
	 *
	 * @param salary
	 * @param employee
	 * @return
	 */
	public String [][] print(String [][] salary, String[][] employee) {

		String[][] list = new String[employee.length][4];
		for(int i = 0; i < employee.length; i++) {
			list[i][0] = employee[i][0];
			list[i][1] = employee[i][1];
			list[i][2] = employee[i][2];

			for(int j = 0; j < salary.length; j++){
				if (employee[i][0] == salary[j][0]){
					list[i][3] = salary[j][1];
				}
			}

		}
//		for (String[] tmp : list) {
//			System.out.println(Arrays.toString(tmp));
//		}

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0; i < employee.length; i++){
			map.put(list[i][2], 0);

		}
		String[][] result = new String[map.size()][2];
		int inx = 0;
		for(String key : map.keySet()){
			int count = 0;
			int sumSalary = 0;
			for (String[] row : list){
				if(row[2].equals(key)) {
					count++;
					sumSalary += Integer.parseInt(row[3]);
				}
			}
			result[inx][0] = key;
			result[inx][1] = Math.round(sumSalary/count) +"";
			inx++;
		}

//		for (String[] tmp : result) {
//			System.out.println(Arrays.toString(tmp));
//		}

		for (int i = 0; i < result.length; i++){
			for (int j = 0; j < result.length; j++){
				if (Integer.parseInt(result[i][1]) < Integer.parseInt(result[j][1])){
					String[] temp = result[i];
					result[i] = result[j];
					result[j] = temp;
				}
			}
		}

//		for (String[] tmp : result) {
//			System.out.println(Arrays.toString(tmp));
//		}

		return result;
	}

}

/*******************************************************************************
3. MAC주소 검증 및 변환하기
*******************************************************************************/
public class MacAddress {

	/**
	 * 입력받은 MAC주소를 검증하고 Type 3 형식으로 변환하여 리턴한다 (구현)
	 *
	 * @param inputMac 입력 MAC주소
	 * @return 변환된 MAC주소, 올바르지 않은 형식은 null을 리턴
	 */
	public String validateMacAddress(String inputMac) {
		String result = null;
		if(inputMac.toLowerCase().matches("^([0-9a-fA-F][0-9a-fA-F][:\\-]){5}[0-9a-fA-F]{2}$")){
			result = inputMac.substring(0,2) + inputMac.substring(3, 5) + "."
		           + inputMac.substring(6,8) + inputMac.substring(9, 11) + "."
		           + inputMac.substring(12,14) + inputMac.substring(15, 17);
//			System.out.println(result);
		}
		if(inputMac.toLowerCase().matches("^([0-9a-fA-F]{4}[.]){2}[0-9a-fA-F]{4}$")){
			result = inputMac.toLowerCase();
//			System.out.println(result);
		}

		return result;
	}

}

/*******************************************************************************
4. 단어 찾기
*******************************************************************************/
public class WordSearch {

	/**
	 * 해당 단어가 격자 내에 존재 하는 경우 시작좌표를 반환하는 메소드 (구현)
	 *
	 * @param matrix
	 *            알파벳 대문자가 포함된 격자
	 * @param word
	 *            격자 내에서 찾을 단어
	 * @return 입력 받은 단어가 격자 내에 존재할 경우 시작좌표
	 */
	public String[] findWordCount(String[][] matrix, String word) {
		String[] result = null;

		word.toUpperCase();

		ArrayList<String> list = new ArrayList<String>();

		// 가로 검색
		for (int i = 0; i < matrix.length; i++) {
			String s = "";
			for (int j = 0; j < matrix.length; j++) {
				s += matrix[i][j];
			}

			if (s.indexOf(word, 0) > -1) {
				String x = String.valueOf(s.indexOf(word, 0));
				String y = changeInx(i);

				list.add(y + x);
//				System.out.println(s + " " + (y + x));
			}
		}

		// 세로 검색
		for (int i = 0; i < matrix.length; i++) {
			String s = "";
			for (int j = 0; j < matrix.length; j++) {
				s += matrix[j][i];
			}

			if (s.indexOf(word, 0) > -1) {
				String x = String.valueOf(i);
				String y = changeInx(s.indexOf(word, 0));

				list.add(y + x);
//				System.out.println(s + " " + (y + x));
			}
		}

		// 대각선 검색
 		for (int i = 0; i < matrix.length - 1 ; i++) {
			String s = "";
			for (int j = 0; j < matrix.length - i; j++) {
				s += matrix[j][j+i];
			}

			if (s.indexOf(word, 0) > -1) {
				String x = String.valueOf(i);
				String y = changeInx(s.indexOf(word, 0));

				list.add(y + x);
//				System.out.println(s + " " + (y + x));
			}
		}

 		if (!list.isEmpty()) {
 			result = list.toArray(new String[list.size()]);
 		}

		return result;
	}

	public String changeInx(int i) {
		String result = "";

		if (i == 0)
			result = "a";
		else if (i == 1)
			result = "b";
		else if (i == 2)
			result = "c";
		else if (i == 3)
			result = "d";
		else if (i == 4)
			result = "e";
		else if (i == 5)
			result = "f";
		else if (i == 6)
			result = "g";
		else if (i == 7)
			result = "h";
		else if (i == 8)
			result = "i";
		else
			result = "j";

		return result;
	}

}

/*******************************************************************************
2017년 추가
1. 분자식 질량 계산
*******************************************************************************/
public class MassCalculation {

    // 각 원소의 단위 질량
	public static final float ELEMENT_C = 12.01F;
    public static final float ELEMENT_H = 1.008F;
    public static final float ELEMENT_N = 14.01F;
    public static final float ELEMENT_O = 16.00F;

    /**
     * 분자식을 파라미터로 받아서 각 분자의 질량의 총합을 리턴하는 메소드
     *
     * @param  data 분자식
     * @return 분자 질량의 총합
     */
    public float calcCum( String data ) {

        //TODO 아래에 프로그램을 작성하시오.

        /* < 참고 >
         * 문자열 API 정보는 참고교재 중, Java기본 > M4. Java API 부분에 있음
         * 필요한 경우, 제공되는 PDF 또는 하드카피 교재(감독관에게 요청)에서 찾아 사용할 것
         */

        float sum = 0.0F;
        for (int i = 0; i < data.length(); i=i+2){
//    		System.out.println(data.charAt(i) + " " + data.charAt(i+1)+ " " + findWeight(data.charAt(i)) );
    		sum += findWeight(data.charAt(i)) * Integer.parseInt((data.substring(i+1,i+2)));
    	}

        return sum;
    }

    /**
     * 파라미터로 전달된 원소의 질량을 리턴하는 메소드
     *    << 원소의 질량 >>
     *      C : 12.01
     *      N : 14.01
     *      O : 16.0
     *      H : 1.008
     *
     * @param  element 원소
     * @return 원소의 질량
     */
    public float findWeight( char element ) {

        //TODO 아래에 프로그램을 작성하시오.
        // 단, 문항에서 주어지지 않은 원소의 질량은 고려하지 않는다.

    	float result = 0;

    	if ( "C".equals(String.valueOf(element))){
    		result = ELEMENT_C;
    	} else if("N".equals(String.valueOf(element))){
    		result = ELEMENT_N;
    	} else if ("O".equals(String.valueOf(element))){
    		result = ELEMENT_O;
    	} else if ("H".equals(String.valueOf(element))){
    		result = ELEMENT_H;
    	}
        return result;
    }
}

/*******************************************************************************
2. 전기 요금 계산기
*******************************************************************************/
public class EnergyCharge {

    public static int BASIC_FEE_LEVEL_1 = 910;
    public static int BASIC_FEE_LEVEL_2 = 1600;
    public static int BASIC_FEE_LEVEL_3 = 7300;

    public static double USING_FEE_LEVEL_1 = 93.3;
    public static double USING_FEE_LEVEL_2 = 187.9;
    public static double USING_FEE_LEVEL_3 = 280.6;

    public static int MANDATORY_GUARANTEE_FEE = 4000;
    public static int MAX_DISCOUNT_AMOUNT = 16000;

    /**
     * 전기 요금을 구하는 메소드
     *
     * 1. 기본 요금 적용 (원 미만 절사)
     *                 ~ 200 kWh 이하 : 910원
     *     200 초과      ~ 400 kWh 이하 : 1600원
     *     400 kWh 초과 ~             : 7300원
     * 2. 전력량 요금 적용 (원 미만 절사)
     *                 ~ 200 kWh 이하 : 93.3원
     *     200 초과      ~ 400 kWh 이하 : 187.9원
     *     400 kWh 초과 ~             : 280.6원
     * 3. 필수 사용량 보장 공제 적용 (원 미만 절사)
     *    : 월 200kWh 이하 전력 사용 고객의 경우, 4000원 공제
     * 4. 대가족 할인 적용 (원 미만 절사)
     *    : 세대 구성원이 5인 이상인 경우, 요금의 30% 할인
     *      (단, 대가족 할인의 최대 할인 금액은 16000원)
     * 5. 최종 청구 금액 확정 (10원 미만 절사)
     *
     * @param  usage  전기 사용량
     * @param  person 세대 인원 수
     * @return 전기 요금
     */
    public int calculateEnergyCharge( int usage, int person ) {

        //TODO 아래에 프로그램을 작성하시오.
        int sum = 0;

        if( usage <= 200 ){
        	sum = BASIC_FEE_LEVEL_1;
        } else if( usage > 200 && usage <= 400){
        	sum = BASIC_FEE_LEVEL_2;
        } else if( usage > 400){
        	sum = BASIC_FEE_LEVEL_3;
        }
        System.out.println(sum);

        if( usage <= 200 ){
        	sum += usage * USING_FEE_LEVEL_1;
        } else if( usage > 200 && usage <= 400){
        	sum += 200 * USING_FEE_LEVEL_1 + (usage-200) * USING_FEE_LEVEL_2;
        } else if( usage > 400){
        	sum += 200 * USING_FEE_LEVEL_1 + 200 * USING_FEE_LEVEL_2 + (usage-400) * USING_FEE_LEVEL_3;
        }
        System.out.println(sum);

        if (usage <= 200) {
        	sum -= 4000;
        }
        System.out.println(sum);

        if (person >= 5) {
        	double discount = sum * 0.3;
        	if (discount > 16000) {
        		sum -= 16000;
        	} else {
        		sum -= Math.floor(discount);
        	}
        }
        System.out.println(sum);


        sum = sum/10*10;
        System.out.println(sum);


        return sum;
    }
}

/*******************************************************************************
3. 친밀도 구하기
*******************************************************************************/
public class AffinityScore {

    private Map<Character, Integer> map = new HashMap<Character, Integer>();

    public AffinityScore() {
        map.put('A', 3); map.put('B', 3); map.put('C', 1); map.put('D', 2); map.put('E', 4); map.put('F', 3);
        map.put('G', 3); map.put('H', 3); map.put('I', 3); map.put('J', 2); map.put('K', 3); map.put('L', 2);
        map.put('M', 4); map.put('N', 3); map.put('O', 1); map.put('P', 2); map.put('Q', 2); map.put('R', 3);
        map.put('S', 1); map.put('T', 2); map.put('U', 1); map.put('V', 2); map.put('W', 4); map.put('X', 2);
        map.put('Y', 3); map.put('Z', 3);
    }

    /**
     * 짧은 길이의 이름을 긴 이름만큼 확장하는 메소드
     * (문자의 자리 수를 동일하게 처리함)
     *
     * @param  largeName 긴 이름
     * @param  smallName 짧은 이름
     * @return 짧은 이름을 확장한 결과
     */
    public String makeSameLength( String largeName, String smallName ) {

        //TODO 아래에 프로그램을 작성하시오.
    	String result = "";

    	int reCount = largeName.length() / smallName.length();
    	int addCount = largeName.length() % smallName.length();

//    	System.out.println(reCount + " " + addCount);
    	while (reCount > 0){
    		result = result + smallName;
    		reCount--;
    	}

    	if (addCount > 0) {
    		result = result + smallName.substring(0, addCount);
    	}

//    	System.out.println(result);
        return result;
    }

    /**
     * 두 사람의 이름을 한 글자씩 번갈아 배치하고, 각 문자를 획수로 변환하는 메소드
     *
     * @param  nameOne 이름1
     * @param  nameTwo 이름2
     * @return 이름을 획수로 변환한 결과
     */
    public int[] crossAssign( String nameOne, String nameTwo ) {

    	int[] result = new int[nameOne.length()*2];

    	for(int i = 0; i < nameOne.length(); i++){
    		result[i*2] = map.get(nameOne.charAt(i));
    		result[i*2+1] = map.get(nameTwo.charAt(i));
    	}

//    	System.out.println(Arrays.toString(result));

        return result;
    }

    /**
     * 친밀도를 계산하는 메소드
     *
     * @param  data 이름을 획수로 변환한 데이터
     * @return 친밀도 결과
     */
    public String crossAssign( int[] data ) {

        //TODO 아래에 프로그램을 작성하시오.
    	int[] result = data.clone();

    	for(int i = 0; i < data.length-2; i++){
    		for(int j = 0; j < data.length-1-i; j++){
    			result[j] = (result[j] + result[j+1])%10;
    		}
    		System.out.println(Arrays.toString(result));
    	}

        return String.valueOf(result[0]) + String.valueOf(result[1]);
    }
}

/*******************************************************************************
2018년 1회
1. Sum List
*******************************************************************************/
public class SumList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList<Integer> list1 = new LinkedList<Integer>();
		LinkedList<Integer> list2 = new LinkedList<Integer>();
//		LinkedList<Integer> result = new LinkedList<Integer>();

		list1.add(7);
		list1.add(1);
		list1.add(6);

		list2.add(5);
		list2.add(9);
		list2.add(2);

		System.out.println(list1);
		System.out.println(list2);

		ListIterator<Integer> reverse1 = list1.listIterator(list1.size());
		ListIterator<Integer> reverse2 = list2.listIterator(list2.size());

		String num1 = "";
		String num2 = "";

		while (reverse1.hasPrevious()){
		    num1 = num1 + reverse1.previous();
		}
		while (reverse2.hasPrevious()){
		    num2 = num2 + reverse2.previous();
		}

		int sum = Integer.parseInt(num1) + Integer.parseInt(num2);
//		System.out.println(num1 + " + "  + num2 + " = " + sum);

		LinkedList<Integer> result = new LinkedList<Integer>();
		while(sum > 0){
			result.add(sum % 10);
			sum = sum / 10;
		}
		System.out.println(result);


	}

}

/*******************************************************************************
2. 도서관리(하-결함예방)
*******************************************************************************/
package com.lgcns.tct.bookmanagement;

import java.util.ArrayList;
import java.util.List;

public class BookManagement {

	/**
	 * 초기 도서 목록 데이터를 이름순으로 정렬하는 메서드
	 *
	 * @param[in] books		초기화된 도서 목록 데이터
	 * @return	books	이름순으로 정렬된 도서 목록 데이터
	 */
	public List<String> sortBooks(List<String> books){
		for(int i=0; i<books.size(); i++) {
			String temporaryVariable = "";
			for(int j=0; j<books.size()-1; j++) {
				if(books.get(j).compareTo(books.get(j+1))>0) {
					temporaryVariable = books.get(j);
					books.set(j,books.get(j+1));
					books.set(j+1, temporaryVariable);
				}
			}
		}
		return books;
	}

	/**
	 * 기준연도에 따라 최신 도서를 추출하는 메서드
	 *
	 * @param[in] sortedBooks	이름순으로 정렬된 도서 목록 데이터
	 * @param[in] basicPeriod	기준연도
	 * @return	extractedBooks	기준연도에 따라 추출된 도서 목록 데이터
	 */
	public List<String> extractLatestBooks(List<String> sortedBooks, int basicPeriod){
		List<String> extractedBooks = new ArrayList<String>();
		for(int i=0; i<sortedBooks.size(); i++) {
			int index = sortedBooks.get(i).indexOf("_")+1;
			String yearData = sortedBooks.get(i).substring(index);
			int convertYear = Integer.parseInt(yearData);
			if(convertYear>basicPeriod) {
				extractedBooks.add(sortedBooks.get(i));
			}
		}
		return extractedBooks;
	}
}

/*******************************************************************************
3. 공통 상위 부서 검색
*******************************************************************************/
public class SearchCommonUpperDept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] deptinfo = { { "CEO", "-" },
	            { "CTO", "CEO" },
	            { "CHO", "CEO" },
	            { "CFO", "CEO" },
	            { "기술담당", "CTO" },
	            { "품질담당", "CTO" }, 			                                                                                           	                { "재무담당", "CFO" },
	            { "회계담당", "CFO" },
	            { "인사담당", "CHO" },
	            { "교육담당", "CHO" },
	            { "기술1팀", "기술담당" },
	            { "기술2팀", "기술담당" },
	            { "재무1팀", "재무담당" },
	            { "재무2팀", "재무담당" } };

		String thisDept = "기술담당";
		String thatDept = "품질담당";

		System.out.println("검색부서 : " + thisDept + " / "+ thatDept);

		ArrayList<String> thisList = new ArrayList<String>();
		ArrayList<String> thatList = new ArrayList<String>();

		String result = "";
		String preDept = thisDept;
		while ( ! preDept.equals("-")){
//			System.out.println(deptinfo.length);
			for(int i = 0; i< deptinfo.length; i++){
//				System.out.println(preDept + " : " + deptinfo[i][0]);
				if(preDept.equals(deptinfo[i][0])){
					thisList.add(deptinfo[i][0]);
					preDept = deptinfo[i][1];
				}
			}
		}
		System.out.println(thisList);

		preDept = thatDept;
		while ( ! preDept.equals("-")){
//			System.out.println(deptinfo.length);
			for(int i = 0; i< deptinfo.length; i++){
//				System.out.println(preDept + " : " + deptinfo[i][0]);
				if(preDept.equals(deptinfo[i][0])){
					thatList.add(deptinfo[i][0]);
					preDept = deptinfo[i][1];
				}
			}
		}
		System.out.println(thatList);

		int match = 0;
		for(String s : thisList) {
			for(String ss : thatList){
				if( s.equals(ss)) {
					result = s;
					match = 1;
					break;
				}
			}
			if(match == 1) break;
		}
		System.out.println("공통부서 : " + result);
	}

}

/*******************************************************************************
2018년 2회
1. 최대합 구하기
*******************************************************************************/
public class MaxSum {
	static final int ARRAY_LENGTH = 5;
	/**
	 * 초기 배열 상태에서 음수는 0으로, 100보다 큰 수는 모두 100으로 나눈 나머지를 취한다.
	 *
	 * @param[in] numData	2차원 정수 배열
	 * @return 				조건에 따라서 전처리된 2차원 배열
	 */
	public static int[][] replaceData(int[][] numData){

		int[][] retData = new int[ARRAY_LENGTH][ARRAY_LENGTH];

		////////////////////////// 여기부터 코딩 (1) ---------------->
		for(int i =0 ;i < numData.length; i++){
			for(int j=0; j < numData.length; j++ ){
				if(numData[i][j] < 0) {
					retData[i][j] = 0;
				} else if(numData[i][j] > 100) {
					retData[i][j] = numData[i][j] % 100;
				} else {
					retData[i][j] = numData[i][j];
				}
			}
		}

		/////////////////////////// <-------------- 여기까지 코딩 (1)

		return retData;
	}

	/**
	 * 2x2 크기의 배열의 최대합을 구한다.
	 *
	 * @param[in] numData	요구 사항에 맞춰 처리된 2차원 정수 배열
	 * @return				최대합
	 */
	public static int getMaxSum(int[][] numData){

		int maxSum = 0;

		////////////////////////// 여기부터 코딩 (2) ---------------->

		for(int i =0 ;i < numData.length-1; i++){
			for(int j=0; j < numData.length-1; j++ ){
				int tempSum = numData[i][j] + numData[i][j+1] + numData[i+1][j] + numData[i+1][j+1];
				if(tempSum > maxSum){
					maxSum = tempSum;
				}
			}
		}

		/////////////////////////// <-------------- 여기까지 코딩 (2)

		return maxSum;
	}
}

/*******************************************************************************
2. 거울에 촬영된 사진을 복구(하-오류수정)
*******************************************************************************/
package com.lgcns.tct.picture;

public class PictureCorrection {
	static final int  MAX_SIZE =  128; // 최대 사진 크기.

	/**
	 * 2차원 사진  배열을 좌우 반전 시킨다.
	 *
	 * @param[in] photoAry	2차원 사진 배열
	 * @param[in] height	사진 배열의 행 개수
	 * @param[in] width		사진 배열의 열 개수
	 * @return 				좌우 반전된 2차원 사진 배열
	 */
	public static char[][] reversalPhoto(char photoAry[][], int height, int width) {
		char[][] retAry;
		retAry=new char[MAX_SIZE][MAX_SIZE]; // 사진을 좌우 반전시킨 2차원 배열.
		int i,k;
	    for ( i=0; i<height; i++) {
	    	for ( k=0; k<width; k++) {
	            retAry[i][width-k-1] = photoAry[i][k];
	        }
	    }
	    return retAry; // 좌우 반전된 2차원 배열.
	}

	/**
	 * 2차원 사진  배열을 2배 확대 시킨다.
	 *
	 * @param[in] photoAry	2차원 사진 배열
	 * @param[in] height	사진 배열의 행 개수
	 * @param[in] width		사진 배열의 열 개수
	 * @return				2배 확대된 2차원 사진 배열
	 */
	public static char[][] zoomScale(char photoAry[][], int height, int width) {

		char[][] retAry=new char[MAX_SIZE][MAX_SIZE];
		int i,k;

		for ( i=0; i<height; i++) {
	    	for ( k=0; k<width; k++) {
				retAry[2*i][2*k] = photoAry[i][k];
				retAry[2*i][2*k+1] = photoAry[i][k];
				retAry[2*i+1][2*k] = photoAry[i][k];
				retAry[2*i+1][2*k+1] = photoAry[i][k];
			}
		}

	    return retAry;
	}

	/**
	 * 2차원 사진 배열을 왼쪽으로 90도 회전시킨다.
	 *
	 * @param[in] photoAry	2차원 사진 배열
	 * @param[in] height	사진 배열의 행 개수
	 * @param[in] width		사진 배열의 열 개수
 	 * @return				왼쪽으로 90도 회전된 2차원 사진 배열
	 */
	public static char[][] rotatePhoto(char photoAry[][], int height, int width) {

		char[][] retAry=new char[MAX_SIZE][MAX_SIZE];

		int i,k;

		for ( i=0; i<height; i++) {
	    	for ( k=0; k<width; k++) {
				retAry[width-k-1][i] = photoAry[i][k];
			}
		}

	    return retAry;
	}

	/**
	 * 2차원 사진 배열에 테두리를 추가한다.
	 *
	 * @param[in] photoAry	2차원 사진 배열
	 * @param[in] height	사진 배열의 행 개수
	 * @param[in] width		사진 배열의 열 개수
	 * @return				테두리가 추가된 2차원 사진 배열
	 */
	public static char[][] drawEdge(char photoAry[][], int height, int width) {
		char[][] retAry=new char[MAX_SIZE][MAX_SIZE];

		int i,k;

		for ( i=0; i<height+2; i++) {
	    	for ( k=0; k<width+2; k++) {
				retAry[i][k] = '*';
			}
		}

		for ( i=1; i<height+1; i++) {
	    	for ( k=1; k<width+1; k++) {
				retAry[i][k] = photoAry[i-1][k-1];
			}
		}

	    return retAry;
	}
}

/*******************************************************************************
3. LG 편의점의 판매 물품 결산
*******************************************************************************/
package com.lgcns.tct.lgstore;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class LGStore {

	static final int  PRODUCT_TYPE_NUM = 13; // 편의점에서 판매하는 물품의 종류 개수.
	static final int  MAX_KIND = 500;  // 하루 최대 판매된 물품 개수.
	static final int  MAX_DISTINCTION_KIND = 100; // 최대 물품 종류 개수.
	static final int MAX_TEXT_LENGTH = 20; // 물품코드의 최대 글자 수.

	/**
	 * 제공된 데이터에서 숫자, 특수문자, 공백을 제거하고 소문자로 변환한다.
	 *
	 * @param[in] saleKind		판매된 물품 코드 문자열 배열
	 * @param[in] saleNumber	판매된 물품의 개수
	 * @return					숫자, 공백, 특수문자가 제거된 소문자 문자열 배열.
	 */
	public static String[] makeNormalData(String[] saleKind, int saleNumber) {

		String[]  retData= new String[MAX_KIND];

		/////////////////  여기부터 코딩 (1) -------->
		String match = "[^\\uAC00-\\uD7A3xfe0-9a-zA-Z\\\\s]";

		for(int i = 0; i < saleNumber; i++) {
			retData[i] = saleKind[i].replaceAll(match, "").toLowerCase();
		}

	    /////////////////  <------------- 여기까지코딩 (1)

		return retData;
}

	/**
	 * 순서가 바뀐 글자의 순서를 올바른 순서로 바로 잡는다.
	 *
	 * @param[in] saleKind		판매된 물품 코드 문자열 배열
	 * @param[in] saleNumber	판매된 물품의 개수
	 * @param[in] products		편의점에서 판매하는 물품 코드 배열 (13종 고정)
	 * @return					글자의 순서가 올바른 순서로 정돈된 문자열 배열.
	 */
	public static String[] correctLetterOrder(String[] saleKind, int saleNumber, String[] products){

		String[]  retData= new String[MAX_KIND];

		/////////////////  여기부터 코딩 (2) -------->

		for(int i = 0; i < saleNumber; i++) {
			String[] tokens = saleKind[i].split("");

			Arrays.sort(tokens);
//			System.out.println(Arrays.toString(tokens));

			for(int j = 0; j < products.length; j++) {
				String[] tokensProducts = products[j].split("");
				Arrays.sort(tokensProducts);

				if(Arrays.equals(tokens, tokensProducts)) {
					retData[i] = products[j];
					break;
				}
			}

		}

		/////////////////  <------------- 여기까지코딩 (2)

		return retData;
	}


	/**
	 * 중복된 물품을 제거하고 정렬한다. 버전 1
	 *
	 * @param[in] saleKind		소문자로만 구성된 물품 코드 문자열 배열
	 * @param[in] saleNumber	판매된 물품의 개수
	 * @return					중복이 제거된 문자열 배열
	 */
	public static String[] makeDistinctedData(String[] saleKind, int saleNumber) {

		String[] retData=new String[MAX_DISTINCTION_KIND];

		/////////////////  여기부터 코딩 (3) -------->

		HashMap<String, String> list = new HashMap<String, String>();

		for(int i = 0; i < saleNumber; i++ ) {
			list.put(saleKind[i], saleKind[i]);
		}

		Set<String> keys = list.keySet();

		TreeMap<String, String> tMap = new TreeMap<String, String>();


		for (String key : keys) {
			tMap.put(key.substring(1,2)+key.substring(0,1), key);
			System.out.println(key.substring(1,2)+key.substring(0,1) + " " + key);
		}

		int i = 0;
		Iterator<String> iteratorKey = tMap.keySet().iterator();
		while(iteratorKey.hasNext()) {
			retData[i] = tMap.get(iteratorKey.next());
			i++;
		}

	    /////////////////  <------------- 여기까지코딩 (3)

	    return retData;
	}

	/**
	 * 중복된 물품을 제거하고 정렬한다. 버전 2
	 *
	 * @param[in] saleKind		소문자로만 구성된 물품 코드 문자열 배열
	 * @param[in] saleNumber	판매된 물품의 개수
	 * @return					중복이 제거된 문자열 배열
	 */
	public static String[] makeDistinctedData(String[] saleKind, int saleNumber) {

		String[] retData=new String[MAX_DISTINCTION_KIND];

		/////////////////  여기부터 코딩 (3) -------->

		HashSet<String> set = new HashSet<String>();

		for(int i = 0; i < saleNumber; i++ ) {
			set.add(saleKind[i]);
		}

		Comparator<String> comp = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				String s1 = o1.substring(1, 2);
				String s2 = o2.substring(1, 2);

				if (s1.equals(s2)){
					s1 = o1.substring(0, 1);
					s2 = o2.substring(0, 1);
					return s1.compareTo(s2);
				} else 	{
					return s1.compareTo(s2);
				}
//				if(o1.substring(1, 2).compareTo(o2.substring(1, 2)) == 0){
//					return o1.substring(0, 1).compareTo(o2.substring(0, 1));
//				} else {
//					return o1.substring(1, 2).compareTo(o2.substring(1, 2));
//				}
			}
		};

		ArrayList<String> list = new ArrayList<String>(set);

//		list.addAll(set);

		Collections.sort(list, comp);

		retData =  list.toArray(retData);

			/////////////////  <------------- 여기까지코딩 (3)

			return retData;
	}

}

/*******************************************************************************
4. 초과근무 시간 계산하기
*******************************************************************************/
package com.lgcns.tct.overtime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class OverTime {

	static final int  MAX_SIZE = 128; // 최대 배열 행 개수.
	static final int  COL_SIZE = 6;  // 배열의 열 개수(사번, 시작(시), 시작(분), 종료(시), 종료(분), 출장여부)

	/**
	 * 원본 테이블을 정렬한다.
	 *
	 * @param[in] otTable		하루의 근무시간이 기록된 2차원 배열
	 * @param[in] row			데이터의 건수(=행 개수)
	 * @return					정렬된 2차원 테이블.
	 */
	public static int[][] sortTableByEmpno(int otTable[][], int row) {

		int retTable[][] = new int[MAX_SIZE][6];

		/////////////////  여기부터 코딩 (1) -------->

		Comparator<int[]> comp = new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				int no1 = o1[0];
				int no2 = o2[0];

				if (no1 == no2) {
					int startTime1 = o1[1] * 60 + o1[2];
					int startTime2 = o2[1] * 60 + o2[2];
					return startTime1 - startTime2;
				} else {
					return no1 - no2;
				}
			}
		};

		Arrays.sort(otTable, comp);

		retTable = otTable;

		/////////////////  <------------- 여기까지코딩 (1)

	   return retTable;
	}


	/**
	 * 정상적으로 초과근무를 한 사원수를 구한다.
	 *
	 * @param[in] otTable		하루의 근무시간이 기록된 2차원 배열
	 * @param[in] row			데이터의 건수(=행 개수)
	 * @return					정상적으로 초과근무한 사원 수
	 */
	public static int countEmployeeNumber(int otTable[][], int row) {

		int empNumber=0;

		/////////////////  여기부터 코딩 (2) -------->

		HashSet<Integer> set = new HashSet<Integer>();

		for(int i = 0; i < row; i++) {
			if(otTable[i][3] != 0 && otTable[i][4] != 0) {
				set.add(otTable[i][0]);
			}
		}
		empNumber = set.size();

	    /////////////////  <------------- 여기까지코딩 (2)

	    return empNumber;
	}


	/**
	 * 총 사원별 초과 근무시간 테이블을 만든다.
	 *
	 * @param[in] otTable		사원번호로 오름차순 정렬된 2차원 배열
	 * @param[in] row			데이터의 건수(=행 개수)
	 * @@return					총 초과 근무시간이 계산된 2차원 테이블.
	 */
	public static int[][] makeTotalTable(int otTable[][], int row) {

		int[][] retTable=new int[MAX_SIZE][2];
		HashSet<Integer> set = new HashSet<Integer>();

		/////////////////  여기부터 코딩 (3) -------->

		int[][] list = new int[MAX_SIZE][6];


		int outOfOffice = 0;
		int no = 0;

		int cnt = -1;

		for(int i = 0; i < otTable.length; i++) {
			if(otTable[i][3] != 0 && otTable[i][4] != 0) {
				set.add(otTable[i][0]);
				if(otTable[i][0] == no) {
					list[cnt][3] = otTable[i][3];
					list[cnt][4] = otTable[i][4];

					if(otTable[i][5] > outOfOffice) list[cnt][5] = otTable[i][5];

				}
				else {
					cnt++;
					no= otTable[i][0];

					list[cnt][0] = otTable[i][0];
					list[cnt][1] = otTable[i][1];
					list[cnt][2] = otTable[i][2];
					list[cnt][3] = otTable[i][3];
					list[cnt][4] = otTable[i][4];

					if(otTable[i][5] > outOfOffice) list[cnt][5] = otTable[i][5];
				}
			}
		}

		for(int i = 0; i < set.size(); i++) {
			System.out.println(Arrays.toString(list[i]));

			double workMin = (list[i][3] - list[i][1])*60 - list[i][2] + list[i][4];
			if (list[i][5] == 1) {
				 workMin = workMin*1.5;
			}
			retTable[i][0] = list[i][0];
			retTable[i][1] = (int)workMin;
		}

	    /////////////////  <------------- 여기까지코딩 (3)

	    return retTable;

	}
}

/*******************************************************************************
2018년 기출문제 1
1. 실시간 검색어
*******************************************************************************/
package com.lgcns.tct.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Search {


	/**
	 * 유효한 검색어 목록을 추출하는 기능
	 *
     * @param		inputData		List		입력데이터(검색어 목록)
     * @return						List		유효한 검색어
	 */
	public List<String> getValidWordList(List<String> inputData) {
		List<String> validWordList = null;
		validWordList = new ArrayList<String>();
		////////////////////////여기부터 구현 (1) ---------------->

		for (int i = 0 ; i < inputData.size() ; i++){
			String str = inputData.get(i);
			if(!str.matches(".*[0-9].*")) {
				validWordList.add(str);
			}
		}

		///////////////////////////// <-------------- 여기까지 구현 (1)
		return validWordList;
	}


	/**
	 * 실시간 검색어 순위 1위를 계산하는 기능
	 *
     * @param		validWordList		List		유효한 검색어
     * @return							String		실시간 검색어 순위 1위
	 */
	public String getSearchWord(List<String> validWordList) {
		String searchWord = "";
		////////////////////////여기부터 구현 (2) ---------------->

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0 ; i < validWordList.size() ; i++){
			String str = validWordList.get(i).toUpperCase();

			if(map.containsKey(str)) {
				map.put(str, map.get(str)+1);
			} else {
				map.put(str, 1);
			}
		}

		List<String> keySetList = new ArrayList<>(map.keySet());

		// 오름차순
//		Collections.sort(keySetList, (o1, o2) -> (map.get(o1).compareTo(map.get(o2))));

		// 내림차순
		Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

		for(String key : keySetList) {
			searchWord = key;
			break;
//			System.out.println("key : " + key + " / " + "value : " + map.get(key));
		}

		///////////////////////////// <-------------- 여기까지 구현 (2)
		return searchWord;
	}
}

/*******************************************************************************
2. 체크수
*******************************************************************************/
package com.lgcns.tct.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Search {


	/**
	 * 유효한 검색어 목록을 추출하는 기능
	 *
     * @param		inputData		List		입력데이터(검색어 목록)
     * @return						List		유효한 검색어
	 */
	public List<String> getValidWordList(List<String> inputData) {
		List<String> validWordList = null;
		validWordList = new ArrayList<String>();
		////////////////////////여기부터 구현 (1) ---------------->

		for (int i = 0 ; i < inputData.size() ; i++){
			String str = inputData.get(i);
			if(!str.matches(".*[0-9].*")) {
				validWordList.add(str);
			}
		}

		///////////////////////////// <-------------- 여기까지 구현 (1)
		return validWordList;
	}


	/**
	 * 실시간 검색어 순위 1위를 계산하는 기능
	 *
     * @param		validWordList		List		유효한 검색어
     * @return							String		실시간 검색어 순위 1위
	 */
	public String getSearchWord(List<String> validWordList) {
		String searchWord = "";
		////////////////////////여기부터 구현 (2) ---------------->

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0 ; i < validWordList.size() ; i++){
			String str = validWordList.get(i).toUpperCase();

			if(map.containsKey(str)) {
				map.put(str, map.get(str)+1);
			} else {
				map.put(str, 1);
			}
		}

		List<String> keySetList = new ArrayList<>(map.keySet());

		// 오름차순
//		Collections.sort(keySetList, (o1, o2) -> (map.get(o1).compareTo(map.get(o2))));

		// 내림차순
		Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

		for(String key : keySetList) {
			searchWord = key;
			break;
//			System.out.println("key : " + key + " / " + "value : " + map.get(key));
		}

		///////////////////////////// <-------------- 여기까지 구현 (2)
		return searchWord;
	}
}

/*******************************************************************************
3. 나누기
*******************************************************************************/
package com.lgcns.tct.division;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Division {


	/**
	 * 연산결과를 구하는 기능
	 *
     * @param		inputData		int			입력데이터(숫자)
     * @return						int			연산 결과
	 */
	public int getOperationResult(int inputData){
		int operationResult = 0;
		//////////////////////여기부터 구현 (1) ---------------->

		String str = Integer.toString(inputData);
		String result = "";
		str = str.replaceAll("0", "1");
//		System.out.println(str);

		String[] tokens = str.split("");

		for(int i = 0; i < tokens.length-1; i++) {
			if(Integer.parseInt(tokens[i]) >= Integer.parseInt(tokens[i+1])) {
				result += Integer.toString(Integer.parseInt(tokens[i]) / Integer.parseInt(tokens[i+1]));
			} else {
				result += Integer.toString(Integer.parseInt(tokens[i]) % Integer.parseInt(tokens[i+1]));
			}
//			System.out.println(result);
		}
		operationResult = Integer.parseInt(result);

		///////////////////////////// <-------------- 여기까지 구현 (1)
		return operationResult;
	}

	/**
	 * 중복을 제거한 수를 만드는 기능
	 *
     * @param		operationResult		int			연산 결과
     * @return							int			중복을 제거한 수
	 */
	public int getNumber(int operationResult){
		int number = 0;
		//////////////////////여기부터 구현 (2) ---------------->

		String str = Integer.toString(operationResult);
		String[] tokens = str.split("");
		String result = "";

		Set<String> set = new LinkedHashSet<String>();

		for(int i = 0; i < tokens.length; i++) {
			set.add(tokens[i]);
		}

		for(String temp : set) {
			result += temp;
		}

		number = Integer.parseInt(result);
		///////////////////////////// <-------------- 여기까지 구현 (2)
		return number;
	}

}

/*******************************************************************************
4. 이름 정렬(결함수정)
*******************************************************************************/
package com.lgcns.tct.name;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Name {

	/**
	 * 표기법 변환 기능
	 *
	 * @param 	inputData   	List			입력데이터(영문이름 정보)
	 * @return 					List 			표기법 변환 후 영문이름 정보
	 */
	public List<String> changeNotation(List<String> inputData) {
		List<String> changedList = new ArrayList<>();

		for(String str : inputData) {
			String[] tokens = str.split(" ");
			String result = tokens[0].substring(0,1).toUpperCase() + tokens[0].substring(1).toLowerCase();
			result += " " + tokens[1].substring(0,1).toUpperCase() + tokens[1].substring(1).toLowerCase();
			result += tokens[2].toLowerCase();
			changedList.add(result);

		}
		return changedList;
	}


	/**
	 * 동일 성씨 계산 기능
	 *
	 * @param 	changedList			List			표기법 변환 후 영문이름 정보
	 * @param 	name				String 			기준 성
	 * @return 						int 			동일 성씨 수
	 */
	public int calculateSameName(List<String> changedList, String name) {
		int numberOfSameName = 0;

		HashSet<String> removeDup = new HashSet<String>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for(String str : changedList ) {
			removeDup.add(str);
		}
//		System.out.println(removeDup);

		for(String str : removeDup ) {
			String[] tokens = str.split(" ");
			if(map.containsKey(tokens[0])) {
				map.put(tokens[0], map.get(tokens[0])+1);
			}
			else {
				map.put(tokens[0], 1);
			}
		}
//		System.out.println(map);
		if(map.containsKey(name)) numberOfSameName = map.get(name);

		return numberOfSameName;
	}

}

/*******************************************************************************
5. 배열접기
*******************************************************************************/
package com.lgcns.tct.folding;


public class Folding {


	/**
	 * 초기배열을 생성하는 기능
	 *
     * @param		inputData		int[][]		입력데이터(이차원배열)
     * @return						int[][]		생성된 초기 배열
	 */
	public int[][] getIniArr(int[][] inputData) {
		int[][] iniArr = new int[inputData.length][inputData[0].length];
		////////////////////////여기부터 구현 (1) ---------------->

		for(int i = 0; i < inputData.length; i++) {
			for(int j=0; j < inputData[0].length; j++) {
				if(inputData[i][j] >= 6) {
					iniArr[i][j] = inputData[i][j] % 5;
				} else {
					iniArr[i][j] = inputData[i][j];
				}
			}
		}
		///////////////////////////// <-------------- 여기까지 구현 (1)
		return iniArr;
	}

	/**
	 * 배열을 상하 좌우로 접는 기능
	 *
     * @param		iniArr		int[][]		생성된 초기 배열
     * @return					int[][]		상하 좌우로 접힌 배열
	 */
	public int[][] getFoldingArr(int[][] iniArr) {
		int[][] foldingArr = new int[iniArr.length / 2][iniArr[0].length];;
		////////////////////////여기부터 구현 (2) ---------------->
		int[][] foldingArr1 = new int[iniArr.length / 2][iniArr[0].length];;
		int[][] foldingArr2 = new int[iniArr.length / 2][iniArr[0].length/2];;

		for(int i = 0; i < iniArr.length/2; i++) {
			for(int j=0; j < iniArr[0].length; j++) {
				foldingArr1[i][j] = iniArr[i][j] + iniArr[iniArr.length - i-1][j];
			}
		}

		for(int i = 0; i < foldingArr1.length; i++) {
			for(int j=0; j < foldingArr1[0].length/2; j++) {
				foldingArr2[i][j] = foldingArr1[i][j] * foldingArr1[i][iniArr.length - j-1];
			}
		}

		foldingArr = foldingArr2;
		///////////////////////////// <-------------- 여기까지 구현 (2)
		return foldingArr;
	}


	/**
	 * 최종배열의 값을 구하는 기능
	 *
     * @param		foldingArr		int[][]		상하 좌우로 접힌 배열
     * @return						int			최종배열의 값
	 */
	public int getFinalValue(int[][] foldingArr) {
		int finalValue = 0;
		////////////////////////여기부터 구현 (3) ---------------->

		int[][] foldingArr1 = foldingArr.clone();

		do {
			if ((foldingArr1.length % 2) != 0) {
				int[][] foldingArr2 = new int[foldingArr1.length - 1][foldingArr1[0].length-1];;

				for(int i = 0; i < foldingArr1.length; i++) {
					for(int j=0; j < foldingArr1[0].length; j++) {
						int inx = i;
						int jnx = j;
						if(i == foldingArr1.length/2 && j == foldingArr1.length/2) break;
						if(i > foldingArr1.length/2) inx = i-1;
						if(j > foldingArr1.length/2) jnx = j-1;
						foldingArr2[inx][jnx] = foldingArr1[i][j];
					}
				}
				foldingArr1 = foldingArr2.clone();
			}
			foldingArr1 = getFoldingArr(foldingArr1);

		} while(foldingArr1.length != 1);

    	if(foldingArr1.length == 1 ) {
    		finalValue = foldingArr1[0][0];
    		return finalValue;
    	}

		///////////////////////////// <-------------- 여기까지 구현 (3)
		return finalValue;
	}

}


/*******************************************************************************
2018년 기출문제 2
1. 출산통계
*******************************************************************************/
package com.lgcns.tct.statistic;

public class Statistic {

	/**
	 * 출생아 수가 가장 많은 연도 검색 기능
	 *
	 * @param 	inputData   	int[]			입력데이터(출생아 수 데이터) ([0]:2010년, [1]:2011년, [2]:2012년, [3]:2013년, [4]:2014년, [5]:2015년, [6]:2016년)
	 * @return 					int 			출생아 수가 가장 많은 연도
	 */
	public int getMaxYear(int[] inputData) {
		int maxYear = 0;
		//////////////////////// 여기부터 구현 (1) ---------------->

		int inx = 0;
		int maxCnt = inputData[0];
		for(int i = 0; i < inputData.length; i++) {
			if(maxCnt < inputData[i]) {
				inx = i;
				maxCnt = inputData[i];
			}
		}

		maxYear = 2010+inx;

		///////////////////////////// <-------------- 여기까지 구현 (1)
		return maxYear;
	}

	/**
	 * 출생아 수가 가장 크게 감소한 연도 검색 기능
	 *
	 * @param 	inputData   	int[]			입력데이터(출생아 수 데이터) ([0]:2010년, [1]:2011년, [2]:2012년, [3]:2013년, [4]:2014년, [5]:2015년, [6]:2016년)
	 * @return 					int 			출생아 수가 가장 크게 감소한 연도
	 */
	public int getMaxDecreaseYear(int[] inputData) {
		int maxDecreaseYear = 0;
		//////////////////////// 여기부터 구현 (2) ---------------->

		int[] diffData = new int[inputData.length];

		for(int i = 0; i < inputData.length; i++) {
			if (i == 0) {
				diffData[i] = inputData[i] - inputData[i];
			} else {
				diffData[i] = inputData[i] - inputData[i-1];
			}
		}

		int inx = 0;
		int minCnt = diffData[0];

		for(int i = 0; i < diffData.length; i++) {
			if(minCnt > diffData[i]) {
				inx = i;
				minCnt = diffData[i];
			}
		}

		maxDecreaseYear = 2010+inx;

		///////////////////////////// <-------------- 여기까지 구현 (2)
		return maxDecreaseYear;
	}

}

/*******************************************************************************
2. 이상한 연산
*******************************************************************************/
package com.lgcns.tct.calculation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Calculation {


	/**
	 * 세 수를 만들어서 큰 순서로 정렬하는 기능
	 *
     * @param		inputData		String			입력데이터(숫자열)
     * @return						List			정렬된 숫자열 목록
	 */
	public List<String> sortNumbers(String inputData) {
		List<String> sortedNumbers = null;

		////////////////////////여기부터 구현 (1) ---------------->

		sortedNumbers = new ArrayList<>();

		String[] tokens = inputData.split("");
		String str = "";

		for(int i = tokens.length-1; i >= 0; i=i-3) {
			if ( i == 0 ) {
				str = tokens[i] + "21";
			}else if ( i == 1 ) {
				str = tokens[i-1] +tokens[i] + "1";
			} else {
				str = tokens[i-2]+ tokens[i-1] + tokens[i];
			}

			sortedNumbers.add(str);
			System.out.println(str);
		}


		Collections.sort(sortedNumbers, Comparator.reverseOrder());


		///////////////////////////// <-------------- 여기까지 구현 (1)
		return sortedNumbers;
	}

	/**
	 * 세 수를 이용하여 새로운 수를 생성하는 기능
	 *
     * @param		sortedNumbers	List			정렬된 숫자열 목록
     * @return						int				생성된 숫자
	 */
	public int generateNumber(List<String> sortedNumbers) {
		int generatedNumber = 0;
		////////////////////////여기부터 구현 (2) ---------------->

		String[][] result = new String[sortedNumbers.size()][3];

		List<String> list = new ArrayList<>();

		for(int i = 0; i < sortedNumbers.size(); i++) {
			result[i] = sortedNumbers.get(i).split("");
		}

		for(int i = 0; i < 3 ; i++) {
			int sum = Integer.parseInt(result[0][i]) + Integer.parseInt(result[1][i]) + Integer.parseInt(result[2][i]);
//			System.out.println(sum);
			if (sum >= 10) sum = sum % 10;
//			System.out.println(sum);
			list.add(Integer.toString(sum));
		}

		String num = "";
		for(String str : list) {
			num += str;
		}
		generatedNumber = Integer.parseInt(num);

		///////////////////////////// <-------------- 여기까지 구현 (2)
		return generatedNumber;
	}

}

/*******************************************************************************
3. 분리 수거
*******************************************************************************/
package com.lgcns.tct.garbage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Garbage {

	/**
	 * 가장 많이 수거된 재활용품의 종류 검색 기능
	 *
	 * @param 	inputData   	String			입력데이터(재활용품과 일반쓰레기 정보를 담고 있는 정보)
	 * @return 					List			가장 많이 수거된 재활용품 (P:플라스틱, B:비닐, S:스티로폼, W:종이)
	 */
	public List<Character> getNameList(String inputData) {
		List<Character> nameList = null;
		//////////////////////// 여기부터 구현 (1) ---------------->
//    	String inputData = "4G5P2B2S7W4G3P2S2G8B3P6B7S4W2W2P5G8S4B7P6S";

		nameList = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for(int i = 0; i < inputData.length() / 2; i++) {
			String type = inputData.substring(2*i+1, 2*i+2);
			Integer cnt = Integer.parseInt(inputData.substring(2*i, 2*i+1));
			System.out.println(type + " "  + cnt);
			if(type.equals("P") || type.equals("B") || type.equals("S") || type.equals("W") ) {
				if (map.containsKey(type)) {
					map.put(type, map.get(type)+cnt);
				} else {
					map.put(type, cnt);
				}
			}
		}

		System.out.println(map.toString());

		List<String> keySetList = new ArrayList<>(map.keySet());

		Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

		int maxCnt = 0;

		for(String key : keySetList) {
			maxCnt = map.get(key);
			break;
		}

		for(String key : keySetList) {
//			System.out.println(key + " " + map.get(key) );
			if(map.get(key) == maxCnt) {
				nameList.add(key.charAt(0));
			}
		}

		///////////////////////////// <-------------- 여기까지 구현 (1)
		return nameList;
	}

	/**
	 * 재활용품의 백분율 계산 기능
	 *
	 * @param 	inputData   	String			입력데이터(재활용품과 일반쓰레기 정보를 담고 있는 정보)
	 * @return 					int				재활용품의 백분율
	 */
	public int getRatio(String inputData) {
		int ratio = 0;
		//////////////////////// 여기부터 구현 (2) ---------------->
		///////////////////////////// <-------------- 여기까지 구현 (2)
		return ratio;
	}

}

/*******************************************************************************
4. 엘리베이터 (결함수정)
*******************************************************************************/
package com.lgcns.tct.garbage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Garbage {

	/**
	 * 가장 많이 수거된 재활용품의 종류 검색 기능
	 *
	 * @param 	inputData   	String			입력데이터(재활용품과 일반쓰레기 정보를 담고 있는 정보)
	 * @return 					List			가장 많이 수거된 재활용품 (P:플라스틱, B:비닐, S:스티로폼, W:종이)
	 */
	public List<Character> getNameList(String inputData) {
		List<Character> nameList = null;
		//////////////////////// 여기부터 구현 (1) ---------------->
//    	String inputData = "4G5P2B2S7W4G3P2S2G8B3P6B7S4W2W2P5G8S4B7P6S";

		nameList = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for(int i = 0; i < inputData.length() / 2; i++) {
			String type = inputData.substring(2*i+1, 2*i+2);
			Integer cnt = Integer.parseInt(inputData.substring(2*i, 2*i+1));
			System.out.println(type + " "  + cnt);
			if(type.equals("P") || type.equals("B") || type.equals("S") || type.equals("W") ) {
				if (map.containsKey(type)) {
					map.put(type, map.get(type)+cnt);
				} else {
					map.put(type, cnt);
				}
			}
		}

		System.out.println(map.toString());

		List<String> keySetList = new ArrayList<>(map.keySet());

		Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

		int maxCnt = 0;

		for(String key : keySetList) {
			maxCnt = map.get(key);
			break;
		}

		for(String key : keySetList) {
//			System.out.println(key + " " + map.get(key) );
			if(map.get(key) == maxCnt) {
				nameList.add(key.charAt(0));
			}
		}

		///////////////////////////// <-------------- 여기까지 구현 (1)
		return nameList;
	}

	/**
	 * 재활용품의 백분율 계산 기능
	 *
	 * @param 	inputData   	String			입력데이터(재활용품과 일반쓰레기 정보를 담고 있는 정보)
	 * @return 					int				재활용품의 백분율
	 */
	public int getRatio(String inputData) {
		int ratio = 0;
		//////////////////////// 여기부터 구현 (2) ---------------->
		///////////////////////////// <-------------- 여기까지 구현 (2)
		return ratio;
	}

}
/*******************************************************************************
5. 숫자 패드
*******************************************************************************/
package com.lgcns.tct.pad;

import java.util.ArrayList;
import java.util.Arrays;

public class Pad {

	/**
	 * 이동문자열을 추출하는 기능
	 *
	 * @param inputData String 입력데이터(문자열)
	 * @return String 이동문자열
	 */
	public String getRotationStr(String inputData) {
		String rotationStr = "";
		//////////////////////// 여기부터 구현 (1) ---------------->
//    	String inputData = "3X1U4D2R6T2K1L2D5B0L";
		for (int i = 0; i < inputData.length() / 2; i++) {
			String cnt = inputData.substring(2 * i, 2 * i + 1);
			String type = inputData.substring(2 * i + 1, 2 * i + 2);

//			System.out.println(cnt + " " + type);
			if (type.equals("U") || type.equals("D") || type.equals("L") || type.equals("R")) {
				if (Integer.parseInt(cnt) > 0) {
					rotationStr += cnt + type;
				}
			}
		}

		///////////////////////////// <-------------- 여기까지 구현 (1)
		return rotationStr;
	}

	/**
	 * 숫자패드를 이동시키는 기능
	 *
	 * @param inputNumberPad int[][] 입력데이터(숫자패드)
	 * @param rotationStr    String 이동문자열
	 * @return int[][] 이동된 숫자패드
	 */
	public int[][] getNumberPad(int[][] inputNumberPad, String rotationStr) {
		int[][] numberPad = null;
		//////////////////////// 여기부터 구현 (2) ---------------->

		int[][] changePad = new int[inputNumberPad.length][inputNumberPad.length];

		changePad = inputNumberPad.clone();

		for (int i = 0; i < rotationStr.length() / 2; i++) {
			String cnt = rotationStr.substring(2 * i, 2 * i + 1);
			String type = rotationStr.substring(2 * i + 1, 2 * i + 2);
//			System.out.println(cnt + " " + type);

			if (type.equals("U")) {
				for (int inx = 0; inx < Integer.parseInt(cnt); inx++) {
//					System.out.println("Upper==============================");

					int[][] rotatePad = new int[inputNumberPad.length][inputNumberPad.length];
					for (int j = 0; j <  inputNumberPad.length; j++) {
						for (int k = 0; k < inputNumberPad.length; k++) {
							rotatePad[j][k] = changePad[j][k];
						}
				    }

					for (int jnx = 0; jnx < inputNumberPad.length; jnx++) {

						if (jnx == (inputNumberPad.length - 1)) {
							changePad[jnx] = rotatePad[0];
						} else {
							changePad[jnx] = rotatePad[jnx + 1];
						}
//						System.out.println(Arrays.toString(changePad[jnx]));
					}
				}
			} else if (type.equals("D")) {
				for (int inx = 0; inx < Integer.parseInt(cnt); inx++) {
//					System.out.println("Down==============================");

					int[][] rotatePad = new int[inputNumberPad.length][inputNumberPad.length];
					for (int j = 0; j <  inputNumberPad.length; j++) {
						for (int k = 0; k < inputNumberPad.length; k++) {
							rotatePad[j][k] = changePad[j][k];
						}
				    }

					for (int jnx = 0; jnx < inputNumberPad.length; jnx++) {

						if (jnx == 0) {
							changePad[jnx] = rotatePad[inputNumberPad.length - 1];
						} else {
							changePad[jnx] = rotatePad[jnx - 1];
						}
//						System.out.println(Arrays.toString(changePad[jnx]));
					}
				}
			} else if (type.equals("L")) {
				for (int inx = 0; inx < Integer.parseInt(cnt); inx++) {
//					System.out.println("Left==============================");

					int[][] rotatePad = new int[inputNumberPad.length][inputNumberPad.length];
					for (int j = 0; j <  inputNumberPad.length; j++) {
						for (int k = 0; k < inputNumberPad.length; k++) {
							rotatePad[j][k] = changePad[j][k];
						}
				    }

					for (int jnx = 0; jnx < inputNumberPad.length; jnx++) {
						for(int knx = 0; knx < inputNumberPad.length; knx++) {
							if (knx == (inputNumberPad.length-1)) {
								changePad[jnx][knx] = rotatePad[jnx][0];
							} else {
								changePad[jnx][knx] = rotatePad[jnx][knx+1];
							}
						}
//						System.out.println(Arrays.toString(changePad[jnx]));
					}
				}
			} else if (type.equals("R")) {

			for (int inx = 0; inx < Integer.parseInt(cnt); inx++) {
//				System.out.println("Right==============================");

				int[][] rotatePad = new int[inputNumberPad.length][inputNumberPad.length];
				for (int j = 0; j <  inputNumberPad.length; j++) {
					for (int k = 0; k < inputNumberPad.length; k++) {
						rotatePad[j][k] = changePad[j][k];
					}
			    }

				for (int jnx = 0; jnx < inputNumberPad.length; jnx++) {
					for(int knx = 0; knx < inputNumberPad.length; knx++) {
						if (knx == 0) {
							changePad[jnx][knx] = rotatePad[jnx][inputNumberPad.length-1];
						} else {
							changePad[jnx][knx] = rotatePad[jnx][knx-1];
						}
					}
//					System.out.println(Arrays.toString(changePad[jnx]));
				}
			}
		}


	}
		numberPad = changePad.clone();
		///////////////////////////// <-------------- 여기까지 구현 (2)
		return numberPad;
	}
}

/*******************************************************************************
2019년 기출문제 1
1. 문자열의 특정 문자 제거하기
*******************************************************************************/
package com.lgcns.tct.trim;

public class Trim {

	/**
	 * 입력 받은 문자열에서 앞, 뒤의 특정 문자를 제거하는 기능
	 *
	 * @param 		message		입력 문자열
	 * @param 		trimStr		Trim할 문자
	 * @return		String		결과 문자열
	 */
	public String getTrimString( String message, String trimStr ) {

		String result = "";

		//////////////////////여기부터 구현 (1) ---------------->

		for(int i = 0; i < message.length(); i++) {
			if(message.substring(0, 1).equals(trimStr)) {
				message = message.substring(1, message.length() );
//				System.out.println(message);
			} else {
				break;
			}
		}

		for(int i = message.length()-1; i >= 0; i--) {
			if(message.substring(i, i+1).equals(trimStr)) {
				message = message.substring(0, i);
//				System.out.println(message);
			} else {
				break;
			}
		}

		result = message;

		///////////////////////////// <-------------- 여기까지 구현 (1)

		return result;
	}
}

/*******************************************************************************
2. 불량 퍼즐 판별하기
*******************************************************************************/
package com.lgcns.tct.puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Puzzle {

	/**
	 * 퍼즐의 구성이 정상인지 판별하는 기능
	 *
	 * @param 		puzzle		퍼즐 구성
	 * @param 		answer		해답 (퍼즐로 만들 영어 단어)
	 * @return		boolean		정상인 퍼즐(true) 또는 불량인 퍼즐(false) 여부
	 */
	public boolean isCorrectPuzzle( List<Character> puzzle, String answer ) {

		boolean isCorrect = false;

		//////////////////////여기부터 구현 (1) ---------------->

		ArrayList<String> aSet = new ArrayList<String>();
		ArrayList<String> bSet = new ArrayList<String>();

		for(Character c : puzzle) {
			aSet.add(Character.toString(c));
		}

		for(int i = 0; i < answer.length(); i++) {
			bSet.add(answer.substring(i, i+1));
		}

//		System.out.println(aSet.toString());
//		System.out.println(bSet.toString());

		Collections.sort(aSet);
		Collections.sort(bSet);

		if(aSet.equals(bSet)) {
			isCorrect = true;
		}

		///////////////////////////// <-------------- 여기까지 구현 (1)

		return isCorrect;
	}
}

/*******************************************************************************
3. 이차원 배열에 숫자 채워넣기
*******************************************************************************/
package com.lgcns.tct.numberprint;

public class NumberPrint {

	/**
	 * 가로 방향으로 숫자를 출력하는 기능
	 *
	 * @param 		width		출력할 배열의 column 수
	 * @param 		height		출력할 배열의 row 수
	 * @param 		maxNum		최대 숫자
	 * @return		int[][]		가로 방향으로 출력된 2차원 배열
	 */
	public int[][] getNumberPrintRow( int width, int height, int maxNum ) {

		int[][] numberArr = null;

		//////////////////////여기부터 구현 (1) ---------------->

		numberArr = new int[height][width];

		int num = 1;

		for(int i = 0; i < height; i++) {
			for(int j= 0; j < width; j++) {
				if(num <= maxNum) {
					numberArr[i][j] = num;
					num++;
				} else {
					numberArr[i][j] = 0;
				}
			}
		}

		///////////////////////////// <-------------- 여기까지 구현 (1)

		return numberArr;
	}

	/**
	 * 세로 방향으로 숫자를 출력하는 기능
	 *
	 * @param 		width		출력할 배열의 column 수
	 * @param 		height		출력할 배열의 row 수
	 * @param 		maxNum		최대 숫자
	 * @return		int[][]		세로 방향으로 출력된 2차원 배열
	 */
	public int[][] getNumberPrintColumn( int width, int height, int maxNum ) {

		int[][] numberArr = null;

		//////////////////////여기부터 구현 (2) ---------------->

		numberArr = new int[height][width];

		int num = 1;
		int flag = 0;

		for(int j= 0; j < width; j++) {
			for(int i = 0; i < height; i++) {
				if(flag == 0 && num < maxNum) {
					numberArr[i][j] = num;
					num++;
				} else if( flag == 0 && num == maxNum){
					numberArr[i][j] = num;
					flag = 1;
					num--;
				} else if( flag == 1 && num > 0) {
					numberArr[i][j] = num;
					num--;
				} else {
					numberArr[i][j] = 0;
				}
			}
		}


		///////////////////////////// <-------------- 여기까지 구현 (2)

		return numberArr;
	}
}

/*******************************************************************************
4. 운석 낙하 위험도 측정하기
*******************************************************************************/
package com.lgcns.tct.meteor;

import java.util.Arrays;

public class Meteor {

	/**
	 * 운석 낙하 위치의 개수를 계산하는 기능
	 *
	 * @param inputData 운석 낙하 위치 입력 데이터
	 * @return int 낙하한 운석의 개수
	 */
	public int getMeteorFallCount(String inputData) {

		int count = 0;
		////////////////////// 여기부터 구현 (1) ---------------->

		String[] tokens = inputData.split("#");
		String[][] input = new String[tokens.length][3];

		for (int i = 0; i < tokens.length; i++) {

			input[i][0] = tokens[i].substring(0, tokens[i].indexOf("*"));
			input[i][1] = tokens[i].substring(tokens[i].indexOf("(") + 1, tokens[i].indexOf(","));
			input[i][2] = tokens[i].substring(tokens[i].indexOf(",") + 1, tokens[i].indexOf(")"));
			System.out.println(Arrays.deepToString(input[i]));
		}

		for (int i = 0; i < input.length; i++) {

			int x = Integer.parseInt(input[i][1]);
			int y = Integer.parseInt(input[i][2]);

			if (x >= 0 && x <= 14 && y >= 0 && y <= 14)
				count++;
		}

		///////////////////////////// <-------------- 여기까지 구현 (1)

		return count;
	}

	/**
	 * 위험도 2 이상의 지역의 개수를 계산하는 기능
	 *
	 * @param inputData 운석 낙하 위치 입력 데이터
	 * @return int 운석 낙하 위험도 2 이상 지역의 개수
	 */
	public int getMeteorDangerAreaCount(String inputData) {

		int count = 0;

		////////////////////// 여기부터 구현 (2) ---------------->
		String[] tokens = inputData.split("#");
		String[][] input = new String[tokens.length][3];
		int[][] array = new int[15][15];

		for (int i =0; i < 15; i++) {
			for (int j =0; j < 15; j++) {
				array[i][j] = 0;
			}
		}

		for (int i = 0; i < tokens.length; i++) {
			input[i][0] = tokens[i].substring(0, tokens[i].indexOf("*"));
			input[i][1] = tokens[i].substring(tokens[i].indexOf("(") + 1, tokens[i].indexOf(","));
			input[i][2] = tokens[i].substring(tokens[i].indexOf(",") + 1, tokens[i].indexOf(")"));
			System.out.println(Arrays.deepToString(input[i]));
		}

		for (int i = 0; i < input.length; i++) {
			int p = Integer.parseInt(input[i][0]);
			int x = Integer.parseInt(input[i][1]);
			int y = Integer.parseInt(input[i][2]);

			if (x < 0 || x >= 15 || y < 0 || y >= 15) continue;

			while(p > 0) {
				int startX = (x-p+1);
				int startY = (y-p+1);
				int interval = (2*p-1);
				System.out.println(p + " " + x + " " + y + " " + startX +" " + startY + " " + interval);

				for(int inx = startX; inx < startX + interval; inx++) {
					for(int jnx = startY; jnx < startY + interval; jnx++) {
						if (inx >= 0 && inx <= 14 && jnx >= 0 && jnx <= 14)
							array[inx][jnx] += 1;
					}
				}
				p--;
			}
		}

		for(int i = 0; i < 15; i++) {
			System.out.println(Arrays.toString(array[i]));
		}

		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 15; j++) {
				if(array[i][j] >= 2) count++;
			}
		}

		///////////////////////////// <-------------- 여기까지 구현 (2)

		return count;
	}
};

/*******************************************************************************
2019년 기출문제 2
1. 대소문자 변환하2
*******************************************************************************/
package com.lgcns.tct.change;

public class ChangeCase {

	/**
	 * 영문 대/소문자를 변환하는 기능
	 *
	 * @param 		inputData		입력 데이터 (문자열)
	 * @return		String			대/소문자 변환 결과
	 */
	public String changeCase( String inputData ) {

		String result = "";

		////////////////////////여기부터 코딩 (1) ---------------->

		for(int i = 0; i < inputData.length(); i++) {
			if(inputData.substring(i, i+1).matches("^[a-z]*$")) {
				result += inputData.substring(i, i+1).toUpperCase();
			}
			if(inputData.substring(i, i+1).matches("^[A-Z]*$")) {
				result += inputData.substring(i, i+1).toLowerCase();
			}
//			System.out.println(result);

		}

		///////////////////////////// <-------------- 여기까지 코딩 (1)

		return result;
	}
}

/*******************************************************************************
2. 사다리 게임 결과 구하기
*******************************************************************************/
package com.lgcns.tct.ladder;

public class Ladder {

	/**
	 * 주어진 사다리 정보를 이용하여 시작 번호에 대한 결과 번호를 구하는 기능
	 *
	 * @param  		ladderData		사다리 정보
	 * @param  		startNo			시작 번호
	 * @return 		int				결과 번호
	 */
	public int getResultNo( int[][] ladderData, int startNo ) {

		int resultNo = 0;

		////////////////////////여기부터 코딩 (1) ---------------->
//		System.out.println("\nstart");

		for(int i=0; i< ladderData.length; i++) {
			if(ladderData[i][0] == startNo) {
//				System.out.print(startNo + "==>");
				startNo= ladderData[i][1];
			} else if(ladderData[i][1] == startNo) {
//				System.out.print(startNo + "==>");
				startNo= ladderData[i][0];
			}
		}

		resultNo = startNo;

		///////////////////////////// <-------------- 여기까지 코딩 (1)

		return resultNo;
	}
}

/*******************************************************************************
3. 어린이집 원아 선발
*******************************************************************************/
package com.lgcns.tct.childcare;

import java.util.*;

public class ChildCare {

	/**
	 * 선발 제외 대상 데이터를 삭제하는 기능
	 *
	 * @param 		inputData		입력 데이터
	 * @return		List<String>	제외하고 남은 선발대상 데이터 (지원자의 사번, 순서 상관 없음)
	 */
	public List<String> getRemovedList( String inputData ) {

		List<String> removedList = new ArrayList<String>();

		////////////////////////여기부터 코딩 (1) ---------------->
		String[] tokens = inputData.split("#");
		String[][] array = new String[tokens.length][3];

		HashMap<String, Integer> target = new HashMap<String, Integer>();
		target.put("2017",4);
		target.put("2016",2);
		target.put("2015",2);
		target.put("2014",1);

		for(int i = 0; i < tokens.length; i++) {
			array[i] = tokens[i].split(",");
			if(target.containsKey(array[i][1])) {
				removedList.add(array[i][0]);
			}
		}

		///////////////////////////// <-------------- 여기까지 코딩 (1)

		return removedList;
	}

	/**
	 * 선발 대상 선정하기
	 *
	 * @param 		inputData		입력 데이터
	 * @return		List<String>	원아로 최종 선정된 선발대상 데이터 (지원자의 사번, 순서 상관 없음)
	 */
	public List<String> getSelectedList( String inputData ) {

		List<String> selectedList = new ArrayList<String>();

		////////////////////////여기부터 코딩 (2) ---------------->
		List<String> removedList = new ArrayList<String>();

		String[] tokens = inputData.split("#");

		HashMap<String, Integer> target = new HashMap<String, Integer>();
		target.put("2017",4);
		target.put("2016",2);
		target.put("2015",2);
		target.put("2014",1);

		for(int i = 0; i < tokens.length; i++) {
			String[] array = tokens[i].split(",");
			if(target.containsKey(array[1])) {
				removedList.add(array[0]);
			}
		}

		String[][] selected = new String[removedList.size()][3];
		int cnt = 0;
		for(int i = 0; i < tokens.length; i++) {
			String[] array = tokens[i].split(",");
			if(target.containsKey(array[1])) {
				selected[cnt]= array;
				cnt++;
			}
		}

		Comparator<String[]> comp = new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				// TODO Auto-generated method stub
				String s1 = o1[2];
				String s2 = o2[2];

				if (s1.equals(s2)){
					s1 = o1[0];
					s2 = o2[0];
					return s1.compareTo(s2);
				} else 	{
					return s1.compareTo(s2);
				}
			}
		};

		Arrays.sort(selected, comp);
		for(int i = 0; i < selected.length; i++) {
			System.out.println(Arrays.toString(selected[i]));
		}

		for(String year : target.keySet()) {
			int buffer = target.get(year);
			for(int i =0; i< selected.length; i++) {
				if(buffer > 0 && selected[i][1].equals(year)) {
					selectedList.add(selected[i][0]);
					buffer--;
				} else if(buffer ==0)
					break;
			}
		}


		///////////////////////////// <-------------- 여기까지 코딩 (2)

		return selectedList;
	}
}

/*******************************************************************************
4. 카드 게임 최고점 구하기
*******************************************************************************/
package com.lgcns.tct.cardgame;

import java.util.*;

public class CardGame {
	
	static int[][] cardsOfPlayer = new int[3][5];
	/**
	 * PLAYER3이 받은 카드를 구하는 기능
	 *
	 * @param 		cards			초기 카드 순서 (cards[0]이 가장 아래 카드)
	 * @param 		shuffleInfo		카드를 섞는 정보 (shuffleInfo[0]부터 순서대로 섞음)
	 * @return		int[]			PLAYER3이 받은 카드 (카드번호 오름차순 정렬)
	 */
	public int[] getCardsOfPlayer3( int[] cards, String[] shuffleInfo ) {

		int[] cardsOfPlayer3 = new int[5];

		////////////////////////여기부터 코딩 (1) ---------------->
		System.out.println(Arrays.toString(shuffleInfo));

		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < cards.length; i++) {
			list.add(cards[i]);
		}

		System.out.println(list);
		for(int i = 0; i< shuffleInfo.length; i++) {
			String[] tokens = shuffleInfo[i].split(",");
			int fromIndex = Integer.parseInt(tokens[0]);
			int toIndex =  Integer.parseInt(tokens[1]);
			for(int j = fromIndex-1; j < toIndex; j++) {
				Integer val = list.remove(fromIndex-1);
				list.add(val);
			}
			System.out.println(list);
		}

		int index = 1;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 3; j++) {
				cardsOfPlayer[j][i] = list.get(list.size()-index);
				index++;
			}
		}

		cardsOfPlayer3 = cardsOfPlayer[2];
		System.out.println(Arrays.toString(cardsOfPlayer[0]));
		System.out.println(Arrays.toString(cardsOfPlayer[1]));
		System.out.println(Arrays.toString(cardsOfPlayer[2]));
		Arrays.sort(cardsOfPlayer3);


		///////////////////////////// <-------------- 여기까지 코딩 (1)

		return cardsOfPlayer3;
	}

	/**
	 * 각 PLAYER들의 최고점을 구하는 기능
	 *
	 * @param 		cards			초기 카드 순서 (cards[0]이 가장 아래 카드)
	 * @param 		shuffleInfo		카드를 섞는 정보 (shuffleInfo[0]부터 순서대로 섞음)
	 * @return		int[]			각 PLAYER들의 최고 점수
	 *                                - int[0] : PLAYER1의 최고점
	 *                                - int[1] : PLAYER2의 최고점
	 *                                - int[2] : PLAYER3의 최고점
	 */
	public int[] getGameResult( int[] cards, String[] shuffleInfo ) {

		int[] gameResult = new int[3];

		////////////////////////여기부터 코딩 (2) ---------------->

		for(int i = 0; i < cardsOfPlayer.length; i++ ) {
			int maxScore = 0;
			for(int j=0; j< cardsOfPlayer[i].length; j++)
				for(int k=j+1; k< cardsOfPlayer[i].length; k++)
					for(int l=k+1; l< cardsOfPlayer[i].length; l++)
						for(int m=l+1; m< cardsOfPlayer[i].length; m++) {
							int sum = cardsOfPlayer[i][j]
									+ cardsOfPlayer[i][k]
									+ cardsOfPlayer[i][l]
									+ cardsOfPlayer[i][m];

							HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
							map.put(cardsOfPlayer[i][j], map.getOrDefault(cardsOfPlayer[i][j], 0)+1);
							map.put(cardsOfPlayer[i][k], map.getOrDefault(cardsOfPlayer[i][k], 0)+1);
							map.put(cardsOfPlayer[i][l], map.getOrDefault(cardsOfPlayer[i][l], 0)+1);
							map.put(cardsOfPlayer[i][m], map.getOrDefault(cardsOfPlayer[i][m], 0)+1);

							System.out.println(map);

							for(Integer count : map.values()) {
								if (count> 1) sum += (count-1)*7;
							}

							if(sum > maxScore) maxScore = sum;

						}
			gameResult[i] = maxScore;
		}


		///////////////////////////// <-------------- 여기까지 코딩 (2)

		return gameResult;
	}
}
