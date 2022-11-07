package com.epam.rd.cls;

import java.util.List;
import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static Predicate<SalesSummaryRow>
        createPredicateRegion(Region region) {
        return (s -> s.getRegion() == region);
    }

    public static Predicate<SalesSummaryRow>
        createPredicateSalesCost(Double percent) {
        return s -> (s.getUnitSalesValue() / s.getUnitCosts()) > percent;
    }

    public static Double sumProfit(Double value,
                                   SalesSummaryRow s) {
        return s.profit() + value;
    }

    final static double THIRTEN_PERCENT = 0.30;

    public static void main(String[] args) {
        List<SalesSummaryRow> dbSales = DBHelper.getDBSales();

        dbSales.stream().
            forEach(System.out::println);

        System.out.println("\nNorth Sales Summary");
        dbSales.stream()
            .filter(createPredicateRegion(Region.NORTH))
            .forEach(System.out::println);

        System.out.println("\nSouth Sales Summary");
        dbSales.stream()
            .filter(createPredicateRegion(Region.SOUTH))
            .forEach(System.out::println);

        System.out.println("\nStarted units from West Sales Summary");
        dbSales.stream()
            .filter(createPredicateRegion(Region.WEST))
            .map(SalesSummaryRow::getInitialUnits)
            .forEach(System.out::println);

        System.out.println("\nFinals units from East Sales Summary");
        dbSales.stream()
            .filter(createPredicateRegion(Region.EAST))
            .map(SalesSummaryRow::finalUnits)
            .forEach(System.out::println);

        System.out.println("\nList of profits over 30 percent over the sales' cost.");
        dbSales.stream()
            .filter(createPredicateSalesCost(THIRTEN_PERCENT))
            .map(SalesSummaryRow::profit)
            .forEach(System.out::println);

        System.out.println("Profit: " + dbSales.stream().
                           reduce(0.0,
                                  Main::sumProfit,
                                  Double::sum));
    }
}
