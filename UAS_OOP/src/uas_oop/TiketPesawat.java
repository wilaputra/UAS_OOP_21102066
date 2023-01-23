/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_oop;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;
/**
 *
 * @author WILA PUTRA_21102066
 */
public class TiketPesawat {
   static String maskapai = null;
    static String asal = null;
    static String tujuan = null;
    static String waktu = null;    
    static String nama = null;
    static String email = null;
    static String telp = null;
    static boolean error = true;
    static boolean cek = true;
    public static void main(String args[]) 
    {
        Scanner inputan = new Scanner(System.in);

        ArrayList<Maskapai> Tiket = new ArrayList<Maskapai>();
        ArrayList<Jadwal> Schedule = new ArrayList<Jadwal>();

        Tiket.add(new Maskapai("Garuda", "Bali", "Lombok"));          
        Schedule.add(new Jadwal(0, "Pagi", 10, 11, 3000000));
        Schedule.add(new Jadwal(0, "Sore", 15, 16, 3000000));

        Tiket.add(new Maskapai("Garuda", "Bali", "Jogja"));          
        Schedule.add(new Jadwal(1, "Pagi", 12, 14, 4000000));
        Schedule.add(new Jadwal(1, "Sore", 18, 20, 4000000));

        Tiket.add(new Maskapai("Garuda", "Jakarta", "Bali"));          
        Schedule.add(new Jadwal(2, "Pagi", 14, 17, 5000000));
        Schedule.add(new Jadwal(2, "Sore", 20, 23, 5000000));
        Schedule.add(new Jadwal(5, "Sore", 20, 23, 4000000));

        Tiket.add(new Maskapai("Batik Air", "Bali", "Bandung")); 
        Schedule.add(new Jadwal(3, "Pagi", 10, 11, 2000000));
        Schedule.add(new Jadwal(3, "Sore", 20, 23, 2000000));

        Tiket.add(new Maskapai("Batik Air", "Bali", "Jakarta")); 
        Schedule.add(new Jadwal(4, "Pagi", 12, 14, 3000000));
        Schedule.add(new Jadwal(4, "Sore", 18, 20, 3000000));

        Tiket.add(new Maskapai("Batik Air", "Jakarta", "Sulawesi")); 
        Schedule.add(new Jadwal(5, "Pagi", 14, 17, 4000000));
        Schedule.add(new Jadwal(5, "Sore", 20, 23, 4000000));
        Schedule.add(new Jadwal(5, "Malam", 23, 20, 4000000));

        System.out.print("\033[H\033[2J");
        System.out.println("------ Pemesanan Tiket Maskapai ------n");              
             
        do
        {        
            System.out.print("Masukkan Maskapai : ");
            maskapai = inputan.nextLine(); 
            System.out.print("Masukkan Kota Asal : ");
            asal = inputan.nextLine();
            System.out.print("Masukkan Kota Tujuan : ");
            tujuan = inputan.nextLine();  

            for(int i = 0; i < Tiket.size(); i++)
            {                
                if(maskapai.equalsIgnoreCase(Tiket.get(i).maskapai) && asal.equalsIgnoreCase(Tiket.get(i).asal) && tujuan.equalsIgnoreCase(Tiket.get(i).tujuan))
                {
                    do
                    {
                        System.out.print("Masukkan Waktu Keberangkatan : ");
                        waktu = inputan.nextLine();

                        for(int j = 0; j < Schedule.size(); j++)
                        {
                            if(maskapai.equalsIgnoreCase(Tiket.get(i).maskapai) && Schedule.get(j).kode == i && waktu.equalsIgnoreCase(Schedule.get(j).waktu))
                            {                       
                                System.out.print("Masukkan Nama : ");
                                nama = inputan.nextLine(); 

                                do
                                {
                                    System.out.print("Masukkan Email : ");
                                    email = inputan.nextLine();
                                    if(isValidEmail(email)){
                                        cek = false;
                                    } else{
                                        System.out.println("\n------ Email Tidak Valid ------\n");                                             
                                    } 
                                } while(cek == true);

                                cek = true;
                                do
                                {
                                    try {
                                        System.out.print("Masukkan No HP : ");
                                        telp = inputan.nextLine();   

                                        if(isValidTelp(telp)){
                                            cek = false;
                                        } else{
                                            System.out.println("\n------ No HP Tidak Valid ------\n");                                             
                                        } 
                                    } catch (NumberFormatException e) {
                                        System.out.println("\n------ No HP Berupa Angka ------\n");                                             
                                    }                                           
                                } while(cek == true);                                
                                
                                System.out.println("\n------ Transaksi -----\n");                                                                    
                                System.out.println("Nama : " + nama);
                                System.out.println("Email : " + email);
                                System.out.println("No HP : " + telp);
                                System.out.println("Maskapai : " + maskapai);
                                System.out.println("Kota Asal : " + asal);
                                System.out.println("Kota Tujuan : " + tujuan);
                                System.out.println("Waktu Keberangkatan : " + waktu);        
                                System.out.println("Jam Berangkat : " + Schedule.get(j).jam_berangkat + ":00");        
                                System.out.println("Durasi : " + Schedule.get(j).durasi + " Jam");        
                                System.out.println("Jam Sampai : " + Schedule.get(j).jam_sampai + ":00");
                                System.out.println("Biaya : " + Schedule.get(j).biaya);    
                                System.out.println("\n----------------------n"); 

                                error = false;
                                System.exit(0);
                            }
                            else
                            {
                                if(j == (Schedule.size() - 1)){
                                    System.out.println("\n------ Waktu Keberangkatan Tidak Tersedia ------\n");                                             
                                }
                            }    
                        }                                
                    } while(error == true);
                }
                else
                {
                    if(i == (Tiket.size() - 1)){
                        System.out.println("\n------ Tiket Tidak Tersedia ------\n");                                             
                    }
                }                
            }
        } while(error == true);

        inputan.close();
    }

    public static boolean isValidEmail(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if(email == null){
            return false; 
        }            
        return pat.matcher(email).matches(); 
    } 

    private static boolean isValidTelp(String telp) 
    {
		if (telp.matches("\\d{12}")) return true;		
		else if(telp.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) return true;		
		else if(telp.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) return true;
		else if(telp.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) return true;
		else return false;
		
	} 
}
