package ch3.data; 
import java.sql.*;
public class AddWord extends ConnectDatabase{
   int isOK ; 
   public int insertWord(Word word) {
      connectDatabase();
      try { 
          String SQL ="insert into word_table values(?,?)";
          PreparedStatement sta  = con.prepareStatement(SQL);
          //????????????1????????????word.getEnglishWord():
          sta.setString(1,word.getEnglishWord());
         //????????????2????????????word.getMeaning():
          sta.setString(2,word.getMeaning());
          isOK = sta.executeUpdate();  
          con.close();
      }
      catch(SQLException e) {
          isOK = 0; //word_table????word??????????????????????????
      }
      return isOK;
   }
}
