public class InStorePurchase implements PurchaseDetails {
    private String storeLocation;

    public InStorePurchase(String storeLocation) {
        this.storeLocation = storeLocation;
    }

    public String getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(String storeLocation) {
        this.storeLocation = storeLocation;
    }
}
