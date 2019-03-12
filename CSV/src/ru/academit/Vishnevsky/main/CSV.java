package ru.academit.Vishnevsky.main;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class CSV {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Должно быть не меньше 2 аргументов!");
            return;
        }
        try (PrintWriter write = new PrintWriter(/*args[1]*/"C:\\Users\\Ivan\\IdeaProjects\\-academit\\CSV\\src\\ru\\academit\\Vishnevsky\\main\\Table.html"); Scanner scanner = new Scanner(new FileInputStream(/*args[0]*/"C:\\Users\\Ivan\\IdeaProjects\\-academit\\CSV\\src\\ru\\academit\\Vishnevsky\\main\\source.CSV"))) {
            StringBuilder htmlStr = new StringBuilder("<!DOCTYPE html><html><title></title><head><meta charset=\"UTF-8\"></head><body><table border=2>");

            int rowCountTable = 0;
            boolean isOpenCell = false;

            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                int cellInRow = 0;
                int cellCountTable = 0;
                for (int i = 0; i < str.length(); i++) {
                    if (i == 0 && !isOpenCell) {
                        cellInRow++;
                        htmlStr.append("<tr><td>");
                        if (rowCountTable == 1) {
                            cellCountTable++;
                        }
                    }

                    if (i == 0 && isOpenCell) {
                        cellCountTable++;
                        htmlStr.append("</br>");
                    }

                    if (i == str.length() - 1 && str.charAt(i) == '"') {
                        htmlStr.append("</td></tr>");
                        isOpenCell = false;
                        continue;
                    }
                    if (i == str.length() - 1 && str.charAt(i) == '"' && cellInRow < cellCountTable) {
                        htmlStr.append("</td><td></td></tr>");
                        isOpenCell = false;
                        continue;
                    }

                    if (i == str.length() - 1 && str.charAt(i) == ',') {
                        htmlStr.append("</td></tr>");
                        isOpenCell = false;
                        continue;
                    }

                    if (i == str.length() - 1 && !isOpenCell) {
                        htmlStr.append(str.charAt(i)).append("</td></tr>");
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
                        htmlStr.append(',');
                        continue;
                    }
                    if (i != str.length() - 1 && isOpenCell && str.charAt(i) == '"' && str.charAt(i + 1) == '"') {
                        htmlStr.append('"');
                        isOpenCell = false;
                        continue;
                    }

                    if (str.charAt(i) == ',' && !isOpenCell) {
                        htmlStr.append("</td><td>");
                        if (rowCountTable == 1) {
                            cellCountTable++;
                        }
                        isOpenCell = false;
                        continue;
                    }
                    htmlStr.append(str.charAt(i));
                }
            }
            htmlStr.append("</table></body></html>");
            write.println(htmlStr);
        } catch (FileNotFoundException e) {
            System.out.println("Неверно указан путь к файлу!");
        } catch (Exception e) {
            System.out.println("Возникли трудности во время оработки файла!");
        }
    }
}
