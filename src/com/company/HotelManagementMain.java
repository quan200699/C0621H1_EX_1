package com.company;

import java.util.Scanner;

public class HotelManagementMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng khách trọ:");
        int size = scanner.nextInt();
        HotelManagement hotelManagement = new HotelManagement(size);
        Hotel[] hotels = hotelManagement.getHotels();
        for (int i = 0; i < size; i++) {
            System.out.println("Nhập thông tin về khách trọ thứ " + (i + 1));
            hotels[i] = hotelManagement.inputHotelInfo(scanner);
        }
        hotelManagement.displayHotelList();
        System.out.println("Nhập chứng minh nhân dân khách trọ cần xóa thông tin:");
        String identity = scanner.nextLine();
        int index = hotelManagement.findHotelByIdentity(identity);
        if(index == -1){
            System.out.println("Không tìm thấy");
        }else {
            hotelManagement.removeHotelInfo(index);
            hotelManagement.displayHotelList();
        }
    }
}
