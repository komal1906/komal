package capgeminiTani;

public class Student {

	
		
		private int rollno;
		private String name;
		private String[] course;
		
		public String[] getCourse() {
			return course;
		}

		public void setCourse(String[] course) {
			this.course = course;
		}

		public int getRollNo()
		{
			return rollno;
		}
		
		public void setRollNo(int rollno)
		{		
			this.rollno=rollno;
		}
	
		public String getName()
		{
			return name;
		}
     public void setName(String name)
     {
    	 this.name=name;
     }
     
}
