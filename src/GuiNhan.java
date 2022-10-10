
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class GuiNhan {
    ServerSocket Sserver;
    public void MoCong(int cong) throws Exception{
        Sserver = new ServerSocket(cong);
        System.out.println("Server da mo cong: " + cong);
    }
    public String Nhan() throws Exception{
        //Lap vo han de doi client noi len
        Socket c=   Sserver.accept();
        System.out.println("Da co 1 client connected ........");
        //Tạo luồng để nhận thông tin client gửi lên
          InputStreamReader is= new InputStreamReader(c.getInputStream());
         //Tạo bộ đệm để lưu dữ liệu nhận về
          BufferedReader r= new BufferedReader(is);
          return r.readLine(); //đọc dữ liệu từ bộ đệm
    }//172.16.3.183
    public void Gui(String data, String Ipserver, int cong) throws Exception{
        Socket c= new Socket(Ipserver, cong);
        System.out.println("Da noi len Server........");
        //Tạo luồng để gửi dũ  liệu lên Server
        DataOutputStream out =new DataOutputStream(c.getOutputStream());
        out.writeBytes(data); //Gửi thông báo
        out.write(13);
        out.write(10);
        out.close();
        c.close();
    }
}
