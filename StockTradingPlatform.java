import java.util.*;

public class StockTradingPlatform {
    private static final Map<String, Stock> market = new HashMap<>();

    public static void main(String[] args) {
        market.put("AAPL", new Stock("AAPL", "Apple Inc.", 175.50));
        market.put("GOOGL", new Stock("GOOGL", "Alphabet Inc.", 140.20));
        market.put("TSLA", new Stock("TSLA", "Tesla Inc.", 210.80));

        Portfolio portfolio = new Portfolio(10000.0);
        portfolio.loadFromFile("portfolio.txt");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Market Data | 2. Buy | 3. Sell | 4. Portfolio | 5. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                market.values().forEach(s -> System.out.printf("%s (%s): $%.2f\n", s.getSymbol(), s.getName(), s.getPrice()));
            } else if (choice == 2 || choice == 3) {
                System.out.print("Symbol: ");
                String sym = sc.next().toUpperCase();
                System.out.print("Quantity: ");
                int qty = sc.nextInt();
                if (market.containsKey(sym)) {
                    if (choice == 2) portfolio.buyStock(market.get(sym), qty);
                    else portfolio.sellStock(market.get(sym), qty);
                } else {
                    System.out.println("Invalid stock.");
                }
            } else if (choice == 4) {
                portfolio.displayPortfolio(market);
            } else if (choice == 5) {
                portfolio.saveToFile("portfolio.txt");
                System.out.println("Saved & Exiting.");
                break;
            }
        }
        sc.close();
    }
}
    

