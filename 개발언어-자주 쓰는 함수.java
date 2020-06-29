
https://docs.oracle.com/javase/8/docs/api/

/*******************************************************************************
import
*******************************************************************************/
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;

/*******************************************************************************
Arrays
*******************************************************************************/
public static <T> List<T> asList(T... a)
public static void sort(char[] a)
public static void sort(char[] a, int fromIndex, int toIndex)
public static int binarySearch(long[] a, long key)	//사전에 정렬되어야 함
public static int binarySearch(long[] a, int fromIndex, int toIndex, long key)
public static boolean equals(long[] a, long[] a2)
public static boolean deepEquals(Object[] a1, Object[] a2)
public static void fill(long[] a, long val)
public static void fill(long[] a, int fromIndex, int toIndex, long val)
public static <T> T[] copyOf(T[] original, int newLength)
public static <T,U> T[] copyOf(U[] original, int newLength, Class<? extends T[]> newType)
public static byte[] copyOfRange(byte[] original, int from, int to)
public static String toString(long[] a)
public static String deepToString(Object[] a)

/*******************************************************************************
ArrayList
*******************************************************************************/
public int size()
public boolean isEmpty()
public boolean contains(Object o)
public int indexOf(Object o)	//The first occurrence
public int lastIndexOf(Object o)	//The last occurrence
public Object clone()
public Object[] toArray()
public <T> T[] toArray(T[] a)
public E get(int index)
public E set(int index, E element)
public boolean add(E e)
public void add(int index, E element)
public boolean addAll(Collection<? extends E> c)
public boolean addAll(int index, Collection<? extends E> c)
public E remove(int index)
public boolean remove(Object o)
protected void removeRange(int fromIndex, int toIndex)
public boolean removeAll(Collection<?> c)
public void clear()
public boolean retainAll(Collection<?> c)
public ListIterator<E> listIterator(int index)
public ListIterator<E> listIterator()
public Iterator<E> iterator()
public List<E> subList(int fromIndex, int toIndex)

/*******************************************************************************
List
*******************************************************************************/
public int getItemCount()
public String getItem(int index)
public String[] getItems()
public void add(String item)
public void add(String item, int index)
public void replaceItem(String newValue, int index)
public void removeAll()
public void remove(String item)
public void remove(int position)
boolean equals(Object o)

/*******************************************************************************
Map
*******************************************************************************/
int size()
boolean isEmpty()
V get(Object key)
V put(K key, V value)
V remove(Object key)
void putAll(Map<? extends K,? extends V> m)
boolean containsKey(Object key)
boolean containsValue(Object value)
void clear()
Object clone()
Set<K> keySet()
Collection<V> values()
Set<Map.Entry<K,V>> entrySet()
boolean equals(Object o)

/*******************************************************************************
HashMap
*******************************************************************************/
public int size()
public boolean isEmpty()
public V get(Object key)
public V getOrDefault(Object key, V defaultValue)
public V put(K key, V value)
public V remove(Object key)
public void putAll(Map<? extends K,? extends V> m)
public boolean containsKey(Object key)
public boolean containsValue(Object value)
public void clear()
public Object clone()
public Set<K> keySet()
public Collection<V> values()
public Set<Map.Entry<K,V>> entrySet()

/*******************************************************************************
TreeMap
*******************************************************************************/
public int size()
public V get(Object key)
public V put(K key, V value)
public V remove(Object key)
public void putAll(Map<? extends K,? extends V> m)
public Comparator<? super K> comparator()
public boolean containsKey(Object key)
public boolean containsValue(Object value)
public void clear()
public Object clone()
public Set<K> keySet()
public NavigableSet<K> navigableKeySet()
public NavigableSet<K> descendingKeySet()
public Collection<V> values()
public Set<Map.Entry<K,V>> entrySet()
public K firstKey()
public K lastKey()
public Map.Entry<K,V> lastEntry()
public Map.Entry<K,V> pollFirstEntry()
public Map.Entry<K,V> pollLastEntry()
public Map.Entry<K,V> lowerEntry(K key)
public K lowerKey(K key)
public Map.Entry<K,V> floorEntry(K key)
public K floorKey(K key)
public Map.Entry<K,V> ceilingEntry(K key)
public K ceilingKey(K key)
public Map.Entry<K,V> higherEntry(K key)
public K higherKey(K key)
public V replace(K key, V value)
public boolean replace(K key, V oldValue, V newValue)
public void replaceAll(BiFunction<? super K,? super V,? extends V> function)

/*******************************************************************************
Set
*******************************************************************************/
int size()
boolean isEmpty()
boolean contains(Object o)
Iterator<E> iterator()
Object[] toArray()
<T> T[] toArray(T[] a)
boolean add(E e)
boolean remove(Object o)
boolean containsAll(Collection<?> c)
boolean addAll(Collection<? extends E> c)
boolean retainAll(Collection<?> c)
boolean removeAll(Collection<?> c)
void clear()
boolean equals(Object o)

/*******************************************************************************
HashSet, LinkedHashSet
HashSet 중복 제거, 정렬
LinkedHashSet 중복 제거, 입력순서를 유지
*******************************************************************************/
public Iterator<E> iterator()
public int size()
public boolean isEmpty()
public boolean contains(Object o)
public boolean add(E e)
public boolean remove(Object o)
public void clear()
public Object clone()

/*******************************************************************************
TreeSet
*******************************************************************************/
public Iterator<E> iterator()
public Iterator<E> descendingIterator()
public int size()
public boolean isEmpty()
public boolean contains(Object o)
public boolean add(E e)
public boolean remove(Object o)
public void clear()
public boolean addAll(Collection<? extends E> c)
public SortedSet<E> subSet(E fromElement, E toElement)
public SortedSet<E> headSet(E toElement)
public SortedSet<E> tailSet(E fromElement)
public Comparator<? super E> comparator()
public E first()
public E last()
public E lower(E e)
public E floor(E e)
public E ceiling(E e)
public E higher(E e)
public Object clone()

/*******************************************************************************
iterator
*******************************************************************************/
boolean hasNext()
E next()
default void remove()
default void forEachRemaining(Consumer<? super E> action)

/*******************************************************************************
Collections
*******************************************************************************/
public static <T extends Comparable<? super T>> void sort(List<T> list)
public static <T> void sort(List<T> list, Comparator<? super T> c)
public static <T> int binarySearch(List<? extends Comparable<? super T>> list,T key)
public static <T> int binarySearch(List<? extends T> list, T key,
public static void reverse(List<?> list)
public static void shuffle(List<?> list)
public static void shuffle(List<?> list, Random rnd)
public static void swap(List<?> list, int i, int j)
public static <T> void fill(List<? super T> list, T obj)
public static <T> void copy(List<? super T> dest, List<? extends T> src)
public static <T extends Object & Comparable<? super T>> T min(Collection<? extends T> coll)
public static <T> T min(Collection<? extends T> coll, Comparator<? super T> comp)
public static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll)
public static <T> T max(Collection<? extends T> coll, Comparator<? super T> comp)
public static void rotate(List<?> list, int distance)
public static <T> boolean replaceAll(List<T> list, T oldVal, T newVal)
public static int indexOfSubList(List<?> source, List<?> target)
public static int lastIndexOfSubList(List<?> source, List<?> target)
public static <T> Comparator<T> reverseOrder()
public static <T> Comparator<T> reverseOrder(Comparator<T> cmp)
public static <T> ArrayList<T> list(Enumeration<T> e)
public static int frequency(Collection<?> c, Object o)
public static <T> boolean addAll(Collection<? super T> c, T... elements)

/*******************************************************************************
comparator
*******************************************************************************/
int compare(T o1, T o2)
boolean equals(Object obj)
default Comparator<T> reversed()
static <T extends Comparable<? super T>> Comparator<T> reverseOrder()

/*******************************************************************************
String
*******************************************************************************/
public int length()
public boolean isEmpty()
public char charAt(int index)
public boolean equals(Object anObject)
public boolean contentEquals(StringBuffer sb)
public int compareTo(String anotherString)
public int compareToIgnoreCase(String str)
public boolean startsWith(String prefix, int toffset)
public boolean startsWith(String prefix)
public boolean endsWith(String suffix)
public int indexOf(int ch)
public int indexOf(int ch, int fromIndex)
public int lastIndexOf(int ch)
public int lastIndexOf(int ch, int fromIndex)
public String substring(int beginIndex)
public String substring(int beginIndex, int endIndex)
public String concat(String str)
public String replace(char oldChar, char newChar)
public String replaceAll(String regex, String replacement)
public boolean matches(String regex)
public boolean contains(CharSequence s)
public String[] split(String regex, int limit)
public String[] split(String regex)
public String toLowerCase()
public String toUpperCase()
public String trim()
public String toString()
public char[] toCharArray()
public static String valueOf(Object obj)

/*******************************************************************************
StringBuilder
*******************************************************************************/
public StringBuilder append(String str)
public StringBuilder delete(int start, int end)
public int indexOf(String str)
public int indexOf(String str, int fromIndex)
public StringBuilder reverse()
public String toString()
public int length()
public char charAt(int index)
public String substring(int start)

/*******************************************************************************
그 외 많이 사용하는 패턴
*******************************************************************************/
// 패턴 체크
import java.util.regex.Pattern;

char ch = name.charAt(i);
if(!Pattern.matches("[가-힝]", ch+"")){
	throw new IllegalArgumentException();
}

/******************************************************************************/
// String replace, 대소문자 변화
originalStr = originalStr.replaceAll( " ", "" ).toLowerCase();
anagramStr = anagramStr.replaceAll( " ", "" ).toLowerCase();
retData[i] = saleKind[i].replaceAll("[^\\uAC00-\\uD7A3xfe0-9a-zA-Z\\\\s]", "").toLowerCase();

// String substring
// index 0부터 3의 앞자리까지 return
System.out.println("abcdefg".substring(0, 3));

// String Split
String[] tokens = list[i].split(",");

// String Split 후 특정 배열만 참조하는 경우
String year = s.split("/").[0];

// String을 char Array로 변환
char[] chars = orignalStr.toCharArray();
for(char c : chars){}

name.charAt(i);

// String 특정 문자의 위치 찾기
int index = anagramStr.indexOf("c");
int index = anagramStr.indexOf("abc", i);

// String 특정 문자 일치
product.matches("^["+kind+"]+$");

// String to int 변환
int sumSalary += Integer.parseInt(str);

/******************************************************************************/
// StringBuilder를 이용한 문자 조합
StringBuilder sb = new StringBuilder();
for (int i = 0; i < arr.length; i++)
		sb.append(arr[i]);

return sb.toString();

/******************************************************************************/
// int to String 변환
String.valueOf(in);
Integer.toString(in);

// 세 자리 숫자 135를 1, 3, 5로 분리하는 코드
int number = 135;
int num1 = number/100;
int num2 = (number-100*num1)/10;
int num3 = (number-100*num1)%10;

// 숫자 format 소수점 이하 몇자리에서 반올림
// 방법1. DecimalFormat 사용하는 방법
DecimalFormat df = new DecimalFormat("###.##");
System.out.println(df.format(avg));

// 숫자 format 382,000 형태로 출력됨
NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.KOREA);
System.out.println("정가 :" + nf.format(price) + " (할인율 : )" + discountRate + "%)");

// 방법2. *, /를 사용하는 방법
System.out.println(Math.round(avg*100)/100.0);
Math.floor(discount);

/*******************************************************************************
단축키
ctrl + / 주석, 주석해제
ctrl + F11 실행
*******************************************************************************/

// 문자에서 null 비교
if(title == null || title.length() < 4) {
if(title != null && title.length() >= 4) {

// ArrayList에서 중간에 내용을 삭제할 필요가 있는 경우
// 새로운 ArrayList를 만들어서 필요한 내용만 add한다

// Set, List, set
// ArrayList : 순서가 있는 저장공간(중복 허용), 순서정렬을 위해 사용
// HashSet, TreeSet : 집합적인 저장공간(중복 허용하지 않음)
// HashMap, TreeMap : 키와 값으로 데이터 변화(키 중복 허용하지 않음)

// StringTokennizer : 특수문자를 처리하기에 좋음, \ {} () [], token으로 return
// split : 정규식을 표현하기에 좋음, String[]로 return

/******************************************************************************/
// 정렬방법
// 오름차순인 경우 o1 - o1
// 내림차순인 경우 o2 - o1

// Collection인 경우
// ArrayList, LinkedList
Collections.sort(aSet);
Collections.sort(list, comp);
Collections.sort(sortedNumbers, Comparator.reverseOrder());

// 내림차순
List<String> keySetList = new ArrayList<>(map.keySet());
Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

// 오름차순
Collections.sort(keySetList, (o1, o2) -> (map.get(o1).compareTo(map.get(o2))));

// Array인 경우
// String[][], int[]
Arrays.sort(list);
Arrays.sort(list, comp);

// 다양한 형태로 정렬, 오름차순
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

// 다양한 형태로 정렬, 오름차순
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
	}
};

// 다양한 형태로 정렬, 내림차순
Comparator<String[]> comp = new Comparator<String[]>() {

	@Override
	public int compare(String[] o1, String[] o2) {
		// TODO Auto-generated method stub
		String s1 = o1[0];
		String s2 = o2[0];

		if (s1.equals(s2)) {
			int n1 = Integer.parseInt(o1[1]);
			int n2 = Integer.parseInt(o2[1]);
			return n2 - n1;
		} else {
			return s2.compareTo(s1);
		}
	}
};

Arrays.sort(list, comp);

/******************************************************************************/
// set에 넣은 값을 가져오는 방법
HashSet<String> set = new HashSet<String>();
for(String temp : set) {
	result += temp;
}

/******************************************************************************/
// ArrayList에 넣은 값을 가져오는 방법
for(String str : list) {
		System.out.println(str);
}

/******************************************************************************/
// HashMap에 넣은 값을 가져오는 방법
for(String key : atypeMap.keySet()) {
		list.add(atypeMap.get(key));
}

// HashMap를 이용하여 빈도를 구하는 방법
HashMap<String, Integer> map = new HashMap<String, Integer>();

for (int i = 0 ; i < validWordList.size() ; i++){
	String str = validWordList.get(i).toUpperCase();

	if(map.containsKey(str)) {
		map.put(str, map.get(str)+1);
	} else {
		map.put(str, 1);
	}
}

HashMap<String, Integer> clothesMap = new HashMap<String, Integer>(); // 종류 : 갯수
// HashMap를 이용하여 빈도를 구하는 방법

for (int i = 0; i < clothes.length; i++) {
		clothesMap.put(clothes[i][1], clothesMap.getOrDefault(clothes[i][1], 0)+1);
}

// HashMap에서 값 목록을 가져오는 방법
for (int val : clothesMap.values()){
		answer *= (val+1);
}

/******************************************************************************/
// TreeMap에 넣은 값을 가져오는 방법
TreeMap<String, String> tMap = new TreeMap<String, String>();

Iterator<String> iteratorKey = tMap.keySet().iterator();
while(iteratorKey.hasNext()) {
	retData[i] = tMap.get(iteratorKey.next());
	i++;
}

/******************************************************************************/
// LinkedList에 넣은 값을 가져오는 방법
LinkedList<Integer> list1 = new LinkedList<Integer>();

ListIterator<Integer> reverse1 = list1.listIterator(list1.size());

while (reverse1.hasPrevious()){
		num1 = num1 + reverse1.previous();
}

/******************************************************************************/
// 배열 출력
String [] list =  new String[employee.length];
System.out.println(Arrays.toString(list));

// 배열 복사
// clone과 arraycopy의 차이점이 뭘까?
int[] result = data.clone();
System.arraycopy(temp, 0, data, 0, temp.length);

// 배열의 내용물 비교
Arrays.equals(originalList, anagramList);

// 배열의 값을 가져오는 방법
String[] tokens = message.split(" ");

for(String str : tokens) {
	System.out.println(str);
}

for(int i = 0; j < tokens.length; i++){
	System.out.println(tokens[i]);
}

// 배열 to ArrayList
ArrayList<String> plist = new ArrayList<String> (Arrays.asList(participant));

// 배열 to ArrayList
String[] strList = ("a", "b", "c");
ArrayList<String> arrList = new ArrayList<String>();
Collections.addAll(arrList, strList);
arrList.addAll(strList);

// List 비교
ArrayList<String> plist = new ArrayList<String>();
ArrayList<String> alist = new ArrayList<String>(Arrays.asList(tokens));
isCorrect = plist.equals(alist);

// List 비교하여 삭제
plist.removeAll(clist); //중복된 값도 삭제함
clist.forEach((i)->plist.remove(i)); //하나씩 삭제함
for (int i = 0 ; i< completion.length; i++)
  	plist.remove(completion[i]);

// ArrayList to 배열
String[] selectList = tempTable.toArray(selectList);

// ArrayList to 배열
// 전체 배열 교체가 아니라 특정 자리만 바꾸기
String[] retData = list.toArray(retData);
System.arraycopy(list.toArray(), 0, retData, 0, list.size());

// ArrayList<Integer> to int[]로 변환
answer = list.stream().mapToInt(i->i).toArray();
Arrays.stream(a).mapToInt(i->i).toArray();

// Set to ArrayList
ArrayList<String> list = new ArrayList<String>(set);

/******************************************************************************/
// 정규표현식
"[^\\uAC00-\\uD7A3xfe0-9a-zA-Z\\\\s]"
"^[0-9]{6}-[1-4][0-9]{6}$" //주민등록번호
"^\\d{4}-\\d{4}\\d{4}\\d{4}$" //카드번호
"^([0-9a-fA-F][0-9a-fA-F][:\\-]){5}[0-9a-fA-F]{2}$" //MAC주소
"^([0-9a-fA-F]{4}[.]){2}[0-9a-fA-F]{4}$" //MAC주소
/******************************************************************************/
// BigInteger
BigInteger result = BigInteger.ONE;

// BigInteger to int 변환
num.intValue();

// BigInteger 연산
result = result.multiply(BigInteger.valueOf(i));

/******************************************************************************/
// 2차원 배열 대각선 검색
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
