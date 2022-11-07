package com.epam.rd.cls;

import java.util.List;
import java.util.ArrayList;

public class DBHelper {

    private static Article article1 = new Article("Article 1",
                                                  "This is the article 1");
    private static Article article2 = new Article("Article 2",
                                                  "This is the article 2");
    private static Article article3 = new Article("Article 3",
                                                  "This is the article 3");
    private static Article article4 = new Article("Article 4",
                                                  "This is the article 4");
    private static Article article5 = new Article("Article 5",
                                                  "This is the article 5");

    public static List<SalesSummaryRow> getDBSales() {
        List<SalesSummaryRow> db = new ArrayList<SalesSummaryRow>();

        db.add(new SalesSummaryRow(Region.NORTH,
                                   article1,
                                   2.0,
                                   3.0,
                                   100,
                                   45));
        db.add(new SalesSummaryRow(Region.SOUTH,
                                   article1,
                                   2.1,
                                   3.25,
                                   200,
                                   80));
        db.add(new SalesSummaryRow(Region.EAST,
                                   article1,
                                   1.9,
                                   3.34,
                                   100,
                                   80));
        db.add(new SalesSummaryRow(Region.WEST,
                                   article1,
                                   1.9,
                                   3.34,
                                   100,
                                   80));

        db.add(new SalesSummaryRow(Region.NORTH,
                                   article2,
                                   25.1,
                                   25.9,
                                   10,
                                   4));
        db.add(new SalesSummaryRow(Region.SOUTH,
                                   article2,
                                   26.1,
                                   30.9,
                                   200,
                                   10));
        db.add(new SalesSummaryRow(Region.EAST,
                                   article2,
                                   25.1,
                                   26.0,
                                   100,
                                   80));
        db.add(new SalesSummaryRow(Region.WEST,
                                   article2,
                                   25.5,
                                   27.8,
                                   34,
                                   12));

        db.add(new SalesSummaryRow(Region.NORTH,
                                   article3,
                                   91.2,
                                   110.4,
                                   98,
                                   44));
        db.add(new SalesSummaryRow(Region.SOUTH,
                                   article3,
                                   91.2,
                                   111.0,
                                   200,
                                   80));
        db.add(new SalesSummaryRow(Region.EAST,
                                   article3,
                                   91.2,
                                   91.9,
                                   1000,
                                   1000));
        db.add(new SalesSummaryRow(Region.WEST,
                                   article3,
                                   91.2,
                                   92.3,
                                   10,
                                   8));

        db.add(new SalesSummaryRow(Region.NORTH,
                                   article4,
                                   5.6,
                                   6.9,
                                   15,
                                   12));
        db.add(new SalesSummaryRow(Region.SOUTH,
                                   article4,
                                   5.8,
                                   6.1,
                                   312,
                                   209));
        db.add(new SalesSummaryRow(Region.EAST,
                                   article4,
                                   5.9,
                                   6.1,
                                   218,
                                   105));
        db.add(new SalesSummaryRow(Region.WEST,
                                   article4,
                                   6.0,
                                   6.05,
                                   1012,
                                   1004));

        return db;
    }
}
