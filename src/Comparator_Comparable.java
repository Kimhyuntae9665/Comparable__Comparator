import java.util.*;

public class Comparator_Comparable {

	public static void main(String[] args) {
		String[] strArr = {"cat","Dog","lion","tiger"};
		
		Arrays.sort(strArr); //������ ��� ���� 2������ �ʿ��ѵ� �̰Ŵ� ��� ���� �� ������ strArr�� String�� String class���� Comparable ������ �ִ�. ���� �⺻ sort(strArr)�� �������� ���ķ� ���� ����
		System.out.println("strArr="+Arrays.toString(strArr));
		
		Arrays.sort(strArr,String.CASE_INSENSITIVE_ORDER);//���� ���� ��� ����  ������ �� �ҹ��� ���� ���Ѵ� �̴�.
		System.out.println("strArr="+Arrays.toString(strArr));
		
		Arrays.sort(strArr,new Descending());//��� ���� ��� ���� ������ ������������ ���� Comparator ����  
		System.out.println("strArr="+Arrays.toString(strArr));

	}

}

class Descending implements Comparator{
	public int compare(Object o1,Object o2) {
		if(o1 instanceof Comparable && o2 instanceof Comparable) { //if()�ڵ�� ���� Comparable�� CompareTo()�� �⺻ �ڵ� (�������� ����)
			Comparable c1 = (Comparable)o1;
			Comparable c2 = (Comparable)o2;
			
			return c1.compareTo(c2)*-1; //Comparable�� �⺻ �ڵ� �������� �ڵ忡�� �������� return ������ *-1�� ���� ���ν� ������������ �ҹ��� z�� ���� ����  
		} //c1.compareTo(c2) �̷��� �ϸ� ������������ ���� �̰� ������ c1 c2�� Comparable�� �� ��ȯ �� ��
		
		return -1;
	}
}
