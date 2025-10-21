import java.util.*;

public class Main {
    public static void main(String[] args) {
        double sumTotal = 0.0;
        String country;
        String city;
        double weight = 0.0;

        Address addrMSK = new Address("Россия", "Москва");
        Address addrSPB = new Address("Россия", "Санкт-Петербург");
        Address addrITL1 = new Address("Италия", "Рим");
        Address addrITL2 = new Address("Италия", "Милан");
        Address addrITL3 = new Address("Италия", "Неаполь");
        Address addrISP1 = new Address("Испания", "Мадрид");
        Address addrISP2 = new Address("Испания", "Барселона");
        Address addrKPR = new Address("Кипр", "Никосия");

        Map<Address, Double> costPerAddress = new HashMap<>();
        costPerAddress.put(addrMSK, 105.0);
        costPerAddress.put(addrSPB, 95.0);
        costPerAddress.put(addrITL1, 130.0);
        costPerAddress.put(addrITL2, 140.0);
        costPerAddress.put(addrITL3, 150.0);
        costPerAddress.put(addrISP1, 1000.0);
        costPerAddress.put(addrISP2, 1100.0);
        costPerAddress.put(addrKPR, 50.0);

        Scanner scanner = new Scanner(System.in);
        Set<String> uniqueCountries = new HashSet<>();

        System.out.println("Заполнение нового заказа. ");
        while (true) {
            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            }

            try {
                System.out.print("Введите страну:");
                input = scanner.nextLine();
                if (input.equals("end")) {
                    break;
                }
                country = input;

                System.out.print("Введите город:");
                input = scanner.nextLine();
                if (input.equals("end")) {
                    break;
                }
                city = input;

                System.out.print("Введите вес (кг):");
                input = scanner.nextLine();
                if (input.equals("end")) {
                    break;
                }
                weight = Double.parseDouble(input);

                if (weight <= 0) {
                    System.out.println("Неправильно введен вес! (" + weight + ")");
                    continue;
                }

                Address inputAddress = new Address(country, city);

                if (costPerAddress.containsKey(inputAddress)) {
                    double costUnit = costPerAddress.get(inputAddress);
                    double costDelivery = costUnit * weight;
                    sumTotal += costDelivery;
                    uniqueCountries.add(country);

                    System.out.printf("Стоимость доставки составит: %.2f руб.\n", costDelivery);
                } else {
                    System.out.println("Доставки по этому адресу нет\n");
                    continue;
                }

            } catch (NumberFormatException e) {
                System.out.println("Вес введен в неправильном формате! (" + weight + ")");
                continue;
            }
        }
        System.out.printf("Общая стоимость всех доставок: %.2f руб.\n", sumTotal);
        System.out.printf("Количество уникальных стран доставки: %d%n", uniqueCountries.size());
        System.out.println("Уникальные страны: " + String.join(", ", uniqueCountries));
        scanner.close();
    }
}

