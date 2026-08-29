import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private double balance;
    private Map<String, Integer> holdings;

    public Portfolio(double initialBalance) {
        this.balance = initialBalance;
        this.holdings = new HashMap<>();
    }

    public void buyStock(Stock stock, int quantity) {
        double cost = stock.getPrice() * quantity;
        if (balance >= cost) {
            balance -= cost;
            holdings.put(stock.getSymbol(), holdings.getOrDefault(stock.getSymbol(), 0) + quantity);
            System.out.println("Bought " + quantity + " shares of " + stock.getSymbol());
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void sellStock(Stock stock, int quantity) {
        int current = holdings.getOrDefault(stock.getSymbol(), 0);
        if (current >= quantity) {
            balance += stock.getPrice() * quantity;
            if (current == quantity) holdings.remove(stock.getSymbol());
            else holdings.put(stock.getSymbol(), current - quantity);
            System.out.println("Sold " + quantity + " shares of " + stock.getSymbol());
        } else {
            System.out.println("You don't own enough shares.");
        }
    }

    public void displayPortfolio(Map<String, Stock> market) {
        System.out.println("\n--- PORTFOLIO SUMMARY ---");
        System.out.printf("Cash Balance: $%.2f\n", balance);
        double totalValue = balance;
        for (Map.Entry<String, Integer> entry : holdings.entrySet()) {
            Stock stock = market.get(entry.getKey());
            double val = stock.getPrice() * entry.getValue();
            totalValue += val;
            System.out.printf("- %s: %d shares ($%.2f total)\n", entry.getKey(), entry.getValue(), val);
        }
        System.out.printf("Total Value: $%.2f\n", totalValue);
    }

    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println(balance);
            for (Map.Entry<String, Integer> e : holdings.entrySet()) {
                writer.println(e.getKey() + "," + e.getValue());
            }
        } catch (IOException ignored) {}
    }

    public void loadFromFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) return;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            balance = Double.parseDouble(reader.readLine());
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) holdings.put(parts[0], Integer.parseInt(parts[1]));
            }
        } catch (Exception ignored) {}
    }
}
    

