import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class HttpClientExampleTest
 {
 
    public static void main(String args[]) 
   {
      HttpClient httpclient = new HttpClient();
      BufferedReader bufferedreader = null;
        
      PostMethod postmethod = new PostMethod("https://www.testme.com/api/searches.xml");
      postmethod.addParameter("param1","aaa");
      postmethod.addParameter("params2", "bbb");
     
    try{
      int rCode = httpclient.executeMethod(postmethod);
 
      if(rCode == HttpStatus.SC_NOT_IMPLEMENTED) {
        System.err.println("The Post postmethod is not implemented by this URI");
        postmethod.getResponseBodyAsString();
      } else {
        bufferedreader = new BufferedReader(new InputStreamReader(postmethod.getResponseBodyAsStream()));
        String readLine;
        while(((readLine = bufferedreader.readLine()) != null)) {
          System.err.println(readLine);
      }
      }
    } catch (Exception e) {
      System.err.println(e);
    } finally {
      postmethod.releaseConnection();
      if(bufferedreader != null) try { bufferedreader.close(); 
} 
catch (Exception fe)
 {
    fe.printStackTrace();
 }
    }
 
  }
}