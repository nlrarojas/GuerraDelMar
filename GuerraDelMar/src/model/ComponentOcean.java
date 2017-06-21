package model;

/**
 *
 * @author Nelson
 */
public class ComponentOcean {
    protected int price;
    protected int rows;
    protected int columns;

    public ComponentOcean(int price, int rows, int columns) {
        this.price = price;
        this.rows = rows;
        this.columns = columns;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }
}
