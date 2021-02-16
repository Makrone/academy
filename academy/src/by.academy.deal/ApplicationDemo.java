package by.academy.deal;

import java.text.ParseException;
import java.util.Scanner;
import by.academy.deal.User;

public class ApplicationDemo {
    private final Deal[] deals = new Deal[20];
    private static int countDeals = 0;

    public static final String START_MENU = """
            Главное меню:
            Введите:
            1.Начать сделку
            2.История сделок
            0.Выход из системы""";

    public static void main(String[] args) throws ParseException {

        ApplicationDemo applicationDemo = new ApplicationDemo();
        applicationDemo.runDeal();
    }

    private void runDeal() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println(START_MENU);

        String value = sc.nextLine();
        while (!value.equals("0")) {
            switch (value) {
                case "1": {
                    Deal deal = new Deal();
                    System.out.println("Заполните данные о продавце");
                    User user1 = new User();
                    user1.readNewUser();
                    System.out.println("Заполните данные о покупателе");
                    User user2 = new User();
                    user2.readNewUser();
                    deal.setSeller(user1);
                    deal.setBuyer(user2);
                    deal.menuDeal();
                    if (deal.getProducts() != null && deal.getProducts()[0] != null) {
                        addDeal(deal);
                        System.out.println("Сделка прошла успешно");
                    } else {
                        System.out.println("Сделка не состоялась");
                    }
                    System.out.println("----------------------------");
                    System.out.println(START_MENU);
                    break;
                }
                case "2": {
                    if (deals[0] == null) {
                        System.out.println("История сделок пуста");
                    } else {
                        for (int i = 0; i < deals.length; i++) {
                            if (deals[i] != null) {
                                System.out.println(" №" + (i + 1) + deals[i].toString());
                            }
                        }
                    }
                    System.out.println("----------------------------");
                    System.out.println(START_MENU);
                    break;
                }
                default: {
                    System.out.println("Введите корректное значение");
                }
            }
            value = sc.nextLine();
        }
        sc.close();
    }

    public void addDeal(Deal deal) {
        deals[countDeals++] = deal;
    }
}
