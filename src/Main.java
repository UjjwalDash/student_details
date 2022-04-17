import java.sql.*;
import java.util.Scanner;
public class Main {
    public static void details()
    {
        int roll_no;
        String fname,lname,dept;
        int age,ch;
        System.out.println("1.Insert\n2.Update\n3.Delete\n4.Search\n5.Show\n6.Exit");
        System.out.print("Enter your choice:");
        Scanner sr=new Scanner(System.in);
        ch=sr.nextInt();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //set connection
            Connection conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "HR", "hr");
            Statement st = conn.createStatement();
            //st.executeQuery("CREATE TABLE STD(ROLL_NO NUMBER,FNAME VARCHAR2(30),LNAME VARCHAR2(15),DEPT VARCHAR2(10),AGE NUMBER)");
            if (ch == 1) {
                System.out.print("Enter Roll No:");
                roll_no = sr.nextInt();
                System.out.print("Enter First Name:");
                fname = sr.next();
                System.out.print("Enter Last Name:");
                lname = sr.next();
                System.out.print("Enter Department:");
                dept = sr.next();
                System.out.print("Enter Age:");
                age = sr.nextInt();
                String sq = "INSERT INTO STD VALUES(" + roll_no + "," + "'" + fname + "'" + "," + "'" + lname + "'" + "," + "'" + dept + "'" + "," + age + ")";
                System.out.println(sq);
                st.executeQuery("INSERT INTO STD VALUES(" + roll_no + "," + "'" + fname + "'" + "," + "'" + lname + "'" + "," + "'" + dept + "'" + "," + age + ")");
                System.out.println("----------------------------------------------------------------------------------------------------------------");
                details();
            }
            else if(ch==2)
            {
                System.out.println("1.Update Roll No\n2.Update First Name\n3.Update Last Name\n4.Update Department\n5.Update Age");
                System.out.print("Enter your choice:");
                int c=sr.nextInt();
                if(c==1)
                {
                    System.out.print("Enter Roll No:");
                    int old_roll=sr.nextInt();
                    System.out.print("Enter New Roll No:");
                    int new_roll=sr.nextInt();
                    st.executeQuery("UPDATE STD SET ROLL_NO="+new_roll+"WHERE ROLL_NO="+old_roll);
                }
                else if(c==2)
                {
                    System.out.print("Enter Roll No of Student:");
                    int old_roll=sr.nextInt();
                    System.out.print("Enter New First Name:");
                    String new_fname=sr.next();
                    st.executeQuery("UPDATE STD SET FNAME='"+new_fname+"'"+"WHERE ROLL_NO="+old_roll);
                }
                else if(c==3)
                {
                    System.out.print("Enter Roll No of Student:");
                    int old_roll=sr.nextInt();
                    System.out.print("Enter New Last Name:");
                    String new_lname=sr.next();
                    st.executeQuery("UPDATE STD SET FNAME='"+new_lname+"'"+"WHERE ROLL_NO="+old_roll);
                }
                else if(c==4)
                {
                    System.out.print("Enter Roll No of Student:");
                    int old_roll=sr.nextInt();
                    System.out.print("Enter New Department Name:");
                    String new_dept=sr.next();
                    st.executeQuery("UPDATE STD SET DEPARTMENT='"+new_dept+"'"+"WHERE ROLL_NO="+old_roll);
                }
                else if(c==5)
                {
                    System.out.print("Enter Roll No of Student:");
                    int old_roll=sr.nextInt();
                    System.out.print("Enter Update Age:");
                    String new_age=sr.next();
                    st.executeQuery("UPDATE STD SET AGE='"+new_age+"WHERE ROLL_NO="+old_roll);
                }
                else
                {
                    System.out.println("Please Enter correct value");
                }
                System.out.println("----------------------------------------------------------------------------------------------------------------");
                details();
            }
            else if(ch==3)
            {
                System.out.print("Enter Roll No of Student:");
                int old_roll=sr.nextInt();
                st.executeQuery("DELETE FROM STD WHERE ROLL_NO="+old_roll);
                System.out.println("----------------------------------------------------------------------------------------------------------------");
                details();
            }
            else if(ch==4)
            {
                System.out.print("Enter Roll No of Student:");
                int old_roll=sr.nextInt();
                ResultSet det=st.executeQuery("SELECT * FROM STD WHERE ROLL_NO="+old_roll);
                while(det.next())
                    System.out.println(det.getInt(1)+" "+det.getString(2)+" "+det.getString(3)+" "+det.getString(4)+" "+det.getInt(5));
                System.out.println("----------------------------------------------------------------------------------------------------------------");
                details();
            }
            else if(ch==5)
            {
                ResultSet det=st.executeQuery("SELECT * FROM STD");
                while(det.next())
                    System.out.println(det.getInt(1)+" "+det.getString(2)+" "+det.getString(3)+" "+det.getString(4)+" "+det.getInt(5));
                System.out.println("----------------------------------------------------------------------------------------------------------------");
                details();
            }
            else if (ch == 6) {
                System.out.println("System Close");
                System.out.println("----------------------------------------------------------------------------------------------------------------");
            }
            else
            {
                System.out.println("Please Enter correct value");
                System.out.println("----------------------------------------------------------------------------------------------------------------");
                details();
            }
        }catch(Exception e){ System.out.println(e);}
    }
    public static void main(String[] args) throws SQLException {
        details();
    }
}