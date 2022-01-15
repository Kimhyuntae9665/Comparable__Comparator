import java.util.*;

public class Comparator_Comparable {

	public static void main(String[] args) {
		String[] strArr = {"cat","Dog","lion","tiger"};
		
		Arrays.sort(strArr); //정렬은 대상 기준 2가지가 필요한데 이거는 대상만 존재 그 이유는 strArr는 String형 String class에는 Comparable 구현이 있다. 따라서 기본 sort(strArr)는 오름차순 정렬로 자종 선택
		System.out.println("strArr="+Arrays.toString(strArr));
		
		Arrays.sort(strArr,String.CASE_INSENSITIVE_ORDER);//대상과 기준 모두 충족  기준은 대 소문자 구분 안한다 이다.
		System.out.println("strArr="+Arrays.toString(strArr));
		
		Arrays.sort(strArr,new Descending());//대상 기준 모두 충족 기준은 내림차순으로 직접 Comparator 구현  
		System.out.println("strArr="+Arrays.toString(strArr));

	}

}

class Descending implements Comparator{
	public int compare(Object o1,Object o2) {
		if(o1 instanceof Comparable && o2 instanceof Comparable) { //if()코드는 원래 Comparable의 CompareTo()의 기본 코드 (오름차순 정렬)
			Comparable c1 = (Comparable)o1;
			Comparable c2 = (Comparable)o2;
			
			return c1.compareTo(c2)*-1; //Comparable의 기본 코드 오름차순 코드에서 마지막에 return 문에서 *-1을 해줌 으로써 내림차순으로 소문자 z가 가장 먼저  
		} //c1.compareTo(c2) 이렇게 하면 오름차순으로 정렬 이걸 쓰려고 c1 c2를 Comparable로 형 변환 한 것
		
		return -1;
	}
}
