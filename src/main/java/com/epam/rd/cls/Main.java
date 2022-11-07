package com.epam.rd.cls;

import java.util.List;

public class Main {

    public static <T,R> void forEach(List<T> list,
                                     SetCmd<T,R> setCmd) {
        ForEachCmd forEachCmd =
            new ForEachCmd<T,R>(list, setCmd);
        forEachCmd.execute();
    }

    public static <T> List<T>
        filter(List<T> list,
               SetCmd<T,Boolean> predicate) {
        FilterCmd<T> filterCmd = new FilterCmd<T>(list,
                                                  predicate);
        return filterCmd.execute();
    }

    public static <T,R> List<R> map(List<T> list,
                                    SetCmd<T,R> setCmd) {
        MapCmd<T,R> mapCmd = new MapCmd<T,R>(list,
                                             setCmd);
        return mapCmd.execute();
    }

    public static <S,R> R reduce(List<S> list,
                                 BiSetCommand<S,R,R> operator,
                                 R initValue) {
        ReduceCmd<S,R> reduceCmd =
            new ReduceCmd<S,R>(list,
                               operator,
                               initValue);
        return reduceCmd.execute();
    }

    public static <T> void printList(List<T> list) {
        forEach(list, new PrintCmd<T,Void>());
    }

    final static double THIRTEN_PERCENT = 0.30;

    public static void main(String[] args) {
        List<SalesSummaryRow> dbSales = DBHelper.getDBSales();

        printList(dbSales);

        System.out.println("\nNorth Sales Summary");
        printList(filter(dbSales, new SetCmd<SalesSummaryRow,Boolean> () {
                private SalesSummaryRow salesSummaryRow;
                public void set(SalesSummaryRow salesSummaryRow) {
                    this.salesSummaryRow = salesSummaryRow;
                }
                public Boolean execute() {
                    return salesSummaryRow.getRegion() == Region.NORTH;
                }
            }));

        System.out.println("\nSouth Sales Summary");
        printList(filter(dbSales, new PredSouthCmd()));

        System.out.println("\nStarted units from West Sales Summary");
        printList(map(filter(dbSales, new PredWestCmd()),
                      new GetInitialUnitsCmd()));

        System.out.println("\nFinals units from East Sales Summary");
        printList(map(filter(dbSales, new PredEastCmd()),
                      new GetFinalUnitsCmd()));

        System.out.println("\nList of profits over 30 percent over the sales' cost.");
        printList(map(filter(dbSales,
                             new PredPercSaleOverCostCmd(THIRTEN_PERCENT)),
                      new GetProfitCmd()));

        System.out.println("Profit: " + reduce(dbSales,
                                               new GetSumProfitCmd(),
                                               0.0));

    }
}
