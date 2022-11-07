package com.epam.rd.cls;

public class SalesSummaryRow {
    private Region region;
    private Article article;
    private double unitCosts;
    private double unitSalesValue;
    private int initialUnits;
    private int soldUnits;

    public SalesSummaryRow(Region region,
                           Article article,
                           double unitCosts,
                           double unitSalesValue,
                           int initialUnits,
                           int soldUnits) {
        this.region = region;
        this.article = article;
        this.unitCosts = unitCosts;
        this.unitSalesValue = unitSalesValue;
        this.initialUnits = initialUnits;
        this.soldUnits = soldUnits;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public double getUnitCosts() {
        return unitCosts;
    }

    public void setUnitCosts(double unitCosts) {
        this.unitCosts = unitCosts;
    }

    public double getUnitSalesValue() {
        return unitSalesValue;
    }

    public void setUnitSalesValue(double unitSalesValue) {
        this.unitSalesValue = unitSalesValue;
    }

    public int getInitialUnits() {
        return initialUnits;
    }

    public void setInitialUnits(int initialUnits) {
        this.initialUnits = initialUnits;
    }

    public int getSoldUnits() {
        return soldUnits;
    }

    public void setSoldUnits(int soldUnits) {
        this.soldUnits = soldUnits;
    }

    public int finalUnits() {
        return (initialUnits - soldUnits);
    }

    public double initialCosts() {
        return (unitCosts * initialUnits);
    }

    public double soldValue() {
        return (soldUnits * unitSalesValue);
    }

    public double profit() {
        return soldValue() - soldUnits * unitCosts;
    }

    @Override
    public String toString() {
        return "(" + region
            + ", " +  article
            + ", " + unitCosts
            + ", " + unitSalesValue
            + ", " + initialUnits
            + ", " + soldUnits
            + ", " + finalUnits()
            + ", " + initialCosts()
            + ", " + soldValue()
            + ", " + profit()
            + ")";
    }
}
