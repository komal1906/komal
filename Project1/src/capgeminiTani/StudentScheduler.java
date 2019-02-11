package capgeminiTani;

public class StudentScheduler {
	Student s[]=new Student[10];
	Course c[]=new Course[10];
	int i,count;
	/*public void showData(int rollNo)
	{
		for(i=0;i<count;i++)
		
			{
				System.out.println("Student name is"+s[i].getName() +" "+"Student roll no is"+s[i].getRollNo());
			}
		else
		{
			
			System.out.println("Roll no is not valid");
		}
		}
	}
	*/
	public void addData(int rollNo,String name,String[] course)
	{
		s[count]=new Student();
		s[count].setName(name);
		s[count].setRollNo(rollNo);
		s[count].setCourse(course);
		count++;
		
		
	}
	public void showData(int rollNo) {
		
		if(s[i].getRollNo()==rollNo) {
		for(i=0;i<count;i++)
		{
			System.out.println("Roll no is"+s[i].getRollNo());
			System.out.println(" "+ "Name is"+s[i].getName());
			for(int j=0;j<s[i].getCourse().length;j++)
			{
				System.out.println("Course is"+s[i].getCourse()[j]);
			}
		}
		
	}
		else
		{
			System.out.println("invalid rollno");
	}
	
		
	}

}
