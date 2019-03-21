package ru.academit.Vishnevsky.main;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class CSV {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Должно быть не меньше 2 аргументов!");
            System.out.println("Надо сначала передавать этот аргумент: C:\\Users\\Ivan\\IdeaProjects\\-academit\\CSV\\src\\ru\\academit\\Vishnevsky\\main\\source.CSV и второй аргумент: lC:\\Users\\Ivan\\IdeaProjects\\-academit\\CSV\\src\\ru\\academit\\Vishnevsky\\main\\Table.html");
            return;
        }

        try (PrintWriter writer = new PrintWriter(args[1]);
             Scanner scanner = new Scanner(new FileInputStream(args[0]))) {
            int cellCountTable = 0;
            boolean isOpenCell = false;
            writer.print("<!DOCTYPE html><html><head><title>Файл СSV</title><meta charset=\"UTF-8\"></head><body><table border=\"2\">");
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                int cellInRow = 0;

                for (int i = 0; i < str.length(); i++) {
                    if (i == 0 && !isOpenCell) {
                        cellInRow++;
                        writer.print("<tr><td>");
                    }
                    if (i == 0 && isOpenCell) {
                        cellCountTable++;
                        writer.print("<br/>");
                    }
                    if (i == str.length() - 1 && str.charAt(i) == '"') {
                        writer.print("</td></tr>");
                        isOpenCell = false;
                        continue;
                    }
                    if (i == str.length() - 1 && str.charAt(i) == '"' && cellInRow < cellCountTable) {
                        writer.print("</td><td></td></tr>");
                        isOpenCell = false;
                        continue;
                    }
                    if (i == str.length() - 1 && str.charAt(i) == ',') {
                        writer.print("</td><td></td></tr>");
                        isOpenCell = false;
                        continue;
                    }
                    if (i == str.length() - 1 && !isOpenCell) {
                        writer.print(str.charAt(i) + "</td></tr>");
                        isOpenCell = false;
                        continue;
                    }
                    if (str.charAt(i) == '"' && !isOpenCell) {
                        isOpenCell = true;
                        continue;
                    }
                    if (i != str.length() - 1 && isOpenCell && str.charAt(i) == '"' && str.charAt(i + 1) != '"') {
                        isOpenCell = false;
                        continue;
                    }
                    if (str.charAt(i) == ',' && isOpenCell) {
                        writer.print(',');
                        continue;
                    }
                    if (i != str.length() - 1 && isOpenCell && str.charAt(i) == '"' && str.charAt(i + 1) == '"') {
                        writer.print('"');
                        isOpenCell = false;
                        continue;
                    }
                    if (str.charAt(i) == ',' && !isOpenCell) {
                        writer.print("</td><td>");
                        cellInRow++;
                        isOpenCell = false;
                        continue;
                    }
                    if (str.charAt(i) == '>') {
                        writer.print("&lt;");
                        continue;
                    }
                    if (str.charAt(i) == '<') {
                        writer.print("&gt;");
                        continue;
                    }
                    if (str.charAt(i) == '&') {
                        writer.print("&amp;");
                        continue;
                    }
                    writer.print(str.charAt(i));
                }
            }
            writer.print("</table></body></html>");
            System.out.println("Конвертация произведена.");
        } catch (FileNotFoundException e) {
            System.out.println("Неверно указан путь к файлу!");
        } catch (Exception e) {
            System.out.println("Возникли трудности во время обработки файла!");
        }
    }
}
