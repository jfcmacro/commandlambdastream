package com.epam.rd.cls;

import java.util.List;

public class Main {

    public static void forEach(List<SalesSummaryRow> list,
                               SetSlsSumRwCmd command) {
        ForEachCmd forEachCmd =
            new ForEachCmd(list, command);
        forEachCmd.execute();
    }

    public static void forEachInteger(List<Integer> list,
                                      SetIntCmd command) {
        ForEachIntCmd forEachCmd =
            new ForEachIntCmd(list, command);
        forEachCmd.execute();
    }

    public static void forEachDouble(List<Double> list,
                                     SetDblCmd command) {
        ForEachDblCmd forEachCmd =
            new ForEachDblCmd(list, command);
        forEachCmd.execute();
    }

    public static List<SalesSummaryRow>
        filter(List<SalesSummaryRow> list,
               GetBoolSetSlsSumRwCmd predicate) {
        FilterCmd filterCmd = new FilterCmd(list,
                                            predicate);
        filterCmd.execute();
        return filterCmd.getListSlsSumRws();
    }

    public static List<Integer>
        mapInteger(List<SalesSummaryRow> list,
                   GetIntSetSlsSumRwCmd transform) {
        MapListSlsSumRwIntCmd mapCmd =
            new MapListSlsSumRwIntCmd(list,
                                          transform);
        mapCmd.execute();
        return mapCmd.getListInt();
    }

    public static List<Double>
        mapDouble(List<SalesSummaryRow> list,
                  GetDblSetSlsSumRwCmd transform) {
        MapListSlsSumRwDblCmd mapCmd =
            new MapListSlsSumRwDblCmd(list,
                                         transform);
        mapCmd.execute();
        return mapCmd.getListDbl();
    }

    public static Double
        reduceDouble(List<SalesSummaryRow> list,
                     GetDblSetDblSetSlsSumRwCmd doubleDblSlsSumRwCmd,
                     double initial) {
        ReduceDblCmd reduceCmd =
            new ReduceDblCmd(list,
                                doubleDblSlsSumRwCmd,
                                initial);
        reduceCmd.execute();
        return reduceCmd.getDbl();
    }

    public static void printListSlsSumRws(List<SalesSummaryRow> list) {
        forEach(list, new PrintSlsSumRwCmd());
    }

    public static void printListInt(List<Integer> list) {
        forEachInteger(list, new PrintIntCmd());
    }

    public static void printListDouble(List<Double> list) {
        forEachDouble(list, new PrintDblCmd());
    }

    final static double THIRTEN_PERCENT = 0.30;

    public static void main(String[] args) {
        List<SalesSummaryRow> dbSales = DBHelper.getDBSales();
        PrintSlsSumRwCmd print = new PrintSlsSumRwCmd();

        printListSlsSumRws(dbSales);

        System.out.println("\nNorth Sales Summary");
        printListSlsSumRws(filter(dbSales, new PredNorthCmd()));

        System.out.println("\nSouth Sales Summary");
        printListSlsSumRws(filter(dbSales, new PredSouthCmd()));

        System.out.println("\nStarted units from West Sales Summary");
        printListInt(mapInteger(filter(dbSales, new PredWestCmd()),
                                    new GetInitialUnitsCmd()));

        System.out.println("\nFinals units from East Sales Summary");
        printListInt(mapInteger(filter(dbSales, new PredEastCmd()),
                                    new GetFinalUnitsCmd()));

        System.out.println("\nList of profits over 30 percent over the sales' cost.");
        printListDouble(mapDouble(filter(dbSales,
                                         new PredPercSaleOverCostCmd(THIRTEN_PERCENT)),
                                  new GetProfitCmd()));

        System.out.println("Profit: " + reduceDouble(dbSales,
                                                     new GetSumProfitCmd(),
                                                     0.0));
    }
}
