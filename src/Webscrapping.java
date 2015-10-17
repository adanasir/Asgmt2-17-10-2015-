import java.io.*;
import java.net.*;
import java.util.regex.*;
 
class SrcapingTest{
  public static void main(String []argv){
    try {
 
      URL url = new URL("http://fskm.uitm.edu.my/v1/fakulti/staff-directory/academic/1097.html");
      URLConnection urlConnection = url.openConnection();
      DataInputStream dis = new DataInputStream(urlConnection.getInputStream());
      String html= "", tmp = "";
      // read all HTML source from given URL
      while ((tmp = dis.readLine()) != null) {
        html += " "+tmp;
      }
      dis.close();
 
      // replace all white spaces region with single space
      html = html.replaceAll("\\s+", " ");
      // build the pattern using regular expression
      Pattern p = Pattern.compile("<title>(.*?)</title>");
      // Match the pattern with given html source
      Matcher m = p.matcher(html);
      // Get all matches that matched my pattern
      while (m.find() == true){
        // Print the first matched pattern
        System.out.println(m.group(1));
      }
    }catch (Exception e) {
      System.out.println(e);
    }
  }
}