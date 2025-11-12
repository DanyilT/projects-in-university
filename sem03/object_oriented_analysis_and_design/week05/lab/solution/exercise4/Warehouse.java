public class Warehouse extends Building {
    private String mainGoodsType;

    public String getMainGoodsType() {
        return mainGoodsType;
    }

    public void setMainGoodsType(String mainGoodsType) {
        this.mainGoodsType = mainGoodsType;
    }

    @Override
    public String toString() {
        return "(WAREHOUSE) address = " + getAddress() + " / size = " + getSizeMetersSquared() + " sq.m. / main goods type = " + getMainGoodsType();
    }
}
