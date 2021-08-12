package com.company;

import java.util.Scanner;

//Class Management sẽ làm nhiệm vụ là thêm, sửa, xóa, hiển thị thông tin khách trọ
public class HotelManagement {
    private Hotel[] hotels;

    public HotelManagement(int size) {
        hotels = new Hotel[size];
    }

    public HotelManagement(Hotel[] hotels) {
        this.hotels = hotels;
    }

    public Hotel[] getHotels() {
        return hotels;
    }

    public void setHotels(Hotel[] hotels) {
        this.hotels = hotels;
    }

    public void removeHotelInfo(int index) {
        Hotel[] newHotel = new Hotel[this.hotels.length - 1];
        for (int i = 0; i < newHotel.length; i++) {
            if (i < index) {
                newHotel[i] = this.hotels[i];
            } else {
                newHotel[i] = this.hotels[i + 1];
            }
        }
        this.hotels = newHotel;
    }

    public int findHotelByIdentity(String identity) {
        int index = -1;
        for (int i = 0; i < this.hotels.length; i++) {
            if (this.hotels[i].getPerson().getIdentity().equals(identity)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void displayHotelList() {
        for (Hotel hotel : this.hotels) {
            System.out.println(hotel);
        }
    }

    public Hotel inputHotelInfo(Scanner scanner) {
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

    public Person inputPersonInfo(Scanner scanner) {
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
