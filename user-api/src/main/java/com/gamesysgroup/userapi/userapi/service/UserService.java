package com.gamesysgroup.userapi.userapi.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gamesysgroup.userapi.userapi.bean.User;

@Service
public class UserService {

	private static List<User> users = new ArrayList();
	private static int counter = 0;
	
	static Path path = Paths.get("src").toAbsolutePath();
	static String imagePath = (path + "\\main\\resources\\image\\nature.jpg").replace('\\', '/');
	static String imagePath1 = (path + "\\main\\resources\\image\\nature1.jpg").replace('\\', '/');
	static String imagePath2 = (path + "\\main\\resources\\image\\nature2.jpg").replace('\\', '/');
	static String imagePath3 = (path + "\\main\\resources\\image\\nature3.jpg").replace('\\', '/');
	static String imagePath4 = (path + "\\main\\resources\\image\\nature4.jpg").replace('\\', '/');
	static String imagePath5 = (path + "\\main\\resources\\image\\nature5.jpg").replace('\\', '/');
	static String imagePath6 = (path + "\\main\\resources\\image\\nature6.jpg").replace('\\', '/');
	static String imagePath7 = (path + "\\main\\resources\\image\\nature7.jpg").replace('\\', '/');
	static String imagePath8 = (path + "\\main\\resources\\image\\nature8.jpg").replace('\\', '/');
	static {
		users.add(new User(++counter,"Sri", "Venkat","Balaji",encoder(imagePath2), "2015/03/01"));
		users.add(new User(++counter,"Mr","Chandra","Sekhar", encoder(imagePath1), "1987/09/14"));
		users.add(new User(++counter,"Anil", "Raj","Kumar", encoder(imagePath8),"1985/03/29"));
		users.add(new User(++counter,"Mr", "Ram","Kumar", encoder(imagePath), "1982/07/13"));
		users.add(new User(++counter,"Sai", "Ravi", "Teja",encoder(imagePath4), "2008/10/18"));
		users.add(new User(++counter,"Anil", "Raj","Kumar", encoder(imagePath5),"1985/03/29"));
		users.add(new User(++counter,"Sri", "Ram","Kumar", encoder(imagePath6), "1982/07/13"));
		users.add(new User(++counter,"Pavan","Sai","Teja", encoder(imagePath7), "1997/03/25"));
		users.add(new User(++counter,"Mouli","Chandra","Sekhar", encoder(imagePath3), "1987/09/14"));
	}
	
	public List<User> listAllUsers() {
		return users;
	}
	
	public static String encoder(String imagePath) {
	    String base64Image = "";
	    File file = new File(imagePath);
	    try (FileInputStream imageInFile = new FileInputStream(file)) {
	      // Reading a Image file from file system
	      byte imageData[] = new byte[(int) file.length()];
	      imageInFile.read(imageData);
	      base64Image = Base64.getEncoder().encodeToString(imageData);
	    } catch (FileNotFoundException e) {
	      System.out.println("Image not found" + e);
	    } catch (IOException ioe) {
	      System.out.println("Exception while reading the Image " + ioe);
	    }
	    return base64Image;
	}
	
	 public static void decoder(String base64Image, String pathFile) {
		try (FileOutputStream imageOutFile = new FileOutputStream(pathFile)) {
			// Converting a Base64 String into Image byte array
			byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
			imageOutFile.write(imageByteArray);
		} catch (FileNotFoundException e) {
		      System.out.println("Image not found" + e);
		} catch (IOException ioe) {
		      System.out.println("Exception while reading the Image " + ioe);
		}
	 }
}