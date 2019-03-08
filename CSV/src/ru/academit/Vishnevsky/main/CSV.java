package ru.academit.Vishnevsky.main;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CSV {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Должно быть 2 аргумента!");
        }
        StringBuilder strHTML = new StringBuilder("!DOCTYPE<html><title></title><head><meta charset=\"UTF-8\"></head><body><table border=1>");
        try (PrintWriter write = new PrintWriter(args[1]); Scanner scanner = new Scanner(new FileInputStream(args[0]))) {

            strHTML.append("</table></body></html>");
            write.println(strHTML);
        } catch (FileNotFoundException e) {
            System.out.println("Невозможно найти файлы!");
        } catch (Exception e) {
            System.out.println("Появились непредвиденные трудности при чтении файла!");
        }
    }
}
