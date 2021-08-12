package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng khách trọ:");
        int size = scanner.nextInt();
        Hotel[] hotels = new Hotel[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Nhập thông tin về khách trọ thứ " + (i + 1));
            hotels[i] = inputHotelInfo(scanner);
        }
        displayHotelList(hotels);
        System.out.println("Nhập chứng minh nhân dân khách trọ cần xóa thông tin:");
        String identity = scanner.nextLine();
        int index = findHotelByIdentity(identity, hotels);
        if (index == -1) {
            System.out.println("Không tìm thấy khách hàng cần thuê");
        } else {
            hotels = removeHotelInfo(index, hotels);
            displayHotelList(hotels);
        }
    }

    public static Hotel[] removeHotelInfo(int index, Hotel[] hotels) {
        Hotel[] newHotel = new Hotel[hotels.length - 1];
        for (int i = 0; i < newHotel.length; i++) {
            if (i < index) {
                newHotel[i] = hotels[i];
            } else {
                newHotel[i] = hotels[i + 1];
            }
        }
        return newHotel;
    }

    public static int findHotelByIdentity(String identity, Hotel[] hotels) {
        int index = -1;
        for (int i = 0; i < hotels.length; i++) {
            if (hotels[i].getPerson().getIdentity().equals(identity)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void displayHotelList(Hotel[] hotels) {
        for (Hotel hotel : hotels) {
            System.out.println(hotel);
        }
    }

    public static Hotel inputHotelInfo(Scanner scanner) {
        System.out.println("Số ngày trọ:");
        int day = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Loại phòng trọ:");
        String type = scanner.nextLine();
        System.out.println("Giá phòng:");
        double price = scanner.nextDouble();
        System.out.println("Thông tin cá nhân của người dùng:");
        Person person = inputPersonInfo(scanner);
        return new Hotel(day, type, price, person);
    }

    public static Person inputPersonInfo(Scanner scanner) {
        System.out.println("Họ tên:");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Ngày sinh:");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Chứng minh nhân dân:");
        String identity = scanner.nextLine();
        return new Person(name, dateOfBirth, identity);
    }
}
