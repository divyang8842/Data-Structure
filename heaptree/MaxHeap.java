package heaptree;
import java.util.ArrayList;
import java.util.Collection;

public class MaxHeap
{
	private ArrayList<Student> students;

	public ArrayList<Student> getStudents()
	{
		return students;
	}


	public MaxHeap(int capacity)
	{
		students = new ArrayList<Student>(capacity);
	}

	public MaxHeap(Collection<Student> collection)
	{
		students = new ArrayList<Student>(collection);

		for(int i = size()/2; i >= 0; i--)
		{
			maxHeapify(i);
		}
	}

	private void setIndex() {
		int i = 0;
		for (Student student : students)
		{
			student.setIndexOfStudent(i++);
		}
	}

	public Student getMax()
	{
		if(size() < 1)
		{
			throw new IndexOutOfBoundsException("No maximum value:  the heap is empty.");
		}
		return students.get(0);
	}

	public Student extractMax()
	{
		Student value = getMax();
		students.set(0,students.get(size()-1));
		students.remove(size()-1);
		//setIndex();
		maxHeapify(0);
		return value;
	}
	public void insert(Student elt) 
	{
		students.add(elt);
		int current = size()-1; //getting the index of the parameter that is being passed

		elt.setIndexOfStudent(current);

		increasePos(elt);
	}

	public void changeKey(Student s, double newGPA) 
	{

		double oldGPA = s.gpa(); //getting the old gpa of the student
		s.setGPA(newGPA);  //updates the gpa of the student
		if (newGPA > oldGPA) 
		{
			increasePos(s);
		}
		else 
		{
			int current = s.getIndexOfStudent();
			maxHeapify(current); //max heapify using the current index if it fails the gpa condition
		}
	}

	private void increasePos(Student s)
	{
		int current = s.getIndexOfStudent();
		int parent = parent(current);
		while (current>0 && s.compareTo(students.get(parent)) > 0) //loop that compares the parameter that is being passed of type student by
			//getting the index of the students with the current obj
		{
			swap(current, parent);		//swapping the current position with the parents and then heapifying it.
			current = parent;
			parent = parent(current);
		}
		//System.out.println(s);
	}

	private int parent(int index)
	{
		return (index - 1)/2;
	}

	private int left(int index)
	{
		return 2 * index + 1;
	}

	private int right(int index)
	{
		return 2 * index + 2;
	}

	private int size()
	{
		return students.size();
	}

	private void swap(int from, int to)
	{
		Student fromVal = students.get(from);
		Student toVal  = students.get(to);

		fromVal.setIndexOfStudent(to);
		toVal.setIndexOfStudent(from);

		students.set(from,  toVal);
		students.set(to,  fromVal);


	}

	private void maxHeapify(int index)
	{
		int left = left(index);
		int right = right(index);
		int largest = index;

		if(index<size()) //gets students and updates index
			students.get(index).setIndexOfStudent(index);
		if(left<size())//gets left child and updates index
			students.get(left).setIndexOfStudent(left);

		if(right<size())// gets right index and updates index
			students.get(right).setIndexOfStudent(right);

		if (left <  size() && students.get(left).compareTo(students.get(largest)) > 0)
		{
			largest = left;
		}
		if (right <  size() && students.get(right).compareTo(students.get(largest)) > 0)
		{
			largest = right;
		}
		if (largest != index)
		{
			swap(index, largest);
			maxHeapify(largest);
		}  
	}   
}