package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;

public class Main {

    public static <T,R> void forEach(List<T> list,
                                     SetCommandTR<T,R> setCommand) {
        ForEachCommand forEachCommand =
            new ForEachCommand<T,R>(list, setCommand);
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

    public static <T> List<T>
        filter(List<T> list,
               SetCommandTR<T,Boolean> predicate) {
        FilterCommandTR<T> filterCommand = new FilterCommandTR<T>(list,
                                                                  predicate);
        return filterCommand.execute();
    }

    public static <T,R> List<R> map(List<T> list,
                                    SetCommandTR<T,R> setCommand) {
        MapCommandTR<T,R> mapCommand = new MapCommandTR<T,R>(list,
                                                             setCommand);
        return mapCommand.execute();
    }

    public static List<Integer>
        mapInteger(List<SalesSummaryRow> list,
                   GetIntegerSetSalesSummaryRowCommand transform) {
        MapListSalesSummaryRowIntegerCommand mapCommand =
            new MapListSalesSummaryRowIntegerCommand(list,
                                                     transform);
        mapCommand.execute();
        return mapCommand.getListInteger();
    }

    public static List<Double>
        mapDouble(List<SalesSummaryRow> list,
                  GetDoubleSetSalesSummaryRowCommand transform) {
        MapListSalesSummaryRowDoubleCommand mapCommand =
            new MapListSalesSummaryRowDoubleCommand(list,
                                                    transform);
        mapCommand.execute();
        return mapCommand.getListDouble();
    }

    public static <S,R> R reduce(List<S> list,
                                 BiSetCommandSTR<S,R,R> operator,
                                 R initValue) {
        ReduceCommandTR<S,R> reduceCommand =
            new ReduceCommandTR<S,R>(list,
                                     operator,
                                     initValue);
        return reduceCommand.execute();
    }

    public static Double
        reduceDouble(List<SalesSummaryRow> list,
                     GetDoubleSetDoubleSetSalesSummaryRowCommand doubleDoubleSalesSummaryRowCommand,
                     double initial) {
        ReduceDoubleCommand reduceCommand =
            new ReduceDoubleCommand(list,
                                    doubleDoubleSalesSummaryRowCommand,
                                    initial);
        reduceCommand.execute();
        return reduceCommand.getDouble();
    }

    public static <T> void printList(List<T> list) {
        forEach(list, new PrintCommand<T,Void>());
    }

    final static double THIRTEN_PERCENT = 0.30;

    public static void main(String[] args) {
        List<SalesSummaryRow> dbSales = DatabaseHelper.getDBSales();

        printList(dbSales);

        System.out.println("\nNorth Sales Summary");
        printList(filter(dbSales, new PredicateNorthCommand()));

        System.out.println("\nSouth Sales Summary");
        printList(filter(dbSales, new PredicateSouthCommand()));

        System.out.println("\nStarted units from West Sales Summary");
        printList(mapInteger(filter(dbSales, new PredicateWestCommand()),
                             new GetInitialUnitsCommand()));

        System.out.println("\nFinals units from East Sales Summary");
        printList(mapInteger(filter(dbSales, new PredicateEastCommand()),
                             new GetFinalUnitsCommand()));

        System.out.println("\nList of profits over 30 percent over the sales' cost.");
        printList(mapDouble(filter(dbSales,
                                   new PredicatePercentSaleOverCostCommand(THIRTEN_PERCENT)),
                            new GetProfitCommand()));

        System.out.println("Profit: " + reduceDouble(dbSales,
                                                     new GetSumProfitCommand(),
                                                     0.0));
    }
}
