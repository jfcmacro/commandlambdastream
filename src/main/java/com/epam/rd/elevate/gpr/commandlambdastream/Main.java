package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;

public class Main {

    public static void forEach(List<SalesSummaryRow> list,
                               SetSalesSummaryRowCommand command) {
        ForEachCommand forEachCommand =
            new ForEachCommand(list, command);
        forEachCommand.execute();
    }

    public static void forEachInteger(List<Integer> list,
                                      SetIntegerCommand command) {
        ForEachIntegerCommand forEachCommand =
            new ForEachIntegerCommand(list, command);
        forEachCommand.execute();
    }

    public static void forEachDouble(List<Double> list,
                                     SetDoubleCommand command) {
        ForEachDoubleCommand forEachCommand =
            new ForEachDoubleCommand(list, command);
        forEachCommand.execute();
    }

    public static List<SalesSummaryRow>
        filter(List<SalesSummaryRow> list,
               GetBooleanSetSalesSummaryRowCommand predicate) {
        FilterCommand filterCommand = new FilterCommand(list,
                                                        predicate);
        filterCommand.execute();
        return filterCommand.getListSalesSummaryRows();
    }

    public static List<Integer>
        mapInteger(List<SalesSummaryRow> list,
                   GetIntegerSetSalesSummaryRowCommand transform) {
        MapListSalesSummaryRowIntegerCommand mapCommand =
            new MapListSalesSummaryRowIntegerCommand(transform);
        mapCommand.setSalesSummaryRows(list);
        mapCommand.execute();
        return mapCommand.getListInteger();
    }

    public static List<Double>
        mapDouble(List<SalesSummaryRow> list,
                  GetDoubleSetSalesSummaryRowCommand transform) {
        MapListSalesSummaryRowDoubleCommand mapCommand =
            new MapListSalesSummaryRowDoubleCommand(transform);
        mapCommand.setSalesSummaryRows(list);
        mapCommand.execute();
        return mapCommand.getListDouble();
    }

    public static Double
        reduceDouble(List<SalesSummaryRow> list,
                     GetDoubleSetSalesSummaryRowCommand doubleSalesSummaryRowCommand,
                     double initial) {
        ReduceCommand reduceCommand = new ReduceCommand(doubleSalesSummaryRowCommand,
                                                        initial);
        reduceCommand.setSalesSummaryRows(list);
        reduceCommand.execute();
        return reduceCommand.getDouble();
    }

    public static void printListSalesSummaryRows(List<SalesSummaryRow> list) {
        forEach(list, new PrintSalesSummaryRowCommand());
    }

    public static void printListInteger(List<Integer> list) {
        forEachInteger(list, new PrintIntegerCommand());
    }

    public static void printListDouble(List<Double> list) {
        forEachDouble(list, new PrintDoubleCommand());
    }

    final static double THIRTEN_PERCENT = 0.30;

    public static void main(String[] args) {
        List<SalesSummaryRow> dbSales = DatabaseHelper.getDBSales();
        PrintSalesSummaryRowCommand print = new PrintSalesSummaryRowCommand();

        printListSalesSummaryRows(dbSales);

        System.out.println("\nNorth Sales Summary");
        printListSalesSummaryRows(filter(dbSales, new PredicateNorthCommand()));

        System.out.println("\nNorth Sales Summary");
        printListSalesSummaryRows(filter(dbSales, new PredicateSouthCommand()));

        System.out.println("\nStarted units from West Sales Summary");
        printListInteger(mapInteger(filter(dbSales, new PredicateWestCommand()),
                                    new GetInitialUnits()));

        System.out.println("\nFinals units from East Sales Summary");
        printListInteger(mapInteger(filter(dbSales, new PredicateEastCommand()),
                                    new GetFinalUnits()));

        System.out.println("\nList of profits over 30 percent over the sales' cost.");
        printListDouble(mapDouble(filter(dbSales,
                                         new PredicatePercentSaleOverCostCommand(THIRTEN_PERCENT)),
                                  new GetProfit()));

        System.out.println("Profit: " + reduceDouble(dbSales,
                                                     new GetProfit(),
                                                     0.0));

    }
}
