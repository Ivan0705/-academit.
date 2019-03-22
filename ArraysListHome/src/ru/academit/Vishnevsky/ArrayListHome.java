package ru.academit.Vishnevsky;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListHome {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new FileInputStream("C:\\Users\\Ivan\\IdeaProjects\\-academit\\ListArrayHome\\src\\ru\\academit\\vishnevsky\\main\\Main\\Main\\Main\\Input.txt"))) {
            ArrayList<String> str = new ArrayList<>();
            while (scanner.hasNextLine()) {
                str.add(scanner.nextLine());
            }
            for (String e : str) {
                System.out.println(e);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
        }

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);
                i--;
            }
        }
        System.out.println(numbers);

        ArrayList<Integer> listNumber = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 45, 4, 3, 2, 1, 11));
        ArrayList<Integer> listNumberNotRepeat = new ArrayList<>();
        for (Integer e : listNumber) {
            if (!listNumberNotRepeat.contains(e)) {
                listNumberNotRepeat.add(e);
            }
        }
        System.out.println(listNumberNotRepeat);
    }
}
