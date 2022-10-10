
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author phucp
 */
public class GuiNhanUDB {
    private DatagramSocket dg ;

    

    public void MoCong(int cong) throws SocketException{
        dg = new DatagramSocket(cong);
        System.out.println("Da mo cong "+ cong);
    }
    public String Nhan() throws Exception{
        
        byte bodem[]=new byte[256]; //Tạo ra bộ đệm để nhận dữ liệu về
        DatagramPacket dr= new DatagramPacket(bodem,bodem.length);
        dg.receive(dr);//Đợi 1 kết nối đến
        System.out.println("dang cho");
        String st = new String(dr.getData()).trim() ;//Lấy dữ liệu về và đổi sang chuỗi
        return st;
    }
    public byte [] NhanFile() throws Exception{
        
        byte bodem[]=new byte[256]; //Tạo ra bộ đệm để nhận dữ liệu về
        DatagramPacket dr= new DatagramPacket(bodem,bodem.length);
        dg.receive(dr);//Đợi 1 kết nối đến
        System.out.println("dang cho");
        return dr.getData();
    }
    public void Gui(String data, String Ipmaychu, int cong) throws Exception{
        try{
            DatagramSocket c=new DatagramSocket();//Tạo ra 1 DatagramSocket  để gửi
            byte bodem[]=new byte[256]; //Tạo ra bộ đệm chứa dữ liệu cần gửi
            String st=data;//Dữ liệu cần gửi
            bodem=st.getBytes(); //Chuyển chuỗi thành dãy các byte
            
            InetAddress ip=InetAddress.getByName(Ipmaychu);//Lấy thông tin của máy cần gửi
            DatagramPacket dr= new DatagramPacket(bodem,bodem.length,ip,cong);
            c.send(dr);//Gửi dữ liệu đi
            Thread.sleep(1000);
            System.out.print("Da gửi");
          }catch(Exception tt)   { 
              System.out.print("bi loi gui") ; }
          

    }
    public void GuiFile(byte[] data, String Ipmaychu, int cong) throws Exception{
        try{
            DatagramSocket c=new DatagramSocket();//Tạo ra 1 DatagramSocket  để gửi
            InetAddress ip=InetAddress.getByName(Ipmaychu);//Lấy thông tin của máy cần gửi
            DatagramPacket dr= new DatagramPacket(data,data.length,ip,cong);
            c.send(dr);//Gửi dữ liệu đi
            System.out.print("Da gửi");
          }catch(Exception tt)   { 
              System.out.print(tt) ; }
          

    }
}
