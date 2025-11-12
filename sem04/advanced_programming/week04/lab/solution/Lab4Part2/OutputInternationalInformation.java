package Lab4Part2;

import java.text.*;
import java.util.*;

public class OutputInternationalInformation {
    public static void main(String[] args) {
        Locale usLocale = Locale.US;
        Locale ukrainianLocale = Locale.of("uk", "UA"); // cmd$ `chcp 1251` to display Ukrainian characters
        Locale irishLocale = Locale.forLanguageTag("ga-IE");

        displayLocalizedInformation(ukrainianLocale);
        displayLocalizedInformation(usLocale);
        displayLocalizedInformation(irishLocale);
    }

    public static void displayLocalizedInformation(Locale locale) {
        System.out.println("Locale: " + locale.getDisplayName());

        // Display days of the week
        String[] weekdays = new DateFormatSymbols(locale).getWeekdays();
        System.out.printf("Days of the week: %s%n", String.join(", ", Arrays.stream(weekdays).filter(day -> !day.isEmpty()).toArray(String[]::new)));

        // Display months of the year
        String[] months = new DateFormatSymbols(locale).getMonths();
        System.out.printf("Months of the year: %s%n", String.join(", ", Arrays.stream(months).filter(month -> !month.isEmpty()).toArray(String[]::new)));

        // Display a big number with decimals
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
        System.out.println("Currency display of 10000.50: " + currencyFormat.format(10000.50));

        // Display today's date in SHORT format
        DateFormat shortDateFormat = DateFormat.getDateInstance(DateFormat.SHORT, locale);
        System.out.println("Today's date in SHORT format: " + shortDateFormat.format(Calendar.getInstance().getTime()));

        // Display one more locale-sensitive information: Currency symbol
        Currency currency = Currency.getInstance(locale);
        System.out.println("Currency symbol: " + currency.getSymbol(locale)); // "₴", "$", "€"

        System.out.println();
    }
}
