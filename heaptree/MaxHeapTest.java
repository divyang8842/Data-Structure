
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
 
public class MaxHeapTest {
	private MaxHeap heap;


	@Before
	public void setUp() throws Exception {
		heap = new MaxHeap(0);
		try 
		{
			heap.getMax();
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println(e.getMessage());
		}
		ArrayList<Student> students = new ArrayList<>(2000); 
		students.add(new Student("Student 0", 0,-4));
		students.add(new Student("Student 1", 1,-3));
		students.add(new Student("Student 2", 2,-2));
		students.add(new Student("Student 3", 3,-1));
		Student s1 = new Student("Student 4");
		s1.setUnits(4);
		s1.setGPA(4);
		students.add(s1);
		heap = new MaxHeap(students);
		
		
		
		Student s;
		for(int i=0;i<1995;i++) {
			s= new Student("student "+(i+5),i+1,i+1);
			heap.insert(s);
		}

	}

	@Test
	public void test() {
		
		
		heap.insert(new Student(" test", 15, 40000));
		assertEquals(40000, heap.extractMax().gpa(), .000001);
		Student s = heap.getStudents().get(1999);
		heap.changeKey(s, 1999.5);
		assertEquals(1999.5, heap.extractMax().gpa(), .000001);
		assertEquals(1995, heap.extractMax().gpa(), .000001);
		s=heap.getStudents().get(0);
		s.setUnits(10);
		s.units();
		s.getName();
		heap.changeKey(s, 1992.5);
		assertEquals(1993, heap.extractMax().gpa(),.000001);
		assertEquals(1992.5, heap.extractMax().gpa(),.000001);
		
		
//		assertEquals(5.1, heap.extractMax().gpa(), .000001);
//		assertEquals(5, heap.extractMax().gpa(), .000001);
//		heap.changeKey(s2, -6);
//		assertEquals(4, heap.extractMax().gpa(), .000001);
//		//assertEquals(3.9, heap.extractMax().gpa(), .000001);
//		assertEquals(3.4, heap.extractMax().gpa(), .000001);
//		assertEquals(3.1, heap.extractMax().gpa(), .000001);
//		assertEquals(1.2, heap.extractMax().gpa(), .000001);
//		
//		heap.changeKey(s4, 15);
//		assertEquals(15, heap.extractMax().gpa(), .000001);
//		assertEquals(0, heap.extractMax().gpa(), .000001);
//		assertEquals(0, heap.extractMax().gpa(), .000001);
//		assertEquals(-1, heap.extractMax().gpa(), .000001);
//		
//		assertEquals(-4.2, heap.extractMax().gpa(), .000001);
//		//assertEquals(-5, heap.extractMax().gpa(), .000001);
//		assertEquals(-6, heap.extractMax().gpa(), .000001);
	}

}