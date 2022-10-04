package com.epam.rd.elevate.gpr.commandlambdastream;

import java.util.List;

public class Main {

    public static <T,R> void forEach(List<T> list,
                                     SetCommandTR<T,R> setCommand) {
        ForEachCommand forEachCommand =
            new ForEachCommand<T,R>(list, setCommand);
        forEachCommand.execute();
    }

    public static <T> List<T>
        filter(List<T> list,
               SetCommandTR<T,Boolean> predicate) {
        FilterCommand<T> filterCommand = new FilterCommand<T>(list,
                                                              predicate);
        return filterCommand.execute();
    }

    public static <T,R> List<R> map(List<T> list,
                                    SetCommandTR<T,R> setCommand) {
        MapCommandTR<T,R> mapCommand = new MapCommandTR<T,R>(list,
                                                             setCommand);
        return mapCommand.execute();
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

    // public static Double
    //     reduceDouble(List<SalesSummaryRow> list,
    //                  GetDoubleSetDoubleSetSalesSummaryRowCommand doubleDoubleSalesSummaryRowCommand,
    //                  double initial) {
    //     ReduceDoubleCommand reduceCommand =
    //         new ReduceDoubleCommand(list,
    //                                 doubleDoubleSalesSummaryRowCommand,
    //                                 initial);
    //     reduceCommand.execute();
    //     return reduceCommand.getDouble();
    // }

    public static <T> void printList(List<T> list) {
        forEach(list, new PrintCommand<T,Void>());
    }

    final static double THIRTEN_PERCENT = 0.30;

    public static void main(String[] args) {
        List<SalesSummaryRow> dbSales = DatabaseHelper.getDBSales();

        printList(dbSales);

        System.out.println("\nNorth Sales Summary");
        printList(filter(dbSales, new SetCommandTR<SalesSummaryRow,Boolean> () {
                private SalesSummaryRow salesSummaryRow;
                @Override
                public void set(SalesSummaryRow salesSummaryRow) {
                    this.salesSummaryRow = salesSummaryRow;
                }
                @Override
                public Boolean execute() {
                    return salesSummaryRow.getRegion() == Region.NORTH;
                }
            }));

        System.out.println("\nSouth Sales Summary");
        printList(filter(dbSales, new PredicateSouthCommand()));

        System.out.println("\nStarted units from West Sales Summary");
        printList(map(filter(dbSales, new PredicateWestCommand()),
                      new GetInitialUnitsCommand()));

        System.out.println("\nFinals units from East Sales Summary");
        printList(map(filter(dbSales, new PredicateEastCommand()),
                      new GetFinalUnitsCommand()));

        System.out.println("\nList of profits over 30 percent over the sales' cost.");
        printList(map(filter(dbSales,
                             new PredicatePercentSaleOverCostCommand(THIRTEN_PERCENT)),
                      new GetProfitCommand()));

        System.out.println("Profit: " + reduce(dbSales,
                                               new GetSumProfitCommand(),
                                               0.0));

    }
}
