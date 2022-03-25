package tqs.labii;

public class Stock {
    
    private String label;
    private int quantity;
    
    
    public Stock (String label, int quant) {
        this.label = label; 
        this.quantity = quant;

    }

    // get label
    public String getLabel() {
        return label;
    }

    // get quantity
    public int getQuantity() {
        return quantity;
    }

    // set label
    public void setLabel(String label) {
        this.label = label;
    }

    // set quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
