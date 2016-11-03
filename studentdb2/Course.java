import java.io.*;
public class Course implements Serializable{
  private String courseCode;
  private String courseDescription;
  
  public Course(){
  
  }
  
  public Course(String courseCode, String courseDescription){
    this.courseCode = courseCode;
    this.courseDescription = courseDescription;
  }
  
  public String getCourseCode(){
    return courseCode;
  }
  
  public void setCourseCode(String courseCode){
    this.courseCode = courseCode;
  }
  
  public String getCourseDescription(){
    return courseDescription;
  }
  
  public void setCourseDescription(String courseDescription){
    this.courseDescription = courseDescription;
  }
  
  public String toString() {
        return String.format("%s\n%s\n", courseCode, courseDescription);
    }
}