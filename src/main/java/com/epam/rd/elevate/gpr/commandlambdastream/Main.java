package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;
import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static <T> void forEach(List<T> list,
                                   Consumer<? super T> action) {
        List<T> filteredList = new ArrayList<>();
        for (T item : list) {
            action.accept(item);
        }
    }

    public static <T> List<T> filter(List<T> list,
                                     Predicate<? super T> predicate) {
        List<T> filteredList = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                filteredList.add(item);
            }
        }

        return filteredList;
    }

    public static <T,R> List<R> map(List<T> list,
                                    Function<? super T, R> mapper) {
        List<R> mappedList = new ArrayList<>();
        for (T item : list) {
            mappedList.add(mapper.apply(item));
        }

        return mappedList;
    }

    public static <T,R> R reduce(List<T> list,
                                 BiFunction<? super T,R,R> func,
                                 R initial) {
        R result = initial;
        for (T item : list) {
            result = func.apply(item,result);
        }
        return result;
    }

    public static Boolean predicateRegion(SalesSummaryRow salesSummaryRow, Region r2) {
        return salesSummaryRow.getRegion() == r2;
    }

    public static Predicate<SalesSummaryRow> createPredicateRegion(Region region) {
        return (s -> s.getRegion() == region);
    }

    public static Predicate<SalesSummaryRow> createPredicateSalesCost(Double percent) {
        return s -> (s.getUnitSalesValue() / s.getUnitCosts()) > percent;
    }

    final static double THIRTEN_PERCENT = 0.30;

    public static void main(String[] args) {
        List<SalesSummaryRow> dbSales = DatabaseHelper.getDBSales();

        forEach(dbSales,System.out::println);

        System.out.println("\nNorth Sales Summary");
        forEach(filter(dbSales, createPredicateRegion(Region.NORTH)),
                System.out::println);

        System.out.println("\nSouth Sales Summary");
        forEach(filter(dbSales, createPredicateRegion(Region.SOUTH)),
                s -> System.out.println(s));

        System.out.println("\nStarted units from West Sales Summary");
        forEach(map(filter(dbSales,
                           createPredicateRegion(Region.WEST)),
                    SalesSummaryRow::getInitialUnits),
                System.out::println);

        System.out.println("\nFinals units from East Sales Summary");
        forEach(map(filter(dbSales,
                           createPredicateRegion(Region.EAST)),
                    SalesSummaryRow::finalUnits),
                System.out::println);

        System.out.println("\nList of profits over 30 percent over the sales' cost.");
        forEach(map(filter(dbSales,
                           createPredicateSalesCost(THIRTEN_PERCENT)),
                    SalesSummaryRow::profit),
                System.out::println);

        System.out.println("Profit: " + reduce(dbSales,
                                               (s,r) -> s.profit() + r,
                                               0.0));
    }
}
